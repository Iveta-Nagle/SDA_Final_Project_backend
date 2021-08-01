package com.company.controller;

import com.company.dto.AccountDTO;
import com.company.mapper.MapperMediator;
import com.company.model.Account;
import com.company.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/rest/Account.svc")

public class AccountController {

    private MapperMediator mapperMediator;

    private AccountService accountService;

    @Value("${com.company.environment}")
    private String env;

    @Autowired
    public AccountController(MapperMediator mapperMediator, AccountService accountService) {
        this.mapperMediator = mapperMediator;
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public List<AccountDTO> showAll() {
       List<Account> accountList = accountService.getAllAccounts();
       List<AccountDTO> accountDTOList = new ArrayList<>();
       for (Account account: accountList) {
           AccountDTO tmp = mapperMediator.getAccountMapper().toDTO(account);
           accountDTOList.add(tmp);
       }
       return accountDTOList;
    }
}
