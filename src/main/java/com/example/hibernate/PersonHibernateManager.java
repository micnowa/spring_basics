package com.example.hibernate;

import com.example.model.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

@Slf4j
public class PersonHibernateManager {
    public static final int UPDATE_ERROR = -1;
    private static Session session = HibernateUtil.getSessionFactory().openSession();

    private PersonHibernateManager() {
        throw new IllegalCallerException();
    }

    public static List<User> getAllUsers() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            var users = session.createQuery("FROM User").list();
            transaction.commit();
            return users;
        } catch (HibernateException e) {
            rollbackTransaction(transaction);
            log.debug(e.getMessage());
        }
        return new LinkedList<>();
    }

    public static User getUserById(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            var person = session.get(User.class, id);
            transaction.commit();
            return person;
        } catch (HibernateException e) {
            rollbackTransaction(transaction);
            log.debug(e.getMessage());
        }
        return null;
    }

    public static int addUser(User user) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        Integer userId = UPDATE_ERROR;
        try {
            transaction = session.beginTransaction();
            userId = (Integer) session.save(user);
            transaction.commit();
        } catch (HibernateException e) {
            rollbackTransaction(transaction);
            log.debug(e.getMessage());
        }
        return userId;
    }

    public static boolean deleteUserById(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            var person = session.get(User.class, id);
            session.delete(person);
            transaction.commit();
        } catch (HibernateException e) {
            rollbackTransaction(transaction);
            log.debug(e.getMessage());
            return false;
        }
        return true;
    }

    private static void rollbackTransaction(Transaction transaction) {
        if (null != transaction) {
            transaction.rollback();
        }
    }


}
