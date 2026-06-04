package org.pams.services;

import java.math.BigDecimal;
import java.util.List;

import org.pams.domain.Account;

public interface AccountService {
     List<Account> getAllAccounts();

    List<Account> getPlatinumAccounts();

    BigDecimal getLiquidityPosition();
}
