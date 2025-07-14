package com.miempresa.miproyecto.service;

import com.miempresa.miproyecto.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();

    Product findProductById(Long id);

    Product createProduct(Product product);

    Product updateProductById(Long id, Product product);

    void deleteProductById(Long id);
}