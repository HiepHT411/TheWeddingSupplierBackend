package com.theweddingsupplier.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theweddingsupplier.exception.ResourceNotFoundException;
import com.theweddingsupplier.model.Product;
import com.theweddingsupplier.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}
	
	public Product getProductById(int id) {
		return productRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("product not found with id: "+ id));
	}
	
	public Product saveProduct(Product product) {
		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss dd-MM-yyyy");
		Date date = Calendar.getInstance().getTime();
		String productDate = dateFormat.format(date);
		
		product.setDate(productDate);
		
		return productRepo.save(product);
	}
	
	public Product updateProduct(int id, Product updatedProduct) {
		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss dd-MM-yyyy");
		Date date = Calendar.getInstance().getTime();
		String productDate = dateFormat.format(date);
		
		Product oldOne = productRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("product not found with id: "+ id));
		oldOne.setTitle(updatedProduct.getTitle());
		oldOne.setDate(productDate);
		oldOne.setPrice(updatedProduct.getPrice());
		oldOne.setContent(updatedProduct.getContent());
		
		return productRepo.save(oldOne);
	}
	
	public List<Product> getServiceProduct(){
		return productRepo.findByType("service");
	}
	
	public List<Product> getNewProduct(){
		//return productRepo.findAllByOrderByDateDesc();
		return productRepo.getFourNewestObject();
	}
	
	public List<Product> getBestSellerProduct(){
		return productRepo.findByType("bestSeller");
	}
}
