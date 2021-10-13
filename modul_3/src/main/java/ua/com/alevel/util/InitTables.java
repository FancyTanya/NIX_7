package ua.com.alevel.util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ua.com.alevel.entity.Account;
import ua.com.alevel.entity.ExpenseCategory;
import ua.com.alevel.entity.IncomeCategory;
import ua.com.alevel.entity.User;

public class InitTables {

    public void initTables() {
        Configuration config = new Configuration();
        config.configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        final Transaction transaction = session.getTransaction();
        transaction.begin();

        User olgaIvanova = new User();
            olgaIvanova.setFirstName("Olga");
            olgaIvanova.setLastName("Ivanova");
            olgaIvanova.setEmail("qwe@gmail.com");
        session.save(olgaIvanova);

        User petrIvanov = new User();
        petrIvanov.setFirstName("Petr");
        petrIvanov.setLastName("Ivanov");
        petrIvanov.setEmail("rew@gmail.com");
        session.save(petrIvanov);

        Account firstAcc = new Account();
        firstAcc.setUser(olgaIvanova);
        session.save(firstAcc);

        Account secondAcc = new Account();
        secondAcc.setUser(olgaIvanova);
        session.save(secondAcc);

        Account thirdAcc = new Account();
        thirdAcc.setUser(petrIvanov);
        session.save(thirdAcc);

        ExpenseCategory shopping = new ExpenseCategory();
        session.save(shopping);

        ExpenseCategory clothes = new ExpenseCategory();
        session.save(clothes);

        ExpenseCategory food = new ExpenseCategory();
        session.save(food);

        IncomeCategory salary = new IncomeCategory();
        session.save(salary);

        IncomeCategory extra = new IncomeCategory();
        session.save(extra);

    }
}
