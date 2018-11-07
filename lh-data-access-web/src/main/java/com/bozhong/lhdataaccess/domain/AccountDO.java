package com.bozhong.lhdataaccess.domain;

import java.util.Date;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 账号的Model对象
 */
public class AccountDO {
    private Long id;

    private String login;

    private String password;

    private String name;

    private String avatarFileId;

    private Long mobile;

    private String email;

    private String validFlag;

    private Integer loginCount;

    private Date lastLoginTime;

    private Long hospitalId;

    private String hospitalIds;

    private String wardId;

    private Long userTypeId;

    private String roleIds;

    private Long deptId;

    private String qq;

    private String position;

    private String alipay;

    private String title;

    private String skill;

    private Integer signFlag;

    private String attributes;

    private Integer version;

    private Long userTags1;

    private Long userTags2;

    private String address;

    private String cardId;

    private String fixedTelephone;

    private String encryptedStr;

    private String clientVersion;

    private String phoneType;

    private String ip;

    private Long createId;

    private Date createTime;

    private Long updateId;

    private Date updateTime;

    private String jobNumber;

    private String sex;

    private String tier;

    private String education;

    private Date birthday;

    private Date firstWorkday;

    private String wechatId;

    private String profession;

    private Date intodeptTime;

    private String nickname;

    private String nailSoftwareId;

    private String signalLanguage;

    private String professionalLicense;

    private String foreignGrade;

    private Date standardTrainDate;

    private String educateExperice;

    private String workExprice;

    private Date startWorkDate;

    private Long trainTypeId;

    private Integer vipFlag;

    private Date vipExpireTime;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login == null ? null : login.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAvatarFileId() {
        return avatarFileId;
    }

    public void setAvatarFileId(String avatarFileId) {
        this.avatarFileId = avatarFileId == null ? null : avatarFileId.trim();
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag == null ? null : validFlag.trim();
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalIds() {
        return hospitalIds;
    }

    public void setHospitalIds(String hospitalIds) {
        this.hospitalIds = hospitalIds == null ? null : hospitalIds.trim();
    }

    public String getWardId() {
        return wardId;
    }

    public void setWardId(String wardId) {
        this.wardId = wardId == null ? null : wardId.trim();
    }

    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds == null ? null : roleIds.trim();
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay == null ? null : alipay.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill == null ? null : skill.trim();
    }

    public Integer getSignFlag() {
        return signFlag;
    }

    public void setSignFlag(Integer signFlag) {
        this.signFlag = signFlag;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes == null ? null : attributes.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getUserTags1() {
        return userTags1;
    }

    public void setUserTags1(Long userTags1) {
        this.userTags1 = userTags1;
    }

    public Long getUserTags2() {
        return userTags2;
    }

    public void setUserTags2(Long userTags2) {
        this.userTags2 = userTags2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getFixedTelephone() {
        return fixedTelephone;
    }

    public void setFixedTelephone(String fixedTelephone) {
        this.fixedTelephone = fixedTelephone == null ? null : fixedTelephone.trim();
    }

    public String getEncryptedStr() {
        return encryptedStr;
    }

    public void setEncryptedStr(String encryptedStr) {
        this.encryptedStr = encryptedStr == null ? null : encryptedStr.trim();
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion == null ? null : clientVersion.trim();
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType == null ? null : phoneType.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
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

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier == null ? null : tier.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getFirstWorkday() {
        return firstWorkday;
    }

    public void setFirstWorkday(Date firstWorkday) {
        this.firstWorkday = firstWorkday;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId == null ? null : wechatId.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public Date getIntodeptTime() {
        return intodeptTime;
    }

    public void setIntodeptTime(Date intodeptTime) {
        this.intodeptTime = intodeptTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getNailSoftwareId() {
        return nailSoftwareId;
    }

    public void setNailSoftwareId(String nailSoftwareId) {
        this.nailSoftwareId = nailSoftwareId == null ? null : nailSoftwareId.trim();
    }

    public String getSignalLanguage() {
        return signalLanguage;
    }

    public void setSignalLanguage(String signalLanguage) {
        this.signalLanguage = signalLanguage == null ? null : signalLanguage.trim();
    }

    public String getProfessionalLicense() {
        return professionalLicense;
    }

    public void setProfessionalLicense(String professionalLicense) {
        this.professionalLicense = professionalLicense == null ? null : professionalLicense.trim();
    }

    public String getForeignGrade() {
        return foreignGrade;
    }

    public void setForeignGrade(String foreignGrade) {
        this.foreignGrade = foreignGrade == null ? null : foreignGrade.trim();
    }

    public Date getStandardTrainDate() {
        return standardTrainDate;
    }

    public void setStandardTrainDate(Date standardTrainDate) {
        this.standardTrainDate = standardTrainDate;
    }

    public String getEducateExperice() {
        return educateExperice;
    }

    public void setEducateExperice(String educateExperice) {
        this.educateExperice = educateExperice == null ? null : educateExperice.trim();
    }

    public String getWorkExprice() {
        return workExprice;
    }

    public void setWorkExprice(String workExprice) {
        this.workExprice = workExprice == null ? null : workExprice.trim();
    }

    public Date getStartWorkDate() {
        return startWorkDate;
    }

    public void setStartWorkDate(Date startWorkDate) {
        this.startWorkDate = startWorkDate;
    }

    public Long getTrainTypeId() {
        return trainTypeId;
    }

    public void setTrainTypeId(Long trainTypeId) {
        this.trainTypeId = trainTypeId;
    }

    public Integer getVipFlag() {
        return vipFlag;
    }

    public void setVipFlag(Integer vipFlag) {
        this.vipFlag = vipFlag;
    }

    public Date getVipExpireTime() {
        return vipExpireTime;
    }

    public void setVipExpireTime(Date vipExpireTime) {
        this.vipExpireTime = vipExpireTime;
    }
}