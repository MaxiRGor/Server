package com.example.demo.service.leaderBoard.past;

import com.example.demo.model.leaderBoard.ActiveLeaderBoard;
import com.example.demo.model.leaderBoard.PastLeaderBoard;
import org.springframework.stereotype.Service;

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
