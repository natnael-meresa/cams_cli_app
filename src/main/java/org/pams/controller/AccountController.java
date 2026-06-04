package org.pams.controller;

import org.pams.domain.Account;
import org.pams.services.AccountService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class AccountController {

    private final AccountService service;

    public AccountController(
            AccountService service) {

        this.service = service;
    }

    public void displayAllAccounts() {

        JSONArray array =
                convert(service.getAllAccounts());

        System.out.println(array.toString(4));

        System.out.println(
                "\nLiquidity Position = $"
                        + service.getLiquidityPosition());
    }

    public void displayPlatinumAccounts() {

        JSONArray array =
                convert(service.getPlatinumAccounts());

        System.out.println(array.toString(4));
    }

    private JSONArray convert(
            List<Account> accounts) {

        JSONArray array = new JSONArray();

        for(Account account : accounts) {

            JSONObject customer =
                    new JSONObject();

            customer.put(
                    "customerId",
                    account.getCustomer()
                            .getCustomerId());

            customer.put(
                    "firstName",
                    account.getCustomer()
                            .getFirstName());

            customer.put(
                    "lastName",
                    account.getCustomer()
                            .getLastName());

            JSONObject obj =
                    new JSONObject();

            obj.put(
                    "accountId",
                    account.getAccountId());

            obj.put(
                    "accountNumber",
                    account.getAccountNumber());

            obj.put(
                    "accountType",
                    account.getAccountType());

            obj.put(
                    "dateOpened",
                    account.getDateOpened()
                            .toString());

            obj.put(
                    "balance",
                    account.getBalance());

            obj.put(
                    "tier",
                    getTier(account));

            obj.put(
                    "customer",
                    customer);

            array.put(obj);
        }

        return array;
    }

    private String getTier(Account account) {

        long years =
                account.getDateOpened()
                        .until(LocalDate.now())
                        .getYears();

        BigDecimal balance =
                account.getBalance();

        if(years >= 10 &&
                balance.compareTo(
                        new BigDecimal("100000")) >= 0)
            return "PLATINUM";

        if(years >= 5 &&
                balance.compareTo(
                        new BigDecimal("50000")) >= 0)
            return "GOLD";

        if(years >= 2 &&
                balance.compareTo(
                        new BigDecimal("10000")) >= 0)
            return "SILVER";

        return "STANDARD";
    }
}