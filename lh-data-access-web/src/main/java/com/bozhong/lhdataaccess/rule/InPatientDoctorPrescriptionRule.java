package com.bozhong.lhdataaccess.rule;

import com.bozhong.lhdataaccess.domain.DoctorOrderDO;
import com.bozhong.lhdataaccess.domain.DoctorPrescriptionDO;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/9
 * 住院患者-处方 智能推送规则类
 */
public class InPatientDoctorPrescriptionRule extends InPatientRule{


    @Override
    public List<RuleMessageDO> execute(RuleMessageDO ruleMessageDO) {
        List<RuleMessageDO> ruleMessageList = new ArrayList<RuleMessageDO>();
        List<DoctorPrescriptionDO> doctorPrescriptionList = ruleMessageDO.getDoctorPrescriptionList();

        for(int i =0;i<doctorPrescriptionList.size();i++){
            DoctorPrescriptionDO doctorPrescriptionDO = doctorPrescriptionList.get(i);
            RuleMessageDO returnRuleMessageDO = new RuleMessageDO();
            returnRuleMessageDO.putKeywordMap(RuleKeywordEnum.DOCTOR_DRUG_NAME.getKey(),doctorPrescriptionDO.getDrugName());
            returnRuleMessageDO.setPatientType(RulePatientTypeEnum.IN_PATIENT.getKey());
            returnRuleMessageDO.setScene(RuleSceneEnum.DOCTOR_PRESCRIPTION.getKey());
            ruleMessageList.add(returnRuleMessageDO);
        }

        return ruleMessageList;
    }
}
