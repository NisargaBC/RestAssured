package API_restAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generalUtility.DataForPostFromExelUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class ReadDataFromExcel {

	DataForPostFromExelUtility e = new DataForPostFromExelUtility();
	
	@Test(dataProvider = "getData")
	public static void dataForPostFromExcel(String name, String job) throws Exception {

		baseURI = "https://reqres.in/api/users";
		
		JSONObject ob = new JSONObject();
		ob.put("name", name);
		ob.put("job", job);
		
		RequestSpecification httpRequest = given().body(ob).contentType(ContentType.JSON);
		Response RESPONSE = httpRequest.post();
		System.out.println(RESPONSE.asPrettyString());
		
	}
	
	
	@DataProvider
	public Object[][] getData() throws Exception
	{	
		
		return e.dataForPost("Sheet1");
	}

}
