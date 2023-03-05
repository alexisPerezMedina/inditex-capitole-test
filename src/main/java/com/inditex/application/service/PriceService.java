package com.inditex.application.service;

import com.inditex.domain.model.Price;
import java.sql.Timestamp;
import java.util.List;

public interface PriceService {
  List<Price> getPrices(long brandId, long productId, Timestamp date);
}
