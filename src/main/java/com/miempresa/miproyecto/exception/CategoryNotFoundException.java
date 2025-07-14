package com.miempresa.miproyecto.exception;


public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(Long id) {
        super("categoria no encontrada con ID: " + id);
    }

}
