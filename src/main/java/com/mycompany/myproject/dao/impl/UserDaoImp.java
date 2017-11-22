package com.mycompany.myproject.dao.impl;

import com.mycompany.myproject.dao.api.RoleDao;
import com.mycompany.myproject.persist.entity.User;
import com.mycompany.myproject.dao.api.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    RoleDao roleDao;

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("FROM User")
                .getResultList();
    }

    @Override
    public void addNewUser(User user) {
        em.merge(user);
        em.flush();
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

    @Override
    public User loginUser(String login, String password) {
        List list =  em.createQuery("FROM User where login=:login" +
                " and password=:password").setParameter("login", login)
                .setParameter("password", password).getResultList();

        return (list.isEmpty()) ? null : (User) list.get(0);
    }

    @Override
    public Long getUserByPrivateData(String firstName, String lastName, Date birthday) {
        List list =  em.createQuery("FROM User where firstName=:firstName" +
                " and lastName=:lastName and birthday=:birthday")
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName)
                .setParameter("birthday", birthday)
                .getResultList();

        User usr = (list.isEmpty()) ? null : (User) list.get(0);
        return usr.getUserId();
    }

    @Override
    public void updateRole(Long userId, Long roleId) {
        Query query = em.createQuery("UPDATE User set role=:roleId where userId=:userId")
                .setParameter("userId",userId)
                .setParameter("roleId", roleDao.getRoleByRoleId(roleId));
        query.executeUpdate();
    }



}
