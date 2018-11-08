package com.bozhong.lhdataaccess.domain;

import java.util.Date;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 住院诊断的Model对象
 */
public class DoctorInDiagnosisDO {

    private Long id;

    private String doctorDiagnosisNumber;

    private String doctorDiagnosisName;

    private String doctorDiagnosisCode;

    private String patientId;

    private String organizStructureCode;

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

    public String getDoctorDiagnosisCode() {
        return doctorDiagnosisCode;
    }

    public void setDoctorDiagnosisCode(String doctorDiagnosisCode) {
        this.doctorDiagnosisCode = doctorDiagnosisCode;
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

    public String getDoctorDiagnosisNumber() {
        return doctorDiagnosisNumber;
    }

    public void setDoctorDiagnosisNumber(String doctorDiagnosisNumber) {
        this.doctorDiagnosisNumber = doctorDiagnosisNumber == null ? null : doctorDiagnosisNumber.trim();
    }

    public String getDoctorDiagnosisName() {
        return doctorDiagnosisName;
    }

    public void setDoctorDiagnosisName(String doctorDiagnosisName) {
        this.doctorDiagnosisName = doctorDiagnosisName == null ? null : doctorDiagnosisName.trim();
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
