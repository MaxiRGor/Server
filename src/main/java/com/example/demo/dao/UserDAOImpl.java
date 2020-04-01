package com.example.demo.dao;


import com.example.demo.model.Film;
import com.example.demo.model.UserData;
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


    @Override
    @SuppressWarnings("unchecked")
    public List<UserData> allUsers(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from UserData ").setFirstResult((10 * (page - 1))).setMaxResults(10).list();
    }

    @Override
    public void add(UserData userData) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(userData);
    }

    @Override
    public void delete(UserData userData) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(userData);
    }

    @Override
    public void edit(UserData userData) {
        Session session = sessionFactory.getCurrentSession();
        session.update(userData);
    }

    @Override
    public UserData getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(UserData.class, id);
    }

    @Override
    public int usersCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from UserData ", Number.class).getSingleResult().intValue();
    }
}
