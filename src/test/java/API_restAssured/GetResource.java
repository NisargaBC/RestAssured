package API_restAssured;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetResource {

	public static void main(String[] args) {
		baseURI = "https://reqres.in/api/users/2";

		Response RESPONS = RestAssured.get();
		RESPONS.then().assertThat().statusCode(200).log().all();
	}

}
