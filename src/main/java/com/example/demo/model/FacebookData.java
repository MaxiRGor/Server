package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "facebook_data")
public class FacebookData {

    private int id;
    private User user;
    private String facebookId;
    private String email;
    private String realName;
    private String iconUrl;

    public FacebookData() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "facebookData")
    public User getUser() {
        return user;
    }

    @Column(name = "facebook_id")
    public String getFacebookId() {
        return facebookId;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    @Column(name = "real_name")
    public String getRealName() {
        return realName;
    }

    @Column(name = "icon_url")
    public String getIconUrl() {
        return iconUrl;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setRealName(String realName) {
        this.realName = realName;
    }


    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }


}
