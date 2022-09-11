package com.boostjava2.MonoliticCoding.controller;

import com.boostjava2.MonoliticCoding.service.ProductService;
import com.boostjava2.MonoliticCoding.utility.Datas;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/savealldemo")
    public ResponseEntity<String> saveAllDemo(){
        productService.saveAll(new Datas().getProductList());
        return ResponseEntity.ok("Kayıt başarılı");
    }
}
