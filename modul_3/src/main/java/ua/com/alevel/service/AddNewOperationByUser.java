package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.AccountDao;
import ua.com.alevel.dao.CategoryDao;
import ua.com.alevel.dao.OperationDao;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.Operation;
import ua.com.alevel.exceptions.IncorrectInput;

import javax.persistence.EntityManager;
import java.util.function.Supplier;


public class AddNewOperationByUser {

    private final Supplier<EntityManager> persistence = null;
    private static final Logger logger = LoggerFactory.getLogger(AddNewOperationByUser.class);
    private OperationDao operationDao = new OperationDao();
    private UserDao userDao = new UserDao();
    private CategoryDao categoryDao = new CategoryDao(persistence);
    private AccountDao accountDao = new AccountDao(persistence);


    public void newOperation(int currency, String category, String email) {
        EntityManager entityManager = persistence.get();
        entityManager.getTransaction().begin();

        logger.info("Create new operation");
        Operation operation = null;
        try {
            operation = new Operation(
                    categoryDao.findByCategoryName(category),
                    currency,
                    accountDao.findByEmail(email));
        } catch (IncorrectInput e) {
            logger.warn("Incorrect input", e);
        }
        operationDao.save(operation);
    }

//    public void newOperation(int currency, String category, Long accountId) {
//        EntityManager entityManager = persistence.get();
//        entityManager.getTransaction().begin();
//
//        logger.info("Create new operation");
//        Operation operation = new Operation(
//                categoryDao.findByCategoryName(category).getTitle(),
//                currency,
//                accountDao.findById(accountId));
//        operationDao.save(operation);
//    }


}
