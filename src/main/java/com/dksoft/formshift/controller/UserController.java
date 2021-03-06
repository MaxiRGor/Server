package com.dksoft.formshift.controller;

import com.dksoft.formshift.GameVariables;
import com.dksoft.formshift.model.FacebookData;
import com.dksoft.formshift.model.User;
import com.dksoft.formshift.model.leaderBoard.ActiveLeaderBoard;
import com.dksoft.formshift.model.leaderBoard.PastLeaderBoard;
import com.dksoft.formshift.serializedObject.*;
import com.dksoft.formshift.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController extends DefaultController {

    private int page;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //by client
    @ResponseBody
    @RequestMapping(value = "/create/", method = RequestMethod.POST)
    public UserDataSerialized createUserByClient(@RequestBody NicknameAndDeviceIdSerialized nicknameAndDeviceIdSerialized) {
        if (isNicknameNormal())
            return getUserDataSerializedByUser(createUser(nicknameAndDeviceIdSerialized));
        else return null;
    }

    //by client
    @ResponseBody
    @RequestMapping(value = "/create-with-facebook-data/", method = RequestMethod.POST)
    public UserDataSerialized createUserWithFaceBookDataByClient(@RequestBody FacebookDataWithNicknameAndDeviceIdSerialized facebookDataWithNicknameAndDeviceIdSerialized) {
        return getUserDataSerializedByUser(createUserWithFacebookData(facebookDataWithNicknameAndDeviceIdSerialized));
    }

    //by client
    @ResponseBody
    @RequestMapping(value = "/add-facebook-data/", method = RequestMethod.POST)
    public UserDataSerialized addFacebookDataByClient(@RequestBody FacebookDataWithCredentialsSerialized facebookDataWithCredentialsSerialized) {
        User user = userService.getById(facebookDataWithCredentialsSerialized.getUserId());
        System.out.println("here" + user.getNickname());
        if (checkAuthSuccess(user, new CredentialsSerialized(facebookDataWithCredentialsSerialized.getUserId(),facebookDataWithCredentialsSerialized.getDeviceId())))
        {
            setFacebookData(user, new FacebookDataSerialized(facebookDataWithCredentialsSerialized.getFacebookId(),
                    facebookDataWithCredentialsSerialized.getEmail(),
                    facebookDataWithCredentialsSerialized.getRealName(),
                    facebookDataWithCredentialsSerialized.getIconUrl()));
            return getUserDataSerializedByUser(user);
        }
        else return null;
    }


    //by client
    @ResponseBody
    @RequestMapping(value = "/get/", method = RequestMethod.POST)
    public UserDataSerialized getUserDataByClient(@RequestBody CredentialsSerialized credentials) {
        User user = userService.getById(credentials.getUserId());
        if (checkAuthSuccess(user, credentials))
            return getUserDataSerializedByUser(user);
        else return null;
    }

    //by client
    @ResponseBody
    @RequestMapping(value = "/score/add/{score-amount}", method = RequestMethod.POST)
    public HighScoreSerialized addScoreByClient(@PathVariable("score-amount") int scoreAmount, @RequestBody CredentialsSerialized credentials) {
        User user = userService.getById(credentials.getUserId());
        if (checkAuthSuccess(user, credentials)) {
            setHighScore(scoreAmount, user);
            return new HighScoreSerialized(user.getHighScore());
        } else return null;
    }

    //by client
    @ResponseBody
    @RequestMapping(value = "/coins/change/{coins-amount}", method = RequestMethod.POST)
    public CoinsAmountSerialized changeCoinsAmountByClient(@PathVariable("coins-amount") int coinsAmount, @RequestBody CredentialsSerialized credentials) {
        return changedCoinsAmount(coinsAmount, credentials);
    }

    //by client
    @ResponseBody
    @RequestMapping(value = "/crystals/change/{crystals-amount}", method = RequestMethod.POST)
    public CrystalsAmountSerialized changeCrystalsAmountByClient(@PathVariable("crystals-amount") int crystalsAmount, @RequestBody CredentialsSerialized credentials) {
        return changedCrystalsAmount(crystalsAmount, credentials);
    }


    //by client
    @ResponseBody
    @RequestMapping(value = "/perform-reward/", method = RequestMethod.POST)
    public CurrencyAmountSerialized rewardUserByClient(@RequestBody CredentialsSerialized credentials) {
        User user = userService.getById(credentials.getUserId());
        if (checkAuthSuccess(user, credentials)) {
            rewardUser(user);
            return new CurrencyAmountSerialized(user.getCoinsAmount(), user.getCrystalsAmount());
        } else return null;
    }


    //by admin
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getPageWithUsers(@RequestParam(defaultValue = "1") int page) {
        List<User> users = userService.getUsersAtPage(page);
        this.page = page;
        int usersCount = userService.usersCount();
        int pagesCount = getPageNumber(usersCount);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/usersPage");
        modelAndView.addObject("page", page);
        modelAndView.addObject("users", users);
        modelAndView.addObject("usersCount", usersCount);
        modelAndView.addObject("pagesCount", pagesCount);
        return modelAndView;
    }

    //by admin
    @ResponseBody
    @RequestMapping(value = "/admin-get/{id}", method = RequestMethod.POST)
    public UserDataSerialized getPageWithUserData(@PathVariable("id") int id) {
        User user = userService.getById(id);
        return getUserDataSerializedByUser(user);
    }

    //by admin
    @RequestMapping(value = "/admin-edit/{id}", method = RequestMethod.GET)
    public ModelAndView getPageToEditUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/editUserPage");
        modelAndView.addObject("user", userService.getById(id));
        return modelAndView;
    }

    //by admin
    @RequestMapping(value = "/admin-edit", method = RequestMethod.POST)
    public ModelAndView getPageAfterEditingUser(@ModelAttribute("user") User changedUser) {
        User user = userService.getById(changedUser.getId());
        user.setNickname(changedUser.getNickname());
        user.setHighScore(changedUser.getHighScore());
        user.setCoinsAmount(changedUser.getCoinsAmount());
        user.setCrystalsAmount(changedUser.getCrystalsAmount());
        userService.edit(user);
        return getUsersModelAndView(this.page);
    }

    //by admin
    @RequestMapping(value = "/admin-create", method = RequestMethod.GET)
    public ModelAndView getPageToAddUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/createUserPage");
        return modelAndView;
    }

    //by admin
    @RequestMapping(value = "/admin-create", method = RequestMethod.POST)
    public ModelAndView getPageAfterAddingUser(@ModelAttribute("nicknameAndDeviceId") NicknameAndDeviceIdSerialized nicknameAndDeviceIdSerialized) {
        createUser(nicknameAndDeviceIdSerialized);
        return getUsersModelAndView(this.page);
    }

    //by admin
    @RequestMapping(value = "/admin-create-with-facebook-data", method = RequestMethod.GET)
    public ModelAndView getPageToAddUserWithFacebookData() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/createUserWithFacebookDataPage");
        return modelAndView;
    }

    //by admin
    @RequestMapping(value = "/admin-create-with-facebook-data", method = RequestMethod.POST)
    public ModelAndView getPageAfterAddingUserWithFacebookData(@ModelAttribute("facebookDataAndNicknameAndDeviceIdSerialized") FacebookDataWithNicknameAndDeviceIdSerialized facebookDataWithNicknameAndDeviceIdSerialized) {
        createUserWithFacebookData(facebookDataWithNicknameAndDeviceIdSerialized);
        return getUsersModelAndView(this.page);
    }

    //by admin
    @RequestMapping(value = "/users/admin-add-facebook-data/{userId}", method = RequestMethod.GET)
    public ModelAndView getPageToAddUserWithFacebookData(@PathVariable("userId") int userId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/addFacebookData");
        modelAndView.addObject("userId", userId);
        return modelAndView;
    }

    //by admin
    @RequestMapping(value = "/users/admin-add-facebook-data/", method = RequestMethod.POST)
    public ModelAndView getPageAfterAddingFacebookDataToUser(@ModelAttribute("facebookDataAndNicknameAndDeviceIdSerialized") FacebookDataWithUserIdSerialized facebookDataWithUserIdSerialized) {
        User user = userService.getById(facebookDataWithUserIdSerialized.getUserId());
        setFacebookData(user, new FacebookDataSerialized(facebookDataWithUserIdSerialized.getFacebookId(),
                facebookDataWithUserIdSerialized.getEmail(),
                facebookDataWithUserIdSerialized.getRealName(),
                facebookDataWithUserIdSerialized.getIconUrl()));
        return getUsersModelAndView(this.page);
    }


    //by admin
    @RequestMapping(value = "/admin-delete/{id}", method = RequestMethod.GET)
    public ModelAndView getPageAfterDeletingUser(@PathVariable("id") int id) {
        userService.delete(userService.getById(id));
        return getUsersModelAndView(this.page);
    }

    //by admin
    @RequestMapping(value = "/admin-set-random-score", method = RequestMethod.GET)
    public ModelAndView TEST_GET_PAGE_AFTER_SETTING_RANDOM_SCORE() {
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            user.setHighScore((int) (Math.random() * (1000)));
            userService.edit(user);
        }
        return getUsersModelAndView(this.page);
    }

    //by admin
    @RequestMapping(value = "/admin-create-initials", method = RequestMethod.GET)
    public ModelAndView TEST_GET_PAGE_AFTER_CREATING_USERS() {
        int TEST_INITIAL_USERS_AMOUNT = 1000;
        for (int i = 0; i < TEST_INITIAL_USERS_AMOUNT; i++) {
            int userCredentialId = ((int) (Math.random() * (TEST_INITIAL_USERS_AMOUNT)));
            NicknameAndDeviceIdSerialized nicknameAndDeviceIdSerialized = new NicknameAndDeviceIdSerialized("test-user-name" + userCredentialId, "test-device-id" + userCredentialId);
            createUser(nicknameAndDeviceIdSerialized);
        }
        return getUsersModelAndView(this.page);
    }

    //by admin
    @ResponseBody
    @RequestMapping(value = "/admin-perform-reward/{id}", method = RequestMethod.POST)
    public void rewardUserByAdmin(@PathVariable("id") int id) {
        rewardUser(userService.getById(id));
    }


    private CoinsAmountSerialized changedCoinsAmount(int value, CredentialsSerialized credentials) {
        User user = userService.getById(credentials.getUserId());
        if (checkAuthSuccess(user, credentials)) {
            user.setCoinsAmount(user.getCoinsAmount() + value);
            userService.edit(user);
            return new CoinsAmountSerialized(user.getCoinsAmount());
        } else return null;
    }


    private CrystalsAmountSerialized changedCrystalsAmount(int value, CredentialsSerialized credentials) {
        User user = userService.getById(credentials.getUserId());
        if (checkAuthSuccess(user, credentials)) {
            user.setCrystalsAmount(user.getCrystalsAmount() + value);
            userService.edit(user);
            return new CrystalsAmountSerialized(user.getCrystalsAmount());
        } else return null;
    }


    private boolean isNicknameNormal() {
        //todo
        return true;
    }

    private UserDataSerialized getUserDataSerializedByUser(User user) {
        return new UserDataSerialized(user.getId(),
                user.getFacebookData().getFacebookId() != null,
                user.getHighScore(),
                user.getCoinsAmount(),
                user.getCrystalsAmount(),
                user.getActiveLeaderBoard().getPlace(),
                user.getPastLeaderBoard().getPlace(),
                user.getPastLeaderBoard().isRewardTaken());
    }

    private boolean checkAuthSuccess(User user, CredentialsSerialized credentials) {
        return user.getDeviceId().equals(credentials.getDeviceId());
    }

    private User createUserWithFacebookData(FacebookDataWithNicknameAndDeviceIdSerialized facebookDataWithNicknameAndDeviceIdSerialized) {
        User user = createUser(new NicknameAndDeviceIdSerialized(facebookDataWithNicknameAndDeviceIdSerialized.getNickname(),
                facebookDataWithNicknameAndDeviceIdSerialized.getDeviceId()));
        setFacebookData(user, new FacebookDataSerialized(facebookDataWithNicknameAndDeviceIdSerialized.getFacebookId(),
                facebookDataWithNicknameAndDeviceIdSerialized.getEmail(),
                facebookDataWithNicknameAndDeviceIdSerialized.getRealName(),
                facebookDataWithNicknameAndDeviceIdSerialized.getIconUrl()));
        return user;
    }


    private User createUser(NicknameAndDeviceIdSerialized nicknameAndDeviceIdSerialized) {
        User user = new User();
        ActiveLeaderBoard activeLeaderBoard = new ActiveLeaderBoard();
        PastLeaderBoard pastLeaderBoard = new PastLeaderBoard();
        FacebookData facebookData = new FacebookData();
        user.setNickname(nicknameAndDeviceIdSerialized.getNickname());
        user.setDeviceId(nicknameAndDeviceIdSerialized.getDeviceId());
        user.setActiveLeaderBoard(activeLeaderBoard);
        user.setPastLeaderBoard(pastLeaderBoard);
        user.setFacebookData(facebookData);
        activeLeaderBoard.setUser(user);
        pastLeaderBoard.setUser(user);
        facebookData.setUser(user);
        userService.add(user);
        return user;
    }

    private void setFacebookData(User user, FacebookDataSerialized facebookDataSerialized) {
        user.getFacebookData().setEmail(facebookDataSerialized.getEmail());
        user.getFacebookData().setRealName(facebookDataSerialized.getRealName());
        user.getFacebookData().setFacebookId(facebookDataSerialized.getFacebookId());
        user.getFacebookData().setIconUrl(facebookDataSerialized.getIconUrl());
        userService.edit(user);
    }

    private void setHighScore(int score, User user) {
        if (user.getHighScore() < score)
            user.setHighScore(score);
        userService.edit(user);
    }

    private void rewardUser(User user) {
        if (!user.getPastLeaderBoard().isRewardTaken()) {
            RewardData rewardData = GameVariables.getInstance().getRewardByPlace(user.getPastLeaderBoard().getPlace());
            switch (rewardData.getRewardType()) {
                case Coins:
                    user.setCoinsAmount(user.getCoinsAmount() + rewardData.getRewardAmount());
                    break;
                case Crystals:
                    user.setCrystalsAmount(user.getCrystalsAmount() + rewardData.getRewardAmount());
                    break;
            }
            user.getPastLeaderBoard().setRewardTaken(true);
            userService.edit(user);
        }
    }

}
