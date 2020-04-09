package com.example.demo.controller;

import com.example.demo.GameVariables;
import com.example.demo.model.User;
import com.example.demo.model.leaderBoard.ActiveLeaderBoard;
import com.example.demo.model.leaderBoard.PastLeaderBoard;
import com.example.demo.serializedObject.ActiveLeaderBoardDataSerialized;
import com.example.demo.serializedObject.PastLeaderBoardDataSerialized;
import com.example.demo.service.leaderBoard.active.ActiveLeaderBoardService;
import com.example.demo.service.leaderBoard.past.PastLeaderBoardService;
import com.example.demo.service.user.UserService;
import com.example.demo.util.SortByScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/leader-board")
public class LeaderBoardController extends DefaultController {

    private ActiveLeaderBoardService activeLeaderBoardService;
    private PastLeaderBoardService pastLeaderBoardService;
    private UserService userService;

    @Autowired
    public void setActiveLeaderBoardService(ActiveLeaderBoardService activeLeaderBoardService) {
        this.activeLeaderBoardService = activeLeaderBoardService;
    }

    @Autowired
    public void setActiveLeaderBoardPage(PastLeaderBoardService pastLeaderBoardService) {
        this.pastLeaderBoardService = pastLeaderBoardService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //by client
    @ResponseBody
    @RequestMapping(value = "/active/top", method = RequestMethod.GET)
    public List<ActiveLeaderBoardDataSerialized> getActiveLeaderBoardTop() {
        List<ActiveLeaderBoard> leaders = activeLeaderBoardService.getActiveLeaderBoardTop(GameVariables.getInstance().getAmountOfLeadersToShow());
        List<ActiveLeaderBoardDataSerialized> leadersSerialized = new ArrayList<>();
        for (ActiveLeaderBoard leader : leaders) {
            leadersSerialized.add(new ActiveLeaderBoardDataSerialized(leader.getUser().getNickname(), leader.getPlace(), leader.getUser().getHighScore()));
        }
        return leadersSerialized;
    }

    //by client
    @ResponseBody
    @RequestMapping(value = "/past/top", method = RequestMethod.GET)
    public List<PastLeaderBoardDataSerialized> getPastLeaderBoardTop() {
        List<PastLeaderBoard> leaders = pastLeaderBoardService.getPastLeaderBoardTop(GameVariables.getInstance().getAmountOfLeadersToShow());
        List<PastLeaderBoardDataSerialized> leadersSerialized = new ArrayList<>();
        for (PastLeaderBoard leader : leaders) {
            leadersSerialized.add(new PastLeaderBoardDataSerialized(leader.getUser().getNickname(), leader.getPlace(), leader.getSavedScore(),
                    GameVariables.getInstance().getRewardByPlace(leader.getPlace()), leader.isRewardTaken()));
        }
        return leadersSerialized;
    }


    //by client
    @ResponseBody
    @RequestMapping(value = "/active/{user-id}", method = RequestMethod.GET)
    public ActiveLeaderBoardDataSerialized getActiveLeaderBoardByUserId(@PathVariable("user-id") int userId) {
        User user = userService.getById(userId);
        return new ActiveLeaderBoardDataSerialized(
                user.getNickname(),
                user.getActiveLeaderBoard().getPlace(),
                user.getHighScore()
        );
    }

    //by client
    @ResponseBody
    @RequestMapping(value = "/past/{user-id}", method = RequestMethod.GET)
    public PastLeaderBoardDataSerialized getPastLeaderBoardByUserId(@PathVariable("user-id") int userId) {
        User user = userService.getById(userId);
        return new PastLeaderBoardDataSerialized(
                user.getNickname(),
                user.getPastLeaderBoard().getPlace(),
                user.getPastLeaderBoard().getSavedScore(),
                GameVariables.getInstance().getRewardByPlace(user.getPastLeaderBoard().getPlace()),
                user.getPastLeaderBoard().isRewardTaken()
        );
    }

    // by admin
    @RequestMapping(value = "/active", method = RequestMethod.GET)
    public ModelAndView getActiveLeaderBoardPage(@RequestParam(defaultValue = "1") int page) {
        List<ActiveLeaderBoard> activeLeaders = activeLeaderBoardService.getActiveLeaderBoardSortedByPlaceAtPage(page);
        int activeLeaderBoardCount = activeLeaderBoardService.activeLeaderBoardCount();
        int pagesCount = getPageNumber(activeLeaderBoardCount);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("leaderBoard/activeLeaderBoard");
        modelAndView.addObject("page", page);
        modelAndView.addObject("activeLeaders", activeLeaders);
        modelAndView.addObject("activeLeaderBoardCount", activeLeaderBoardCount);
        modelAndView.addObject("pagesCount", pagesCount);
        return modelAndView;
    }


    // by admin
    @RequestMapping(value = "/past", method = RequestMethod.GET)
    public ModelAndView getPastLeaderBoardPage(@RequestParam(defaultValue = "1") int page) {
        List<PastLeaderBoard> pastLeaders = pastLeaderBoardService.getPastLeaderBoardSortedByPlaceAtPage(page);
        int pastLeaderBoardCount = pastLeaderBoardService.pastLeaderBoardCount();
        int pagesCount = getPageNumber(pastLeaderBoardCount);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("leaderBoard/pastLeaderBoard");
        modelAndView.addObject("page", page);
        modelAndView.addObject("pastLeaders", pastLeaders);
        modelAndView.addObject("pastLeaderBoardCount", pastLeaderBoardCount);
        modelAndView.addObject("pagesCount", pagesCount);
        return modelAndView;
    }


    public void updateActiveLeaderBoard() {
        System.out.println("updatingLeaderBoard");
        List<ActiveLeaderBoard> leaders = activeLeaderBoardService.getActiveLeaderBoard();
        /*
        if (leaders.size() < GameVariables.getInstance().getAmountOfLeadersToKeepInLeaderBoard()) {
                    GameVariables.getInstance().setAmountOfLeadersToKeepInLeaderBoard(leaders.size());
                }*/
        leaders.sort(new SortByScore());
        for (int i = 0; i < leaders.size(); i++) {
            leaders.get(i).setPlace(i + 1);
            activeLeaderBoardService.edit(leaders.get(i));
        }
        System.out.println("updated");
    }

    public void saveDataToPastLeaderBoardAndClearActiveLeaderBoard() {
        updateActiveLeaderBoard();
        setPastLeaderBoardFromActiveLeaderBoard();
        clearActiveLeaderBoard();
    }



    private void setPastLeaderBoardFromActiveLeaderBoard() {
        List<PastLeaderBoard> pastLeaders = pastLeaderBoardService.getPastLeaderBoard();
        for (PastLeaderBoard pastLeader : pastLeaders) {
            pastLeader.setPlace(pastLeader.getUser().getActiveLeaderBoard().getPlace());
            pastLeader.setSavedScore(pastLeader.getUser().getHighScore());
            pastLeader.setRewardTaken(false);
            pastLeaderBoardService.edit(pastLeader);
        }
    }

    private void clearActiveLeaderBoard() {
        List<ActiveLeaderBoard> activeLeaders = activeLeaderBoardService.getActiveLeaderBoard();
        for (ActiveLeaderBoard activeLeader : activeLeaders) {
            activeLeader.setPlace(0);
            activeLeaderBoardService.edit(activeLeader);
        }

    }

    public void clearPastLeaderBoard() {
        List<PastLeaderBoard> pastLeaders = pastLeaderBoardService.getPastLeaderBoard();
        for (PastLeaderBoard pastLeader : pastLeaders) {
            pastLeader.setPlace(0);
            pastLeader.setSavedScore(0);
            pastLeader.setRewardTaken(true);
            pastLeaderBoardService.edit(pastLeader);
        }

    }
}
