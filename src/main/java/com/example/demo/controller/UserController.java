package com.example.demo.controller;

import com.example.demo.model.ActiveLeaderBoard;
import com.example.demo.model.PastLeaderBoard;
import com.example.demo.model.User;
import com.example.demo.serializedObject.CredentialsSerialized;
import com.example.demo.serializedObject.NicknameAndDeviceIdSerialized;
import com.example.demo.serializedObject.UserDataSerialized;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private int page;
    private UserService userService;
    // private ActiveLeaderBoardService activeLeaderBoardService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

/*    @Autowired
    public void setActiveLeaderBoardService(ActiveLeaderBoardService activeLeaderBoardService){
        this.activeLeaderBoardService = activeLeaderBoardService;
    }*/

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView allUsers(@RequestParam(defaultValue = "1") int page) {
        List<User> users = userService.allUsers(page);
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

    @ResponseBody
    @RequestMapping(value = "/get-json/{id}", method = RequestMethod.GET)
    public UserDataSerialized getUserData(@PathVariable("id") int id) {
        User user = userService.getById(id);
        return getUserDataSerializedByUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/get-json/", method = RequestMethod.GET)
    public UserDataSerialized getUserData(@RequestBody CredentialsSerialized credentials) {
        User user = userService.getById(credentials.getUserId());
        if(checkAuth(user, credentials))
        return getUserDataSerializedByUser(user);
        else return null;
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editUserPage(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editUserPage");
        modelAndView.addObject("user", userService.getById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("user") User changedUser) {
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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addUserPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addUserPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("newUser") NicknameAndDeviceIdSerialized nicknameAndDeviceIdSerialized) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users?page=" + this.page);
        User user = new User();
        ActiveLeaderBoard activeLeaderBoard = new ActiveLeaderBoard();
        PastLeaderBoard pastLeaderBoard = new PastLeaderBoard();
        user.setNickname(nicknameAndDeviceIdSerialized.getNickname());
        user.setDeviceId(nicknameAndDeviceIdSerialized.getDeviceId());
        user.setActiveLeaderBoard(activeLeaderBoard);
        user.setPastLeaderBoard(pastLeaderBoard);
        activeLeaderBoard.setUser(user);
        pastLeaderBoard.setUser(user);
        userService.add(user);
        return modelAndView;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users?page=" + this.page);
        userService.delete(userService.getById(id));
        return modelAndView;
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

    private boolean checkAuth(User user, CredentialsSerialized credentials){
        return user.getDeviceId().equals(credentials.getDeviceId());
    }

}
