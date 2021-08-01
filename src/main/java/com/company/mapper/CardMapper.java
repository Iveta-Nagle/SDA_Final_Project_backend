package com.company.mapper;

import com.company.dto.AccountDTO;
import com.company.dto.CardDTO;
import com.company.model.Account;
import com.company.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    private MapperMediator mapperMediator;

    @Autowired
    public CardMapper(MapperMediator mapperMediator) {
        this.mapperMediator = mapperMediator;
    }


    public CardDTO toDTO(Card card){
        CardDTO cardDTO = new CardDTO();
        cardDTO.setId(card.getId());
        cardDTO.setCardHolder(card.getCardHolder());
        cardDTO.setCardNumber(card.getCardNumber());

        AccountDTO accountDTO = mapperMediator.getAccountMapper().toDTO(card.getAccount());
        cardDTO.setAccountDTO(accountDTO);

        cardDTO.setExpDate(card.getExpDate());
        cardDTO.setStatus(card.getStatus());
        return cardDTO;
    }

    public Card fromDTO(CardDTO cardDTO){
        Card card = new Card();
        card.setId(cardDTO.getId());
        card.setCardHolder(cardDTO.getCardHolder());
        card.setCardNumber(cardDTO.getCardNumber());

        Account account =  mapperMediator.getAccountMapper().fromDTO(cardDTO.getAccountDTO());
        card.setAccount(account);

        card.setExpDate(cardDTO.getExpDate());
        card.setStatus(cardDTO.getStatus());
        return card;
    }
}
