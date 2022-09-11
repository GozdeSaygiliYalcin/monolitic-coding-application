package com.boostjava2.MonoliticCoding.controller;

import com.boostjava2.MonoliticCoding.dto.request.FindByIdRequestDto;
import com.boostjava2.MonoliticCoding.dto.response.GetAllSaleResponseDto;
import com.boostjava2.MonoliticCoding.repostiory.ProductRepository;
import com.boostjava2.MonoliticCoding.repostiory.SaleRepository;
import com.boostjava2.MonoliticCoding.repostiory.entity.Sale;
import com.boostjava2.MonoliticCoding.service.CustomerService;
import com.boostjava2.MonoliticCoding.service.ProductService;
import com.boostjava2.MonoliticCoding.service.SaleService;
import com.boostjava2.MonoliticCoding.utility.Datas;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sale")
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;

    @GetMapping("/savealldemo")
    public ResponseEntity<String> saveAllDemo(){
        saleService.saveAll(new Datas().getSaleList());
        return ResponseEntity.ok("Kayıtlar Eklendi.");
    }
    @GetMapping("/getall")
    public ResponseEntity<List<GetAllSaleResponseDto>> findAll(){
        return ResponseEntity.ok(saleService.findAllDto());
    }

    @PostMapping("/findbyid")
    public ResponseEntity<Sale> findById(FindByIdRequestDto dto){
        Optional<Sale> sale = saleService.findById(dto);
        if(sale.isPresent()){
            return ResponseEntity.ok(sale.get());
        }
        return ResponseEntity.ok(new Sale());
    }

}
