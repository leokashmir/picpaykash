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
@Table(name ="consumer")
@SequenceGenerator(name="CONSUMER_SQ", initialValue=1, allocationSize = 1, sequenceName="sq_consumer_tb")
public class Consumer {
	
	//sq_consumer_tb
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CONSUMER_SQ")
	@Column(name = "CONSUMER_ID")
	private Long consumerId;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@OneToOne
	@JoinColumn(name = "user_id_fk")
	private User user;

	

	public Long getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Long consumerId) {
		this.consumerId = consumerId;
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
