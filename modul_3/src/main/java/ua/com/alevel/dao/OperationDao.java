package ua.com.alevel.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.com.alevel.entity.Operation;
import ua.com.alevel.util.HibernateSessionFactoryUtil;

public class OperationDao {

    public void save(Operation operation) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(operation);
        transaction.commit();
        session.close();
    }
}
