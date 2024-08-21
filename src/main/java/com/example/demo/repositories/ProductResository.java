package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Product;

@Repository
public interface ProductResository extends JpaRepository<Product, Long> {
	//Product Save(Product product);
}
