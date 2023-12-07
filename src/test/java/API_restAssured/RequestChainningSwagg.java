package API_restAssured;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestChainningSwagg {

	public static void main(String[] args) throws Exception {

		baseURI = "https://petstore.swagger.io/v2";
		File f = new File(".\\src\\test\\resources\\SwaggerObject.json");
		FileInputStream fi = new FileInputStream(f);
		RequestSpecification httpRequest = given().body(fi).contentType(ContentType.JSON);
		Response RESPONSE = httpRequest.post();
		System.out.println(RESPONSE.asPrettyString());
		RESPONSE.then().assertThat().statusCode(200).log().all();
		
		
		
//		{
//		  "id": 0,
//		  "petId": 0,
//		  "quantity": 0,
//		  "shipDate": "2023-12-03T18:27:14.224Z",
//		  "status": "placed",
//		  "complete": true
		}
	}


