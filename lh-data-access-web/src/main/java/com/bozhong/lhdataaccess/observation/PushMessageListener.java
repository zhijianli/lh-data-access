package com.bozhong.lhdataaccess.observation;


import com.bozhong.lhdataaccess.domain.*;
import com.bozhong.lhdataaccess.infrastructure.dao.*;
import com.bozhong.lhdataaccess.infrastructure.service.InPatientService;
import com.bozhong.lhdataaccess.infrastructure.service.OutPatientService;
import com.bozhong.lhdataaccess.rule.*;
import com.zhicall.core.mybatis.page.Page;
import com.zhicall.core.mybatis.page.PageRequest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 把根据患者相关信息推送消息，也是观察者之一
 */
@Component
public class PushMessageListener implements ApplicationListener<DumpDataEvent> {

    private static final Logger logger = LoggerFactory.getLogger("dlDataAccessLog");

    @Autowired
    private OutPatientService outPatientService;

    @Autowired
    private InPatientService inPatientService;

    @Autowired
    private DoctorOrderDAO doctorOrderDAO;

    @Autowired
    private DoctorPrescriptionDAO doctorPrescriptionDAO;

    @Autowired
    private DoctorOutDiagnosisDAO doctorOutDiagnosisDAO;

    @Autowired
    private DoctorInDiagnosisDAO doctorInDiagnosisDAO;

    @Override
    public void onApplicationEvent(DumpDataEvent event)  {

        System.out.println("+++++++推送消息开始！++++++");

        Date lastUpdateTime = event.getLastUpdateTime();

//        List<RuleMessageDO> opRuleMessageList = this.configOutPatientRule(lastUpdateTime);

        //获取住院患者规则对象
        List<RuleMessageDO> ipRuleMessageList = this.configInPatientRule(lastUpdateTime);


        //获取特殊人群规则对象


        //根据规则推送消息

    }

    private List<RuleMessageDO> configInPatientRule(Date lastUpdateTime) {

        List<RuleMessageDO> ruleMessageDOList = new ArrayList<RuleMessageDO>();

        //获取住院患者规则对象
        int pageIndex = 0;
        int pageSize = 50;

        RuleContext ruleContext = new RuleContext();
        RuleMessageDO ruleMessageDO = new RuleMessageDO();

        while(true) {

            //避免死循环
            if (pageIndex > 2000) {
                logger.error("住院患者制定规则的时候，循环超出了范围，时间是" + lastUpdateTime);
                break;
            }

            try{
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("lastEditedTime",lastUpdateTime);
                PageRequest pageRequest = new PageRequest(pageIndex,pageSize);
                pageRequest.setFilters(params);
                Page<InPatientDO> page = inPatientService.selectDataByPage(pageRequest);

                if (page != null && page.getResult() != null && page.getResult().size()>0) {

                    List<InPatientDO> inPatientList = page.getResult();

                    for(int i =0;i<inPatientList.size();i++){
                        InPatientDO inPatientDO = inPatientList.get(i);
                        String organizStructureCode = inPatientDO.getOrganizStructureCode();
                        String patientId = inPatientDO.getPatientId();
                        ruleMessageDO.setInPatientDO(inPatientDO);

                        //执行住院患者-住院时规则
                        ruleContext.setRule(new InPatientHospitalizationRule());
                        ruleMessageDOList.addAll(ruleContext.execute(ruleMessageDO));

                        if(!"null".equals(organizStructureCode) && StringUtils.isNotBlank(organizStructureCode) &&
                                !"null".equals(patientId) && StringUtils.isNotBlank(patientId)){

                            //获取该住院患者处方数据
                            DoctorPrescriptionDO doctorPrescriptionDO = new DoctorPrescriptionDO();
                            doctorPrescriptionDO.setLastEditedTime(lastUpdateTime);
                            doctorPrescriptionDO.setOrganizStructureCode(organizStructureCode);
                            doctorPrescriptionDO.setPatientId(patientId);
                            List<DoctorPrescriptionDO> doctorPrescriptionList = doctorPrescriptionDAO.selectDpDataByDoctorPrescriptionDO(doctorPrescriptionDO);

                            //执行住院患者-处方规则
                            if(doctorPrescriptionList!=null && doctorPrescriptionList.size()>0){
                                ruleMessageDO.setDoctorPrescriptionList(doctorPrescriptionList);
                                ruleContext.setRule(new InPatientDoctorPrescriptionRule());
                                ruleMessageDOList.addAll(ruleContext.execute(ruleMessageDO));
                            }

                            //获取该住院患者诊断数据
                            DoctorInDiagnosisDO doctorInDiagnosisDO = new DoctorInDiagnosisDO();
                            doctorInDiagnosisDO.setLastEditedTime(lastUpdateTime);
                            doctorInDiagnosisDO.setOrganizStructureCode(organizStructureCode);
                            doctorInDiagnosisDO.setPatientId(patientId);
                            List<DoctorInDiagnosisDO> doctorInDiagnosisList = doctorInDiagnosisDAO.selectDidDataByDoctorInDiagnosisDO(doctorInDiagnosisDO);
                            if(doctorInDiagnosisList!=null && doctorInDiagnosisList.size()>0){
                                ruleMessageDO.setDoctorInDiagnosisList(doctorInDiagnosisList);

                                //执行住院患者-诊断规则
                                ruleContext.setRule(new InPatientDoctorDiagnosisRule());
                                ruleMessageDOList.addAll(ruleContext.execute(ruleMessageDO));

                            }
                        }
                    }
                }
            }catch(Exception e){
                logger.error("配置住院患者规则的时候报错"+e);
                pageIndex = pageIndex+1;
                continue;
            }
            pageIndex = pageIndex+1;
        }
        return ruleMessageDOList;


    }

    private List<RuleMessageDO> configOutPatientRule(Date lastUpdateTime) {
        List<RuleMessageDO> ruleMessageDOList = new ArrayList<RuleMessageDO>();

        //获取门诊患者规则对象
        int pageIndex = 0;
        int pageSize = 50;

        RuleContext ruleContext = new RuleContext();
        RuleMessageDO ruleMessageDO = new RuleMessageDO();

        while(true) {

            //避免死循环
            if (pageIndex > 2000) {
                logger.error("门诊患者制定规则的时候，循环超出了范围，时间是" + lastUpdateTime);
                break;
            }

            try{
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("lastEditedTime",lastUpdateTime);
                PageRequest pageRequest = new PageRequest(pageIndex,pageSize);
                pageRequest.setFilters(params);
                Page<OutPatientDO> page = outPatientService.selectDataByPage(pageRequest);

                if (page != null && page.getResult() != null && page.getResult().size()>0) {

                    List<OutPatientDO> outPatientList = page.getResult();

                    for(int i =0;i<outPatientList.size();i++){
                        OutPatientDO outpatientDO = outPatientList.get(i);
                        String organizStructureCode = outpatientDO.getOrganizStructureCode();
                        String patientId = outpatientDO.getPatientId();
                        ruleMessageDO.setOutPatientDO(outpatientDO);

                        //执行门诊患者-挂号后规则
                        ruleContext.setRule(new OutPatientRegisterRule());
                        ruleMessageDOList.addAll(ruleContext.execute(ruleMessageDO));

                        if(!"null".equals(organizStructureCode) && StringUtils.isNotBlank(organizStructureCode) &&
                                !"null".equals(patientId) && StringUtils.isNotBlank(patientId)){

                            //获取该门诊患者医嘱数据
                            DoctorOrderDO doctorOrderDO = new DoctorOrderDO();
                            doctorOrderDO.setLastEditedTime(lastUpdateTime);
                            doctorOrderDO.setOrganizStructureCode(organizStructureCode);
                            doctorOrderDO.setPatientId(patientId);
                            List<DoctorOrderDO> doctorOrderDOList = doctorOrderDAO.selectDoDataByDoctorOrderDO(doctorOrderDO);

                            //执行门诊患者-医嘱规则
                            if(doctorOrderDOList!=null && doctorOrderDOList.size()>0){
                                ruleMessageDO.setDoctorOrderList(doctorOrderDOList);
                                ruleContext.setRule(new OutPatientDoctorOrderRule());
                                ruleMessageDOList.addAll(ruleContext.execute(ruleMessageDO));
                            }

                            //获取该门诊患者诊断数据
                            DoctorOutDiagnosisDO doctorOutDiagnosisDO = new DoctorOutDiagnosisDO();
                            doctorOutDiagnosisDO.setLastEditedTime(lastUpdateTime);
                            doctorOutDiagnosisDO.setOrganizStructureCode(organizStructureCode);
                            doctorOutDiagnosisDO.setPatientId(patientId);
                            List<DoctorOutDiagnosisDO> doctorOutDiagnosisList = doctorOutDiagnosisDAO.selectDodDataByDoctorOutDiagnosisDO(doctorOutDiagnosisDO);
                            if(doctorOutDiagnosisList!=null && doctorOutDiagnosisList.size()>0){
                                ruleMessageDO.setDoctorOutDiagnosisList(doctorOutDiagnosisList);
                                //执行门诊患者-诊断规则
                                ruleContext.setRule(new OutPatientDoctorDiagnosisRule());
                                ruleMessageDOList.addAll(ruleContext.execute(ruleMessageDO));

                                //执行门诊患者-就诊后规则
                                ruleContext.setRule(new OutPatientVisitRule());
                                ruleMessageDOList.addAll(ruleContext.execute(ruleMessageDO));
                            }
                        }
                    }
                }
            }catch(Exception e){
                logger.error("配置门诊患者规则的时候报错"+e);
                pageIndex = pageIndex+1;
                continue;
            }
            pageIndex = pageIndex+1;
        }
        return ruleMessageDOList;
    }

//    @Override
//    public int getOrder() {
//        return 1;
//    }
//
//    @Override
//    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
//        return eventType == DumpDataEvent.class;
//    }
//
//    @Override
//    public boolean supportsSourceType(Class<?> sourceType) {
//        return sourceType == DumpDataPubisher.class;
//    }

}
