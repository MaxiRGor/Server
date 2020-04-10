package com.example.demo.serializedObject;

import java.io.Serializable;

public class NicknameAndDeviceIdSerialized implements Serializable {

    private String nickname;
    private String deviceId;

    public NicknameAndDeviceIdSerialized(String nickname, String deviceId) {
        this.nickname = nickname;
        this.deviceId = deviceId;
    }

    public NicknameAndDeviceIdSerialized() {
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

}
