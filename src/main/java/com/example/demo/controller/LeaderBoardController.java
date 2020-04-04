package com.example.demo.controller;

import com.example.demo.model.ActiveLeaderBoard;
import com.example.demo.service.ActiveLeaderBoardService;
import com.example.demo.util.SortByScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/leader-board")
public class LeaderBoardController {

    private int activeLeaderBoardPage;
    private int pastLeaderBoardPage;
    private ActiveLeaderBoardService activeLeaderBoardService;

    @Autowired
    public void setActiveLeaderBoardService(ActiveLeaderBoardService activeLeaderBoardService) {
        this.activeLeaderBoardService = activeLeaderBoardService;
    }

    @RequestMapping(value = "/active", method = RequestMethod.GET)
    public ModelAndView getActiveLeaderBoard(@RequestParam(defaultValue = "1") int page) {
        List<ActiveLeaderBoard> leaders = activeLeaderBoardService.getActiveLeaderBoardAtPage(page);
        this.activeLeaderBoardPage = page;
        int activeLeaderBoardCount = activeLeaderBoardService.activeLeaderBoardCount();
        int pagesCount = (activeLeaderBoardCount + 9) / 10;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("activeLeaderBoards");
        modelAndView.addObject("page", page);
        modelAndView.addObject("leaders", leaders);
        modelAndView.addObject("activeLeaderBoardCount", activeLeaderBoardCount);
        modelAndView.addObject("pagesCount", pagesCount);
        return modelAndView;
    }

    @RequestMapping(value = "/past", method = RequestMethod.GET)
    public ModelAndView getPastLeaderBoard(@RequestParam(defaultValue = "1") int page) {
        List<ActiveLeaderBoard> leaders = activeLeaderBoardService.getActiveLeaderBoardAtPage(page);
        this.pastLeaderBoardPage = page;
        int activeLeaderBoardCount = activeLeaderBoardService.activeLeaderBoardCount();
        int pagesCount = (activeLeaderBoardCount + 9) / 10;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("activeLeaderBoards");
        modelAndView.addObject("page", page);
        modelAndView.addObject("leaders", leaders);
        modelAndView.addObject("activeLeaderBoardCount", activeLeaderBoardCount);
        modelAndView.addObject("pagesCount", pagesCount);
        return modelAndView;
    }

    public void updateLeaderboard(){
        System.out.println("updatingLeaderBoard");
        List<ActiveLeaderBoard> leaders = activeLeaderBoardService.getActiveLeaderBoard();
        leaders.sort(new SortByScore());
        for (int i = 0; i < leaders.size(); i++) {
            leaders.get(i).setPlace(i+1);
            activeLeaderBoardService.edit(leaders.get(i));
        }
        System.out.println("updated");
    }

    public void renewLeaderBoard() {
    }

    public void deletePassedLeaderBoard() {
    }
}
