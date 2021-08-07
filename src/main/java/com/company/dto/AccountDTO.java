package com.company.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class AccountDTO {

    private long id;

    @Size(min = 3, max = 15, message="Account number min is 3, max 15")
    private String accountNumber;

    @Pattern(regexp = "^(?!IRR|NKW|irr|nkw).*$", message = "Currency can't be IRR or NKW")
    @Size(min = 3, max = 3)
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
