package com.boostjava2.MonoliticCoding.mapper;

import com.boostjava2.MonoliticCoding.repostiory.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

 /* !!ÖNEMLİ!!
         * Bir pojo nesnesinden diğer bir pojo nesnesine dönüşüm yaparken illaki uyuşmayan
         * alanlar olabilir, bu durumda hata alırsınız. çünkü karşılığı olamyan alanlar için
         * hata döner. Bu nedenle sorun yaşamamak için ReportingPolicy.IGNORE eklememiz gerekiyor.
         */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toProduct(ProductSaveRequestDto dto);

    ProductSaveRequestDto fromProduct(Product product);
}
