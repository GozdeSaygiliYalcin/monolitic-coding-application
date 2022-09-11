package com.boostjava2.MonoliticCoding.controller;

import com.boostjava2.MonoliticCoding.dto.request.ProductSaveRequestDto;
import com.boostjava2.MonoliticCoding.repostiory.entity.Product;
import com.boostjava2.MonoliticCoding.service.ProductService;
import com.boostjava2.MonoliticCoding.utility.Datas;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        return ResponseEntity.ok("Kayıtlar eklendi");
    }
    @PostMapping("/save")
    public ResponseEntity<Product> save(Product product){
        return ResponseEntity.ok(productService.save(product));
    }

    @PostMapping("/saveparam")
    public ResponseEntity<Product> saveParameter(String name,String brand,
                                              String model,Double price){
        Product product = Product.builder()
                .price(price)
                .brand(brand)
                .model(model)
                .name(name).build();
        return ResponseEntity.ok(productService.save(product));
    }

    @PostMapping("/saveparamdto")
    public ResponseEntity<Product> saveParamDto(ProductSaveRequestDto dto){
        return ResponseEntity.ok(productService.saveMapper(dto));
    }
}
