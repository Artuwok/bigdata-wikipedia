package com.rialto.service;

import com.rialto.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class AppRun {

    @Autowired
    ExchangeRateParser exchangeRateparser;
    @Autowired
    RateService rateService;

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class);
        ExchangeRateParser obj = (ExchangeRateParser) applicationContext.getBean("exchangeRateParser");

        obj.parse();


    }
}
