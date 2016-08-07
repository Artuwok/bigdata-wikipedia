package com.rialto.service;


import com.rialto.entity.CurrencyPair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RateServiceImpl implements RateService {

    static final Logger logger = LogManager.getLogger(RateServiceImpl.class);
    private static final String TRADING_CURRENCIES = "http://webrates.truefx.com/rates/connect.html?f=html";

    public List<CurrencyPair> getRates() {
        List<CurrencyPair> currencyPairs = new ArrayList<CurrencyPair>();
        try {
            Document doc = Jsoup.connect(TRADING_CURRENCIES).get();
            Element table = doc.select("table").get(0); //select the first table.
            Elements rows = table.select("tr");

            for (Element currentRow : rows) { // Getting Rows
                Elements columns = currentRow.select("td"); // getting Columns
                CurrencyPair pair = new CurrencyPair();
                pair.setPair(columns.get(0).text());
                pair.setTime(Long.parseLong(columns.get(1).text()));
                pair.setBid(Float.parseFloat(columns.get(2).text() + columns.get(3).text()));
                pair.setAsk(Float.parseFloat(columns.get(4).text() + columns.get(5).text()));
                currencyPairs.add(pair);
                logger.error("Getting pair object as: " + pair);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return currencyPairs;
    }
}
