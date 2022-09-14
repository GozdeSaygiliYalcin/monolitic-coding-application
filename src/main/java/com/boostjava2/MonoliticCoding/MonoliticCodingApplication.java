package com.boostjava2.MonoliticCoding;

import com.boostjava2.MonoliticCoding.repostiory.entity.Product;
import com.boostjava2.MonoliticCoding.service.CustomerService;
import com.boostjava2.MonoliticCoding.service.ProductService;
import com.boostjava2.MonoliticCoding.service.SaleService;
import com.boostjava2.MonoliticCoding.utility.Datas;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class MonoliticCodingApplication {

	private final SaleService saleService;
	private final CustomerService customerService;
	private final ProductService productService;
	@PostConstruct
	private void implData(){
		customerService.saveAll(new Datas().getCustomerList());
		productService.saveAll(new Datas().getProductList());
		saleService.saveAll(new Datas().getSaleList());
	}

	public static void main(String[] args) {
		SpringApplication.run(MonoliticCodingApplication.class, args);
	}

}
