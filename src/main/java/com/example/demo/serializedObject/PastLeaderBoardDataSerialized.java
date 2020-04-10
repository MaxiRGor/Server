package com.example.demo.serializedObject;

public class PastLeaderBoardDataSerialized extends ActiveLeaderBoardDataSerialized
{
    private RewardData rewardData;
    private boolean rewardTaken;

    public PastLeaderBoardDataSerialized() {
    }

    public PastLeaderBoardDataSerialized(String nickname, int place, int score, RewardData rewardData, boolean rewardTaken) {
        super(nickname, place, score);
        this.rewardData = rewardData;
        this.rewardTaken = rewardTaken;
    }

    public RewardData getRewardData() {
        return rewardData;
    }

    public void setRewardData(RewardData rewardData) {
        this.rewardData = rewardData;
    }

    public boolean isRewardTaken() {
        return rewardTaken;
    }

    public void setRewardTaken(boolean rewardTaken) {
        this.rewardTaken = rewardTaken;
    }



}
