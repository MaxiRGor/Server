package com.example.demo.dao;

import com.example.demo.model.Film;
import com.example.demo.model.UserData;

import java.util.List;

public interface UserDAO {
    List<UserData> allUsers(int page);
    void add(UserData userData);
    void delete(UserData userData);
    void edit(UserData userData);
    UserData getById(int id);
    int usersCount();
}
