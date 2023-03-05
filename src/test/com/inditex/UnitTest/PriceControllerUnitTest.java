package com.inditex.UnitTest;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.application.service.PriceService;
import com.inditex.domain.model.Price;
import com.inditex.infraestructure.rest.PriceController;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(PriceController.class)
public class PriceControllerUnitTest {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper mapper;

  @MockBean
  private PriceService priceService;

  @Test
  public void givenPrice_whenGetPrices_thenReturnPrice() throws Exception {

    given(priceService.getPrices(1,36455, getTimestamp("2016-03-04 11:30"))).willReturn(getPrice());

    mvc.perform(get("/api/prices/{brandId}/{productId}/{date}", 1, 36455, getTimestamp("2016-03-04 11:30")))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].brandId").value(1));
  }

  @Test
  public void givenNonExistentProductId_whenGetPrices_thenErrorNotFound() throws Exception {

    given(priceService.getPrices(1,36455, getTimestamp("2016-03-04 11:30"))).willReturn(getPrice());

    mvc.perform(get("/api/prices/{brandId}/{productId}/{date}", 1, 36499, getTimestamp("2016-03-04 11:30")))
        .andDo(print())
        .andExpect(status().isNotFound());
  }

  private List<Price> getPrice(){
    Price price = new Price((long) 1, (long) 1, getLocalDateTime( "2016-03-04 11:30"), getLocalDateTime( "2016-03-04 17:00"),
        1, (long) 35455, new BigDecimal("35.50"));
    return List.of(price);
  }

  private Timestamp getTimestamp(String date){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
    return Timestamp.valueOf(dateTime);
  }

  private LocalDateTime getLocalDateTime(String date){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    return LocalDateTime.parse(date, formatter);
  }
}
