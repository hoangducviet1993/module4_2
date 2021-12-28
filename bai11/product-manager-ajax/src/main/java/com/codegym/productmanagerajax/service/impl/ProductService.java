package com.codegym.productmanagerajax.service.impl;

import com.codegym.productmanagerajax.model.Product;
import com.codegym.productmanagerajax.repository.ProductRepository;
import com.codegym.productmanagerajax.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
            productRepository.deleteById(id);
    }
}
