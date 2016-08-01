package com.rialto.service;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateParser {

    @Autowired
    RateService rateService;

    public ExchangeRateParser(RateService rateService) {
        this.rateService = rateService;
    }

    public ExchangeRateParser() {
    }


    public void parse() {
        Document parse = Jsoup.parse(rateService.getRates());

        System.out.println("parse " + parse.toString());
    }
}
