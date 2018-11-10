package com.bozhong.lhdataaccess.rule;

import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/9
 * 智能推送规则接口
 */
public interface Rule {

   public List<RuleMessageDO> execute(RuleMessageDO ruleMessageDO);

}
