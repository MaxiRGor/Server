package com.dksoft.formshift.serializedObject;

import java.io.Serializable;

public class FacebookDataSerialized implements Serializable {
    public FacebookDataSerialized(){
    }

    private String facebookId;
    private String email;
    private String realName;
    private String iconUrl;

    public FacebookDataSerialized(String facebookId, String email, String realName, String iconUrl) {
        this.facebookId = facebookId;
        this.email = email;
        this.realName = realName;
        this.iconUrl = iconUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

}
