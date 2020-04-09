package com.example.demo.service.user;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    List<User> getUsersAtPage(int page);
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(int id);
    int usersCount();
}
