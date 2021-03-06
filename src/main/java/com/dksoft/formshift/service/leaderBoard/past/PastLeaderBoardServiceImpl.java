package com.dksoft.formshift.service.leaderBoard.past;

import com.dksoft.formshift.dao.leaderBoard.past.PastLeaderBoardDAO;
import com.dksoft.formshift.model.leaderBoard.PastLeaderBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PastLeaderBoardServiceImpl implements PastLeaderBoardService {

    private PastLeaderBoardDAO pastLeaderBoardDAO;

    @Autowired
    private void setPastLeaderBoardDAO(PastLeaderBoardDAO pastLeaderBoardDAO) {
        this.pastLeaderBoardDAO = pastLeaderBoardDAO;
    }


    @Override
    @Transactional
    public List<PastLeaderBoard> getPastLeaderBoard() {
        return pastLeaderBoardDAO.getPastLeaderBoard();
    }

    @Override
    @Transactional
    public List<PastLeaderBoard> getPastLeaderBoardSortedByPlaceAtPage(int page) {
        return pastLeaderBoardDAO.getPastLeaderBoardSortedByPlaceAtPage(page);
    }

    @Override
    @Transactional
    public List<PastLeaderBoard> getPastLeaderBoardTop(int topCount) {
        return pastLeaderBoardDAO.getPastLeaderBoardTop(topCount);
    }

    @Override
    @Transactional
    public void add(PastLeaderBoard pastLeaderBoard) {
        pastLeaderBoardDAO.add(pastLeaderBoard);
    }

    @Override
    @Transactional
    public void delete(PastLeaderBoard pastLeaderBoard) {
        pastLeaderBoardDAO.delete(pastLeaderBoard);
    }

    @Override
    @Transactional
    public void edit(PastLeaderBoard pastLeaderBoard) {
        pastLeaderBoardDAO.edit(pastLeaderBoard);
    }

    @Override
    @Transactional
    public PastLeaderBoard getById(int id) {
        return pastLeaderBoardDAO.getById(id);
    }

    @Override
    @Transactional
    public int pastLeaderBoardCount() {
        return pastLeaderBoardDAO.pastLeaderBoardCount();
    }
}
