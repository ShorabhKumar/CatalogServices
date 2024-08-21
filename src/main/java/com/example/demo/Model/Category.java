package com.example.demo.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category extends BaseModel {
	
	@Column(name = "name")
	private String name;
	
//	@OneToMany
//    private List<Product> featuredProducts;
//	
//    @OneToMany(mappedBy = "category")
//	@JoinColumn(name = "product_ids")
//	private List<Product> product;
		
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
//	public List<Product> getProduct() {
//		return product;
//	}
//	public void setProduct(List<Product> product) {
//		this.product = product;
//	}
	
	
	
}