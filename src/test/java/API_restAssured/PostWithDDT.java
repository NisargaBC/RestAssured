package API_restAssured;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostWithDDT {

	@Test(dataProvider = "postData")
	public static void postDDT(String name, String job) {
		// TODO Auto-generated method stub

		
		baseURI = "https://reqres.in/api/users";
		JSONObject ob = new JSONObject();
		ob.put("name", name);
		ob.put("job", job);
		
		RequestSpecification httpRequest = given().body(ob).contentType(ContentType.JSON);
		Response RESPONSE = httpRequest.post();
		System.out.println(RESPONSE.asPrettyString());
		JsonPath PATH = RESPONSE.jsonPath();
		String nameEmp = PATH.getString("name");
		System.out.println(nameEmp);
		RESPONSE.then().assertThat().statusCode(201).log().all();
		
	}
	
	@DataProvider(name = "postData")
	public Object[][] dataForPost()
	{
		Object[][] data = new Object[3][2];
		data[0][0] = "nisarga";
		data[0][1] = "QA tester";
		
		data[1][0] = "nithin";
		data[1][1] = "developer";
		
		data[2][0] = "sandesh";
		data[2][1] = "Team Lead";
		
		return data;
	}

}
