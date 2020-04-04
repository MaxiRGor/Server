package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface UserDAO {
    List<User> allUsers(int page);
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(int id);
    int usersCount();
}
