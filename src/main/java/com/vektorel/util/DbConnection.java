package com.vektorel.util;

import com.vektorel.entity.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DbConnection {

    public Session session = null;
    Transaction transaction = null;
    // 3 adet metot'a ihtiyacımız var
    // open
    // close
    // rollback

    public void openSession() {

        SessionFactory sessionFactory =
                new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

    }

    public void closeSession() {
        transaction.commit();
        session.close();
    }

    public void rollBack(){
        transaction.rollback();
        session.close();
    }

}
