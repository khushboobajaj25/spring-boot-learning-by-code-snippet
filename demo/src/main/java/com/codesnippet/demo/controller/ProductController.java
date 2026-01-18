package com.codesnippet.demo.controller;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codesnippet.demo.entity.Product;
import com.codesnippet.demo.entity.ErrorResponse;
import com.codesnippet.demo.exceptions.ProductNotFoundException;
import com.codesnippet.demo.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Product> getBookById(@PathVariable Integer id){
        Product product = productService.findById(id).orElseThrow( () -> new ProductNotFoundException("Product not found with"+ id));
        return ResponseEntity.ok(product);
    }

     @GetMapping("/getProductByName/{name}")
    public ResponseEntity<Product> getBookByName(@PathVariable String name){
        Product product = productService.findByName(name).orElseThrow( () -> new ProductNotFoundException("Product not found with"+ name));
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){

        Product createProduct = productService.addProduct(product);
        return new ResponseEntity<>(createProduct,HttpStatus.CREATED);
    }

   
}
