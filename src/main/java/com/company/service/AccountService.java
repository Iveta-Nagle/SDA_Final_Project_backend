package com.company.service;

import com.company.model.Account;
import com.company.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountService {


    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Account getAccountById(long id) {
        return accountRepository.getById(id);
    }

    public Account saveAccount(Account account){
        return accountRepository.save(account);
    }

    public List<Account> getAccountByNumberLike(String accountNumber){
        return accountRepository.findAccountByAccountNumberContains(accountNumber);
    }
}
