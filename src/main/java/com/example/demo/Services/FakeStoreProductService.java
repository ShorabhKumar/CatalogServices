package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Category;
import com.example.demo.Model.Product;

@Service
public class FakeStoreProductService implements ProductServices {

	@Override
	public List<Product> getAllProduct() {
		List<Product> products = new ArrayList<>();		
		Category cat = new Category(1L, "HandSet");		
		products.add(new Product(1L, "J2", "mobile", "j2.png", 20.00, cat));
		products.add(new Product(2L, "J5", "mobile", "j5.png", 40.00, cat));
		products.add(new Product(3L, "J7", "mobile", "j7.png", 60.00, cat));
		
		return products;
	}

	@Override
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		List<Product> proMod = this.getAllProduct();
		
		for(Product pr: proMod) {
			if(pr.getId() == id) {
				return pr;
			}
		}
		return null;
	}

}
