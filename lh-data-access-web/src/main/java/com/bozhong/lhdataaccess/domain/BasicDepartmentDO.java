package com.bozhong.lhdataaccess.domain;

import java.util.Date;

public class BasicDepartmentDO {
    private Long id;

    private Long hospitalId;

    private String name;

    private String code;

    private String otherName;

    private Long parentId;

    private String location;

    private Integer sortOrder;

    private Date picTime;

    private String picName;

    private Byte isFeatured;

    private Byte isSpecial;

    private Date createTime;

    private Date updateTime;

    private String validFlag;

    private Long createBy;

    private Long updateBy;

    private Byte isBizGift;

    private Integer level;

    private Byte defaultHosBranch;

    private String introduction;

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

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName == null ? null : otherName.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Date getPicTime() {
        return picTime;
    }

    public void setPicTime(Date picTime) {
        this.picTime = picTime;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName == null ? null : picName.trim();
    }

    public Byte getIsFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(Byte isFeatured) {
        this.isFeatured = isFeatured;
    }

    public Byte getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(Byte isSpecial) {
        this.isSpecial = isSpecial;
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

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag == null ? null : validFlag.trim();
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

    public Byte getIsBizGift() {
        return isBizGift;
    }

    public void setIsBizGift(Byte isBizGift) {
        this.isBizGift = isBizGift;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Byte getDefaultHosBranch() {
        return defaultHosBranch;
    }

    public void setDefaultHosBranch(Byte defaultHosBranch) {
        this.defaultHosBranch = defaultHosBranch;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}