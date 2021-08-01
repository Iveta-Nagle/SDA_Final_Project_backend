package com.company.mapper;

import com.company.dto.AccountDTO;
import com.company.model.Account;
import org.springframework.stereotype.Component;


@Component
public class AccountMapper {

    public AccountDTO toDTO(Account account){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setAccountNumber(account.getAccountNumber());
        accountDTO.setBallance(account.getBallance());
        accountDTO.setCurrency(account.getCurrency());
        accountDTO.setStatus(account.getStatus());
        return accountDTO;
    }

    public Account fromDTO(AccountDTO accountDTO){
        Account account = new Account();
        account.setId(accountDTO.getId());
        account.setAccountNumber(accountDTO.getAccountNumber());
        account.setBallance(accountDTO.getBallance());
        account.setCurrency(accountDTO.getCurrency());
        account.setStatus(accountDTO.getStatus());
        return account;
    }


}
