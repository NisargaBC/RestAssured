package API_restAssured;

import static io.restassured.RestAssured.*;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.internal.mapping.JsonbMapper;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class CreatePost {

	@Test
	public static void crud() {

		try
		{
			baseURI = "https://reqres.in/api/users";
			
			Pojo p = new Pojo();
			p.setName("nisarga");
			p.setJob("QA tester");
			
			ObjectMapper mapper = new ObjectMapper();
			String JsonObject = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(p);
			
			RequestSpecification httprequest = given().body(JsonObject).contentType(ContentType.JSON);
			
			
			Response RESPONSE = httprequest.post();
			System.out.println(RESPONSE.asPrettyString());
			
			String head = RESPONSE.header("Content-Type");
			
			
			RESPONSE.then().assertThat().statusCode(201).log().all();
			Assert.assertEquals(head, "application/json; charset=utf-8");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}

}
