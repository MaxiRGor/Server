package com.dksoft.formshift.serializedObject;

import java.io.Serializable;

public class FacebookDataWithNicknameAndDeviceIdSerialized implements Serializable {
    public FacebookDataWithNicknameAndDeviceIdSerialized() {
    }


    private int userId;
    private String nickname;
    private String deviceId;
    private String facebookId;
    private String email;
    private String realName;
    private String iconUrl;

    public FacebookDataWithNicknameAndDeviceIdSerialized(int userId, String nickname, String deviceId, String facebookId, String email, String realName, String iconUrl) {
        this.userId = userId;
        this.nickname = nickname;
        this.deviceId = deviceId;
        this.facebookId = facebookId;
        this.email = email;
        this.realName = realName;
        this.iconUrl = iconUrl;
    }

    public FacebookDataWithNicknameAndDeviceIdSerialized(String nickname, String deviceId, String facebookId, String email, String realName, String iconUrl) {
        this.nickname = nickname;
        this.deviceId = deviceId;
        this.facebookId = facebookId;
        this.email = email;
        this.realName = realName;
        this.iconUrl = iconUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
