package com.bozhong.lhdataaccess.domain;

import java.util.Date;
/**
 * User: 李志坚
 * Date: 2018/11/5
 * 住院患者的Model对象
 */
public class InPatientDO {
    private Long id;

    private String patientId;

    private String patientName;

    private String patientNumber;

    private String bedNumber;

    private String telephone;

    private String idNumber;

    private Date dateOfBirth;

    private String attendingDoctorName;

    private String organizStructureCode;

    private String departCode;

    private String departName;

    private String wardCode;

    private String wardName;

    private Date visitTime;

    private String visitRecord;

    private String visitCardNumber;

    private Date diagnosticUpdateTime;

    private Date admissionTime;

    private String admissionState;

    private String hospitalRecord;

    private String outcome;

    private String validFlag;

    private Long createId;

    private Date createTime;

    private Long updateId;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber == null ? null : patientNumber.trim();
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber == null ? null : bedNumber.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAttendingDoctorName() {
        return attendingDoctorName;
    }

    public void setAttendingDoctorName(String attendingDoctorName) {
        this.attendingDoctorName = attendingDoctorName == null ? null : attendingDoctorName.trim();
    }

    public String getOrganizStructureCode() {
        return organizStructureCode;
    }

    public void setOrganizStructureCode(String organizStructureCode) {
        this.organizStructureCode = organizStructureCode == null ? null : organizStructureCode.trim();
    }

    public String getDepartCode() {
        return departCode;
    }

    public void setDepartCode(String departCode) {
        this.departCode = departCode == null ? null : departCode.trim();
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName == null ? null : departName.trim();
    }

    public String getWardCode() {
        return wardCode;
    }

    public void setWardCode(String wardCode) {
        this.wardCode = wardCode == null ? null : wardCode.trim();
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName == null ? null : wardName.trim();
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitRecord() {
        return visitRecord;
    }

    public void setVisitRecord(String visitRecord) {
        this.visitRecord = visitRecord == null ? null : visitRecord.trim();
    }

    public String getVisitCardNumber() {
        return visitCardNumber;
    }

    public void setVisitCardNumber(String visitCardNumber) {
        this.visitCardNumber = visitCardNumber == null ? null : visitCardNumber.trim();
    }

    public Date getDiagnosticUpdateTime() {
        return diagnosticUpdateTime;
    }

    public void setDiagnosticUpdateTime(Date diagnosticUpdateTime) {
        this.diagnosticUpdateTime = diagnosticUpdateTime;
    }

    public Date getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(Date admissionTime) {
        this.admissionTime = admissionTime;
    }

    public String getAdmissionState() {
        return admissionState;
    }

    public void setAdmissionState(String admissionState) {
        this.admissionState = admissionState == null ? null : admissionState.trim();
    }

    public String getHospitalRecord() {
        return hospitalRecord;
    }

    public void setHospitalRecord(String hospitalRecord) {
        this.hospitalRecord = hospitalRecord == null ? null : hospitalRecord.trim();
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome == null ? null : outcome.trim();
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