package com.example.springapp.controllers;

import com.example.springapp.entities.Product;
import com.example.springapp.services.interfaces.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("hello")
    public String sayHello() {
        return "Hello world!";
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        Product p = productService.getProduct(id);

        if (p == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> list = productService.getAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
