package org.pams.dbcontext;

import org.pams.domain.Account;
import org.pams.domain.Customer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InMemoryDbContext {

    private final List<Customer> customers = new ArrayList<>();
    private final List<Account> accounts = new ArrayList<>();

    public InMemoryDbContext() {

        Customer c1 =
                new Customer(1L,"Bob","Jones");

        Customer c2 =
                new Customer(2L,"Anna","Smith");

        Customer c3 =
                new Customer(3L,"Carlos","Lopez");

        customers.add(c1);
        customers.add(c2);
        customers.add(c3);

        accounts.add(
                new Account(
                        1L,
                        "AC1001",
                        "Checking",
                        LocalDate.of(2013,5,1),
                        new BigDecimal("150000"),
                        c1));

        accounts.add(
                new Account(
                        2L,
                        "AC1002",
                        "Savings",
                        LocalDate.of(2018,6,10),
                        new BigDecimal("70000"),
                        c2));

        accounts.add(
                new Account(
                        3L,
                        "AC1003",
                        "Checking",
                        LocalDate.of(2023,1,1),
                        new BigDecimal("5000"),
                        c3));
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
