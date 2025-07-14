package com.miempresa.miproyecto.controller;

import com.miempresa.miproyecto.model.Sale;
import com.miempresa.miproyecto.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
        return ResponseEntity.status(HttpStatus.CREATED).body(saleService.createSale(sale));
    }

    @GetMapping
    public ResponseEntity<List<Sale>> getAllSale(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(saleService.getAllSale());
    }



}
