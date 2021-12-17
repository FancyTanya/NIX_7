package com.github.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount{

    private final Lock lock = new ReentrantLock();
    private Long id;
    private int balance;

    public int getBalance() {
        return balance;
    }

    public BankAccount(Long id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private void withdraw(int amount) {
        balance -= amount;
    }

    private void deposit(int amount) {
        balance += amount;
    }

    private void transfer(BankAccount fromAccount, BankAccount toAccount, int transferAmount) throws InterruptedException {

        while (true) {
            if (fromAccount.lock.tryLock()) {
                try {
                    if (toAccount.lock.tryLock()) {
                        try {
                            fromAccount.withdraw(transferAmount);
                            toAccount.deposit(transferAmount);
                            break;
                        } finally {
                            lock.unlock();
                        }
                    }
                } finally {
                    lock.unlock();
                }

                Thread.sleep(1000);
            }
        }
    }
}
