/*
 * Aaron Flores
 * Aplazo project
 * 26, Agosto 2021
 */

package com.api.SimpleInterest.models;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "simpleinterestrequest")
public class RequestModel {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
    private Double amount;
	
	@Column(nullable = false)
    private Integer terms;
	
	@Column(nullable = false)
    private Double rate;

	public RequestModel(double amount, int terms, double rate) {
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
	public int hashCode() {
		return Objects.hash(amount, rate, terms);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestModel other = (RequestModel) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Double.doubleToLongBits(rate) == Double.doubleToLongBits(other.rate) && terms == other.terms;
	}

	@Override
	public String toString() {
		return "SimpleInterestRequest [amount=" + amount + ", terms=" + terms + ", rate=" + rate + "]";
	}

	
}
