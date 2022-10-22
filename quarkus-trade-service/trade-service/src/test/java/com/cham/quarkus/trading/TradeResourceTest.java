package com.cham.quarkus.trading;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class TradeResourceTest {

    @Test
    public void shouldTestGetAllTrades() {
        given()
                .header(ACCEPT, APPLICATION_JSON)
                .when()
                .get("/api/trades")
                .then()
                .statusCode(200)
                .body("size()", is(4));
    }

    @Test
    public void shouldTestTradeCount(){
        given()
                .header(ACCEPT, TEXT_PLAIN)
                .when()
                .get("/api/trades/count")
                .then()
                .statusCode(200)
                .body(is("4"));
    }

    @Test
    public void shoudTestGetBookById(){
        given()
                .header(ACCEPT, APPLICATION_JSON)
                .pathParam("id", 1)
                .when()
                .get("/api/trades/{id}")
                .then()
                .statusCode(200)
                .body("traderName", is("Tom Johns"))
                .body("tradeValue", is(20000.0F))
                .body("tradeDate", is("17-10-2022"))
                .body("tradeType", is("bond"))
                .body("customerName", is("John Taler"));
    }
}