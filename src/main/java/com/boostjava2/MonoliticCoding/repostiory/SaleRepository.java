package com.boostjava2.MonoliticCoding.repostiory;

import com.boostjava2.MonoliticCoding.repostiory.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
