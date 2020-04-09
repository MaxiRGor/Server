package com.example.demo.dao.leaderBoard.past;


import com.example.demo.model.leaderBoard.PastLeaderBoard;

import java.util.List;

public interface PastLeaderBoardDAO {
    List<PastLeaderBoard> getPastLeaderBoard();
    List<PastLeaderBoard> getPastLeaderBoardSortedByPlaceAtPage(int page);
    List<PastLeaderBoard> getPastLeaderBoardTop(int topCount);
    void add(PastLeaderBoard pastLeaderBoard);
    void delete(PastLeaderBoard pastLeaderBoard);
    void edit(PastLeaderBoard pastLeaderBoard);
    PastLeaderBoard getById(int id);
    int pastLeaderBoardCount();
}
