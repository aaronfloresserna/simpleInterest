/*
 * Aaron Flores
 * Aplazo project
 * 26, Agosto 2021
 */

package com.api.SimpleInterest.models;

import javax.persistence.*;

@Entity
@Table(name = "simpleinterestresponse")
public class ResponseModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private Integer payment_number;

	private Double amount;

	private String payment_date;

	@ManyToOne(targetEntity = RequestModel.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "requestId", referencedColumnName = "id")
	private RequestModel request;
	
	public ResponseModel(Integer payment_number, Double amount, String payment_date, RequestModel requestModel) {
		super();
		this.payment_number = payment_number;
		this.amount = amount;
		this.payment_date = payment_date;
		this.request = requestModel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public String getPayment_date() {
		return payment_date;
	}
	
	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public RequestModel getRequest() {
		return request;
	}

	public void setRequest(RequestModel request) {
		this.request = request;
	}

	@Override
	public String toString() {
		return "ResponseModel [amount=" + amount + ", id=" + id + ", payment_date=" + payment_date + ", payment_number="
				+ payment_number + ", request=" + request + "]";
	}
	
}
