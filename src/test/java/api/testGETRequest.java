package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
public class testGETRequest {

	

	public class APITest {

	    @Test
	    public void testGETRequest() {
	        // Base URI for the API
	        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	        
	        // Send a GET request and get the response
	        Response response = RestAssured.given()
	                .when()
	                .get("/posts/1");

	        // Validate the status code
	        int statusCode = response.getStatusCode();
	        assert statusCode == 200 : "Expected status code 200 but got " + statusCode;

	        // Validate the response body (example)
	        String title = response.jsonPath().getString("title");
	        System.out.println("Post title: " + title);
	        assert title != null : "Title is null!";
	    }
	}

}
