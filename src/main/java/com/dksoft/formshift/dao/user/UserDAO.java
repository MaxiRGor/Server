package com.dksoft.formshift.dao.user;

import com.dksoft.formshift.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    List<User> getUsersAtPage(int page);
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(int id);
    int usersCount();
}
