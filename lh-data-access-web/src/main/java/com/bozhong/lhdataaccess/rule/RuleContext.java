package com.bozhong.lhdataaccess.rule;

import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/9
 * 智能推送规则环境类
 */
public class RuleContext {

    public Rule rule;

    public RuleContext(){

    }

    public RuleContext(Rule rule){
        this.rule = rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public List<RuleMessageDO> execute(RuleMessageDO ruleMessageDO) {
        return rule.execute(ruleMessageDO);
    }
}
