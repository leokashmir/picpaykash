package com.picpaykash.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.picpaykash.model.Seller;
import com.picpaykash.model.User;

public interface SellerRepository extends JpaRepository<Seller, Long> {

	@Query("select s from Seller s where user_id_fk = ?1") 
	Optional<Seller> findByUserId(Long id);

	@Query("select u from User u, Consumer co, Seller s where co.userName like %?1 or s.userName like %?1") 
	List<User> findByUserNameOrName(String userName);

}
