package com.mycompany.myproject.service.dao.impl;

import com.mycompany.myproject.persist.entity.User;
import com.mycompany.myproject.service.dao.api.UserDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("FROM User")
                .getResultList();
    }

    @Override
    public void addNewUser(User user) {
        em.persist(user);
    }

    @Override
    public void removeUser(Long id) {
        User toDeleteUser = this.getUserById(id);
        em.remove(toDeleteUser);
    }

    @Override
    public User getUserById(Long userId) {
        List list = em.createQuery("FROM User where userId=:userId")
                .setParameter("userId",userId).getResultList();
        return (list.isEmpty()) ? null : (User) list.get(0);
    }

    @Override
    public User getUserByEmail(String email) {
        List list = em.createQuery("FROM User where email=:email")
                .setParameter("email",email).getResultList();
        return (list.isEmpty()) ? null : (User) list.get(0);
    }

    @Override
    public User getUserByLogin(String login) {
        List list = em.createQuery("FROM User where login=:login")
                .setParameter("login",login).getResultList();
        return (list.isEmpty()) ? null : (User) list.get(0);
    }

    @Override
    public long getUserIdByEmail(String email) {
        List list =  em.createQuery("select u.id FROM User u where u.email=:email")
                .setParameter("email", email).getResultList();
        return (list.isEmpty()) ? 0 : (long) list.get(0);
    }

    @Override
    public long getUserIdByLogin(String login) {
        List list =  em.createQuery("select u.id FROM User u where u.login=:login")
                .setParameter("login", login).getResultList();
        return (list.isEmpty()) ? 0 : (long) list.get(0);
    }

}
