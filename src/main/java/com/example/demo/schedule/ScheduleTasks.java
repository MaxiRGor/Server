package com.example.demo.schedule;

import com.example.demo.GameVariables;
import com.example.demo.controller.LeaderBoardController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTasks {
/*
    private final int TIMEOUT_MINUTES_TO_UPDATE_LEADERBORD = 1 * 24 * 60 * 60 * 1000;
    private final long TIMEOUT_DAYS_TO_RENEW_LEADERBORD = getMillisecondsFromMinutes(15);
    private final long TIMEOUT_DAYS_TO_DELETE_PASSED_LEADERBORD = getMillisecondsFromDays(7);
    private long timeToDeletePastLeaderboard = getMillisecondsFromDays(3);

    private LeaderBoardController leaderBoardController;

    @Autowired
    public void setLeaderBoardController(LeaderBoardController leaderBoardController) {
        this.leaderBoardController = leaderBoardController;
    }

    @Scheduled(fixedRate = TEST_TIMEOUT)       //3600000 = 60 min // 60000 = 1 min // 10000 = 10 sec
    public void updateLeaderBoard() {
        leaderBoardController.updateLeaderboard();
        GameVariables.getInstance().getTimeToUpdateLeaderboard();
    }

*/
    private final long millisecondsInDays = 24 * 60 * 60 * 1000;
    private final long millisecondsInMinutes = 60 * 1000;

}
