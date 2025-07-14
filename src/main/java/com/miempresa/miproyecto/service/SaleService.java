package com.miempresa.miproyecto.service;

import com.miempresa.miproyecto.model.Sale;

import java.util.List;

public interface SaleService {

    Sale createSale(Sale sale);
    List<Sale> getAllSale();

}
