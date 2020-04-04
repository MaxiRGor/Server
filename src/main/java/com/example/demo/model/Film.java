package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "films")
public class Film {

    private int id;
    private String title;
    private int year;
    private String genre;
    private boolean watched;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    @Column(name = "year")
    public int getYear() {
        return year;
    }

    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    @Column(name = "watched")
    public boolean isWatched() {
        return watched;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }
}