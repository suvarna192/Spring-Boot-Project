package com.javatechie.springbootcrudexample2.controller;

import com.javatechie.springbootcrudexample2.entity.Product;
import com.javatechie.springbootcrudexample2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController
{
    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Product product)
    {
        String status = service.saveProduct(product);
        return status;

    }

    @PostMapping("/addProducts")
    public List<Product> addProduct(@RequestBody List<Product> products)
    {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts()
    {
        return service.getProducts();
    }

    @GetMapping("/product1/{id}")
    public Product findProductById(@PathVariable("id") int id)
    {
        return service.getProductById( id);
    }

    @GetMapping("/product2/{name}")
    public List<Product> findtProductByname(@PathVariable String name)
    {
        return (List<Product>) this.service.getProductByName(name);
    }
    @PutMapping ("/update")
    public Product updateProduct(@RequestBody Product product)
    {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(int id)
    {
        return service.deleteProduct(id);
    }

}
