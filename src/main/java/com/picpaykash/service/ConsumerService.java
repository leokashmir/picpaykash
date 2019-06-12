package com.picpaykash.service;

import com.picpaykash.DTO.ConsumerViewDto;
import com.picpaykash.exceptions.UniqueException;
import com.picpaykash.exceptions.ValidaCamposException;
import com.picpaykash.model.Consumer;

public interface ConsumerService {
	
	public Consumer addConsumer(ConsumerViewDto consumer) throws UniqueException, ValidaCamposException, IllegalArgumentException, IllegalAccessException;

}
