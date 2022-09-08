package com.boostjava2.MonoliticCoding.repostiory.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "product_table")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    Long id;
    @Column(length = 300,nullable = false)
    String name;
    String brand;
    String model;
    @Column(nullable = false)
    Double price;
    int stock;
    int state;
    Long createddate;
    Long updateddate;
}