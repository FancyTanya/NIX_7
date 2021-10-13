package ua.com.alevel.entity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "expense_categories", schema = "finance_app")
public class ExpenseCategory extends Category{

    @Column(name = "category_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_title")
    private final String EXPENSE = "expense";

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "expense_category")
    private List<ExpenseCategory> expenseCategories;

    public Long getId() {
        return id;
    }

    public String getEXPENSE() {
        return EXPENSE;
    }

    public ExpenseCategory() {
    }

    public List<ExpenseCategory> getExpenseCategories() {
        return expenseCategories;
    }

    public void setExpenseCategories(List<ExpenseCategory> expenseCategories) {
        this.expenseCategories = expenseCategories;
    }
}
