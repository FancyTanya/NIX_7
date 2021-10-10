package ua.com.alevel.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtil {

    private static SessionFactory sessionFactory = null;
    private final static Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
