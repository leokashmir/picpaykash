package com.picpaykash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="seller")
@SequenceGenerator(name="SELLER_SQ", initialValue=1, allocationSize = 1, sequenceName="sq_seller_tb")
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SELLER_SQ")
	@Column(name = "SELLER_ID")
	private Long sellerId;
	
	@Column(name = "SOCIAL_NAME")
	private String socialName;
	
	@Column(name = "FANTASY_NAME")
	private String fantasyName;	
	
	@Column(name = "CNPJ")
	private String cnpj;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@OneToOne
	@JoinColumn(name = "user_id_fk")
	private User user;

	
	
	public Long getSellerId() {
		return sellerId;
	}


	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}


	public String getSocialName() {
		return socialName;
	}


	public void setSocialName(String socialName) {
		this.socialName = socialName;
	}


	public String getFantasyName() {
		return fantasyName;
	}


	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}



	
	
}
