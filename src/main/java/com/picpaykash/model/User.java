package com.picpaykash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="user_tb")
@SequenceGenerator(name="USER_SQ", initialValue=1, allocationSize = 1, sequenceName="sq_user_tb")
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="USER_SQ")
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "FULL_NAME")
	private String fullName;
	
	@Column(name = "CPF")
	private String cpf;
	
	@Column(name = "PHONE_NUMBER")
	private String phone_number;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASS")
	private String password;
	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFull_name() {
		return fullName;
	}

	public void setFull_name(String fullName) {
		this.fullName = fullName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	

}
