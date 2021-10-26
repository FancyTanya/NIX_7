package ua.com.alevel.service;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.Account;
import ua.com.alevel.entity.Category;
import ua.com.alevel.entity.Operation;
import ua.com.alevel.exceptions.IncorrectInput;
import ua.com.alevel.util.HibernateSessionFactoryUtil;

import javax.persistence.TypedQuery;


public class AddNewOperationByUser {

    private static final Logger logger = LoggerFactory.getLogger(AddNewOperationByUser.class);
    private final String login;
    private final String password;


    public AddNewOperationByUser(String login, String password) {
        this.login = login;
        this.password = password;

    }

    public void newOperation(int currency, String category, String email) {
        try (var sessionFactory = HibernateSessionFactoryUtil.getSessionFactory(login, password)) {
            try (var session = sessionFactory.openSession()) {
                session.beginTransaction();
                try {
                    logger.info("Create new operation");
                    session.getTransaction().begin();

                    TypedQuery<Category> categoryTypedQuery = session.createQuery("select c from Category " +
                            "as c where c.title = :category", Category.class).setParameter("category", category);
                    Category cat = categoryTypedQuery.getResultStream().findAny()
                            .orElseThrow(() -> new IncorrectInput("Incorrect input"));

                    TypedQuery<Account> accountTypedQuery = session.createQuery(
                                    "select ac.id from Account as ac left join User  as u ON " +
                                            "ac.id=u.id where u.email like :email", Account.class)
                            .setParameter("email", email);
                    Account account = accountTypedQuery.getResultStream().findAny()
                            .orElseThrow(() -> new IncorrectInput("Incorrect input"));

                    var operation = new Operation(category, currency, account);
                    session.save(operation);

                } catch (Exception e) {
                    logger.warn("Incorrect input", e);
                }
            }
        }

    }
}
