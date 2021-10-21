package ua.com.alevel.dao;

import ua.com.alevel.entity.Account;
import ua.com.alevel.util.HibernateSessionFactoryUtil;
import java.util.List;


public class AccountDao {


    public Account findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Account.class, id);
    }

    public List<Long> findAllAccounts() {
        List<Long> accounts = HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("select ac from Account ac where id = ?").list();
        return accounts;
    }
}
