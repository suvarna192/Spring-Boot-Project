package com.javatechie.springbootcrudexample2.service;

import com.javatechie.springbootcrudexample2.entity.Product;
import com.javatechie.springbootcrudexample2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository repository;

    public String saveProduct(Product product)
    {
        repository.save(product);
        return "success";
    }

    public List<Product> saveProducts(List<Product> products)
    {
        return repository.saveAll(products);
    }

    public List<Product> getProducts()
    {
        return repository.findAll();
    }

    public Product getProductById(int id)
    {

        return repository.findById(id).orElse(null);
    }

    public List<Product> getProductByName(String name)
    {
        return (List<Product>) this.repository.findByName(name);
    }

    public String deleteProduct(int id)
    {
        repository.deleteById(id);
        return "product removed!!"+id;
    }

    public Product updateProduct(Product product)
    {
        Product existingProduct=repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }


}
