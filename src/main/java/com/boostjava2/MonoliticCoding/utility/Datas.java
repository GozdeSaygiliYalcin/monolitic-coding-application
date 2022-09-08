package com.boostjava2.MonoliticCoding.utility;

import com.boostjava2.MonoliticCoding.repostiory.entity.Customer;

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

}
