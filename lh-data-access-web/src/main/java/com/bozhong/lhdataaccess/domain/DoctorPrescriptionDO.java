package com.bozhong.lhdataaccess.domain;

import java.util.Date;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 医生处方的Model对象
 */
public class DoctorPrescriptionDO {

    private Long id;

    private String doctorPrescriptionNumber;

    private String patientId;

    private String organizStructureCode;

    private String drugName;

    private String doctorPrescriptionClassific;

    private Date lastEditedTime;

    private String validFlag;

    private Long createId;

    private Date createTime;

    private Long updateId;

    private Date updateTime;

    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public Date getLastEditedTime() {
        return lastEditedTime;
    }

    public void setLastEditedTime(Date lastEditedTime) {
        this.lastEditedTime = lastEditedTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoctorPrescriptionNumber() {
        return doctorPrescriptionNumber;
    }

    public void setDoctorPrescriptionNumber(String doctorPrescriptionNumber) {
        this.doctorPrescriptionNumber = doctorPrescriptionNumber == null ? null : doctorPrescriptionNumber.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getOrganizStructureCode() {
        return organizStructureCode;
    }

    public void setOrganizStructureCode(String organizStructureCode) {
        this.organizStructureCode = organizStructureCode == null ? null : organizStructureCode.trim();
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDoctorPrescriptionClassific() {
        return doctorPrescriptionClassific;
    }

    public void setDoctorPrescriptionClassific(String doctorPrescriptionClassific) {
        this.doctorPrescriptionClassific = doctorPrescriptionClassific == null ? null : doctorPrescriptionClassific.trim();
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
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
