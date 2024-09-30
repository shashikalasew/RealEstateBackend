package com.example.RealEstateBackend.Sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable int id) {
        Sale sale = saleService.getSaleById(id);
        if (sale != null) {
            return ResponseEntity.ok(sale);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Sale addSale(@RequestBody SaleDTO saleDTO) {
        return saleService.addSale(saleDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sale> updateSale(@PathVariable int id, @RequestBody SaleDTO saleDTO) {
        Sale updatedSale = saleService.updateSale(id, saleDTO);
        if (updatedSale != null) {
            return ResponseEntity.ok(updatedSale);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable int id) {
        saleService.deleteSale(id);
        return ResponseEntity.noContent().build();
    }
}
