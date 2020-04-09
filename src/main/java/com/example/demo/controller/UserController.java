package com.example.demo.controller;

import com.example.demo.GameVariables;
import com.example.demo.model.leaderBoard.ActiveLeaderBoard;
import com.example.demo.model.leaderBoard.PastLeaderBoard;
import com.example.demo.model.User;
import com.example.demo.serializedObject.CredentialsSerialized;
import com.example.demo.serializedObject.HighScoreSerialized;
import com.example.demo.serializedObject.NicknameAndDeviceIdSerialized;
import com.example.demo.serializedObject.UserDataSerialized;
import com.example.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController extends DefaultController{

    private int page;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //by client
    @ResponseBody
    @RequestMapping(value = "/create/", method = RequestMethod.GET)
    public UserDataSerialized createUserByClient(@RequestBody NicknameAndDeviceIdSerialized nicknameAndDeviceIdSerialized) {
        if(isNicknameNormal())
            return getUserDataSerializedByUser(createUser(nicknameAndDeviceIdSerialized));
        else return null;
    }

    //by client
    @ResponseBody
    @RequestMapping(value = "/get/", method = RequestMethod.GET)
    public UserDataSerialized getUserDataByClient(@RequestBody CredentialsSerialized credentials) {
        User user = userService.getById(credentials.getUserId());
        if(checkAuthSuccess(user, credentials))
            return getUserDataSerializedByUser(user);
        else return null;
    }

    //by client
    @ResponseBody
    @RequestMapping(value = "/add-score/{score}", method = RequestMethod.GET)
    public HighScoreSerialized addScoreByClient(@PathVariable("score") int score, @RequestBody CredentialsSerialized credentials) {
        User user = userService.getById(credentials.getUserId());
        if(checkAuthSuccess(user, credentials)){
            setHighScore(score, user);
            return new HighScoreSerialized(user.getHighScore());
        }
        else return null;
    }


    //in server
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getPageWithUsers(@RequestParam(defaultValue = "1") int page) {
        List<User> users = userService.getUsersAtPage(page);
        this.page = page;
        int usersCount = userService.usersCount();
        int pagesCount = getPage(usersCount);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/usersPage");
        modelAndView.addObject("page", page);
        modelAndView.addObject("users", users);
        modelAndView.addObject("usersCount", usersCount);
        modelAndView.addObject("pagesCount", pagesCount);
        return modelAndView;
    }

    //in server
    @ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public UserDataSerialized getPageWithUserData(@PathVariable("id") int id) {
        User user = userService.getById(id);
        return getUserDataSerializedByUser(user);
    }

    //in server
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getPageToEditUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/editUserPage");
        modelAndView.addObject("user", userService.getById(id));
        return modelAndView;
    }

    //in server
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView getPageAfterEditingUser(@ModelAttribute("user") User changedUser) {
        User user = userService.getById(changedUser.getId());
        user.setNickname(changedUser.getNickname());
        user.setHighScore(changedUser.getHighScore());
        user.setCoinsAmount(changedUser.getCoinsAmount());
        user.setCrystalsAmount(changedUser.getCrystalsAmount());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users?page=" + this.page);
        userService.edit(user);
        return modelAndView;
    }

    //in server
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView getPageToAddUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/createUserPage");
        return modelAndView;
    }

    //in server
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView getPageAfterAddingUser(@ModelAttribute("nicknameAndDeviceId") NicknameAndDeviceIdSerialized nicknameAndDeviceIdSerialized) {
        createUser(nicknameAndDeviceIdSerialized);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users?page=" + this.page);
        return modelAndView;
    }


    //in server
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public ModelAndView getPageAfterDeletingUser(@PathVariable("id") int id) {
        userService.delete(userService.getById(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users?page=" + this.page);
        return modelAndView;
    }

    private boolean isNicknameNormal() {
        //todo
        return true;
    }

    private UserDataSerialized getUserDataSerializedByUser(User user) {
        return new UserDataSerialized(user.getId(),
                false,
                user.getHighScore(),
                user.getCoinsAmount(),
                user.getCrystalsAmount(),
                user.getActiveLeaderBoard().getPlace(),
                user.getPastLeaderBoard().getPlace(),
                user.getPastLeaderBoard().isRewardTaken());
    }

    private boolean checkAuthSuccess(User user, CredentialsSerialized credentials){
        return user.getDeviceId().equals(credentials.getDeviceId());
    }

    private User createUser(NicknameAndDeviceIdSerialized nicknameAndDeviceIdSerialized) {
        User user = new User();
        ActiveLeaderBoard activeLeaderBoard = new ActiveLeaderBoard();
        PastLeaderBoard pastLeaderBoard = new PastLeaderBoard();
        user.setNickname(nicknameAndDeviceIdSerialized.getNickname());
        user.setDeviceId(nicknameAndDeviceIdSerialized.getDeviceId());
        user.setActiveLeaderBoard(activeLeaderBoard);
        user.setPastLeaderBoard(pastLeaderBoard);
        activeLeaderBoard.setUser(user);
        //activeLeaderBoard.setPlace(GameVariables.getInstance().getAmountOfLeadersToKeepInLeaderBoard() + 1);
        pastLeaderBoard.setUser(user);
        userService.add(user);
        return user;
    }

    private void setHighScore(int score, User user) {
        if(user.getHighScore()<score)
            user.setHighScore(score);
        userService.edit(user);
    }
}
