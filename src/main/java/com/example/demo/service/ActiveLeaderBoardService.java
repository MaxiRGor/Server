package com.example.demo.service;

import com.example.demo.model.ActiveLeaderBoard;

import java.util.List;

public interface ActiveLeaderBoardService {
    List<ActiveLeaderBoard> getActiveLeaderBoard();
    List<ActiveLeaderBoard> getActiveLeaderBoardAtPage(int page);
    void add(ActiveLeaderBoard activeLeaderBoard);
    void delete(ActiveLeaderBoard activeLeaderBoard);
    void saveAll(List<ActiveLeaderBoard> leaders);
    void edit(ActiveLeaderBoard activeLeaderBoard);
    ActiveLeaderBoard getById(int id);
    int activeLeaderBoardCount();
}
