package com.rialto.entity;

public class CurrencyPair {

    private String pair;
    private float bid;
    private float ask;
    private long time;

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public float getBid() {
        return bid;
    }

    public void setBid(float bid) {
        this.bid = bid;
    }

    public float getAsk() {
        return ask;
    }

    public void setAsk(float ask) {
        this.ask = ask;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return "CurrencyPair{ " +
                "pair='" + pair + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                ", time=" + time +
                '}';
    }
}
