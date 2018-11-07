package com.bozhong.lhdataaccess.domain;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 登陆用户关系的Model对象
 */
public class LoginUserRelationDO {
    private String login;

    private Long userId;

    private Long mobile;

    private String wechatId;

    private String nickname;

    private String nailSoftwareId;

    private String smallProgramId;

    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login == null ? null : login.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId == null ? null : wechatId.trim();
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

    public String getSmallProgramId() {
        return smallProgramId;
    }

    public void setSmallProgramId(String smallProgramId) {
        this.smallProgramId = smallProgramId == null ? null : smallProgramId.trim();
    }
}