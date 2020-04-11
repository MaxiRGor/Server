package com.dksoft.formshift.serializedObject;

import java.io.Serializable;

public class HighScoreSerialized implements Serializable {
    public HighScoreSerialized() {
    }

    private int highScore;

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
