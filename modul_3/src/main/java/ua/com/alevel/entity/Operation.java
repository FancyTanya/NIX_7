package ua.com.alevel.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "operation")
public class Operation {

    @Column(name = "operation_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "operation_time", nullable = false)
    private Timestamp operationTime;

    @Column
    private int currency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Operation(String category, int currency, Account account) {
        Category newCategory = new Category();
        newCategory.setTitle(category);
        this.currency = currency;
        this.account = account;
    }

}
