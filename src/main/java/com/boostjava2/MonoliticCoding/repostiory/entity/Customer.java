package com.boostjava2.MonoliticCoding.repostiory.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "customer_table")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_table_seq_id",
            sequenceName = "customer_table_seq_id",
            allocationSize = 5, initialValue = 100)
    @GeneratedValue(generator = "customer_table_seq_id")
    Long id;
    @Column(length = 300, nullable = false)
    String firstName;
    String lastName;
    String phoneNumber;
    String address;
    String email;

    /*
    Veri tabanından veriyi kalıcı olarak silmek o bilgiye ulaşılmasını engelleyeceği için
    aktif pasif durumlarını belirlemek için kullandığımız değişken
     */
    int state;

    Long createdDate;
    Long updatedDate;
}
