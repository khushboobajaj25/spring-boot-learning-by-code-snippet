package com.codesnippet.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesnippet.demo.entity.Product;
import com.codesnippet.demo.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public Product addProduct(Product product){
        
        return productRepository.save(product);
    }

    public Optional<Product> findById(Integer id){
        System.out.println("findProductById");
        return productRepository.findById(id);
    }

    public Optional<Product> findByName(String name){
        return productRepository.findByName(name);
    }

    public List<Product> listAllProducts(){
        return productRepository.findAll();
    }
}
