package com.dksoft.formshift.service.user;

import com.dksoft.formshift.dao.user.UserDAO;
import com.dksoft.formshift.model.User;
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
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public List<User> getUsersAtPage(int page) {
        return userDAO.getUsersAtPage(page);
    }

    @Override
    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    @Transactional
    public void edit(User user) {
        userDAO.edit(user);
    }

    @Override
    @Transactional
    public User getById(int id) {
        return userDAO.getById(id);
    }

    @Override
    @Transactional
    public int usersCount() {
        return userDAO.usersCount();
    }
}
