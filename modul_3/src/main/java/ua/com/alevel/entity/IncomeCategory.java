package ua.com.alevel.entity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "income_categories", schema = "finance_app")
public class IncomeCategory extends Category{
    @Column(name = "category_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private final String INCOME = "income";

    @OneToMany
    @JoinColumn(name = "income_category")
    private List<IncomeCategory> incomeCategories;

    public Long getId() {
        return id;
    }

    public String getINCOME() {
        return INCOME;
    }

    public List<IncomeCategory> getIncomeCategories() {
        return incomeCategories;
    }

    public void setIncomeCategories(List<IncomeCategory> incomeCategories) {
        this.incomeCategories = incomeCategories;
    }

    public IncomeCategory() {
    }

}
