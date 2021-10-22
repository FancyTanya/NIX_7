package ua.com.alevel.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.Category;
import ua.com.alevel.exceptions.IncorrectInput;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.function.Supplier;

public class CategoryDao {

    private final Supplier<EntityManager> persistence;
    private static final Logger logger = LoggerFactory.getLogger(CategoryDao.class);

    public CategoryDao(Supplier<EntityManager> persistence) {
        this.persistence = persistence;
    }

    public String findByCategoryName(String category) throws IncorrectInput {
        EntityManager entityManager = persistence.get();
        entityManager.getTransaction().begin();

        TypedQuery<Category> categoryTypedQuery = entityManager.createQuery("select c.title from Category " +
                "as c where like :category", Category.class).setParameter("category", category);
        Category cat = categoryTypedQuery.getSingleResult();

        if (cat == null) {
            logger.warn("Incorrect input");
            throw new IncorrectInput("Incorrect input");
        }

        entityManager.persist(cat);
        entityManager.getTransaction().commit();
        entityManager.close();

        return cat.getTitle();
    }

//    public Category findByCategoryName(String category) {
//        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Category.class, category);
//    }
}
