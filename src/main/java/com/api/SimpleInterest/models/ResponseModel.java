/*
 * Aaron Flores
 * Aplazo project
 * 26, Agosto 2021
 */

package com.api.SimpleInterest.models;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "simpleinterestresponse")
public class ResponseModel {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer payment_number;
	private Double amount;
	private Date payment_date;
	
	
	
	public ResponseModel(Integer payment_number, Double amount, Date payment_date) {
		super();
		this.payment_number = payment_number;
		this.amount = amount;
		this.payment_date = payment_date;
	}

	public int getPayment_number() {
		return payment_number;
	}
	
	public void setPayment_number(int payment_number) {
		this.payment_number = payment_number;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public Date getPayment_date() {
		return payment_date;
	}
	
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	
	
}
