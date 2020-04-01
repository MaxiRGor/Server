package com.example.demo.controller;

import com.example.demo.model.Film;
import com.example.demo.model.UserData;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    private int page;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView allFilms(@RequestParam(defaultValue = "1") int page) {
        List<UserData> users = userService.allUsers(page);
        this.page = page;
        int usersCount = userService.usersCount();
        int pagesCount = (usersCount + 9) / 10;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("page", page);
        modelAndView.addObject("users", users);
        modelAndView.addObject("usersCount", usersCount);
        modelAndView.addObject("pagesCount", pagesCount);
        return modelAndView;
    }


    @RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
    public ModelAndView editUserPage(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editUserPage");
        modelAndView.addObject("user", userService.getById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("user") UserData user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users?page=" + this.page);
        userService.edit(user);
        return modelAndView;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public ModelAndView addUserPage(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("addUserPage");
        return modelAndView;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("film") UserData user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users?page=" + this.page);
        userService.add(user);
        return modelAndView;
    }

    @RequestMapping(value = "deleteUser/{id}",method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users?page=" + this.page);
        userService.delete(userService.getById(id));
        return modelAndView;
    }

}
