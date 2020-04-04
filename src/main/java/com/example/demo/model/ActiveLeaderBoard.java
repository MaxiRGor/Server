package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "active_leader_board")
public class ActiveLeaderBoard {

    private int id;
    //   private int userId;
    private User user;
    private int place;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "activeLeaderBoard")
    public User getUser() {
        return user;
    }

    @Column(name = "place", columnDefinition = "integer default -1")
    public int getPlace() {
        return place;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPlace(int place) {
        this.place = place;
    }

}
