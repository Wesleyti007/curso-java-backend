package com.backend.javabackend.controller;


import com.backend.javabackend.model.Product;
import com.backend.javabackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<Product> getAllProduct(){
       return productService.getAll();
    }

    @PostMapping("/add-product")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/per-id/{id}")
    public Optional<Product> getPerId(@PathVariable Long id){
        return productService.getPerId(id);
    }

    @DeleteMapping("/delete-product/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @PutMapping("/update-product/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id){
        return productService.updateProduct(id, product);
    }
}
