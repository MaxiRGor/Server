package com.dksoft.formshift.util;

import com.dksoft.formshift.model.leaderBoard.ActiveLeaderBoard;

import java.util.Comparator;

public class SortByScore implements Comparator<ActiveLeaderBoard> {
    @Override
    public int compare(ActiveLeaderBoard o1, ActiveLeaderBoard o2) {
        return o2.getUser().getHighScore() - o1.getUser().getHighScore();
    }
}
