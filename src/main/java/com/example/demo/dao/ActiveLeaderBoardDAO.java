package com.example.demo.dao;

import com.example.demo.model.ActiveLeaderBoard;

import java.util.List;

public interface ActiveLeaderBoardDAO {
    List<ActiveLeaderBoard> getActiveLeaderBoard();
    List<ActiveLeaderBoard> getActiveLeaderBoardAtPage(int page);
    void add(ActiveLeaderBoard activeLeaderBoard);
    void delete(ActiveLeaderBoard activeLeaderBoard);
    void edit(ActiveLeaderBoard activeLeaderBoard);
    void saveAll(List<ActiveLeaderBoard> leaders);
    ActiveLeaderBoard getById(int id);
    int activeLeaderBoardCount();
}
