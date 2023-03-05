package com.inditex.UnitTest;

import static org.assertj.core.api.Assertions.assertThat;

import com.inditex.application.repository.PriceRepository;
import com.inditex.application.service.PriceService;
import com.inditex.domain.model.Price;
import com.inditex.domain.serviceImpl.PriceServiceImpl;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PriceServiceUnitTest {
  @TestConfiguration
  static class ProductServiceTestConfig {
    @Bean
    public PriceService priceService() {
      return new PriceServiceImpl();
    }
  }

  @MockBean
  private PriceRepository priceRepository;

  @Autowired
  private PriceService priceService;

  @Before
  public void setUp() {
    Mockito.when(priceRepository.getPrices(getPrice().get(0).getBrandId(), getPrice().get(0).getProductId(), getDate())).thenReturn(getPrice());
  }

  @Test
  public void whenValidProductId_thenPriceShouldBeFound() {
    List<Price> prices = priceService.getPrices(1, 35455, getDate());
    assertThat(prices.get(0).getProductId()).isEqualTo(35455);
  }

  @Test
  public void whenInValidProductId_thenProductShouldNotBeFound() {
    List<Price> prices = priceService.getPrices(1, 35455, getDate());
    assertThat(prices.get(0).getProductId()).isNotEqualTo(35477);

  }

  private List<Price> getPrice(){
    Price price1 = new Price((long) 1, (long) 1, getLocalDateTime("2016-03-04 11:30"), getLocalDateTime("2016-03-04 17:00"), 1,
        (long) 35455, new BigDecimal("35.50"));
    return List.of(price1);
  }

  private Timestamp getDate(){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse("2016-03-04 11:30", formatter);
    return Timestamp.valueOf(dateTime);
  }

  private LocalDateTime getLocalDateTime(String date){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    return LocalDateTime.parse(date, formatter);
  }
}
