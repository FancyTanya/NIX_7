package ua.com.alevel.entity;


import ua.com.alevel.exceptions.IncorrectInput;

import javax.persistence.*;
import java.util.List;
@Entity
@Table
public class Operation<T extends Category> {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expence_category")
    private List<ExpenseCategory> expenseCategories;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "income_category")
    private List<IncomeCategory> incomeCategories;

    @Column
    private int currency;

    public Operation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ExpenseCategory> getExpenseCategories() {
        return expenseCategories;
    }

    public void setExpenseCategories(List<ExpenseCategory> expenseCategories) {
        this.expenseCategories = expenseCategories;
    }

    public List<IncomeCategory> getIncomeCategories() {
        return incomeCategories;
    }

    public void setIncomeCategories(List<IncomeCategory> incomeCategories) {
        this.incomeCategories = incomeCategories;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }
}
