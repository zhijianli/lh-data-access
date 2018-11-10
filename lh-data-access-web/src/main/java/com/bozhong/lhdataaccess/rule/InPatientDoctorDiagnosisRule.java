package com.bozhong.lhdataaccess.rule;

import com.bozhong.lhdataaccess.domain.DoctorInDiagnosisDO;
import com.bozhong.lhdataaccess.domain.DoctorOutDiagnosisDO;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/9
 * 住院患者-诊断 智能推送规则类
 */
public class InPatientDoctorDiagnosisRule extends InPatientRule{

    @Override
    public List<RuleMessageDO> execute(RuleMessageDO ruleMessageDO) {
        List<RuleMessageDO> ruleMessageList = new ArrayList<RuleMessageDO>();
        List<DoctorInDiagnosisDO> doctorInDiagnosisList = ruleMessageDO.getDoctorInDiagnosisList();

        for(int i =0;i<doctorInDiagnosisList.size();i++){
            DoctorInDiagnosisDO doctorInDiagnosisDO = doctorInDiagnosisList.get(i);
            RuleMessageDO returnRuleMessageDO = new RuleMessageDO();
            returnRuleMessageDO.putKeywordMap(RuleKeywordEnum.DOCTOR_DIAGNOSIS_NAME.getKey(),doctorInDiagnosisDO.getDoctorDiagnosisName());
            returnRuleMessageDO.setPatientType(RulePatientTypeEnum.IN_PATIENT.getKey());
            returnRuleMessageDO.setScene(RuleSceneEnum.DOCTOR_DIAGNOSIS.getKey());
            ruleMessageList.add(returnRuleMessageDO);
        }
        return ruleMessageList;
    }
}
