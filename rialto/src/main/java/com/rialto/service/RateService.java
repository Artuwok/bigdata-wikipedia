package com.rialto.service;

import com.rialto.entity.CurrencyPair;

import java.util.List;

public interface RateService {
    List<CurrencyPair> getRates();
}
