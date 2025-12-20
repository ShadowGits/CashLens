package com.aistuff.dto;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StandardizedTransactionDTO {

    @JsonProperty("transaction_id")
    private String transactionId;

    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate date;

    @JsonProperty("description")
    private String description;

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("type")
    private String type; // "credit" or "debit"

    @JsonProperty("balance")
    private Double balance;

    @JsonProperty("account_no")
    private String accountNo;

    @JsonProperty("bank")
    private String bank;

    // ---------- Constructors ----------
    public StandardizedTransactionDTO() {}

    public StandardizedTransactionDTO(String transactionId, LocalDate date, String description,
                                      Double amount, String type, Double balance,
                                      String accountNo, String bank) {
        this.transactionId = transactionId;
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.balance = balance;
        this.accountNo = accountNo;
        this.bank = bank;
    }

    // ---------- Getters & Setters ----------

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }

    public String getAccountNo() { return accountNo; }
    public void setAccountNo(String accountNo) { this.accountNo = accountNo; }

    public String getBank() { return bank; }
    public void setBank(String bank) { this.bank = bank; }

    // ---------- equals/hashCode/toString ----------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StandardizedTransactionDTO)) return false;
        StandardizedTransactionDTO that = (StandardizedTransactionDTO) o;
        return Objects.equals(transactionId, that.transactionId)
                && Objects.equals(date, that.date)
                && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, date, amount);
    }

    @Override
    public String toString() {
        return "StandardizedTransactionDTO{" +
                "transactionId='" + transactionId + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                ", accountNo='" + accountNo + '\'' +
                ", bank='" + bank + '\'' +
                '}';
    }
}
