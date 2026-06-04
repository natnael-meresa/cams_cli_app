package org.pams.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {

    private Long accountId;
    private String accountNumber;
    private String accountType;
    private LocalDate dateOpened;
    private BigDecimal balance;
    private Customer customer;

    public Account(
            Long accountId,
            String accountNumber,
            String accountType,
            LocalDate dateOpened,
            BigDecimal balance,
            Customer customer) {

        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.dateOpened = dateOpened;
        this.balance = balance;
        this.customer = customer;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public LocalDate getDateOpened() {
        return dateOpened;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }
}
