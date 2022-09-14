package com.boostjava2.MonoliticCoding.repostiory.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "sales_table")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    Long customerId;
    Long productId;
    Integer amount;
    Double price;
    int state;
    Long createddate;
    Long updateddate;

}
