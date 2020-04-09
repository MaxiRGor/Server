package com.example.demo.model;

import com.example.demo.model.leaderBoard.ActiveLeaderBoard;
import com.example.demo.model.leaderBoard.PastLeaderBoard;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    private int id;
    private String nickname;
    private String deviceId;

    //facebook data todo

    private ActiveLeaderBoard activeLeaderBoard;
    private PastLeaderBoard pastLeaderBoard;
    private int highScore;
    private int coinsAmount;
    private int crystalsAmount;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "nickname", columnDefinition = "varchar(30) default 'Anonymous'")
    public String getNickname() {
        return nickname;
    }

    @Column(name = "device_id", columnDefinition = "varchar(60) default 'abc'")
    public String getDeviceId() {
        return deviceId;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public ActiveLeaderBoard getActiveLeaderBoard() {
        return activeLeaderBoard;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public PastLeaderBoard getPastLeaderBoard() {
        return pastLeaderBoard;
    }

    @Column(name = "high_score", columnDefinition = "integer default 0")
    public int getHighScore() {
        return highScore;
    }

    @Column(name = "coins_amount", columnDefinition = "integer default 0")
    public int getCoinsAmount() {
        return coinsAmount;
    }

    @Column(name = "crystals_amount", columnDefinition = "integer default 0")
    public int getCrystalsAmount() {
        return crystalsAmount;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setActiveLeaderBoard(ActiveLeaderBoard activeLeaderBoard) {
        this.activeLeaderBoard = activeLeaderBoard;
    }

    public void setPastLeaderBoard(PastLeaderBoard pastLeaderBoard) {
        this.pastLeaderBoard = pastLeaderBoard;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public void setCoinsAmount(int coinsAmount) {
        this.coinsAmount = coinsAmount;
    }

    public void setCrystalsAmount(int crystalsAmount) {
        this.crystalsAmount = crystalsAmount;
    }

}
