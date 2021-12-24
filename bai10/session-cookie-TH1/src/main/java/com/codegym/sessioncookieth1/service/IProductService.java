package com.codegym.sessioncookieth1.service;

import com.codegym.sessioncookieth1.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
