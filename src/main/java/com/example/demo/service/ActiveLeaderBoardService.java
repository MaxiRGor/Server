package com.example.demo.service;

import com.example.demo.model.ActiveLeaderBoard;

import java.util.List;

public interface ActiveLeaderBoardService {
    List<ActiveLeaderBoard> getActiveLeaderBoard();
    List<ActiveLeaderBoard> getActiveLeaderBoardAtPage(int page);
    List<ActiveLeaderBoard> getActiveLeaderBoardTop(int topCount);
    void add(ActiveLeaderBoard activeLeaderBoard);
    void delete(ActiveLeaderBoard activeLeaderBoard);
    void edit(ActiveLeaderBoard activeLeaderBoard);
    ActiveLeaderBoard getById(int id);
    int activeLeaderBoardCount();
}
