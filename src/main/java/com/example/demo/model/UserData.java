package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserData {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "role")
    public String role;

    @Column(name = "nickName")
    public String nickName;

    @Column(name = "deviceId")
    public String deviceId;

    @Column(name = "levelNumber")
    public int levelNumber = 1;


    @Column(name = "highScore")
    public int highScore;

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Currency> currencies;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

  /*  public List<String> activeSlots = new List<String>(1);

  public int facebookDataId;
   public int leaderboardGeneralId;
   public int leaderboardGroupId;
    public Inventory inventory;
    public List<Quest> quests;
    public int day;
    public int presentsAcquiredToday;
    public long presentStartUpdateTime;
    public long shopLastUpdateTime;
    public TutorialStageType tutorialStageType;*/
}
