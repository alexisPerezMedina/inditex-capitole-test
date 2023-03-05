package com.inditex.domain.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "prices")
public class Price {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "brandId")
  private Long brandId;
  @Column(name = "startDate")
  private LocalDateTime startDate;
  @Column(name = "endDate")
  private LocalDateTime endDate;
  @Column(name = "priceList")
  private Integer priceList;
  @Column(name = "productId")
  private Long productId;
  @Column(name = "price")
  private BigDecimal price;
}
