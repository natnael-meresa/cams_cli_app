package org.pams.repository;

import org.pams.dbcontext.InMemoryDbContext;
import org.pams.domain.Account;

import java.util.List;

public class AccountRepositoryImpl
        implements AccountRepository {

    private final InMemoryDbContext dbContext;

    public AccountRepositoryImpl(
            InMemoryDbContext dbContext) {

        this.dbContext = dbContext;
    }

    @Override
    public List<Account> findAll() {
        return dbContext.getAccounts();
    }
}