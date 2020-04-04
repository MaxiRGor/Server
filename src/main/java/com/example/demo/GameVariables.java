package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class GameVariables {

    public static int a = 1000;

    private static GameVariables ourInstance = new GameVariables();

    public static GameVariables getInstance() {
        return ourInstance;
    }

    private GameVariables() {
        this.timeToUpdateLeaderboard = getMillisecondsFromMinutes(15);
        this.timeToRenewLeaderboard = getMillisecondsFromDays(7);
        this.timeToDeletePastLeaderboard = getMillisecondsFromDays(3);
        this.rewardsForFirstPlaces = new ArrayList<Integer>();
        this.    rewardsForFirstPlaces.add(1000);
        this.      rewardsForFirstPlaces.add(500);
        this.      rewardsForFirstPlaces.add(250);
    }

    private long timeToUpdateLeaderboard;

    private long timeToRenewLeaderboard;

    private long timeToDeletePastLeaderboard;

    private List<Integer> rewardsForFirstPlaces;

    public long getTimeToUpdateLeaderboard() {
        return timeToUpdateLeaderboard;
    }

    public void setTimeToUpdateLeaderboard(long timeToUpdateLeaderboard) {
        this.timeToUpdateLeaderboard = timeToUpdateLeaderboard;
    }

    public long getTimeToRenewLeaderboard() {
        return timeToRenewLeaderboard;
    }

    public void setTimeToRenewLeaderboard(long timeToRenewLeaderboard) {
        this.timeToRenewLeaderboard = timeToRenewLeaderboard;
    }

    public long getTimeToDeletePastLeaderboard() {
        return timeToDeletePastLeaderboard;
    }

    public void setTimeToDeletePastLeaderboard(long timeToDeletePastLeaderboard) {
        this.timeToDeletePastLeaderboard = timeToDeletePastLeaderboard;
    }

    public List<Integer> getRewardsForFirstPlaces() {
        return rewardsForFirstPlaces;
    }

    public void setRewardsForFirstPlaces(List<Integer> rewardsForFirstPlaces) {
        this.rewardsForFirstPlaces = rewardsForFirstPlaces;
    }

    private long getMillisecondsFromDays(int daysAmount){
        return daysAmount * 24 * 60 * 60 * 1000;
    }

    private long getMillisecondsFromMinutes(int minutesAmount){
        return minutesAmount * 60 * 1000;
    }
}
