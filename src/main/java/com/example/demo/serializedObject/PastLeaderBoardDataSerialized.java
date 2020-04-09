package com.example.demo.serializedObject;

import com.example.demo.util.Reward;

public class PastLeaderBoardDataSerialized extends ActiveLeaderBoardDataSerialized
{
    private Reward reward;
    private boolean rewardTaken;

    public PastLeaderBoardDataSerialized() {
    }

    public PastLeaderBoardDataSerialized(String nickname, int place, int score, Reward reward, boolean rewardTaken) {
        super(nickname, place, score);
        this.reward = reward;
        this.rewardTaken = rewardTaken;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    public boolean isRewardTaken() {
        return rewardTaken;
    }

    public void setRewardTaken(boolean rewardTaken) {
        this.rewardTaken = rewardTaken;
    }



}
