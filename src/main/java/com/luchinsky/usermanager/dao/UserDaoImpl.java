package com.luchinsky.usermanager.dao;

import com.luchinsky.usermanager.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RLuchinsky on 03.02.2017.
 */
@Repository
public class UserDaoImpl implements UserDao  {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override

    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));

        if(user!=null){
            session.delete(user);
        }

    }

    @Override
    public User getUserById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));

        logger.info("User successfully loaded. user details: " + user);

        return user;

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers(int start) {
        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery("from User");
        query.setFirstResult(start);
        query.setMaxResults(5);
        List<User> userList = query.list();

        return userList;
    }
}
