package com.rialto.entity;

public class CurrencyPair {

    private String pair;
    private long bid;
    private long ask;
    private long time;

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public long getBid() {
        return bid;
    }

    public void setBid(long bid) {
        this.bid = bid;
    }

    public long getAsk() {
        return ask;
    }

    public void setAsk(long ask) {
        this.ask = ask;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
