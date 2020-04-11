package com.dksoft.formshift.dao.user;


import com.dksoft.formshift.model.User;
import com.dksoft.formshift.GameVariables;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return getCurrentSession().createQuery("from User ").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsersAtPage(int page) {
        return getCurrentSession().createQuery("from User ").setFirstResult((GameVariables.getInstance().getAmountOfItemsOnPage() * (page - 1))).setMaxResults(GameVariables.getInstance().getAmountOfItemsOnPage()).list();
    }

    @Override
    public void add(User user) {
        getCurrentSession().persist(user);
    }

    @Override
    public void delete(User user) {
        getCurrentSession().delete(user);
    }

    @Override
    public void edit(User user) {
        getCurrentSession().update(user);
    }

    @Override
    public User getById(int id) {
        return getCurrentSession().get(User.class, id);
    }

    @Override
    public int usersCount() {
        return getCurrentSession().createQuery("select count(*) from User ", Number.class).getSingleResult().intValue();
    }
}
