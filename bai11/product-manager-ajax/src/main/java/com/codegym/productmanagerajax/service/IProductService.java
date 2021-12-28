package com.codegym.productmanagerajax.service;

import com.codegym.productmanagerajax.model.Product;

public interface IProductService extends IGeneralService<Product>{
    Iterable<Product> findByNameContaining(String name);
}
