package com.example.demo.dtos;

import com.example.demo.Model.Category;
import com.example.demo.Model.Product;

public class FakeStoreProductResponseDto {
	private Long id;
    private String title;
    private String price;
    private String category;
    private String description;
    private String image;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
    
	public Product toProduct() {
        Product product = new Product();
        product.setId(this.id);
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setImageUrl(this.image);
        product.setPrice(Double.valueOf(this.price));

        Category category1 = new Category();
        category1.setName(this.category);

        product.setCategory(category1);

        return product;
    }
}
