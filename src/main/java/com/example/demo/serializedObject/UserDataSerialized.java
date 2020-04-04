package com.example.demo.serializedObject;

import java.io.Serializable;


public class UserDataSerialized implements Serializable {

    public UserDataSerialized() {
    }

    private int id;
    private boolean isLoginedViaFacebook;
    private int highScore;
    private int coinsAmount;
    private int crystalsAmount;
    private int placeInActiveLeaderBoard;
    private int placeInPastLeaderBoard;
    private boolean isRewardTaken;

    public UserDataSerialized(int id, boolean isLoginedViaFacebook, int highScore, int coinsAmount, int crystalsAmount, int placeInActiveLeaderBoard, int placeInPastLeaderBoard, boolean isRewardTaken) {
        this.id = id;
        this.isLoginedViaFacebook = isLoginedViaFacebook;
        this.highScore = highScore;
        this.coinsAmount = coinsAmount;
        this.crystalsAmount = crystalsAmount;
        this.placeInActiveLeaderBoard = placeInActiveLeaderBoard;
        this.placeInPastLeaderBoard = placeInPastLeaderBoard;
        this.isRewardTaken = isRewardTaken;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLoginedViaFacebook() {
        return isLoginedViaFacebook;
    }

    public void setLoginedViaFacebook(boolean loginedViaFacebook) {
        isLoginedViaFacebook = loginedViaFacebook;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getCoinsAmount() {
        return coinsAmount;
    }

    public void setCoinsAmount(int coinsAmount) {
        this.coinsAmount = coinsAmount;
    }

    public int getCrystalsAmount() {
        return crystalsAmount;
    }

    public void setCrystalsAmount(int crystalsAmount) {
        this.crystalsAmount = crystalsAmount;
    }

    public int getPlaceInActiveLeaderBoard() {
        return placeInActiveLeaderBoard;
    }

    public void setPlaceInActiveLeaderBoard(int placeInActiveLeaderBoard) {
        this.placeInActiveLeaderBoard = placeInActiveLeaderBoard;
    }

    public int getPlaceInPastLeaderBoard() {
        return placeInPastLeaderBoard;
    }

    public void setPlaceInPastLeaderBoard(int placeInPastLeaderBoard) {
        this.placeInPastLeaderBoard = placeInPastLeaderBoard;
    }

    public boolean isRewardTaken() {
        return isRewardTaken;
    }

    public void setRewardTaken(boolean rewardTaken) {
        isRewardTaken = rewardTaken;
    }
}
