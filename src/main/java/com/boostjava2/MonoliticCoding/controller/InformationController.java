package com.boostjava2.MonoliticCoding.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.boostjava2.MonoliticCoding.constants.Url.*;


@RestController
@RequestMapping(VERSION + API + INFORMATIONS)
public class InformationController {

    @Value("${myapplication.myinfo.info}")
    private String info = "Bilgi mesajı";

    @Value("${myapplication.myinfo.title}")
    private String title = "Bilgi mesajı";

    @RequestMapping(INFO)
    public String info() {
        return info;
    }

    @RequestMapping(TITLE)
    public String title() {
        return title;
    }

}
