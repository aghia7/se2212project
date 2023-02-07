package com.example.springapp.services.interfaces;

import com.example.springapp.entities.Product;

import java.util.List;

public interface IProductService {
    Product createProduct(Product product);
    Product getProduct(int id);
    List<Product> getAll();
}
