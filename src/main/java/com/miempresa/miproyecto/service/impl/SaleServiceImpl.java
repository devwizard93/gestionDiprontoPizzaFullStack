package com.miempresa.miproyecto.service.impl;

import com.miempresa.miproyecto.model.Sale;
import com.miempresa.miproyecto.repository.SaleRepository;
import com.miempresa.miproyecto.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {


    private final SaleRepository saleRepository;
    @Override
    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public List<Sale> getAllSale() {
        return saleRepository.findAll();
    }
}
