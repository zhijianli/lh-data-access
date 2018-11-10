package com.bozhong.lhdataaccess.rule;

import com.bozhong.lhdataaccess.domain.OutPatientDO;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: 李志坚
 * Date: 2018/11/9
 * 门诊患者-挂号 智能推送规则类
 */
public class OutPatientRegisterRule extends OutPatientRule {

    @Override
    public List<RuleMessageDO> execute(RuleMessageDO ruleMessageDO) {
        List<RuleMessageDO> ruleMessageList = new ArrayList<RuleMessageDO>();
        RuleMessageDO returnRuleMessageDO = new RuleMessageDO();
        OutPatientDO outPatientDO = ruleMessageDO.getOutPatientDO();
        String departCode = outPatientDO.getDepartCode();
        if(!"null".equals(departCode)&& StringUtils.isNotBlank(departCode)){
            returnRuleMessageDO.putKeywordMap(RuleKeywordEnum.DEPART_CODE.getKey(),departCode);
        }
        returnRuleMessageDO.setPatientType(RulePatientTypeEnum.OUT_PATIENT.getKey());
        returnRuleMessageDO.setScene(RuleSceneEnum.REGISTER.getKey());
        ruleMessageList.add(returnRuleMessageDO);
        return ruleMessageList;
    }
}
