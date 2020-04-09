package com.example.demo.model.leaderBoard;

import com.example.demo.model.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "past_leader_board")
public class PastLeaderBoard {

    private int id;
    private User user;
    private int place;
    private int savedScore;
    private boolean rewardTaken;

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

    //todo nullable
    @Column(name = "place", columnDefinition = "integer default 0")
    public int getPlace() {
        return place;
    }

    @Column(name = "saved_score", columnDefinition = "integer default 0")
    public int getSavedScore() {
        return savedScore;
    }

    @Column(name = "reward_taken", columnDefinition = "boolean default true")
    public boolean isRewardTaken() {
        return rewardTaken;
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

    public void setRewardTaken(boolean rewardTaken) {
        this.rewardTaken = rewardTaken;
    }

    public void setSavedScore(int savedScore) {
        this.savedScore = savedScore;
    }
}
