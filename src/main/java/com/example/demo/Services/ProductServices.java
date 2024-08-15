package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;

public interface ProductServices {
	
	public List<Product> getAllProduct();
	
	public Product getProductById(Long id);
	
}
