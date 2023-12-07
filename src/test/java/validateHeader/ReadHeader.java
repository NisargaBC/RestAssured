package validateHeader;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ReadHeader {

	public static void main(String[] args) {
// this will read the header of the response
		try
		{
			baseURI = "https://reqres.in/api/users/2";
			Response RESPONSE = RestAssured.get();
			Headers HEADERS = RESPONSE.headers();
			for(Header head: HEADERS)
			{
				String KEY = head.getName();
				String VALUE = head.getValue();
				System.out.println(KEY+ " : " +VALUE);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
