package ua.com.alevel.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateSessionFactoryUtil {

    private static final Logger logger = LoggerFactory.getLogger(HibernateSessionFactoryUtil.class);
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory(String login, String password) {
        if (sessionFactory == null) {
            try {
                var configuration = new Configuration().configure()
                        .setProperty("hibernate.connection.username", login)
                        .setProperty("hibernate.connection.password", password);

                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                logger.error("Exception",e);
            }
        }
        return sessionFactory;
    }
}
