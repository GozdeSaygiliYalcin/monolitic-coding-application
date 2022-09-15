package com.boostjava2.MonoliticCoding.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorType {

    MUSTERI_BULUNAMADI(1000, "Musteri kayıtlı değil", INTERNAL_SERVER_ERROR),
    MUSTERI_KAYDEDILEMEDI(1001, "Musteri kaydilemedi", INTERNAL_SERVER_ERROR),
    URUN_BULUNAMADI(2000, "Musteri kayıtlı değil",INTERNAL_SERVER_ERROR);


    private int code;
    private String message;
    HttpStatus httpStatus;
}
