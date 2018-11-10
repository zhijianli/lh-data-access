package com.bozhong.lhdataaccess.rule;

import com.bozhong.lhdataaccess.domain.DoctorPrescriptionDO;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/9
 * 住院患者-住院时 智能推送规则类
 */
public class InPatientHospitalizationRule extends InPatientRule{

    @Override
    public List<RuleMessageDO> execute(RuleMessageDO ruleMessageDO) {
        List<RuleMessageDO> ruleMessageList = new ArrayList<RuleMessageDO>();

        return ruleMessageList;
    }
}
