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
import java.util.stream.Collectors;

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

    public List<GetAllSaleResponseDto> findAllDto(String customerName){
        return findAllDto().stream().filter(x-> x.getCustomerName().contains(customerName)).collect(Collectors.toList());
    }
        /**
         * Satis tablosundaki tüm kayıtları alıyoruz.
         */
    public List<GetAllSaleResponseDto> findAllDto(){
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
             * Her bir satıştaki müşteri id için müşteriyi VT nından sorguluyoruz.
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
                                        .atZone(java.time.ZoneId.systemDefault())
                                        .toLocalDate()
                        )
                        .productName(product.get().getName() + "- marka: " + product.get().getBrand() +"model: " +product.get().getModel())
                        .customerName(customer.get().getFirstName())
                                .customerId(customer.get().getId())
                                .productId(product.get().getId())
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
    public void save(Long customerId, Long productId, Integer amount, Double price) {
        saleRepository.save(Sale.builder()
                .customerId(customerId)
                .productId(productId)
                .amount(amount)
                .price(price)
                .createddate(System.currentTimeMillis())
                .build());
    }
    public void update(Long id, Long customerId, Long productId, Integer amount, Double price) {
        Sale sale = saleRepository.findById(id).get();
        sale.setCustomerId(customerId);
        sale.setProductId(productId);
        sale.setAmount(amount);
        sale.setPrice(price);
        sale.setUpdateddate(System.currentTimeMillis());
        saleRepository.save(sale);
    }
}
