package com.picpaykash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.picpaykash.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

	
	  @Query("select u from User u where u.fullName like %?1") List<User>
	  findByName(String name);
	  
	  @Query("select u from User u, Consumer co, Seller s where co.userName like %?1 or s.userName like %?1" ) 
	  List<User>  findByNameOrUserName(String userName);
	  
	
}


