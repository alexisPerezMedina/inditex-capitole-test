package com.inditex.infraestructure.rest;

import com.inditex.application.service.PriceService;
import com.inditex.domain.exception.ResourceNotFoundException;
import com.inditex.domain.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PriceController {

  private PriceService priceService;

  @Autowired
  public PriceController(PriceService priceService) {
    this.priceService = priceService;
  }
  @RequestMapping(path = "/prices/{brandId}/{productId}/{date}", method = RequestMethod.GET)
  public ResponseEntity<List<Price>> getPrices(@PathVariable("brandId") long brandId, @PathVariable("productId") long productId,
      @PathVariable("date") Timestamp date) {

    List<Price> prices = priceService.getPrices(brandId, productId, date);

    prices.stream()
        .findAny()
        .orElseThrow((() -> new ResourceNotFoundException("Not found any Price with " +
            "brandId = " + brandId +", productId = " +productId+ " and date = "+date)));

    return new ResponseEntity<>(prices, HttpStatus.OK);
  }
}
