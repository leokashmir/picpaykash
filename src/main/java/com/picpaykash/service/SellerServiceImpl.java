package com.picpaykash.service;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picpaykash.DTO.SellerViewDTO;
import com.picpaykash.exceptions.UniqueException;
import com.picpaykash.exceptions.ValidaCamposException;
import com.picpaykash.model.Seller;
import com.picpaykash.model.User;
import com.picpaykash.repository.ConsumerRepository;
import com.picpaykash.repository.SellerRepository;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	@Autowired
	private ConsumerRepository consumerRepository;
	
	@Override
	public Seller addSeller(SellerViewDTO sellerViewDto)
			throws UniqueException, ValidaCamposException, IllegalArgumentException, IllegalAccessException {
		
		
		StringBuilder erro = new StringBuilder();
				
				for (Field field : SellerViewDTO.class.getDeclaredFields()) {
				    if (Modifier.isPrivate(field.getModifiers())) {
				    	 field.setAccessible(true);
				    		 if(field.get(sellerViewDto) == null || field.get(sellerViewDto).equals("")) {
				    			 	erro.append(field.getName()).append(",");
				    			 }
				    	
				    }
				}
				
				if(erro.length() > 0) {
					throw new ValidaCamposException(erro.toString());
				}
				
			
				if(consumerRepository.existsById(sellerViewDto.getUserId())) {
					throw new UniqueException("Usuario Já Possui Cadastro como Consumer");
				}
	
				if(sellerRepository.findByUserNameOrName(sellerViewDto.getUserName()) != null
						&& sellerRepository.findByUserNameOrName(sellerViewDto.getUserName()).size() > 0) {
					throw new UniqueException("User Name, já Cadastrado");
				}
				
				
					Seller seller = new Seller();
					User user = new User();
					user.setUserId(sellerViewDto.getUserId());
					
					seller.setCnpj(sellerViewDto.getCnpj());
					seller.setFantasyName(sellerViewDto.getFantasyName());
					seller.setSocialName(sellerViewDto.getSocialName());
					seller.setUserName(sellerViewDto.getUserName());
					seller.setUser(user);
					
					return sellerRepository.save(seller);
				
				
			
			}
	
}
