package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;

public interface ProductServices {
	
	public Product getProductById(Long id);
	
	public List<Product> getAllProduct();
	
	public Product createProduct(String title, String description, Double price,
            String imageUrl, String categoryName);
	
	public Product partialUpdate(Long id, Product product);
}
