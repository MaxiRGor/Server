package com.example.demo.dao;

import com.example.demo.model.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class FilmDAOImpl implements FilmDAO {

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
    public List<Film> allFilms(int page) {
        return getCurrentSession().createQuery("from Film").setFirstResult((10 * (page - 1))).setMaxResults(10).list();
    }

    @Override
    public void add(Film film) {
        getCurrentSession().persist(film);
    }

    @Override
    public void delete(Film film) {
        getCurrentSession().delete(film);
    }

    @Override
    public void edit(Film film) {
        getCurrentSession().update(film);
    }

    @Override
    public Film getById(int id) {
       return getCurrentSession().get(Film.class, id);
    }

    @Override
    public int filmsCount() {
        return getCurrentSession().createQuery("select count(*) from Film", Number.class).getSingleResult().intValue();
    }

}
