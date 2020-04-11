package com.dksoft.formshift.serializedObject;

import java.io.Serializable;

public class ActiveLeaderBoardDataSerialized implements Serializable {
    public ActiveLeaderBoardDataSerialized() {
    }

    private String nickname;
    private int place;
    private int score;

    public ActiveLeaderBoardDataSerialized(String nickname, int place, int score) {
        this.nickname = nickname;
        this.place = place;
        this.score = score;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
