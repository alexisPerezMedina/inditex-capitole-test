package com.inditex.domain.serviceImpl;

import com.inditex.application.repository.PriceRepository;
import com.inditex.domain.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import com.inditex.application.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService {
  @Autowired
  private PriceRepository priceRepository;

  @Override
  public List<Price> getPrices(long brandId, long productId, Timestamp date) {
    return priceRepository.getPrices(brandId, productId, date);
  }
}
