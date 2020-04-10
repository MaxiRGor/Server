package com.example.demo.serializedObject;

import java.io.Serializable;

public class FacebookDataWithUserIdSerialized implements Serializable {
    public FacebookDataWithUserIdSerialized(){
    }

    private int userId;
    private String facebookId;
    private String email;
    private String realName;
    private String iconUrl;

    public FacebookDataWithUserIdSerialized(int userId, String facebookId, String email, String realName, String iconUrl) {
        this.userId = userId;
        this.facebookId = facebookId;
        this.email = email;
        this.realName = realName;
        this.iconUrl = iconUrl;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
}
