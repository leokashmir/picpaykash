package com.picpaykash.service;

import java.util.List;

import com.picpaykash.DTO.UsuarioDetalhesDTO;
import com.picpaykash.exceptions.UniqueException;
import com.picpaykash.exceptions.ValidaCamposException;
import com.picpaykash.model.User;

public interface UserService {
	public List<User> listUsers(String usrFiltro);
	
	public User addUser(User user) throws UniqueException, ValidaCamposException, IllegalArgumentException, IllegalAccessException;
	
	public UsuarioDetalhesDTO getUsuarioDetalheById (Long id);

}
