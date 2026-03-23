package Tests;

import CommonBase.ApiHelper;
import PageObjects.LandingPage;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTests {


    String BASE_URL = "https://restful-booker.herokuapp.com";
    String username = System.getenv("USERNAME");
    String password = System.getenv("PASSWORD");
    String bookingId;





    @Test(description = "testing ping api", priority = 0)
    public void testGPingEndPoint(){
        ApiHelper api = new ApiHelper(BASE_URL);
        Response response = api.get("/ping");
        Assert.assertEquals(response.getStatusCode(), 201, "status should be 201");

    }

    @Test(description = "testing Authentication API", priority = 1)
    public void testAuthEndPoint(){
        ApiHelper api = new ApiHelper(BASE_URL);

        Response response = api.createToken(username,password);
        Assert.assertEquals(response.getStatusCode(), 200);

        String token = response.jsonPath().getString("token");
        Assert.assertNotNull(token, "Token should not be null");
        Assert.assertFalse(token.isEmpty(), "Token should not be empty");
    }

    @Test(description = "testing get booking ID API", priority = 2)
    public void testGetBookingIdEndPoint(){
        ApiHelper api = new ApiHelper(BASE_URL);

        api.createToken(username,password);

        Response response = api.get("booking");
        Assert.assertEquals(response.getStatusCode(), 200, "status should be 200");

        String bookingId = response.jsonPath().getString("[0].bookingid");
        Assert.assertNotNull(bookingId);
    }

    @Test(description = "testing create booking  API", priority = 3)
    public void testCreateBookingEndPoint(){
        ApiHelper api = new ApiHelper(BASE_URL);

        api.createToken(username,password);

        String body = "{\n" +
                "    \"firstname\" : \"Paballo\",\n" +
                "    \"lastname\" : \"Tester\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2027-01-01\",\n" +
                "        \"checkout\" : \"2029-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        Response response = api.post("/booking",body);

        Assert.assertEquals(response.getStatusCode(), 200, "status should be 200");
        bookingId = response.jsonPath().getString("bookingid");
        Assert.assertNotNull(bookingId);

    }

    @Test(description = "testing update booking  API", priority = 4)
    public void testUpdateBookingEndPoint(){
        ApiHelper api = new ApiHelper(BASE_URL);

        api.createToken(username,password);

        String body = "{\n" +
                "    \"firstname\" : \"Paballo\",\n" +
                "    \"lastname\" : \"updated\",\n" +
                "    \"totalprice\" : 114,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2027-01-01\",\n" +
                "        \"checkout\" : \"2029-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        Response response = api.put("/booking/" + bookingId,body);

        Assert.assertEquals(response.getStatusCode(), 200, "status should be 200");
        Assert.assertNotNull(bookingId);

    }

    @Test(description = "testing partial update booking  API", priority = 5)
    public void testPartialUpdateBookingEndPoint(){
        ApiHelper api = new ApiHelper(BASE_URL);

        api.createToken(username,password);

        String body = """
        {
            "firstname": "Nkuna",
            "lastname": "updated"
        }
        """;

        Response response = api.patch("/booking/" + bookingId,body);

        Assert.assertEquals(response.getStatusCode(), 200, "status should be 200");
        Assert.assertNotNull(bookingId);

    }

    @Test(description = "testing delete booking  API", priority = 6)
    public void testDeleteBookingEndPoint(){
        ApiHelper api = new ApiHelper(BASE_URL);

        api.createToken(username,password);

        Response response = api.get("/booking");
        Assert.assertEquals(response.getStatusCode(), 200, "status should be 200");

        String bookingId = response.jsonPath().getString("[0].bookingid");
        Assert.assertNotNull(bookingId);

        Response deleteResponse = api.delete("/booking/" + bookingId);
        Assert.assertEquals(deleteResponse.getStatusCode(), 201, "status should be 201");

    }













}
