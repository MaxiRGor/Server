package com.example.demo.serializedObject;

import com.example.demo.model.User;

import java.io.Serializable;

public class FacebookDataSerialized implements Serializable {
    private User user;
    private String facebookId;
    private String email;
    private String realName;
    private String iconUrl;
}
