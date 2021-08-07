package com.company.service;

import com.company.model.Account;
import com.company.model.Card;
import com.company.repository.AccountRepository;
import com.company.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountService {


    private AccountRepository accountRepository;

    private CardRepository cardRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, CardRepository cardRepository) {
        this.accountRepository = accountRepository;
        this.cardRepository = cardRepository;
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

    public void addCardToAccount(long accountId, long cardId){
        Account account = accountRepository.getById(accountId);
        Card card = cardRepository.getById(cardId);
        account.getCards().add(card);
        accountRepository.save(account);
    }

    public void removeCardFromAccount(long cardId){
        Card card = cardRepository.getById(cardId);
        card.setAccount(null);
        cardRepository.save(card);

    }
}
