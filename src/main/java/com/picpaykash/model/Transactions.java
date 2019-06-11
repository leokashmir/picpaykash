package com.picpaykash.model;

import java.util.Date;

public class Transactions {

	private Long id;
	
	private Long payee_id;
	
	private Long payer_id;
	
	private Float value;

	private Date transaction_date;
	
	
	public long getPayee_id() {
		return payee_id;
	}

	public void setPayee_id(Long payee_id) {
		this.payee_id = payee_id;
	}

	public long getPayer_id() {
		return payer_id;
	}

	public void setPayer_id(Long payer_id) {
		this.payer_id = payer_id;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}

	
	
}
