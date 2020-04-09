package com.example.demo.controller;

import com.example.demo.GameVariables;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/game-variables")
public class GameVariablesController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gameVariablesPage");
        modelAndView.addObject("gameVariables", GameVariables.getInstance());
        return modelAndView;
    }
}
