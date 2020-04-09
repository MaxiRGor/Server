package com.example.demo.dao.leaderBoard.past;

import com.example.demo.GameVariables;
import com.example.demo.model.leaderBoard.PastLeaderBoard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PastLeaderBoardDAOImpl implements PastLeaderBoardDAO {

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
    public List<PastLeaderBoard> getPastLeaderBoard() {
        return getCurrentSession().createQuery("from PastLeaderBoard ").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<PastLeaderBoard> getPastLeaderBoardAtPage(int page) {
        return getCurrentSession().createQuery("from PastLeaderBoard").setFirstResult((GameVariables.getInstance().getAmountOfItemsOnPage() * (page - 1))).setMaxResults(GameVariables.getInstance().getAmountOfItemsOnPage()).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<PastLeaderBoard> getPastLeaderBoardTop(int topCount) {
        return getCurrentSession().createQuery("from PastLeaderBoard order by place asc").setMaxResults(topCount).list();
    }

    @Override
    public void add(PastLeaderBoard pastLeaderBoard) {
        getCurrentSession().persist(pastLeaderBoard);
    }

    @Override
    public void delete(PastLeaderBoard pastLeaderBoard) {
        getCurrentSession().delete(pastLeaderBoard);
    }

    @Override
    public void edit(PastLeaderBoard pastLeaderBoard) {
        getCurrentSession().update(pastLeaderBoard);
    }

    @Override
    public PastLeaderBoard getById(int id) {
        return getCurrentSession().get(PastLeaderBoard.class, id);
    }

    @Override
    public int pastLeaderBoardCount() {
        return getCurrentSession().createQuery("select count(*) from PastLeaderBoard", Number.class).getSingleResult().intValue();
    }
}
