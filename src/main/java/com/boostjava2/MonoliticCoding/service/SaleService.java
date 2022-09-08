package com.boostjava2.MonoliticCoding.service;

import com.boostjava2.MonoliticCoding.repostiory.SaleRepository;
import com.boostjava2.MonoliticCoding.repostiory.entity.Sale;
import org.springframework.stereotype.Service;

@Service
public class SaleService extends ServiceManager<Sale, Long> {

private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        super(saleRepository);
        this.saleRepository = saleRepository;
    }
}
