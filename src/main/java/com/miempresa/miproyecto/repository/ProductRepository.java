package com.miempresa.miproyecto.repository;

import com.miempresa.miproyecto.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}