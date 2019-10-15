package com.wlg.bookstore.dao.impl;

import com.wlg.bookstore.dao.BaseDAO;
import com.wlg.bookstore.dao.IUserDAO;
import com.wlg.bookstore.vo.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAO extends BaseDAO implements IUserDAO {
    public void saveUser(User user) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
    }

    public User validateUser(String username, String password) {
        String sql = "from User u where u.username=:name and u.password=:pass";
        Session session = getSession();
        Query query = session.createQuery(sql);
        query.setParameter("name", username);
        query.setParameter("pass", password);
        List users = query.list();
        if (users.size() != 0) {
            User user = (User) users.get(0);
            return user;
        }
        session.close();
        return null;
    }

    public boolean exitUser(String username) {
        Session session = getSession();
        String hql = "from User u where u.username=:name ";
        Query query = session.createQuery(hql);
        query.setParameter("name", username);
        List users = query.list();
        if (users.size() != 0) {
            User user = (User) users.get(0);
            return true;
        }
        session.close();
        return false;
    }
}
