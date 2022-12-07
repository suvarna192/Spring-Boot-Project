package com.javatechie.springbootcrudexample2.repository;

import com.javatechie.springbootcrudexample2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
   List<Product> findByName(String name);
}
