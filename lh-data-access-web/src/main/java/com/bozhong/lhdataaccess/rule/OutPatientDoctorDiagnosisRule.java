package com.bozhong.lhdataaccess.rule;

import com.bozhong.lhdataaccess.domain.DoctorOrderDO;
import com.bozhong.lhdataaccess.domain.DoctorOutDiagnosisDO;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/9
 * 门诊患者-诊断 智能推送规则类
 */
public class OutPatientDoctorDiagnosisRule extends OutPatientRule {

    @Override
    public List<RuleMessageDO> execute(RuleMessageDO ruleMessageDO) {
        List<RuleMessageDO> ruleMessageList = new ArrayList<RuleMessageDO>();
        List<DoctorOutDiagnosisDO> doctorOutDiagnosisList = ruleMessageDO.getDoctorOutDiagnosisList();

        for(int i =0;i<doctorOutDiagnosisList.size();i++){
            DoctorOutDiagnosisDO doctorOutDiagnosisDO = doctorOutDiagnosisList.get(i);
            RuleMessageDO returnRuleMessageDO = new RuleMessageDO();
            returnRuleMessageDO.putKeywordMap(RuleKeywordEnum.DOCTOR_DIAGNOSIS_NAME.getKey(),doctorOutDiagnosisDO.getDoctorDiagnosisName());
            returnRuleMessageDO.setPatientType(RulePatientTypeEnum.OUT_PATIENT.getKey());
            returnRuleMessageDO.setScene(RuleSceneEnum.DOCTOR_DIAGNOSIS.getKey());
            ruleMessageList.add(returnRuleMessageDO);
        }
        return ruleMessageList;
    }
}
