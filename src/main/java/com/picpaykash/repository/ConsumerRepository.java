package com.picpaykash.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.picpaykash.model.Consumer;


public interface ConsumerRepository extends JpaRepository<Consumer, Long> {

	@Query("select c from Consumer c where user_id_fk = ?1") 
	Optional<Consumer> findByUserId(Long id);
}
