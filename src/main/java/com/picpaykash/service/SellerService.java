package com.picpaykash.service;

import com.picpaykash.DTO.SellerViewDTO;
import com.picpaykash.exceptions.UniqueException;
import com.picpaykash.exceptions.ValidaCamposException;
import com.picpaykash.model.Seller;


public interface SellerService {

	public Seller addSeller(SellerViewDTO seller) throws UniqueException, ValidaCamposException, IllegalArgumentException, IllegalAccessException;
}
