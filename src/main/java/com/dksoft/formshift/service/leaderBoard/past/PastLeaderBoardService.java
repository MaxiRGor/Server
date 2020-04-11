package com.dksoft.formshift.service.leaderBoard.past;

import com.dksoft.formshift.model.leaderBoard.PastLeaderBoard;

import java.util.List;

public interface PastLeaderBoardService {
    List<PastLeaderBoard> getPastLeaderBoard();
    List<PastLeaderBoard> getPastLeaderBoardSortedByPlaceAtPage(int page);
    List<PastLeaderBoard> getPastLeaderBoardTop(int topCount);
    void add(PastLeaderBoard pastLeaderBoard);
    void delete(PastLeaderBoard pastLeaderBoard);
    void edit(PastLeaderBoard pastLeaderBoard);
    PastLeaderBoard getById(int id);
    int pastLeaderBoardCount();
}
