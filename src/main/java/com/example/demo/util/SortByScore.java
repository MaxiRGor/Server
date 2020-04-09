package com.example.demo.util;

import com.example.demo.model.leaderBoard.ActiveLeaderBoard;

import java.util.Comparator;

public class SortByScore implements Comparator<ActiveLeaderBoard> {
    @Override
    public int compare(ActiveLeaderBoard o1, ActiveLeaderBoard o2) {
        return o2.getUser().getHighScore() - o1.getUser().getHighScore();
    }
}
