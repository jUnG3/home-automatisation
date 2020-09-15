package org.junge;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class VcanResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/messages/vcan0")
          .then()
             .statusCode(200);
    }

}