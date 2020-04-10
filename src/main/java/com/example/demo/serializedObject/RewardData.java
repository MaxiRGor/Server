package com.example.demo.serializedObject;

import java.io.Serializable;

public class RewardData implements Serializable {

    private RewardType rewardType;
    private int rewardAmount;

    public RewardData() {
    }

    public RewardData(RewardType rewardType, int rewardAmount) {
        this.rewardType = rewardType;
        this.rewardAmount = rewardAmount;
    }

    public RewardType getRewardType() {
        return rewardType;
    }

    public void setRewardType(RewardType rewardType) {
        this.rewardType = rewardType;
    }

    public int getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(int rewardAmount) {
        this.rewardAmount = rewardAmount;
    }
}
