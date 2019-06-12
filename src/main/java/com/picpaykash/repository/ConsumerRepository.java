package com.picpaykash.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.picpaykash.model.Consumer;
import com.picpaykash.model.User;


public interface ConsumerRepository extends JpaRepository<Consumer, Long> {

	@Query("select u from User u, Consumer c where user_id_fk = ?1") 
	Optional<Consumer> findByUserId(Long id);
	
	
	@Query("select u from User u, Consumer co, Seller s where co.userName like %?1 or s.userName like %?1") 
	List<User> findByUserNameOrName(String userName);
	

}
