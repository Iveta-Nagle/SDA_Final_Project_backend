package com.company.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class AccountDTO {

    private long id;

    private String accountNumber;

    private String currency;

    private double ballance;

    private int status;

    @JsonManagedReference
    private List<CardDTO> cardDTO;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBallance() {
        return ballance;
    }

    public void setBallance(double ballance) {
        this.ballance = ballance;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<CardDTO> getCardDTO() {
        return cardDTO;
    }

    public void setCardDTO(List<CardDTO> cardDTO) {
        this.cardDTO = cardDTO;
    }
}
