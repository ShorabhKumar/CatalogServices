package com.example.demo.Contollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ProductNotFoundException;
import com.example.demo.Model.Product;
import com.example.demo.Services.ProductServices;
import com.example.demo.dtos.ProductRequestDto;
import com.example.demo.dtos.ProductResponseDto;

@RestController
public class ProductController {
	
	@Autowired
	ProductServices productServices;
	
	@Autowired
	public ProductController(@Qualifier("productDbService") ProductServices productServices) {
		super();
		this.productServices = productServices;
	}
	
	
	@GetMapping("/product/{id}")
	public ProductResponseDto getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
		Optional<Product> product = productServices.getProductById(id);
		return ProductResponseDto.from(product.get());
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
	
	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
		return productServices.deleteProduct(id);
	}
	
    // Only invoked in ProductController class.
    // If there is any other controller that throws NPE, this won't be called
//	@ExceptionHandler(NullPointerException.class)
//	 public ErrorDto nullPointerExceptionHandler() {
//		 ErrorDto errorDto = new ErrorDto();
//		 errorDto.setStatus("FAILURE");
//		 errorDto.setMessage("some thing want wrong");
//		 return errorDto;
//	 }
}
