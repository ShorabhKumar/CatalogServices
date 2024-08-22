package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.ProductNotFoundException;
import com.example.demo.Model.Category;
import com.example.demo.Model.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductResository;

@Primary
@Service("productDbService")
public class ProductServiceImpl implements ProductServices {

	@Autowired
	private ProductResository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;	
	
	public ProductServiceImpl(ProductResository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository= categoryRepository;
	}
	@Override
	public Optional<Product> getProductById(Long id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
		//return null;
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product createProduct(String title, String description, Double price, String imageUrl, String categoryName) {
		// TODO Auto-generated method stub
		Product product = new Product();
		product.setTitle(title);
		product.setDescription(description);
		product.setPrice(price);
		product.setImageUrl(imageUrl);
		product.setCategory(getAndSetCategory(categoryName));		
		return productRepository.save(product);
	}

	@Override
	public Product partialUpdate(Long id, Product product) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public String deleteProduct(Long id) {
		// TODO Auto-generated method stub
		if(productRepository.findById(id).isPresent()) {
			productRepository.deleteById(id);
			return "Product Deleted Successfully "+id;
		}
		return "Product Is Not Precent";
	}
	
	private Category getAndSetCategory(String categoryName) {
		Optional<Category> categoryOptional = categoryRepository.findByName(categoryName);
		
		if(categoryOptional.isEmpty()) {
			Category category = new Category();
			category.setName(categoryName);
			return categoryRepository.save(category);
		}
		
		return categoryOptional.get();
	}
}
