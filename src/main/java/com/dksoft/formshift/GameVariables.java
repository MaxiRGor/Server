package com.dksoft.formshift;

import com.dksoft.formshift.serializedObject.RewardData;
import com.dksoft.formshift.serializedObject.RewardType;

import java.util.ArrayList;
import java.util.List;

public class GameVariables {

    //60 sec
    public static final int TIMEOUT_TO_UPDATE_LEADER_BOARD = 60 * 1000;
    //7 days
    public static final long TIMEOUT_TO_RENEW_LEADER_BOARD = 7 * 24 * 60 * 60 * 1000;
    // 3 days
    public static final long TIMEOUT_TO_CLEAR_PAST_LEADER_BOARD = 3 * 24 * 60 * 60 * 1000;

    private List<RewardData> rewardsForFirstPlaces;
    private RewardData defaultReward;
    private int amountOfItemsOnPage;
    private int amountOfLeadersToShow;
    //private int amountOfLeadersToKeepInLeaderBoard;

    private static GameVariables ourInstance = new GameVariables();
    public static GameVariables getInstance() {
        return ourInstance;
    }

    private GameVariables() {
        this.rewardsForFirstPlaces = new ArrayList<>();
        setRewardsForFirstPlaces();
        this.amountOfItemsOnPage = 25;
        this.amountOfLeadersToShow = 100;
        this.defaultReward =  new RewardData(RewardType.Coins, 1);
        //this.amountOfLeadersToKeepInLeaderBoard = 1000;
    }


    public List<RewardData> getRewardsForFirstPlaces() {
        return rewardsForFirstPlaces;
    }

    private void setRewardsForFirstPlaces() {
        this.rewardsForFirstPlaces.add(new RewardData(RewardType.Crystals,1000));
        this.rewardsForFirstPlaces.add(new RewardData(RewardType.Crystals,750));
        this.rewardsForFirstPlaces.add(new RewardData(RewardType.Crystals,500));
        this.rewardsForFirstPlaces.add(new RewardData(RewardType.Crystals,250));
        this.rewardsForFirstPlaces.add(new RewardData(RewardType.Crystals,100));
        this.rewardsForFirstPlaces.add(new RewardData(RewardType.Crystals,75));
        this.rewardsForFirstPlaces.add(new RewardData(RewardType.Crystals,50));
        this.rewardsForFirstPlaces.add(new RewardData(RewardType.Crystals,25));
        this.rewardsForFirstPlaces.add(new RewardData(RewardType.Crystals,10));
        this.rewardsForFirstPlaces.add(new RewardData(RewardType.Crystals,5));

        this.rewardsForFirstPlaces.add(new RewardData(RewardType.Coins,10000));
        this.rewardsForFirstPlaces.add(new RewardData(RewardType.Coins,8000));
        this.rewardsForFirstPlaces.add(new RewardData(RewardType.Coins,7500));
        this.rewardsForFirstPlaces.add(new RewardData(RewardType.Coins,6500));
        this.rewardsForFirstPlaces.add(new RewardData(RewardType.Coins,5000));
        this.rewardsForFirstPlaces.add(new RewardData(RewardType.Coins,4000));
        this.rewardsForFirstPlaces.add(new RewardData(RewardType.Coins,3000));
        this.rewardsForFirstPlaces.add(new RewardData(RewardType.Coins,2000));
        this.rewardsForFirstPlaces.add(new RewardData(RewardType.Coins,1500));
    }

    public RewardData getRewardByPlace(int place){
        if(place>0 && place<rewardsForFirstPlaces.size())
            return rewardsForFirstPlaces.get(place-1);
        else return defaultReward;
    }


    public int getAmountOfItemsOnPage() {
        return amountOfItemsOnPage;
    }

    public int getAmountOfLeadersToShow() {
        return amountOfLeadersToShow;
    }

   /* public int getAmountOfLeadersToKeepInLeaderBoard() {
        return amountOfLeadersToKeepInLeaderBoard;
    }

    public void setAmountOfLeadersToKeepInLeaderBoard(int amountOfLeadersToKeepInLeaderBoard) {
        this.amountOfLeadersToKeepInLeaderBoard = amountOfLeadersToKeepInLeaderBoard;
    }*/
}
