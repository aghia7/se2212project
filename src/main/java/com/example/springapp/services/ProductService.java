package com.example.springapp.services;


import com.example.springapp.entities.Product;
import com.example.springapp.repositories.ProductRepository;
import com.example.springapp.services.interfaces.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(int id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (!optionalProduct.isPresent())
            return null;

        return optionalProduct.get();
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
