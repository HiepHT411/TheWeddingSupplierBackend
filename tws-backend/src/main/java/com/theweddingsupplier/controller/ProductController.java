package com.theweddingsupplier.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.theweddingsupplier.exception.ResourceNotFoundException;
import com.theweddingsupplier.model.Product;
import com.theweddingsupplier.repository.ProductRepository;
import com.theweddingsupplier.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/tws")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
public class ProductController {
	
	@Autowired
	private final ProductRepository productRepository;
	
	@Autowired
	private final ProductService productService;
	
	@GetMapping("/product")
	public List<Product> getAllProducts(){
		log.info("get all products");
		return productService.getAllProduct();
		
	}
	
	@GetMapping("/product/{id}")
	public Product getDetailProduct(@PathVariable int id) {
		Product product = productService.getProductById(id);
		log.info("get product: "+ product.getTitle());
		return product;
	}
	
	@GetMapping("/product/service")
	public List<Product> getServiceProduct(){
		log.info("get all service products");
		return productService.getServiceProduct();
	}
	@GetMapping("/product/new")
	public List<Product> getNewProduct(){
		log.info("get 4 newest products");
		return productService.getNewProduct();
	}
	@GetMapping("/product/bestSeller")
	public List<Product> getBestSellerProduct(){
		log.info("get all best seller products");
		return productService.getBestSellerProduct();
	}
//	@GetMapping("/product/{type}")
//	public List<Product> getProductInSpecificType(@PathVariable("type") String type){
//		log.info("get product int type:" +type);
//		if(type.equalsIgnoreCase("service")) {
//			return productService.getServiceProduct();
//		}
//		else if(type.equalsIgnoreCase("bestSeller")) {
//			return productService.getBestSellerProduct();
//		}
//		else if(type.equalsIgnoreCase("new")) {
//			return productService.getNewProduct();
//		}
//		return null;
//	}
	@PostMapping("/product")
	public ResponseEntity<Product> create(@RequestBody Product product){
		log.info("create product: "+ product.getTitle());
		return ResponseEntity.ok(productService.saveProduct(product));
		
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable int id){
		Product product = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("product not found"));
		log.info("delete product: "+ product.getTitle());
		productRepository.delete(product);
		
		HashMap<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
