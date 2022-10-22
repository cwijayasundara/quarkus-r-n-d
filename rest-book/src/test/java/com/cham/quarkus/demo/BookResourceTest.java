package com.cham.quarkus.demo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void shouldTestGetAllBooks() {
        given()
                .header(ACCEPT, APPLICATION_JSON)
          .when()
                .get("/api/books")
          .then()
             .statusCode(200)
             .body("size()", is(4));
    }

    @Test
    public void shouldTestGetBookCount(){
        given()
                .header(ACCEPT, TEXT_PLAIN)
            .when()
                .get("/api/books/count")
            .then()
                .statusCode(200)
                .body(is("4"));
    }

    @Test
    public void shouldTestGetBookById(){
        given()
                .header(ACCEPT, APPLICATION_JSON)
                .pathParam("id", 1)
            .when()
                .get("/api/books/{id}")
            .then()
                .statusCode(200)
                .body("title", is("Effective Java"))
                .body("author", is("Josh Bloch"))
                .body("yearOfPublication", is(2000))
                .body("genre", is("IT"));
    }
}