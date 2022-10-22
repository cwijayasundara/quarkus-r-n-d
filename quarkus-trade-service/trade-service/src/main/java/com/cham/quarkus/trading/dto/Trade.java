package com.cham.quarkus.trading.dto;

public class Trade {
    private int tradeId;
    private String tradeType;
    private String traderName;
    private float tradeValue;
    private String tradeDate;
    private String customerName;

    public int getTradeId() {
        return tradeId;
    }

    public String getTradeType() {
        return tradeType;
    }

    public String getTraderName() {
        return traderName;
    }

    public float getTradeValue() {
        return tradeValue;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Trade(int tradeId, String tradeType, String traderName, float tradeValue, String tradeDate, String customerName) {
        this.tradeId = tradeId;
        this.tradeType = tradeType;
        this.traderName = traderName;
        this.tradeValue = tradeValue;
        this.tradeDate = tradeDate;
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "tradeId=" + tradeId +
                ", tradeType='" + tradeType + '\'' +
                ", traderName='" + traderName + '\'' +
                ", tradeValue=" + tradeValue +
                ", tradeDate='" + tradeDate + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
