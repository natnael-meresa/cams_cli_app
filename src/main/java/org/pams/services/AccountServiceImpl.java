package org.pams.services;

import org.pams.domain.Account;
import org.pams.repository.AccountRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AccountServiceImpl
        implements AccountService {

    private final AccountRepository repository;

    public AccountServiceImpl(
            AccountRepository repository) {

        this.repository = repository;
    }

    @Override
    public List<Account> getAllAccounts() {

        List<Account> list = new ArrayList<>();
        for (Account account : repository.findAll()) {
            list.add(account);
        }
        list.sort(Comparator.comparing(
                        Account::getBalance)
                .reversed());
        return list;
    }

    @Override
    public List<Account> getPlatinumAccounts() {

        List<Account> list = new ArrayList<>();
        for (Account account : repository.findAll()) {

            long years =
                    account.getDateOpened()
                            .until(LocalDate.now())
                            .getYears();

            if (years >= 10 &&
                    account.getBalance()
                            .compareTo(
                                    new BigDecimal("100000")) >= 0) {
                list.add(account);
            }
        }
        return list;
    }

    @Override
    public BigDecimal getLiquidityPosition() {

        return repository.findAll()
                .stream()
                .map(Account::getBalance)
                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add);
    }
}
