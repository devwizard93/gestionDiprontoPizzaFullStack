// --- Implementación del Servicio ---
package com.miempresa.miproyecto.service.impl;

import com.miempresa.miproyecto.exception.ProductCreateException;
import com.miempresa.miproyecto.exception.ProductNotFoundException;
import com.miempresa.miproyecto.exception.ProductsListEmptyException;
import com.miempresa.miproyecto.model.Product;
import com.miempresa.miproyecto.repository.ProductRepository;
import com.miempresa.miproyecto.service.CategoryService;
import com.miempresa.miproyecto.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryService categoryService;

    @Override
    public List<Product> getAllProducts() {
        final var products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new ProductsListEmptyException();
        }
        return products;
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public Product createProduct(Product product) {
        categoryService.findCategoryById(product.getIdCategory());
        if (product.getPrice() < 0) {
            throw new ProductCreateException();
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProductById(Long id, Product afterProduct) {
        var productoOptional = productRepository.findById(id);
        if (productoOptional.isEmpty()) {
            throw new ProductNotFoundException(id);
        }
        Product postProducto = productoOptional.get();
        postProducto.setName(afterProduct.getName());
        postProducto.setPrice(afterProduct.getPrice());
        return productRepository.save(postProducto);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id);
        productRepository.deleteById(id);
    }





}
