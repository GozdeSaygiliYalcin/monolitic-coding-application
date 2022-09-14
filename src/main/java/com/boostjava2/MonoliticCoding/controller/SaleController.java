package com.boostjava2.MonoliticCoding.controller;

import static com.boostjava2.MonoliticCoding.constants.Url.*;
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

/**
 * RestAPI
 * -- Kullanıcıdan tüm HTML methodlarında istek alıp yine kullanıyıya
 *    response olarak bir Entity dönebildiğimiz yapılandırma şeklidir.
 * -- 3. Parti uygulamaların birbirleriyle haberleşmesi için kullanılır.
 * -- Microservis yapısında anahtar rol oynar ve microservislerin aralarında
 *    haberleşmesini sağlar.
 *    Controllerin rest API olduğunu belirtmek için rest controller anotasyonunu kullanıyoruz
 */
@RestController
//gelen isteği yakalamak için kullanıyoruz. sınıfa gelen istek. aksiyonu alan getmapping anotasyonudur
@RequestMapping(VERSION + WEB + SALE)
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;

    @GetMapping(SAVEALL)
    public ResponseEntity<String> saveAllDemo(){
        saleService.saveAll(new Datas().getSaleList());
        return ResponseEntity.ok("Kayıtlar Eklendi.");
    }
    /*
    @GetMapping("/getallbycustomername")
    public ResponseEntity<List<GetAllSaleResponseDto>> findAllByCustomerFirstNameGet(String customerFirstName){
        System.out.println("Get Methodu Çağrıldı.");
        return ResponseEntity.ok(saleService.findAllDto(customerFirstName));
    }
     */

    @GetMapping(FINDALL)
    public ResponseEntity<List<GetAllSaleResponseDto>> findAll(){
        return ResponseEntity.ok(saleService.findAllDto());
    }

    @PostMapping(FINDBYID)
    public ResponseEntity<Sale> findById(FindByIdRequestDto dto){
        Optional<Sale> sale = saleService.findById(dto);
        if(sale.isPresent()){
            return ResponseEntity.ok(sale.get());
        }
        return ResponseEntity.ok(new Sale());
    }

}
