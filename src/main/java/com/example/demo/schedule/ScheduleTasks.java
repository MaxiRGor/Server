package com.example.demo.schedule;

import com.example.demo.controller.LeaderBoardController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTasks {

    private final int TIMEOUT_TO_UPDATE_LEADER_BOARD = 60 * 1000;
    private final long TIMEOUT_TO_RENEW_LEADER_BOARD = 7 * 24 * 60 * 60 * 1000;
    private final long TIMEOUT_TO_DELETE_PASSED_LEADER_BOARD = 3 * 24 * 60 * 60 * 1000;

    private LeaderBoardController leaderBoardController;

    @Autowired
    public void setLeaderBoardController(LeaderBoardController leaderBoardController) {
        this.leaderBoardController = leaderBoardController;
    }

    @Scheduled(fixedRate = TIMEOUT_TO_UPDATE_LEADER_BOARD)
    public void updateLeaderBoard() {
        leaderBoardController.updateLeaderBoard();
    }

    @Scheduled(fixedRate = TIMEOUT_TO_RENEW_LEADER_BOARD)
    public void renewLeaderBoard() {
        leaderBoardController.renewLeaderBoard();
    }

    @Scheduled(fixedRate = TIMEOUT_TO_DELETE_PASSED_LEADER_BOARD)
    public void deletePassedLeaderBoard() {
        leaderBoardController.deletePassedLeaderBoard();
    }

}
