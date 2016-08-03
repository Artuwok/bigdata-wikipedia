package com.rialto.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RateService implements Runnable {

    static final Logger logger = LogManager.getLogger(RateService.class);
    private static final String TRADING_CURRENCIES = "http://webrates.truefx.com/rates/connect.html?f=html";

    public void getRates() {

        Document doc = null;
        try {
            doc = Jsoup.connect(TRADING_CURRENCIES).get();

            Element table = doc.select("table").get(0); //select the first table.
            Elements rows = table.select("tr");

            for (Element currentRow : rows) { // Getting Rows
                Element row = currentRow;
                System.out.println("row: " + row);
                Elements cols = row.select("td");
                for (Element column : cols) {
                    System.out.println(column.text());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        while (true) {
            getRates();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
