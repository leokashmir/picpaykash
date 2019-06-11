package com.picpaykash.service;

import com.picpaykash.DTO.SellerViewDTO;
import com.picpaykash.exceptions.UniqueException;
import com.picpaykash.exceptions.ValidaCamposException;


public interface SellerService {

	public void addSeller(SellerViewDTO seller) throws UniqueException, ValidaCamposException, IllegalArgumentException, IllegalAccessException;
}
