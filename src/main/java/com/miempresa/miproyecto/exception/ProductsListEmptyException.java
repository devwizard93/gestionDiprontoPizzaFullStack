package com.miempresa.miproyecto.exception;

public class ProductsListEmptyException extends RuntimeException{

   public ProductsListEmptyException(){
       super("Lista vacia");
   }

}
