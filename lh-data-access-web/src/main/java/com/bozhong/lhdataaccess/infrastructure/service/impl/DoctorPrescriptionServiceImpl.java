package com.bozhong.lhdataaccess.infrastructure.service.impl;

import com.bozhong.lhdataaccess.common.util.HttpUtil;
import com.bozhong.lhdataaccess.domain.DoctorOrderDO;
import com.bozhong.lhdataaccess.domain.DoctorPrescriptionDO;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;
import com.bozhong.lhdataaccess.infrastructure.dao.DoctorPrescriptionDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.InPatientDAO;
import com.bozhong.lhdataaccess.infrastructure.service.DoctorOrderService;
import com.bozhong.lhdataaccess.infrastructure.service.DoctorPrescriptionService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 处方数据的Serviced的实例
 */
@Service("doctorPrescriptionService")
public class DoctorPrescriptionServiceImpl implements DoctorPrescriptionService {

    private static final Logger logger = LoggerFactory.getLogger("dlDataAccessLog");

    @Autowired
    private DoctorPrescriptionDAO doctorPrescriptionDAO;

    @Override
    public void dumpDoctorPrescription(Date lastUpdateTime) {

        int pageIndex = 0;
        int pageSize = 50;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        while(true){

            Date currentTime = new Date();

            //避免死循环
            if(pageIndex>2000){
                logger.error("处方数据dump的时候，循环超出了范围，时间是"+currentTime);
                break;
            }
            try{
                //调用中兴接口获取处方数据
                List<Map<String,String>> dataList = new ArrayList<Map<String,String>>();
                Map<String, String> dataMap = new HashMap<String, String>();
                dataMap.put("orgCode","");
                dataMap.put("personId","");
                dataMap.put("outSno","");
                dataList.add(dataMap);

                Map<String, Object> attributes = new HashMap<String, Object>();
                attributes.put("data",dataList);
                attributes.put("pageIndex",Integer.toString(pageIndex));
                attributes.put("pageSize", Integer.toString(pageSize));
                attributes.put("lastEditedTime", sdf.format(lastUpdateTime));
                Map resultMap = JSONObject.fromObject(HttpUtil.httpPostWithJson("http://118.178.131.147:6003/hospital/personDetails/prescription", attributes));
                Object code = resultMap.get("code");
                if(code==null || !"200".equals(code.toString())){
                    logger.error("处方数据dump的时候，调用接口出错，code = "+code+",msg = "+(String)resultMap.get("msg"));
                    pageIndex = pageIndex+1;
                    continue;
                }

                JSONArray backBodyJson = JSONArray.fromObject(resultMap.get("prescription"));
                if(backBodyJson==null || backBodyJson.size()<=0){
                    logger.error("处方数据dump结束，时间是"+currentTime);
                    break;
                }

                //把返回数据映射为我们自己的OutPatientDO对象,并将OutPatientDO同步到本地库
                for(int i=0;i<backBodyJson.size();i++){
                    JSONObject job = backBodyJson.getJSONObject(i);
                    DoctorPrescriptionDO doctorPrescriptionDO = new DoctorPrescriptionDO();
                    doctorPrescriptionDO.setDoctorPrescriptionNumber(job.get("outRpDetSno").toString());
                    doctorPrescriptionDO.setPatientId(job.get("patientId").toString());
                    doctorPrescriptionDO.setOrganizStructureCode(job.get("orgCode").toString());
                    doctorPrescriptionDO.setDrugName(job.get("drugName").toString());
                    doctorPrescriptionDO.setDoctorPrescriptionClassific(job.get("rpSort").toString());
                    doctorPrescriptionDO.setLastEditedTime(sdf.parse(job.get("lastEditedTime").toString()));
                    doctorPrescriptionDO.setValidFlag(job.get("cancelFlag").toString());
                    doctorPrescriptionDO.setCreateId(0L);
                    doctorPrescriptionDO.setCreateTime(currentTime);
                    doctorPrescriptionDO.setUpdateId(0L);
                    doctorPrescriptionDO.setUpdateTime(currentTime);
                    doctorPrescriptionDAO.updateOrInsertDoctorPrescription(doctorPrescriptionDO);
                }
            }catch(Exception e){
                logger.error("处方数据dump的时候报错"+e);
                pageIndex = pageIndex+1;
                continue;
            }
            pageIndex = pageIndex+1;
        }
    }

    @Override
    public List<OrganizStructureDO> selectDataBylastUpdateTime(Date lastUpdateTime) {
        OrganizStructureDO organizStructureDO = new OrganizStructureDO();
        organizStructureDO.setLastEditedTime(lastUpdateTime);
//        return organizStructureDAO.selectDataBylastUpdateTime(organizStructureDO);
        return null;
    }

}
