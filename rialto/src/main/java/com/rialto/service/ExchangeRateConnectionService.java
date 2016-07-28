package com.rialto.service;


import org.springframework.http.HttpMethod;
import org.springframework.http.client.AsyncClientHttpRequest;
import org.springframework.http.client.AsyncClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.util.concurrent.ListenableFuture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

public class ExchangeRateConnectionService {

    private static final String TRADING_CURRENCIES = "http://webrates.truefx.com/rates/connect.html?f=html";

    public static void main(String[] args) {

        while (true) {
            try {
                ExchangeRateConnectionService.connection();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    public static void connection() throws IOException, ExecutionException, InterruptedException, URISyntaxException {


        AsyncClientHttpRequestFactory asyncFactory = new HttpComponentsAsyncClientHttpRequestFactory();
        URI uri = new URI(TRADING_CURRENCIES);
        AsyncClientHttpRequest asynReq = asyncFactory.createAsyncRequest(uri, HttpMethod.GET);
        ListenableFuture<ClientHttpResponse> future = asynReq.executeAsync();
        ClientHttpResponse response = future.get();
        System.out.println(response.getStatusCode());

        BufferedReader bf = new BufferedReader(new InputStreamReader(response.getBody()));

        String line;
        while ((line = bf.readLine()) != null) {
            System.out.println(line);
        }
    }
}
