package com.bozhong.lhdataaccess.rule;

import com.bozhong.lhdataaccess.domain.DoctorOrderDO;
import com.bozhong.lhdataaccess.domain.OutPatientDO;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/9
 * 门诊患者-医嘱 智能推送规则类
 */
public class OutPatientDoctorOrderRule extends OutPatientRule {

    @Override
    public List<RuleMessageDO> execute(RuleMessageDO ruleMessageDO) {
        List<RuleMessageDO> ruleMessageList = new ArrayList<RuleMessageDO>();
        List<DoctorOrderDO> doctorOrderList = ruleMessageDO.getDoctorOrderList();

        for(int i =0;i<doctorOrderList.size();i++){
            DoctorOrderDO doctorOrderDO = doctorOrderList.get(i);
            RuleMessageDO returnRuleMessageDO = new RuleMessageDO();
            returnRuleMessageDO.putKeywordMap(RuleKeywordEnum.DOCTOR_ORDER_NAME.getKey(),doctorOrderDO.getDoctorOrderName());
            returnRuleMessageDO.setPatientType(RulePatientTypeEnum.OUT_PATIENT.getKey());
            returnRuleMessageDO.setScene(RuleSceneEnum.DOCTOR_ORDER.getKey());
            ruleMessageList.add(returnRuleMessageDO);
        }

        return ruleMessageList;
    }
}
