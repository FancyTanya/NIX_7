package ua.com.alevel.entity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "income_categories")
public class IncomeCategory extends Category{
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private final String INCOME = "income";

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "income_category")
    private List<IncomeCategory> incomeCategories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
