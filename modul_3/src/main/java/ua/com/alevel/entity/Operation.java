package ua.com.alevel.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "operation", schema = "finance_app")
public class Operation{

    @Column(name = "operation_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "operation_time", nullable = false)
    private Timestamp operationTime;

    @ManyToOne
    @Column(name = "category_id")
    private ExpenseCategory expenseCategory;

    @ManyToOne
    @Column(name = "category_id")
    private IncomeCategory incomeCategory;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    private Category category;

    @Column
    private int currency;

    @Column(name = "user_id")
    @OneToOne
    private User user;

    @Column(name = "account_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    public Operation() {
    }

    public Operation(Category category, int currency, Account account) {
        if (currency > 0) {
            category = incomeCategory;
        }
        if (currency < 0) {
            category = expenseCategory;
        }

        this.currency = currency;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public IncomeCategory getIncomeCategory() {
        return incomeCategory;
    }

    public void setIncomeCategory(IncomeCategory incomeCategory) {
        this.incomeCategory = incomeCategory;
    }

    public Timestamp getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Timestamp operationTime) {
        this.operationTime = operationTime;
    }

}
