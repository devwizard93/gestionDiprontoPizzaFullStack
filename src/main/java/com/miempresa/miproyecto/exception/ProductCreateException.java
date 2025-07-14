package com.miempresa.miproyecto.exception;

public class ProductCreateException extends RuntimeException{

    public ProductCreateException(){
        super("el precio no puede ser negativo");
    }

}
