package com.bozhong.lhdataaccess.domain;

import java.util.Date;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 医院账号的Model对象
 */
public class HospitalAccountDO {
    private Long hospitalId;

    private Long accountId;

    private String login;

    private String name;

    private Long mobile;

    private String qq;

    private String wardId;

    private Long deptId;

    private String validFlag;

    private String position;

    private String email;

    private String cardId;

    private String address;

    private Integer signFlag;

    private Integer version;

    private Long userTypeId;

    private String roleIds;

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

    private String title;

    private String skill;

    private String avatarFileId;

    private String attributes;

    private Boolean identity;

    private Long orgWardId;

    private String profession;

    private Date intodeptTime;

    private String nickname;

    private String signalLanguage;

    private Long userTags1;

    private Long userTags2;

    private Long trainTypeId;

    private String trainPrivilege;

    private String professionalLicense;

    private String foreignGrade;

    private Date standardTrainDate;

    private String educateExperice;

    private String workExprice;

    private Date startWorkDate;

    private String cadetCardNumber;

    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login == null ? null : login.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWardId() {
        return wardId;
    }

    public void setWardId(String wardId) {
        this.wardId = wardId == null ? null : wardId.trim();
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag == null ? null : validFlag.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getSignFlag() {
        return signFlag;
    }

    public void setSignFlag(Integer signFlag) {
        this.signFlag = signFlag;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public String getAvatarFileId() {
        return avatarFileId;
    }

    public void setAvatarFileId(String avatarFileId) {
        this.avatarFileId = avatarFileId == null ? null : avatarFileId.trim();
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes == null ? null : attributes.trim();
    }

    public Boolean getIdentity() {
        return identity;
    }

    public void setIdentity(Boolean identity) {
        this.identity = identity;
    }

    public Long getOrgWardId() {
        return orgWardId;
    }

    public void setOrgWardId(Long orgWardId) {
        this.orgWardId = orgWardId;
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

    public String getSignalLanguage() {
        return signalLanguage;
    }

    public void setSignalLanguage(String signalLanguage) {
        this.signalLanguage = signalLanguage == null ? null : signalLanguage.trim();
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

    public Long getTrainTypeId() {
        return trainTypeId;
    }

    public void setTrainTypeId(Long trainTypeId) {
        this.trainTypeId = trainTypeId;
    }

    public String getTrainPrivilege() {
        return trainPrivilege;
    }

    public void setTrainPrivilege(String trainPrivilege) {
        this.trainPrivilege = trainPrivilege == null ? null : trainPrivilege.trim();
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

    public String getCadetCardNumber() {
        return cadetCardNumber;
    }

    public void setCadetCardNumber(String cadetCardNumber) {
        this.cadetCardNumber = cadetCardNumber == null ? null : cadetCardNumber.trim();
    }
}