package com.picpaykash.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.picpaykash.model.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

	@Query("select s from Seller s where user_id_fk = ?1") 
	Optional<Seller> findByUserId(Long id);

}
