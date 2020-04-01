package com.example.demo.service;

import com.example.demo.model.UserData;

import java.util.List;

public interface UserService {
    List<UserData> allUsers(int page);
    void add(UserData userData);
    void delete(UserData userData);
    void edit(UserData userData);
    UserData getById(int id);
    int usersCount();
}
