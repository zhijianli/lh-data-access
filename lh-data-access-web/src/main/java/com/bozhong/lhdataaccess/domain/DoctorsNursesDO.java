package com.bozhong.lhdataaccess.domain;

import java.util.Date;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 医生护士信息的Model对象
 */
public class DoctorsNursesDO {

    private Long id;

    private String name;

    private String sex;

    private String mobilePhone;

    private String organizStructureCode;

    private String departWardCode;

    private String departWardName;

    private String empCode;

    private String jobTitleCode;

    private String currentProfessionalCode;

    private String workNumber;

    private Date dateOfBirth;

    private String isOffice;

    private Integer validFlag;

    private Long createId;

    private Date createTime;

    private Long updateId;

    private Date updateTime;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getOrganizStructureCode() {
        return organizStructureCode;
    }

    public void setOrganizStructureCode(String organizStructureCode) {
        this.organizStructureCode = organizStructureCode == null ? null : organizStructureCode.trim();
    }

    public String getDepartWardCode() {
        return departWardCode;
    }

    public void setDepartWardCode(String departWardCode) {
        this.departWardCode = departWardCode;
    }

    public String getDepartWardName() {
        return departWardName;
    }

    public void setDepartWardName(String departWardName) {
        this.departWardName = departWardName;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public String getJobTitleCode() {
        return jobTitleCode;
    }

    public void setJobTitleCode(String jobTitleCode) {
        this.jobTitleCode = jobTitleCode == null ? null : jobTitleCode.trim();
    }

    public String getCurrentProfessionalCode() {
        return currentProfessionalCode;
    }

    public void setCurrentProfessionalCode(String currentProfessionalCode) {
        this.currentProfessionalCode = currentProfessionalCode == null ? null : currentProfessionalCode.trim();
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIsOffice() {
        return isOffice;
    }

    public void setIsOffice(String isOffice) {
        this.isOffice = isOffice;
    }

    public Integer getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(Integer validFlag) {
        this.validFlag = validFlag;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
