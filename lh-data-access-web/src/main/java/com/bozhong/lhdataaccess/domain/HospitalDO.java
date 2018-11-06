package com.bozhong.lhdataaccess.domain;

import java.util.Date;

public class HospitalDO {
    private Long id;

    private String name;

    private String address;

    private String phone;

    private String site;

    private String intro;

    private Integer sortOrder;

    private Integer nurseAssessFlag;

    private Double geoLat;

    private Double geoLng;

    private String validFlag;

    private Date createTime;

    private Date updateTime;

    private String code;

    private String province;

    private String city;

    private String county;

    private String level;

    private String imageId;

    private String timeOnline;

    private Integer departmentsNum;

    private Integer openFlag;

    private Date openCloseUpdateTime;

    private Integer bedNum;

    private Byte hospitalType;

    private String nurseDir;

    private String nurseDirPhone;

    private Long createBy;

    private Long updateBy;

    private Boolean inner;

    private String logoId;

    private String reviewRoles;

    private Long fundId;

    private String groupKey;

    private String groupSecret;

    private Long accuratePush;

    private Long accuratePushCourse;

    private Date lastHospitalFollowTime;

    private String customerServiceId;

    private String customerServiceName;

    private String customerServiceManagerId;

    private String customerServiceManagerName;

    private Byte isBizTemplateHospital;

    private Boolean pennantFlag;

    private String wechatCourseColumn;

    private String siteTitle;

    private String siteDomain;

    private String smsSign;

    private String siteIcon;

    private String siteBackground;

    private String appHomepage;

    private String appLoginBackground;

    private Boolean helpFlag;

    private String appDownloadUrl;

    private Boolean isCustom;

    private String functions;

    private String buttFlag;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Boolean getInner() {
        return inner;
    }

    public void setInner(Boolean inner) {
        this.inner = inner;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site == null ? null : site.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getNurseAssessFlag() {
        return nurseAssessFlag;
    }

    public void setNurseAssessFlag(Integer nurseAssessFlag) {
        this.nurseAssessFlag = nurseAssessFlag;
    }

    public Double getGeoLat() {
        return geoLat;
    }

    public void setGeoLat(Double geoLat) {
        this.geoLat = geoLat;
    }

    public Double getGeoLng() {
        return geoLng;
    }

    public void setGeoLng(Double geoLng) {
        this.geoLng = geoLng;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId == null ? null : imageId.trim();
    }

    public String getTimeOnline() {
        return timeOnline;
    }

    public void setTimeOnline(String timeOnline) {
        this.timeOnline = timeOnline == null ? null : timeOnline.trim();
    }

    public Integer getDepartmentsNum() {
        return departmentsNum;
    }

    public void setDepartmentsNum(Integer departmentsNum) {
        this.departmentsNum = departmentsNum;
    }

    public Integer getOpenFlag() {
        return openFlag;
    }

    public void setOpenFlag(Integer openFlag) {
        this.openFlag = openFlag;
    }

    public Date getOpenCloseUpdateTime() {
        return openCloseUpdateTime;
    }

    public void setOpenCloseUpdateTime(Date openCloseUpdateTime) {
        this.openCloseUpdateTime = openCloseUpdateTime;
    }

    public Integer getBedNum() {
        return bedNum;
    }

    public void setBedNum(Integer bedNum) {
        this.bedNum = bedNum;
    }

    public Byte getHospitalType() {
        return hospitalType;
    }

    public void setHospitalType(Byte hospitalType) {
        this.hospitalType = hospitalType;
    }

    public String getNurseDir() {
        return nurseDir;
    }

    public void setNurseDir(String nurseDir) {
        this.nurseDir = nurseDir == null ? null : nurseDir.trim();
    }

    public String getNurseDirPhone() {
        return nurseDirPhone;
    }

    public void setNurseDirPhone(String nurseDirPhone) {
        this.nurseDirPhone = nurseDirPhone == null ? null : nurseDirPhone.trim();
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


    public String getLogoId() {
        return logoId;
    }

    public void setLogoId(String logoId) {
        this.logoId = logoId == null ? null : logoId.trim();
    }

    public String getReviewRoles() {
        return reviewRoles;
    }

    public void setReviewRoles(String reviewRoles) {
        this.reviewRoles = reviewRoles == null ? null : reviewRoles.trim();
    }

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey == null ? null : groupKey.trim();
    }

    public String getGroupSecret() {
        return groupSecret;
    }

    public void setGroupSecret(String groupSecret) {
        this.groupSecret = groupSecret == null ? null : groupSecret.trim();
    }

    public Long getAccuratePush() {
        return accuratePush;
    }

    public void setAccuratePush(Long accuratePush) {
        this.accuratePush = accuratePush;
    }

    public Long getAccuratePushCourse() {
        return accuratePushCourse;
    }

    public void setAccuratePushCourse(Long accuratePushCourse) {
        this.accuratePushCourse = accuratePushCourse;
    }

    public Date getLastHospitalFollowTime() {
        return lastHospitalFollowTime;
    }

    public void setLastHospitalFollowTime(Date lastHospitalFollowTime) {
        this.lastHospitalFollowTime = lastHospitalFollowTime;
    }

    public String getCustomerServiceId() {
        return customerServiceId;
    }

    public void setCustomerServiceId(String customerServiceId) {
        this.customerServiceId = customerServiceId == null ? null : customerServiceId.trim();
    }

    public String getCustomerServiceName() {
        return customerServiceName;
    }

    public void setCustomerServiceName(String customerServiceName) {
        this.customerServiceName = customerServiceName == null ? null : customerServiceName.trim();
    }

    public String getCustomerServiceManagerId() {
        return customerServiceManagerId;
    }

    public void setCustomerServiceManagerId(String customerServiceManagerId) {
        this.customerServiceManagerId = customerServiceManagerId == null ? null : customerServiceManagerId.trim();
    }

    public String getCustomerServiceManagerName() {
        return customerServiceManagerName;
    }

    public void setCustomerServiceManagerName(String customerServiceManagerName) {
        this.customerServiceManagerName = customerServiceManagerName == null ? null : customerServiceManagerName.trim();
    }

    public Byte getIsBizTemplateHospital() {
        return isBizTemplateHospital;
    }

    public void setIsBizTemplateHospital(Byte isBizTemplateHospital) {
        this.isBizTemplateHospital = isBizTemplateHospital;
    }

    public Boolean getPennantFlag() {
        return pennantFlag;
    }

    public void setPennantFlag(Boolean pennantFlag) {
        this.pennantFlag = pennantFlag;
    }

    public String getWechatCourseColumn() {
        return wechatCourseColumn;
    }

    public void setWechatCourseColumn(String wechatCourseColumn) {
        this.wechatCourseColumn = wechatCourseColumn == null ? null : wechatCourseColumn.trim();
    }

    public String getSiteTitle() {
        return siteTitle;
    }

    public void setSiteTitle(String siteTitle) {
        this.siteTitle = siteTitle == null ? null : siteTitle.trim();
    }

    public String getSiteDomain() {
        return siteDomain;
    }

    public void setSiteDomain(String siteDomain) {
        this.siteDomain = siteDomain == null ? null : siteDomain.trim();
    }

    public String getSmsSign() {
        return smsSign;
    }

    public void setSmsSign(String smsSign) {
        this.smsSign = smsSign == null ? null : smsSign.trim();
    }

    public String getSiteIcon() {
        return siteIcon;
    }

    public void setSiteIcon(String siteIcon) {
        this.siteIcon = siteIcon == null ? null : siteIcon.trim();
    }

    public String getSiteBackground() {
        return siteBackground;
    }

    public void setSiteBackground(String siteBackground) {
        this.siteBackground = siteBackground == null ? null : siteBackground.trim();
    }

    public String getAppHomepage() {
        return appHomepage;
    }

    public void setAppHomepage(String appHomepage) {
        this.appHomepage = appHomepage == null ? null : appHomepage.trim();
    }

    public String getAppLoginBackground() {
        return appLoginBackground;
    }

    public void setAppLoginBackground(String appLoginBackground) {
        this.appLoginBackground = appLoginBackground == null ? null : appLoginBackground.trim();
    }

    public Boolean getHelpFlag() {
        return helpFlag;
    }

    public void setHelpFlag(Boolean helpFlag) {
        this.helpFlag = helpFlag;
    }

    public String getAppDownloadUrl() {
        return appDownloadUrl;
    }

    public void setAppDownloadUrl(String appDownloadUrl) {
        this.appDownloadUrl = appDownloadUrl == null ? null : appDownloadUrl.trim();
    }

    public Boolean getIsCustom() {
        return isCustom;
    }

    public void setIsCustom(Boolean isCustom) {
        this.isCustom = isCustom;
    }

    public String getFunctions() {
        return functions;
    }

    public void setFunctions(String functions) {
        this.functions = functions == null ? null : functions.trim();
    }

    public String getButtFlag() {
        return buttFlag;
    }

    public void setButtFlag(String buttFlag) {
        this.buttFlag = buttFlag == null ? null : buttFlag.trim();
    }
}