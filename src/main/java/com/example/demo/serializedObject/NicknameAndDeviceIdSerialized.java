package com.example.demo.serializedObject;

import java.io.Serializable;

public class NicknameAndDeviceIdSerialized implements Serializable {

    private String nickname;
    private String deviceId;

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

}
