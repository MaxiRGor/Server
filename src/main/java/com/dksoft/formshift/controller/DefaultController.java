package com.dksoft.formshift.controller;

import com.dksoft.formshift.GameVariables;
import org.springframework.web.servlet.ModelAndView;

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




    int getPageNumber(int itemsCount){
        return (itemsCount + GameVariables.getInstance().getAmountOfItemsOnPage() - 1) / GameVariables.getInstance().getAmountOfItemsOnPage();
    }

    ModelAndView getUsersModelAndView(int page) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users?page=" + page);
        return modelAndView;
    }
}
