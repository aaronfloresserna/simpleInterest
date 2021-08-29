/*
 * Aaron Flores
 * Aplazo project
 * 26, Agosto 2021
 */

package com.api.SimpleInterest.dto;

public class SimpleInterestDTO {
    private Integer payment_number;
    private Double amount;
    private String payment_date;
    
    public SimpleInterestDTO(Integer payment_number, Double amount, String payment_date) {
        this.payment_number = payment_number;
        this.amount = amount;
        this.payment_date = payment_date;
    }

    public Integer getPayment_number() {
        return payment_number;
    }

    public void setPayment_number(Integer payment_number) {
        this.payment_number = payment_number;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    @Override
    public String toString() {
        return "SimpleInterestDTO [amount=" + amount + ", payment_date=" + payment_date + ", payment_number="
                + payment_number + "]";
    }

    
}
