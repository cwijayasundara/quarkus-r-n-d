package com.cham.quarkus.trading.service;

import com.cham.quarkus.trading.dto.Trade;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TradeService {

    @ConfigProperty(name="trade.type", defaultValue = "bond")
    private String tradeType;
    public List<Trade> getAllTrades(){
        return List.of(
                new Trade(1,tradeType, "Tom Johns", 20000f, "17-10-2022", "John Taler"),
                new Trade(2,tradeType, "Bill Smith`", 20000f, "20-01-2020", "Tim Black"),
                new Trade(3,tradeType, "Nancy Johns", 20000f, "01-02-2003", "Jezz Walker"),
                new Trade(4,tradeType, "Sam Write", 20000f, "17-10-2022", "Sally Peters")
        );
    }

    public Optional <Trade> getTradeById(int id){
        return getAllTrades().stream().filter(trade -> trade.getTradeId() == id).findFirst();
    }
}
