package com.luchinsky.usermanager.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by RLuchinsky on 03.02.2017.
 */

@Entity
@Table(name = "users")

public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(name = "name")
    private String userName;

    @Column(name = "age")
    private int userAge;

    @Column(name = "isAdmin")
    private boolean userIsAdmin;

    @Column(name = "createdData")
    private Timestamp userCreatedData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public boolean getUserIsAdmin() {
        return userIsAdmin;
    }

    public void setUserIsAdmin(boolean userIsAdmin) {
        this.userIsAdmin = userIsAdmin;
    }

    public Timestamp getUserCreatedData() {
        return userCreatedData;
    }

    public void setUserCreatedData(Timestamp userCreatedData) {
        this.userCreatedData = userCreatedData;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userIsAdmin=" + userIsAdmin +
                ", userCreatedData=" + userCreatedData +
                '}';
    }
}
