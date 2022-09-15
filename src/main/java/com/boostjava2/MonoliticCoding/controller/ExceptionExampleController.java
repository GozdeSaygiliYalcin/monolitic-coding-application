package com.boostjava2.MonoliticCoding.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionExampleController {

   @RequestMapping("/test")
        public String test() {
            throw new RuntimeException("Test exception");
        }
}
