package pratice;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CRUD_operations {

	public static void main(String[] args) throws Exception, JsonMappingException, IOException {

		baseURI = "https://reqres.in/api/users/2";
		
		Pojo_Demo POJO = new Pojo_Demo();
		POJO.setName("nisarga");
		POJO.setJob("QA Lead");
		
		ObjectMapper mapper = new ObjectMapper();
		String OBJECT = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(POJO);
		
		RequestSpecification httpRequest = given().body(OBJECT).contentType(ContentType.JSON);
		
		Response RESPONSE = httpRequest.post();
		System.out.println(RESPONSE.asPrettyString());
		JsonPath PATH = RESPONSE.jsonPath();
		String id = PATH.getString("id");
		System.out.println(id);
		
		RESPONSE.then().assertThat().statusCode(201).log().all();
		
	}

}
