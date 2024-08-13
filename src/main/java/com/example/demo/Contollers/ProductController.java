package com.example.demo.Contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.ProductModel;
import com.example.demo.Services.ProductServices;

@RestController
public class ProductController {
	
	@Autowired
	ProductServices productServices;
	
	@GetMapping("/products")
	public List<ProductModel> getProductList() {
		return productServices.getAllProduct();
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductModel> getProductById(@PathVariable("id") int id) {
		//return productServices.getProductById(id);
		ResponseEntity<ProductModel> resEnty = new ResponseEntity<>(productServices.getProductById(id),HttpStatusCode.valueOf(202));
		return resEnty;
	}
}
