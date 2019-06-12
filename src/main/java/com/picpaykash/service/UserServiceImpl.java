package com.picpaykash.service;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.picpaykash.DTO.AccountsDTO;
import com.picpaykash.DTO.UsuarioDetalhesDTO;
import com.picpaykash.exceptions.UniqueException;
import com.picpaykash.exceptions.ValidaCamposException;
import com.picpaykash.model.User;
import com.picpaykash.repository.ConsumerRepository;
import com.picpaykash.repository.SellerRepository;
import com.picpaykash.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Autowired
	private ConsumerRepository consumerRepository;
	
	
	
	

	@Override
	public User addUser(User user) throws UniqueException, ValidaCamposException, IllegalArgumentException, IllegalAccessException {
		User usr = null;
		StringBuilder erro = new StringBuilder();
		
	for (Field field : User.class.getDeclaredFields()) {
		    if (Modifier.isPrivate(field.getModifiers())) {
		    	 field.setAccessible(true);
		    	 
		    	 if(!field.getName().equals("userId")) {
		    		 if(field.get(user) == null || field.get(user).equals(""))
		    			 erro.append(field.getName()).append(",");
		    		 	
		    	 }
		    	
		    }
		}
		
		if(erro.length() > 0) {
			throw new ValidaCamposException(erro.toString());
		}
		
		
		
		try {
			usr = userRepository.save(user);
		}catch(DataIntegrityViolationException r) {
			throw new UniqueException("Usuario Já Cadastrado");
		
		}
		
		return usr;
	}


	@Override
	public UsuarioDetalhesDTO getUsuarioDetalheById(Long id) {
		UsuarioDetalhesDTO usuarioDetalhes = new UsuarioDetalhesDTO();
		AccountsDTO accounts = new AccountsDTO();
		
		accounts.setSeller(sellerRepository.findByUserId(id));
		accounts.setConsumer(consumerRepository.findByUserId(id));
		
		usuarioDetalhes.setUser(userRepository.findById(id));
		usuarioDetalhes.setAccounts(accounts);
		return usuarioDetalhes;
	}


	@Override
	public List<User> listUsers(String usrFiltro) {
		
		List<User> lstUsuarios = new ArrayList<User>();
		
		if(usrFiltro == null || usrFiltro.equals("")) {
			lstUsuarios =  userRepository.findAll();
		}else {
			lstUsuarios = userRepository.findByNameOrUserName(usrFiltro);
		}
		
		return lstUsuarios;
		
	}

}
