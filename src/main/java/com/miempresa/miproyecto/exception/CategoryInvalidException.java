package com.miempresa.miproyecto.exception;

public class CategoryInvalidException extends RuntimeException{

    public CategoryInvalidException(){
        super("El nombre no puede estar vacio");
    }

}
