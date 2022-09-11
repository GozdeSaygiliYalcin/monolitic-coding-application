package com.boostjava2.MonoliticCoding.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.sound.midi.Sequence;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllSaleResponseDto {

    private Long id;
    private String customerName;
    private String productName;
    private int amount;
    private Double price;
    private Double totalPrice;
    private LocalDate createdDate;
}
