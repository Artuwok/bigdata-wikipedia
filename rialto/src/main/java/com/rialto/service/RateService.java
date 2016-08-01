package com.rialto.service;


import org.springframework.http.HttpMethod;
import org.springframework.http.client.AsyncClientHttpRequest;
import org.springframework.http.client.AsyncClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

@Service
public class RateService implements Runnable {
    private static final String TRADING_CURRENCIES = "http://webrates.truefx.com/rates/connect.html?f=html";

    public String getRates() {

        String line = null;
        try {
            AsyncClientHttpRequestFactory asyncFactory = new HttpComponentsAsyncClientHttpRequestFactory();
            URI uri = new URI(TRADING_CURRENCIES);
            AsyncClientHttpRequest request = asyncFactory.createAsyncRequest(uri, HttpMethod.GET);
            ListenableFuture<ClientHttpResponse> future = request.executeAsync();
            ClientHttpResponse response = future.get();
            System.out.println(response.getStatusCode());

            BufferedReader bf = new BufferedReader(new InputStreamReader(response.getBody()));

            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return line;
    }


    @Override
    public void run() {
        while (true) {
            getRates();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
