package com.bozhong.lhdataaccess.rule;

/**
 * User: 李志坚
 * Date: 2018/11/9
 * 智能推送规则的场景枚举类
 */
public enum RuleSceneEnum {
	REGISTER("register","挂号后"),
	DOCTOR_ORDER("doctorOrder","医嘱"),
	DOCTOR_PRESCRIPTION("doctorPrescription","处方"),
	DOCTOR_DIAGNOSIS("doctorDiagnosis","诊断"),
	VISIT("visit","就诊后"),
	HOSPITALIZATION("hospitalization","住院时"),
	LEAVE_HOSPITAL("leaveHospital","出院后");

	private String key;

	private String value;

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	RuleSceneEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}
}
