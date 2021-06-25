package com.example.hibernate;

import com.example.model.Person;
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

    public static List<Person> getAllUsers() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            var users = session.createQuery("FROM Person").list();
            transaction.commit();
            return users;
        } catch (HibernateException e) {
            rollbackTransaction(transaction);
            log.debug(e.getMessage());
        }
        return new LinkedList<>();
    }

    public static Person getUserById(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            var person = session.get(Person.class, id);
            transaction.commit();
            return person;
        } catch (HibernateException e) {
            rollbackTransaction(transaction);
            log.debug(e.getMessage());
        }
        return null;
    }

    public static int addUser(Person person) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        Integer userId = UPDATE_ERROR;
        try {
            transaction = session.beginTransaction();
            userId = (Integer) session.save(person);
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
            var person = session.get(Person.class, id);
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
