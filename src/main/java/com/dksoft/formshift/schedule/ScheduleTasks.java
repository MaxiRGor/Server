package com.dksoft.formshift.schedule;

import com.dksoft.formshift.controller.LeaderBoardController;
import com.dksoft.formshift.GameVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTasks {

    private LeaderBoardController leaderBoardController;

    @Autowired
    public void setLeaderBoardController(LeaderBoardController leaderBoardController) {
        this.leaderBoardController = leaderBoardController;
    }

    @Scheduled(fixedRate = GameVariables.TIMEOUT_TO_UPDATE_LEADER_BOARD)
    public void updateLeaderBoard() {
        leaderBoardController.updateActiveLeaderBoard();
    }

    @Scheduled(fixedRate = GameVariables.TIMEOUT_TO_RENEW_LEADER_BOARD)
    public void saveDataToPastLeaderBoardAndClearActiveLeaderBoard() {
        leaderBoardController.saveDataToPastLeaderBoardAndClearActiveLeaderBoard();
    }

    @Scheduled(fixedRate = GameVariables.TIMEOUT_TO_CLEAR_PAST_LEADER_BOARD)
    public void clearPastLeaderBoard() {
        leaderBoardController.clearPastLeaderBoard();
    }

}
