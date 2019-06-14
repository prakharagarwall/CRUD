package com.example.myfirst.services;

import com.example.myfirst.domain.product;

import java.util.List;

public interface ProductService {
    List<product> listAllProducts();
    product getProductById(Integer id);

    product saveOrUpdateProduct(product product);

    void deleteProduct(Integer id);
}
