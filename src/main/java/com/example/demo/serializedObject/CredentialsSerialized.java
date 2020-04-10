package com.example.demo.serializedObject;

import java.io.Serializable;

public class CredentialsSerialized implements Serializable {
    public CredentialsSerialized() {
    }

    private int userId;
    private String deviceId;

    public CredentialsSerialized(int userId, String deviceId) {
        this.userId = userId;
        this.deviceId = deviceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
