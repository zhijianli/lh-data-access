package com.bozhong.lhdataaccess.client.common.constants.enumtype;

/**
 * Created by Administrator on 2018/5/10.
 */
public enum TaskStatusEnum {
	INIT(0, "初始"),
	BEGIN(1, "开始"),
	HANG_UP(2, "挂起"),
	FINISH(9, "完成");

	private int value;

	private String name;

	private String target;

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	TaskStatusEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public static TaskStatusEnum getTaskStatusEnum(Integer value) {
		for (TaskStatusEnum taskStatusEnum: TaskStatusEnum.values()) {
			if (taskStatusEnum.value == value) {
				return taskStatusEnum;
			}
		}
		return null;
	}
}
