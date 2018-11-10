package com.bozhong.lhdataaccess.rule;

/**
 * User: 李志坚
 * Date: 2018/11/9
 * 智能推送规则的病人类型枚举类
 */
public enum RulePatientTypeEnum {
	OUT_PATIENT("outPatient","门诊患者"),
	IN_PATIENT("inPatient","住院患者"),
	SPECIAL_CROWD("specialCrowd","特殊人群");

	private String key;

	private String value;

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	RulePatientTypeEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}

}
