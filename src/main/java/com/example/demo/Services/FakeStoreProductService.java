package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.ProductNotFoundException;
import com.example.demo.Model.Product;
import com.example.demo.dtos.FakeStoreProductRequestDto;
import com.example.demo.dtos.FakeStoreProductResponseDto;


@Service
public class FakeStoreProductService implements ProductServices {

	

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	public FakeStoreProductService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@Override
	public Optional<Product> getProductById(Long id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		FakeStoreProductResponseDto responseDto = restTemplate.getForObject(
			"https://fakestoreapi.com/products/"+id, 
			FakeStoreProductResponseDto.class
		);
		
		if(responseDto == null) {
			throw new ProductNotFoundException("Product with id: "+ id +" not found");
		}
		return Optional.ofNullable(responseDto.toProduct());
	}
	
	@Override
	public List<Product> getAllProduct() {
		FakeStoreProductResponseDto[] responseDtos = restTemplate.getForObject(
			"https://fakestoreapi.com/products/", 
			FakeStoreProductResponseDto[].class
		);
		
		List<Product> products = new ArrayList<>();
		for(FakeStoreProductResponseDto response: responseDtos) {
			products.add(response.toProduct());
		}
		
		return products;
	}

	@Override
	public Product createProduct(String title, String description, Double price, String imageUrl, String categoryName) {
		
		FakeStoreProductRequestDto requestDto = new FakeStoreProductRequestDto();
        requestDto.setTitle(title);
        requestDto.setDescription(description);
        requestDto.setCategory(categoryName);
        requestDto.setPrice(price);
        requestDto.setImage(imageUrl);

        FakeStoreProductResponseDto responseDto = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                requestDto,
                FakeStoreProductResponseDto.class
        );


        return responseDto.toProduct();
	}
	
	@Override
	public Product partialUpdate(Long id, Product product) {
		return product;
	}
	
	@Override
	public String deleteProduct(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
//	 @Override
//	 public Product partialUpdate(Long id, Product product) {
//		 HttpEntity<Product> httpEntity = new HttpEntity<>(product); // Add dto object here
//
//		 ResponseEntity<FakeStoreProductResponseDto> responseEntity = restTemplate.exchange(
//				 "https://fakestoreapi.com/products" + id,
//				 HttpMethod.PATCH,
//	                httpEntity, // use dto here
//	                FakeStoreProductResponseDto.class
//				);
//
//	      FakeStoreProductResponseDto responseDto = responseEntity.getBody();
//
//	      return null;
//	    }
	 
	 
}
