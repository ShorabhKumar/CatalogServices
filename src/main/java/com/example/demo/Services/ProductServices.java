package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.ProductModel;

@Service
public class ProductServices {
	
	public List<ProductModel> getAllProduct()
	{		
		List<ProductModel> proMod = new ArrayList<>();
		
		proMod.add(new ProductModel(1,"J7","mobile","j7.png",200));
		proMod.add(new ProductModel(2,"M29","mobile","j11.png",500));
		proMod.add(new ProductModel(3,"samsung","tv","tv15.png",1500));
		
		return proMod;  
	}
	
	public ProductModel getProductById(int id) {
		
		List<ProductModel> proMod = this.getAllProduct();
		
		for(ProductModel pr: proMod) {
			if(pr.getId() == id) {
				return pr;
			}
		}
		
		return null;
	}
}
