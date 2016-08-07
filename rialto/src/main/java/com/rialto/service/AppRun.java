package com.rialto.service;

import org.springframework.stereotype.Service;

@Service
public class AppRun {

    public static void main(String[] args) {

        RateServiceImpl rateServiceImpl = new RateServiceImpl();
    }
}
