package org.pams.repository;


import java.util.List;

import org.pams.domain.Account;

public interface AccountRepository {

    List<Account> findAll();
}
