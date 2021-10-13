package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.AccountDao;
import ua.com.alevel.dao.CategoryDao;
import ua.com.alevel.dao.OperationDao;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.Operation;
import ua.com.alevel.entity.User;


public class AddNewOperationByUser {

    private static final Logger logger = LoggerFactory.getLogger(AddNewOperationByUser.class);
    private OperationDao operationDao = new OperationDao();
    private UserDao userDao = new UserDao();
    private CategoryDao categoryDao = new CategoryDao();
    private AccountDao accountDao = new AccountDao();


    public AddNewOperationByUser() {
    }

    public void newOperation(int currency, String category, String email, Long account_id) {
        AddNewOperationByUser addNewOperation = new AddNewOperationByUser();
        if (findUserByEmail(email).equals(findUserByAccount(account_id))) {
            Operation operation = new Operation(categoryDao.findByCategoryName(category)
                    , currency, accountDao.findById(account_id));
            addNewOperation.save(operation);
        }
    }
    public void save(Operation operation) {
        operationDao.save(operation);
    }
    public User findUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public User findUserByAccount(Long accountId) {
        return userDao.findByAccount(accountId);
    }
}
