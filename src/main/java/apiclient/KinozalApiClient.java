package apiclient;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import util.Properties;

import static io.restassured.RestAssured.given;

public class KinozalApiClient {

    private static final String endpoint = Properties.getProperty("host");

    public KinozalApiClient() {
        RestAssured.baseURI = Properties.getProperty("host");
    }

    public int getStatusCode() {
        return given().log().all()
                .get(endpoint)
                .then().contentType(ContentType.HTML).log().all()
                .extract().response().statusCode();
    }
}
