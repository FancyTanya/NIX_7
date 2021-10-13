package ua.com.alevel.dao;
import ua.com.alevel.entity.User;
import ua.com.alevel.util.HibernateSessionFactoryUtil;

public class UserDao {
    public User findByEmail(String email) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, email);
    }

    public User findByAccount(Long accountId) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, accountId);
    }
}
