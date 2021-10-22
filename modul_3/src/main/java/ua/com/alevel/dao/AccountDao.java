package ua.com.alevel.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.Account;
import ua.com.alevel.exceptions.IncorrectInput;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.function.Supplier;


public class AccountDao {

    private final Supplier<EntityManager> persistence;
    private static final Logger logger = LoggerFactory.getLogger(AccountDao.class);

    public AccountDao(Supplier<EntityManager> persistence) {
        this.persistence = persistence;
    }

    public Account findByEmail(String email) throws IncorrectInput {
        EntityManager entityManager = persistence.get();
        entityManager.getTransaction().begin();

        TypedQuery<Account> accountTypedQuery = entityManager.createQuery(
                "select ac.id from Account as ac left join User  as u ON " +
                        "ac.id=u.id where u.email like :email", Account.class).setParameter("email", email);
        Account account = accountTypedQuery.getSingleResult();

        if (account == null) {
            logger.warn("Incorrect input");
            throw new IncorrectInput("Incorrect input");
        }

        entityManager.persist(account);
        entityManager.getTransaction().commit();
        entityManager.close();

        return account;
    }

//    public Account findById(Long id) {
//        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Account.class, id);
//    }
//
//    public List<Long> findAllAccounts() {
//        List<Long> accounts = HibernateSessionFactoryUtil.getSessionFactory()
//                .openSession().createQuery("select ac from Account ac where id = ?").list();
//        return accounts;
//    }
}
