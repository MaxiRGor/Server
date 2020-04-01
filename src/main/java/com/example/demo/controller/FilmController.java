package com.example.demo.controller;

import com.example.demo.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.service.FilmService;

import java.util.List;

@Controller
public class FilmController {

    private int page;
    private FilmService filmService;

    @Autowired
    public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }


    @RequestMapping(value = "/films", method = RequestMethod.GET)
    public ModelAndView allFilms(@RequestParam(defaultValue = "1") int page){
        List<Film> films = filmService.allFilms(page);
        this.page = page;
        int filmsCount = filmService.filmsCount();
        int pagesCount = (filmsCount + 9) /10;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("films");
        modelAndView.addObject("page",page);
        modelAndView.addObject("filmsList",films);
        modelAndView.addObject("filmsCount", filmsCount);
        modelAndView.addObject("pagesCount", pagesCount);
        return modelAndView;
    }

    @RequestMapping(value = "/editFilm/{id}", method = RequestMethod.GET)
    public ModelAndView editFilmPage(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editFilmPage");
        modelAndView.addObject("film",filmService.getById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/editFilm", method = RequestMethod.POST)
    public ModelAndView editFilm(@ModelAttribute("film") Film film){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/films?page=" + this.page);
        filmService.edit(film);
        return modelAndView;
    }

    @RequestMapping(value = "/addFilm", method = RequestMethod.GET)
    public ModelAndView addFilmPage(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("addFilmPage");
        return modelAndView;
    }

    @RequestMapping(value = "/addFilm", method = RequestMethod.POST)
    public ModelAndView addFilm(@ModelAttribute("film") Film film){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/films?page=" + this.page);
        filmService.add(film);
        return modelAndView;
    }

    @RequestMapping(value = "deleteFilm/{id}",method = RequestMethod.GET)
    public ModelAndView deleteFilm(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/films?page=" + this.page);
        Film film = filmService.getById(id);
        filmService.delete(film);
        return modelAndView;
    }
}
