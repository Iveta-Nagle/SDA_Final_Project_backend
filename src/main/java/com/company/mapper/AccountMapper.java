package com.company.mapper;

import com.company.dto.AccountDTO;
import com.company.dto.CardDTO;
import com.company.model.Account;
import com.company.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountMapper {

    private MapperMediator mapperMediator;

    @Autowired
    public AccountMapper(MapperMediator mapperMediator) {
        this.mapperMediator = mapperMediator;
    }


    public AccountDTO toDTO(Account account){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setAccountNumber(account.getAccountNumber());
        accountDTO.setBallance(account.getBallance());
        accountDTO.setCurrency(account.getCurrency());
        accountDTO.setStatus(account.getStatus());
        List<Card> cards =  account.getCards();
        List<CardDTO> cardDTOS = new ArrayList<>();
        for (Card card: cards) {
            CardDTO tmp = mapperMediator.getCardMapper().toDTO(card);
            cardDTOS.add(tmp);
        }
        accountDTO.setCardDTO(cardDTOS);
        return accountDTO;
    }

    public Account fromDTO(AccountDTO accountDTO){
        Account account = new Account();
        account.setId(accountDTO.getId());
        account.setAccountNumber(accountDTO.getAccountNumber());
        account.setBallance(accountDTO.getBallance());
        account.setCurrency(accountDTO.getCurrency());
        account.setStatus(accountDTO.getStatus());
        List<CardDTO> cardDTOS =  accountDTO.getCardDTO();
        List<Card> cards = new ArrayList<>();
        for (CardDTO cardDTO: cardDTOS) {
            Card tmp = mapperMediator.getCardMapper().fromDTO(cardDTO);
            cards.add(tmp);
        }
        account.setCards(cards);
        return account;
    }


}
