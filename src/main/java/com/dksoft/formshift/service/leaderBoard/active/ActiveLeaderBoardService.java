package com.dksoft.formshift.service.leaderBoard.active;

import com.dksoft.formshift.model.leaderBoard.ActiveLeaderBoard;

import java.util.List;

public interface ActiveLeaderBoardService {
    List<ActiveLeaderBoard> getActiveLeaderBoard();
    List<ActiveLeaderBoard> getActiveLeaderBoardSortedByPlaceAtPage(int page);
    List<ActiveLeaderBoard> getActiveLeaderBoardTop(int topCount);
    void add(ActiveLeaderBoard activeLeaderBoard);
    void delete(ActiveLeaderBoard activeLeaderBoard);
    void edit(ActiveLeaderBoard activeLeaderBoard);
    ActiveLeaderBoard getById(int id);
    int activeLeaderBoardCount();
}
