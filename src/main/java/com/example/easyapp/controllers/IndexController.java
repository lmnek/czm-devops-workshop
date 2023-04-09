package com.example.easyapp.controllers;

import com.example.easyapp.entity.Product;
import com.example.easyapp.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class IndexController {
    private ProductRepository productRepository;
    @PostMapping("/create-product")
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping("/get-products")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

}
