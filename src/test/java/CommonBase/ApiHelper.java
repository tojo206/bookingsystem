package CommonBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class ApiHelper {

    private String token;

    public ApiHelper(String baseUrl) {
        RestAssured.baseURI = baseUrl;
    }

    public Response createToken(String username, String password) {
        String body = String.format("""
    {
        "username": "%s",
        "password": "%s"
    }
    """, username, password);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/auth")
                .then()
                .extract()
                .response();

        // store token for future requests
        if (response.getStatusCode() == 200) {
            this.token = response.jsonPath().getString("token");
        }

        return response;
    }

    private RequestSpecification request() {
        var req = given().header("Content-Type", "application/json");
        if (token != null) {
            req.header("Cookie", "token=" + token);
        }return req;
    }

    public Response get(String endpoint) {
        return request()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response post(String endpoint, Object body) {
        return request()
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response put(String endpoint, Object body) {
        return request()
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response patch(String endpoint, Object body) {
        return request()
                .body(body)
                .when()
                .patch(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response delete(String endpoint) {
        return request()
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }
}
