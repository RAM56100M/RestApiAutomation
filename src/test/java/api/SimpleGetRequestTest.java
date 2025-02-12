package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
public class SimpleGetRequestTest {


	    @Test
	    public void testGetRequest() {
	        // Define the base URL for the API
	        String baseUrl = "https://jsonplaceholder.typicode.com/posts/1";

	        // Send a GET request and get the response
	        Response response = RestAssured.get(baseUrl);

	        // Print the response body as a string
	        System.out.println("Response Body: " + response.asString());

	        // Validate the status code (should be 200 for success)
	        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");

	        // Validate that the response body contains a specific field value
	        int userId = response.jsonPath().getInt("userId");
	        Assert.assertEquals(userId, 1, "User ID mismatch!");

	        // Validate content type header
	        String contentType = response.getHeader("Content-Type");
	        Assert.assertTrue(contentType.contains("application/json"), "Incorrect Content-Type!");
	    }
	}


