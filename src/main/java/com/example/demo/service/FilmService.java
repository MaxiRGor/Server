package com.example.demo.service;

import com.example.demo.model.Film;

import java.util.List;


public interface FilmService {
    List<Film> allFilms(int page);
    void add(Film film);
    void delete(Film film);
    void edit(Film film);
    Film getById(int id);
    int filmsCount();
}
