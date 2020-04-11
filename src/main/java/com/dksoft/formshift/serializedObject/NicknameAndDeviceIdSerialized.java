package com.dksoft.formshift.serializedObject;

import java.io.Serializable;

public class NicknameAndDeviceIdSerialized implements Serializable {
    public NicknameAndDeviceIdSerialized() {
    }

    private String nickname;
    private String deviceId;

    public NicknameAndDeviceIdSerialized(String nickname, String deviceId) {
        this.nickname = nickname;
        this.deviceId = deviceId;
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
