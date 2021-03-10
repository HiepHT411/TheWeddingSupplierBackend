package com.theweddingsupplier.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.theweddingsupplier.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	//@Query(value = "Select * from user where 'name' = ?1", nativeQuery = true)
	Optional<User> findByUsername(String name);
	
	Boolean existsByUsername(String name);
	
	Boolean existsByEmail(String email);
}
