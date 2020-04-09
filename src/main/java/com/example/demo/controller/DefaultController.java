package com.example.demo.controller;

import com.example.demo.GameVariables;
import com.example.demo.util.Attribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class DefaultController {

/*    public ModelAndView getModelAndView(String viewName, List<Attribute> attributes){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        for (Attribute attribute:attributes
             ) {
            modelAndView.addObject(attribute.getName(),attribute.getObject());
        }
       return modelAndView;
    }*/

    public int getPage(int itemsCount){
        return (itemsCount + GameVariables.getInstance().getAmountOfItemsOnPage() - 1) / GameVariables.getInstance().getAmountOfItemsOnPage();
    }
}
