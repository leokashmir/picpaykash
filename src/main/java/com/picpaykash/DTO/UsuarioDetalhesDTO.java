package com.picpaykash.DTO;

import java.util.Optional;

import com.picpaykash.model.User;

public class UsuarioDetalhesDTO {

	private Optional<User> user;
	
	private AccountsDTO accounts;

	

	public AccountsDTO getAccounts() {
		return accounts;
	}

	public void setAccounts(AccountsDTO accounts) {
		this.accounts = accounts;
	}

	public Optional<User> getUser() {
		return user;
	}

	public void setUser(Optional<User> user) {
		this.user = user;
	}
	
	
}
