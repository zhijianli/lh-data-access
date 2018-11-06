package com.bozhong.lhdataaccess.domain;

import java.util.Date;

public class HospitalWardDO {
    private Long id;

    private String name;

    private Long hospitalId;

    private String validFlag;

    private Date createTime;

    private Date updateTime;

    private String phone;

    private String code;

    private Long deptId;

    private Long createBy;

    private Long updateBy;

    private Integer sortOrder;

    private String thirdPartId;

    private String thirdPartName;

    private String nursingManagThirdPartId;

    private String nursingManagThirdPartName;

    private Integer onlineStatus;

    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag == null ? null : validFlag.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getThirdPartId() {
        return thirdPartId;
    }

    public void setThirdPartId(String thirdPartId) {
        this.thirdPartId = thirdPartId == null ? null : thirdPartId.trim();
    }

    public String getThirdPartName() {
        return thirdPartName;
    }

    public void setThirdPartName(String thirdPartName) {
        this.thirdPartName = thirdPartName == null ? null : thirdPartName.trim();
    }

    public String getNursingManagThirdPartId() {
        return nursingManagThirdPartId;
    }

    public void setNursingManagThirdPartId(String nursingManagThirdPartId) {
        this.nursingManagThirdPartId = nursingManagThirdPartId == null ? null : nursingManagThirdPartId.trim();
    }

    public String getNursingManagThirdPartName() {
        return nursingManagThirdPartName;
    }

    public void setNursingManagThirdPartName(String nursingManagThirdPartName) {
        this.nursingManagThirdPartName = nursingManagThirdPartName == null ? null : nursingManagThirdPartName.trim();
    }

    public Integer getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Integer onlineStatus) {
        this.onlineStatus = onlineStatus;
    }
}