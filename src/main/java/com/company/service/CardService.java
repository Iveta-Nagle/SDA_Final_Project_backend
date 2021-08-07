package com.company.service;


import com.company.dto.CardDTO;
import com.company.model.Card;
import com.company.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
public class CardService {

    private CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getAllCards(){
        return cardRepository.findAll();
    }

    public List<Card> getAllByAccountId(long id){
        return cardRepository.findAllByAccountId(id);
    }

    public Card saveCard(Card card){
        return cardRepository.save(card);
    }


}
