package com.boostjava2.MonoliticCoding.utility;

import com.boostjava2.MonoliticCoding.repostiory.entity.Customer;
import com.boostjava2.MonoliticCoding.repostiory.entity.Product;
import com.boostjava2.MonoliticCoding.repostiory.entity.Sale;

import java.util.ArrayList;
import java.util.List;

public class Datas {

    private List<Customer> customerList;

    public List<Customer> getCustomerList() {
        customerList = new ArrayList<>();
        customerList.add(Customer.builder()
                .firstName("Ali")
                .address("Ankara")
                .phoneNumber("123456789")
                .lastName("Yılmaz")
                .email("muhammet@gmail.com").build());
        customerList.add(Customer.builder()
                .firstName("Deniz")
                .address("İstanbul")
                .phoneNumber("545456665")
                .lastName("Yılmaz")
                .email("deniz@gmail.com").build());
        customerList.add(Customer.builder()
                .firstName("Bahar")
                .address("Ankara")
                .phoneNumber("77455512")
                .lastName("Yılmaz")
                .email("bahar@gmail.com").build());
        customerList.add(Customer.builder()
                .firstName("Gülşen")
                .address("İzmir")
                .phoneNumber("5454654")
                .lastName("Yılmaz")
                .email("gulsen@gmail.com").build());
        return customerList;
    }

    private List<Product> productList;

    public List<Product> getProductList() {
        productList = new ArrayList<>();
        productList.add(Product.builder()
                .name("Bilgisayar")
                .price(1000.0)
                .brand("Asus")
                .model("X555")
                .stock(10)
                .state(1)
                .createddate(1662556017000l)
                .build());
        productList.add(Product.builder()
                .name("Bilgisayar")
                .price(2000.0)
                .brand("Asus")
                .model("X322")
                .stock(10)
                .state(1)
                .createddate(1662556017000l)
                .build());
        productList.add(Product.builder()
                .name("Bilgisayar")
                .price(3000.0)
                .brand("Asus")
                .model("CX33")
                .stock(10)
                .state(1)
                .createddate(1662556017000l)
                .build());
        return productList;

    }
    private List<Sale> saleList;

    public List<Sale> getSaleList(){
        saleList = new ArrayList<>();
        saleList.add(Sale.builder()
                .amount(1)
                .price(1000.0)
                .customerId(105l)
                .productId(1l)
                .state(1)
                .createddate(1662556017000l)
                .build());
        saleList.add(Sale.builder()
                .amount(1)
                .price(2000.0)
                .customerId(115l)
                .productId(2l)
                .state(1)
                .createddate(1662556017000l)
                .build());
        saleList.add(Sale.builder()
                .amount(1)
                .price(3000.0)
                .customerId(119l)
                .productId(3l)
                .state(1)
                .createddate(1662556017000l)
                .build());
        saleList.add(Sale.builder()
                .amount(1)
                .price(3000.0)
                .customerId(119l)
                .productId(2l)
                .state(1)
                .createddate(1662556017000l)
                .build());
        saleList.add(Sale.builder()
                .amount(1)
                .price(3000.0)
                .customerId(101l)
                .productId(3l)
                .state(1)
                .createddate(1662556017000l)
                .build());
        return saleList;
    }
}