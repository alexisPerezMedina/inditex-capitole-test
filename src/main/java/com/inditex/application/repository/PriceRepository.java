package com.inditex.application.repository;

import com.inditex.domain.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.sql.Timestamp;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {
  @Query(value ="SELECT * FROM PRICES WHERE BRAND_ID = :brandId and PRODUCT_ID = :productId and START_DATE <= :date and END_DATE >= :date", nativeQuery = true)
  List<Price> getPrices(@Param(value="brandId") long brandId, @Param(value="productId") long productId, @Param(value="date") Timestamp date);
}
