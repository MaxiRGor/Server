package com.example.demo.serializedObject;

import java.io.Serializable;

public class HighScoreSerialized implements Serializable {
    private int highScore;

    public HighScoreSerialized() {
    }

    public HighScoreSerialized(int highScore) {
        this.highScore = highScore;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }
}
