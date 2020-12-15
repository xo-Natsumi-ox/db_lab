package com.shevchuk.connection;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class ConnectionManager {

    private static final SessionFactory OUR_SESSION_FACTORY;
    private static Session session;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            OUR_SESSION_FACTORY = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        session = OUR_SESSION_FACTORY.openSession();
        return session;
    }
    public static void closeSession() throws HibernateException {
        session.close();
        OUR_SESSION_FACTORY.close();
    }
    }
