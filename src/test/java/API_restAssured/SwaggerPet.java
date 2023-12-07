package API_restAssured;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SwaggerPet {

	public static void main(String[] args) throws Exception {

				try
				{
					baseURI = "https://petstore.swagger.io/v2";
					
					RequestSpecification httpRequest = given().pathParam("orderId", 5);
					Response RESPONSE = httpRequest.get("store/order/{orderId}");
					RESPONSE.then().assertThat().statusCode(404).log().all();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}

		



	}

}
