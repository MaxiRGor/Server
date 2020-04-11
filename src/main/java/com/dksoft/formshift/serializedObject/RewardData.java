package com.dksoft.formshift.serializedObject;

import java.io.Serializable;

public class RewardData implements Serializable {
    public RewardData() {
    }

    private RewardType rewardType;
    private int rewardAmount;

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
