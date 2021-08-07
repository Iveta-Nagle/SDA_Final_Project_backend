package com.company.validator;

import com.company.exception.TooManyCardsException;
import com.company.model.Account;
import org.springframework.stereotype.Component;

@Component
public class CardValidator {

    public void checkMaxCardAmount(Account account){
        if(account.getCards().size() >=3) {
            throw new TooManyCardsException("Max number of cards reached");
        }
    }
}
