package com.boostjava2.MonoliticCoding.controller;

import static com.boostjava2.MonoliticCoding.constants.Url.*;
import com.boostjava2.MonoliticCoding.repostiory.entity.Customer;
import com.boostjava2.MonoliticCoding.service.CustomerService;
import com.boostjava2.MonoliticCoding.utility.Datas;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(VERSION + API + CUSTOMER)
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    /**
     * localhost:9090/musteri/save
     * burada mapleme yapmayı sağlıyor
     */
    @GetMapping(SAVEALL)
    public ResponseEntity<Void> saveAll() {
        try {
            customerService.saveAll(new Datas().getCustomerList());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
    @GetMapping(FINDALL)
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }
    @GetMapping(GETBYADDRESS)
    public ResponseEntity<List<Customer>> findAllByAddress(){
        String address = "İstanbul";
        return ResponseEntity.ok(customerService.findAllByAddress(address));
    }
    @GetMapping(GETBYFIRSTNAMELIKE)
    public ResponseEntity<List<Customer>> findAllByFirstNameLike() {
        String firstName = "%a%";
        return ResponseEntity.ok(customerService.findAllByFirstNameLike(firstName));
    }
    @GetMapping(GETBYFIRSTNAMEANDADDRESS)
    public ResponseEntity<List<Customer>> findByFirstNameStartsWithAndAddressStartsWith(){
        String firstName = "A";
        String address = "A";
        return ResponseEntity.ok(customerService.findByFirstNameStartsWithAndAddressStartsWith(firstName, address));
    }
    @GetMapping(GETBYCREATEDDATE)
    public ResponseEntity<List<Customer>> findAllByCreatedDateGreaterThan() {
        Long createdDate = 166249800000L; // 08.09.2022 00:00:00
        return ResponseEntity.ok(customerService.findAllByCreatedDateGreaterThan(createdDate));
    }
    @GetMapping(GETBYFIRSTNAME)
    public ResponseEntity<Object> findByFirstName() {
        String firstName = "Ali";
        Optional<Customer> customer = customerService.findByFirstName(firstName);
        if(customer.isPresent())
            return ResponseEntity.ok(customer.get());

        return ResponseEntity.badRequest().build();
    }
    @GetMapping(GETBYFIRSTNAMEDESC)
    public ResponseEntity<Object> findByAdDesc(){
        String ad = "Ali";
        Optional<Customer> customer = customerService.findTopOptionalByAdOOrderByIdDesc(ad);
        if(customer.isPresent())
            return ResponseEntity.ok(customer.get());

        return ResponseEntity.badRequest().build();
    }
    Customer customer;
    Optional<Customer> customerOptional;
    private void OptionalD(){
        if(customer !=null)
            customer.getFirstName().equals("");

        if(customerOptional.isPresent())
            customerOptional.get().getFirstName().equals("");
    }


}

