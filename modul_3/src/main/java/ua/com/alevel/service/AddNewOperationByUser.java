package ua.com.alevel.service;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.AccountDao;
import ua.com.alevel.dao.CategoryDao;
import ua.com.alevel.dao.OperationDao;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.Operation;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.function.Supplier;


public class AddNewOperationByUser {

    public AddNewOperationByUser(Session session) {
        this.session = session;
    }

    private final Session session;
    private static final Logger logger = LoggerFactory.getLogger(AddNewOperationByUser.class);
    private OperationDao operationDao = new OperationDao();
    private UserDao userDao = new UserDao();
    private CategoryDao categoryDao = new CategoryDao();
    private AccountDao accountDao = new AccountDao();




    public void newOperation(int currency, String category, Long accountId) {
        logger.info("Create new operation");
        Operation operation = new Operation(
                categoryDao.findByCategoryName(category).getTitle(),
                currency,
                accountDao.findById(accountId));
        operationDao.save(operation);
    }

    public List<Long> findAllAccounts() {
        return accountDao.findAllAccounts();
    }

}
