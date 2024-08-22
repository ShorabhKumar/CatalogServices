package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.ProductNotFoundException;
import com.example.demo.Model.Product;

public interface ProductServices {
	
	public Optional<Product> getProductById(Long id) throws ProductNotFoundException;
	
	public List<Product> getAllProduct();
	
	public Product createProduct(String title, String description, Double price,
            String imageUrl, String categoryName);
	
	public Product partialUpdate(Long id, Product product);
	
	public String deleteProduct(Long id);
}
