package com.theweddingsupplier.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.theweddingsupplier.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>,JpaSpecificationExecutor<Product> {
	List<Product> findByType(String type);
	
	List<Product> findAllByOrderByDateDesc();	//thoi gian gan day nhat
	
	// get only 4 newest objects
	@Query(value="SELECT * FROM product ORDER BY date DESC LIMIT 4", nativeQuery = true)
	List<Product> getFourNewestObject(); 
}
