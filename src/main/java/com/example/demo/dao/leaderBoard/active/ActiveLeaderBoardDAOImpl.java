package com.example.demo.dao.leaderBoard.active;

import com.example.demo.GameVariables;
import com.example.demo.model.leaderBoard.ActiveLeaderBoard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActiveLeaderBoardDAOImpl implements ActiveLeaderBoardDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ActiveLeaderBoard> getActiveLeaderBoard() {
        return getCurrentSession().createQuery("from ActiveLeaderBoard").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ActiveLeaderBoard> getActiveLeaderBoardSortedByPlaceAtPage(int page) {
        return getCurrentSession().createQuery("from ActiveLeaderBoard order by place asc").setFirstResult((GameVariables.getInstance().getAmountOfItemsOnPage() * (page - 1))).setMaxResults(GameVariables.getInstance().getAmountOfItemsOnPage()).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ActiveLeaderBoard> getActiveLeaderBoardTop(int topCount) {
        return getCurrentSession().createQuery("from ActiveLeaderBoard order by place asc").setMaxResults(topCount).list();
    }

    @Override
    public void add(ActiveLeaderBoard activeLeaderBoard) {
        getCurrentSession().persist(activeLeaderBoard);
    }

    @Override
    public void delete(ActiveLeaderBoard activeLeaderBoard) {
        getCurrentSession().delete(activeLeaderBoard);
    }

    @Override
    public void edit(ActiveLeaderBoard activeLeaderBoard) {
        getCurrentSession().update(activeLeaderBoard);
    }

    @Override
    public ActiveLeaderBoard getById(int id) {
        return getCurrentSession().get(ActiveLeaderBoard.class, id);
    }

    @Override
    public int activeLeaderBoardCount() {
        return getCurrentSession().createQuery("select count(*) from ActiveLeaderBoard ", Number.class).getSingleResult().intValue();
    }
}
