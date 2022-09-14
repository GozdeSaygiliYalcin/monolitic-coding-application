package com.boostjava2.MonoliticCoding.controllermvc;

import static com.boostjava2.MonoliticCoding.constants.Url.*;
import com.boostjava2.MonoliticCoding.service.CustomerService;
import com.boostjava2.MonoliticCoding.service.ProductService;
import com.boostjava2.MonoliticCoding.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(VERSION + WEB + SALE)
@RequiredArgsConstructor
public class SaleMvcController {

    private final SaleService saleService;
    private final CustomerService customerService;
    private final ProductService productService;

    @GetMapping(INDEX)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(("sale"));
        modelAndView.addObject("salelist", saleService.findAllDto());
        modelAndView.addObject("customerlist", customerService.findAll());
        modelAndView.addObject("productlist", productService.findAll());
        return modelAndView;
    }
    /*
     * ÖNEMLİ!!!!!
     * kayıt methodunda tekrardan bir sayfa dönmüyoruz. nedeni zaten bu işlemi yapabilen bir endpoint var
     * oraya yönlendirme yapmak en doğru hareket olacaktır.
     * @param musteriid
     * @param urunid
     * @param adet
     * @param fiyat
     * @return
     * http://localhost:9090/WEB/satis/save
     */
    @PostMapping(SAVE)
    public ModelAndView sale(Long customerId, Long productId, Integer amount, Double price) {
        saleService.save(customerId, productId, amount, price);
        return new ModelAndView("redirect:index");
    }
    @PostMapping(DELETE)
    public ModelAndView delete(Long id) {
        saleService.deleteById(id);
        return new ModelAndView("redirect:index");
    }
    @PostMapping(UPDATE)
    public ModelAndView update(Long id, Long customerId, Long productId, Integer amount, Double price) {
        saleService.update(id, customerId, productId, amount, price);
        return new ModelAndView("redirect:index");
    }
}
