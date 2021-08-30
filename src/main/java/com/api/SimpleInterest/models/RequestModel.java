/*
 * Aaron Flores
 * Aplazo project
 * 26, Agosto 2021
 */

package com.api.SimpleInterest.models;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "simpleinterestrequest")
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
public class RequestModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@ApiModelProperty(hidden = true)
	private Long id;

	@ApiModelProperty(example = "10000.00" , notes = "Principal amount", required = true)
    private Double amount;

	@ApiModelProperty(example = "5", notes = "Monthly terms", required = true)
    private Integer terms;

	@ApiModelProperty(example = "3.86", notes = "Monthly rate", required = true)
    private Double rate;


	public RequestModel(Double amount, Integer terms, Double rate) {
		this.amount = amount;
		this.terms = terms;
		this.rate = rate;
	}
	
	public Long getId() {
		return this.id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getTerms() {
		return terms;
	}

	public void setTerms(Integer terms) {
		this.terms = terms;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "RequestModel [amount=" + amount + ", id=" + id + ", rate=" + rate + ", terms=" + terms + "]";
	}

}
