package com.bozhong.lhdataaccess.domain;

import java.util.Date;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 医生医嘱的Model对象
 */
public class DoctorOrderDO {

    private Long id;

    private String doctorOrderNumber;

    private String patientId;

    private String organizStructureCode;

    private String doctorOrderName;

    private String doctorOrderLongTemporary;

    private String doctorOrderClassific;

    private String doctorOrderTypeCode;

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

    public String getDoctorOrderTypeCode() {
        return doctorOrderTypeCode;
    }

    public void setDoctorOrderTypeCode(String doctorOrderTypeCode) {
        this.doctorOrderTypeCode = doctorOrderTypeCode;
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

    public String getDoctorOrderNumber() {
        return doctorOrderNumber;
    }

    public void setDoctorOrderNumber(String doctorOrderNumber) {
        this.doctorOrderNumber = doctorOrderNumber == null ? null : doctorOrderNumber.trim();
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

    public String getDoctorOrderName() {
        return doctorOrderName;
    }

    public void setDoctorOrderName(String doctorOrderName) {
        this.doctorOrderName = doctorOrderName == null ? null : doctorOrderName.trim();
    }

    public String getDoctorOrderLongTemporary() {
        return doctorOrderLongTemporary;
    }

    public void setDoctorOrderLongTemporary(String doctorOrderLongTemporary) {
        this.doctorOrderLongTemporary = doctorOrderLongTemporary == null ? null : doctorOrderLongTemporary.trim();
    }

    public String getDoctorOrderClassific() {
        return doctorOrderClassific;
    }

    public void setDoctorOrderClassific(String doctorOrderClassific) {
        this.doctorOrderClassific = doctorOrderClassific == null ? null : doctorOrderClassific.trim();
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
