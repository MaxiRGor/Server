package com.dksoft.formshift.service.leaderBoard.active;

import com.dksoft.formshift.model.leaderBoard.ActiveLeaderBoard;
import com.dksoft.formshift.dao.leaderBoard.active.ActiveLeaderBoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ActiveLeaderBoardServiceImpl implements ActiveLeaderBoardService {

    private ActiveLeaderBoardDAO activeLeaderBoardDAO;

    @Autowired
    private void setActiveLeaderBoardDAO(ActiveLeaderBoardDAO activeLeaderBoardDAO){
        this.activeLeaderBoardDAO = activeLeaderBoardDAO;
    }

    @Override
    @Transactional
    public List<ActiveLeaderBoard> getActiveLeaderBoard() {
        return activeLeaderBoardDAO.getActiveLeaderBoard();
    }

    @Override
    @Transactional
    public List<ActiveLeaderBoard> getActiveLeaderBoardSortedByPlaceAtPage(int page) {
        return activeLeaderBoardDAO.getActiveLeaderBoardSortedByPlaceAtPage(page);
    }

    @Override
    @Transactional
    public List<ActiveLeaderBoard> getActiveLeaderBoardTop(int topCount) {
        return activeLeaderBoardDAO.getActiveLeaderBoardTop(topCount);
    }

    @Override
    @Transactional
    public void add(ActiveLeaderBoard activeLeaderBoard) {
        activeLeaderBoardDAO.add(activeLeaderBoard);
    }

    @Override
    @Transactional
    public void delete(ActiveLeaderBoard activeLeaderBoard) {
        activeLeaderBoardDAO.delete(activeLeaderBoard);
    }


    @Override
    @Transactional
    public void edit(ActiveLeaderBoard activeLeaderBoard) {
        activeLeaderBoardDAO.edit(activeLeaderBoard);
    }

    @Override
    @Transactional
    public ActiveLeaderBoard getById(int id) {
        return activeLeaderBoardDAO.getById(id);
    }

    @Override
    @Transactional
    public int activeLeaderBoardCount() {
        return activeLeaderBoardDAO.activeLeaderBoardCount();
    }
}
