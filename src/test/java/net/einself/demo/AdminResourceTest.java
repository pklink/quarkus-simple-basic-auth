package net.einself.demo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AdminResourceTest {

    @Test
    public void testAdminEndpoint() {
        given()
                .when()
                .auth().basic("admin", "password")
                .get("/admin")
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body(is("hello admin"));
    }

    @Test
    public void testAdminEndpoint_WithoutAuth() {
        given()
                .when().get("/admin")
                .then().statusCode(Response.Status.UNAUTHORIZED.getStatusCode());
    }

}