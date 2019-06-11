package com.picpaykash.DTO;

import java.util.Optional;

import com.picpaykash.model.Consumer;
import com.picpaykash.model.Seller;

public class AccountsDTO {
	
	private Optional<Consumer> consumer;
	
	private Optional<Seller> seller;

	public Optional<Consumer> getConsumer() {
		return consumer;
	}

	public void setConsumer(Optional<Consumer> consumer) {
		this.consumer = consumer;
	}

	public Optional<Seller> getSeller() {
		return seller;
	}

	public void setSeller(Optional<Seller> seller) {
		this.seller = seller;
	}

	
	

}
