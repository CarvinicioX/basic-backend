package com.sinch.backend.repository;

import com.sinch.backend.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "sales", path = "sales")
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @RestResource(path = "/totalSales")
    @Query(
            value = "SELECT CAST(SUM(TOTAL) AS NUMERIC) AS NUMBER FROM SALES",
            nativeQuery = true
    )
    Float calculateSalesTotal();

    @RestResource(path = "/totalProducts")
    @Query(
            value = "SELECT COUNT(*) FROM (SELECT PRODUCT FROM SALES GROUP BY PRODUCT)",
            nativeQuery = true
    )
    Integer calculateProductCount();

}
