package com.rialto.service;

import org.springframework.stereotype.Service;

@Service
public class AppRun {

    public static void main(String[] args) {

        RateService rateService = new RateService();

        new Thread(rateService).start();

    }
}
