package com.company.service;

import com.company.model.Account;
import com.company.model.Card;
import com.company.repository.AccountRepository;
import com.company.repository.CardRepository;
import com.company.validator.CardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountService {


    private AccountRepository accountRepository;

    private CardRepository cardRepository;

    private CardValidator cardValidator;

    @Autowired
    public AccountService(AccountRepository accountRepository, CardRepository cardRepository, CardValidator cardValidator) {
        this.accountRepository = accountRepository;
        this.cardRepository = cardRepository;
        this.cardValidator = cardValidator;
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
        cardValidator.checkMaxCardAmount(account);
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
