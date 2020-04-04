package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "past_leader_board")
public class PastLeaderBoard {


    private int id;
    private User user;
    private int place;
    private int rewardCrystalsAmount;
    private boolean isRewardTaken;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "pastLeaderBoard")
    public User getUser() {
        return user;
    }

    @Column(name = "place", columnDefinition = "integer default -1")
    public int getPlace() {
        return place;
    }

    @Column(name = "reward_crystals_amount", columnDefinition = "integer default 100")
    public int getRewardCrystalsAmount() {
        return rewardCrystalsAmount;
    }

    @Column(name = "is_reward_taken", columnDefinition = "boolean default false")
    public boolean isRewardTaken() {
        return isRewardTaken;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public void setRewardCrystalsAmount(int rewardCrystalsAmount) {
        this.rewardCrystalsAmount = rewardCrystalsAmount;
    }

    public void setRewardTaken(boolean rewardTaken) {
        isRewardTaken = rewardTaken;
    }

}
