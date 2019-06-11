package com.picpaykash.service;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picpaykash.DTO.ConsumerViewDto;
import com.picpaykash.exceptions.UniqueException;
import com.picpaykash.exceptions.ValidaCamposException;
import com.picpaykash.model.Consumer;
import com.picpaykash.model.User;
import com.picpaykash.repository.ConsumerRepository;
import com.picpaykash.repository.SellerRepository;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	@Autowired
	private ConsumerRepository consumerRepository;
	

	@Override
	public void addConsumer(ConsumerViewDto consViewDto)
			throws UniqueException, ValidaCamposException, IllegalArgumentException, IllegalAccessException {
		
	
		StringBuilder erro = new StringBuilder();
		
		//Verifica se os campos estao vazios. 
		
		for (Field field : ConsumerViewDto.class.getDeclaredFields()) {
		    if (Modifier.isPrivate(field.getModifiers())) {
		    	 field.setAccessible(true);
		    		 if(field.get(consViewDto) == null || field.get(consViewDto).equals("")) {
		    			 	erro.append(field.getName()).append(",");
		    			 }
		    	
		    }
		}
		
		if(erro.length() > 0) {
			throw new ValidaCamposException(erro.toString());
		}
		
		if(sellerRepository.existsById(consViewDto.getUserId())) {
			throw new UniqueException("Usuario Já Possui Cadastro como Vendedor");
		}
		
		try {
			Consumer consumerObj = new Consumer();
			User user = new User();
			user.setUserId(consViewDto.getUserId());
			
			consumerObj.setUsername(consViewDto.getUsername());
			consumerObj.setUser(user);
			consumerRepository.save(consumerObj);
		}
		catch(Exception f) {
			f.getMessage();
		}
	
		
		
		
	}

}

