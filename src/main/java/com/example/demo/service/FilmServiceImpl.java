package com.example.demo.service;

import com.example.demo.dao.FilmDAO;
import com.example.demo.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    private FilmDAO filmDao;

    @Autowired
    public void setFilmDao(FilmDAO filmDao){
        this.filmDao = filmDao;
    }

    @Override
    @Transactional
    public List<Film> allFilms(int page) {
     return    filmDao.allFilms(page);
    }

    @Override
    @Transactional
    public void add(Film film) {
filmDao.add(film);
    }

    @Override
    @Transactional
    public void delete(Film film) {
filmDao.delete(film);
    }

    @Override
    @Transactional
    public void edit(Film film) {
filmDao.edit(film);
    }

    @Override
    @Transactional
    public Film getById(int id) {
        return filmDao.getById(id);
    }

    @Override
    @Transactional
    public int filmsCount() {
        return filmDao.filmsCount();
    }
}
