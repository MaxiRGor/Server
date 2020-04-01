package com.example.demo.service;

import com.example.demo.dao.FilmDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDAO userDAO;

    @Autowired
    public void userDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }


    @Override
    @Transactional
    public List<UserData> allUsers(int page) {
        return userDAO.allUsers(page);
    }

    @Override
    @Transactional
    public void add(UserData userData) {
        userDAO.add(userData);
    }

    @Override
    @Transactional
    public void delete(UserData userData) {
        userDAO.delete(userData);
    }

    @Override
    @Transactional
    public void edit(UserData userData) {
        userDAO.edit(userData);
    }

    @Override
    @Transactional
    public UserData getById(int id) {
        return userDAO.getById(id);
    }

    @Override
    @Transactional
    public int usersCount() {
        return userDAO.usersCount();
    }
}
