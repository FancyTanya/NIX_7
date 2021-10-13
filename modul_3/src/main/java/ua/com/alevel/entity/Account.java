package ua.com.alevel.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts", schema = "finance_app")
public class Account {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Long id;

    @Column
    @OneToMany(mappedBy = "accounts")
    private User user;

    @OneToMany(mappedBy = "user_id")
    @JoinColumn(name = "user_id")
    private Long user_id;

//    @OneToMany(mappedBy = "user")
//    private List<Account> accounts;

    public Account() {
    }

//    public Account(User user) {
//        this.user = user;
//        accounts = new ArrayList<>();
//    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
