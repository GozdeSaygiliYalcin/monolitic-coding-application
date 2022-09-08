package com.boostjava2.MonoliticCoding.service;

import com.boostjava2.MonoliticCoding.repostiory.CustomerRepository;
import com.boostjava2.MonoliticCoding.repostiory.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService extends ServiceManager<Customer, Long> {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        super(customerRepository);
        this.customerRepository = customerRepository;
    }
    public List<Customer> findAllByAddress(String address){
        return customerRepository.findAllByAddress(address);
    }
    public List<Customer> findAllByFirstNameLike(String firstName){
        return customerRepository.findAllByFirstNameLike(firstName);
    }
    public List<Customer> findByFirstNameStartsWithAndAddressStartsWith(String firstName, String address) {
        return customerRepository.findByFirstNameStartsWithAndAddress(firstName, address);
    }
    public List<Customer> findAllByCreatedDateGreaterThan(Long createdDate) {
        return customerRepository.findAllByCreatedDateGreaterThan(createdDate);
    }
    public Optional<Customer> findByFirstName(String firstName){
        return customerRepository.findTopOptionalByFirstName(firstName);
    }
    public  Optional<Customer> findTopOptionalByAdOOrderByIdDesc(String firstName){
        return customerRepository.findTopOptionalByFirstNameOrderByIdDesc(firstName);
    }
}


