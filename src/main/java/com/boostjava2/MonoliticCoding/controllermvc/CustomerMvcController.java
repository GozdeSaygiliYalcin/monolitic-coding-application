package com.boostjava2.MonoliticCoding.controllermvc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import static com.boostjava2.MonoliticCoding.constants.Url.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(VERSION + WEB + CUSTOMER)
public class CustomerMvcController {

    /*
    *MVC modelinde oluşturulan metot
     */
    @GetMapping(INDEX)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer");
        String mansetStr = "Thymeleaf ile MVC";
        List<String> nameList =
                Arrays.asList("Ali", "Veli", "49", "50");
        modelAndView.addObject("names", nameList);
        modelAndView.addObject("manset", mansetStr);
        return modelAndView;
    }
}
