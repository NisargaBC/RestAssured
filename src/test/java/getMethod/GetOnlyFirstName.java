package getMethod;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetOnlyFirstName {

	public static void main(String[] args) {

		baseURI = "https://reqres.in/api/users?page=2";
		
		Response RESPONSE = RestAssured.get();
		String OUTPUT = RESPONSE.asPrettyString();
		System.out.println(OUTPUT); 
		
		JsonPath PATH = RESPONSE.jsonPath();
		String out = PATH.getString("data[0].last_name");
		System.out.println(out);
	}

}
