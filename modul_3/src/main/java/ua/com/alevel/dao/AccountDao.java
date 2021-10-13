package ua.com.alevel.dao;
import ua.com.alevel.entity.Account;
import ua.com.alevel.entity.Category;
import ua.com.alevel.util.HibernateSessionFactoryUtil;

public class AccountDao {
    public Account findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Account.class, id);
    }
}
