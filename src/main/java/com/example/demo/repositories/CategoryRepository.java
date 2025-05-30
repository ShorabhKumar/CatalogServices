package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
	Optional<Category> findByName(String name);
	Category save(Category category);
}
