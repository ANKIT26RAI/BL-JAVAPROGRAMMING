package com.fundoo.contactsapp;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ContactApiTest {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8081;
    }

    @Test
    public void testGreetingApi() throws Exception {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8081/greeting"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(200, response.statusCode());
        assertEquals("Welcome to Contacts App Backend", response.body());
    }

    @Test
    public void testCreateContact() {

        String requestBody = """
                {
                  "name": "Test User",
                  "email": "test@gmail.com",
                  "phone": "9876543210",
                  "address": "Delhi"
                }
                """;

        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post("/contacts")
        .then()
            .statusCode(200)
            .body("name", equalTo("Test User"))
            .body("email", equalTo("test@gmail.com"));
    }

    @Test
    public void testGetAllContacts() throws Exception {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8081/contacts"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(200, response.statusCode());
    }
}