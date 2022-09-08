package com.boostjava2.MonoliticCoding.repostiory;

import com.boostjava2.MonoliticCoding.repostiory.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long > {
    //kaydet, güncelle gibi talimatlar Jpa Repositoryden gelecek onun için extend ediyoruz

    /*
    *findAllByAddress Jpa Repo sınıfının bize sağladığı arama biçimleri
    * find+By+..+Değişkenin adı (camel case olması önemli)
    * find + All +By + Variable (firstName)-> FirstName
     */
    List<Customer> findAllByAddress(String address);
    //phoneNumber
    List<Customer> findAllByPhoneNumber(String phoneNumber);

    //SQL like arama biçimi gibi çalışıyor
    List<Customer> findAllByFirstNameLike(String firstName);

    List<Customer> findByFirstNameStartsWithAndAddress(String firstName, String address);

    List<Customer> findAllByCreatedDateGreaterThan(Long createdDate);

    /*
    *Optional aranan değerin null sonuç
    * döndürmesini engelliyor
     */
    Optional<Customer> findTopOptionalByFirstName(String firstName);
    Optional<List<Customer>> findOptionalByAddress(String address);
    Optional<Customer> findTopOptionalByFirstNameOrderByIdDesc(String firstName);

    /**
     * iki tarih arasındaki kayıtları getiren metotlar
     */
    List<Customer> findAllByCreatedDateBetween(Long start, Long end);
    List<Customer> findAllByAddressAndCreatedDateBetween(String address, Long start, Long end);

    @Query("select m from Customer m where m.email = ?1")
    Customer findByEmailAddress(String emailAddress);

    @Query(value = "select * from Customer where email = ?1 and firstName like ?2", nativeQuery = true)
    Customer findByEmailAddress(String emailAddress, String firstName);

    /*
    *bu sorgulamayı hiç anlamadım
     */
    @Query("select u from Customer u where u.firstName = :firstname or u.lastName = :lastname")
    Customer findByAdOrLastName(@Param("firstName") String customerFirstName,
                            @Param("lastName") String customerLastName);

    Customer findByEmail(String email);
}
