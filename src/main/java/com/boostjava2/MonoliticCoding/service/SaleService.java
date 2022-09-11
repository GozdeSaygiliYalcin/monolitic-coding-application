package com.boostjava2.MonoliticCoding.service;

import com.boostjava2.MonoliticCoding.dto.request.FindByIdRequestDto;
import com.boostjava2.MonoliticCoding.dto.response.GetAllSaleResponseDto;
import com.boostjava2.MonoliticCoding.repostiory.CustomerRepository;
import com.boostjava2.MonoliticCoding.repostiory.ProductRepository;
import com.boostjava2.MonoliticCoding.repostiory.SaleRepository;
import com.boostjava2.MonoliticCoding.repostiory.entity.Customer;
import com.boostjava2.MonoliticCoding.repostiory.entity.Product;
import com.boostjava2.MonoliticCoding.repostiory.entity.Sale;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService extends ServiceManager<Sale, Long> {

private final SaleRepository saleRepository;
private final CustomerRepository customerRepository;
private final ProductRepository productRepository;

    public SaleService(SaleRepository saleRepository,
                        CustomerRepository customerRepository,
                        ProductRepository productRepository) {
        super(saleRepository);
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }
    public Optional<Sale> findById(FindByIdRequestDto dto){
        if(dto.getId()!=null){
            return saleRepository.findById(dto.getId());
        }
        return Optional.empty();
    }
    public List<GetAllSaleResponseDto> findAllDto() {
        /**
         * Satis tablosundaki tüm kayıtları alıyoruz.
         */
        List<Sale> saleList = saleRepository.findAll();
        /**
         * Satış tablosundan alacağımız datayı düzenleyerek bir DTO objesi olarak
         * dönmek istiyoruyz. bu nedenle öncelike boş bir DTO listesi oluşturuyoruz.
         */
        List<GetAllSaleResponseDto> responseDtoList = new ArrayList<>();
        /**
         * Satış listesini dönüyoruz hher bir kayıt için arama yaplılacak ve uygun kayıtlar
         * DTO listesine eklenicek.
         */
        saleList.forEach(x -> {
            /**
             * Her bir satıştaki müşteri id için müşteriyi VT nından soorguluyoruz.
             */
            Optional<Customer> customer = customerRepository.findById(x.getCustomerId());
            /**
             * Her bir satıştaki ürün id için ürünü VT nından soorguluyoruz.
             */
            Optional<Product> product = productRepository.findById(x.getProductId());
            /**
             * Müşteri ve Urun gerçekten VT nında var mıdır? kontrol ediyoruz.
             */

            if (customer.isPresent() && product.isPresent()) {
                /**
                 * Oluşturulan DTO DTOLİST içine ekleniyor.
                 */
                responseDtoList.add(GetAllSaleResponseDto.builder()
                        .id(x.getId())
                        .amount(x.getAmount())
                        .price(x.getPrice())
                        .totalPrice(x.getPrice() * x.getAmount())
                        .createdDate(
                                Instant.ofEpochMilli(x.getCreateddate())
                                        .atZone(ZoneId.systemDefault())
                                        .toLocalDate()
                        )
                        .productName(product.get().getName())
                        .customerName(customer.get().getName())
                        .build());
            } else {
                /**
                 * Müşteri veya ürün bulunamadıysa hata mesajı döndürüyoruz.
                 */
                System.out.println("Müşteri veya ürün bulunamadı...: [Satis Id] " + x.getId());
            }

        });

        return responseDtoList;
    }
}
