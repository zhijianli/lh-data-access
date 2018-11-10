package com.bozhong.lhdataaccess.rule;

/**
 * User: 李志坚
 * Date: 2018/11/9
 * 智能推送规则的关键字枚举类
 */
public enum RuleKeywordEnum {
	DEPART_CODE("departCode","科室代码"),
	DOCTOR_ORDER_NAME("doctorOrderName","医嘱名称"),
	DOCTOR_DRUG_NAME("doctorDrugName","药品名称"),
	DOCTOR_DIAGNOSIS_NAME("doctorDiagnosisName","诊断名称"),
	BEGIN("", "开始");

	private String key;

	private String value;

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	RuleKeywordEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}

}
