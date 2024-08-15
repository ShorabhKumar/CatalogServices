package com.example.demo.Contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Product;
import com.example.demo.Services.ProductServices;
import com.example.demo.dtos.ProductRequestDto;
import com.example.demo.dtos.ProductResponseDto;

@RestController
public class ProductController {
	
	@Autowired
	ProductServices productServices;
	
	@Autowired
	public ProductController(ProductServices productServices) {
		super();
		this.productServices = productServices;
	}
	
	
	@GetMapping("/product/{id}")
	public ProductResponseDto getProductById(@PathVariable("id") Long id) {
		Product product = productServices.getProductById(id);
		return ProductResponseDto.from(product);
	}
	
	@GetMapping("/product")
	public List<Product> getProductList() {
		return productServices.getAllProduct();
	}
	
	@PostMapping("/product")
	public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
		Product product = productServices.createProduct(
				productRequestDto.getTitle(),
                productRequestDto.getDescription(),
                productRequestDto.getPrice(),
                productRequestDto.getImageUrl(),
                productRequestDto.getCategoryName()
				);
		return ProductResponseDto.from(product);
	}
}
