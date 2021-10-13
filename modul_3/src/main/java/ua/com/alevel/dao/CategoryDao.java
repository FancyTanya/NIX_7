package ua.com.alevel.dao;
import ua.com.alevel.entity.Category;
import ua.com.alevel.util.HibernateSessionFactoryUtil;

public class CategoryDao {
    public Category findByCategoryName(String category) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Category.class, category);
    }
}
