package com.cham.quarkus.trading;

import com.cham.quarkus.trading.dto.Trade;
import com.cham.quarkus.trading.service.TradeService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/api/trades")
@Produces(MediaType.APPLICATION_JSON)
public class TradeResource {

    @Inject
    private TradeService tradeService;

    @Inject
    Logger logger;

    @GET
    public List<Trade> getAllTrades() {
        logger.info("returning all the trades");
        return tradeService.getAllTrades();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int getTradeCount(){
        logger.info("returning the trade count");
        return tradeService.getAllTrades().size();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Trade> getTradeById(@PathParam("id") int id){
        logger.info("returning trade by its id");
        return tradeService.getTradeById(id);
    }
}