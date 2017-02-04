package com.luchinsky.usermanager.service;

import com.luchinsky.usermanager.model.User;

import java.util.List;

/**
 * Created by RLuchinsky on 03.02.2017.
 */
public interface UserService {

    public void addUser(User user);

    public void updateUser(User user);

    public void removeUser(int id);

    public User getUserById(int id);

    public List<User> listUsers(int start);

}
