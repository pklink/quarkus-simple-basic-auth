package net.einself.demo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PublicResourceTest {

    @Test
    public void testPublicEndpoint() {
        given()
                .when().get("/public")
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body(is("hello user"));
    }

}