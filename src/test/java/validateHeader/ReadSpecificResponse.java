package validateHeader;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
//import junit.framework.Assert;

public class ReadSpecificResponse {

	@Test
	public static void crud() {

		try
		{
			baseURI = "https://reqres.in/api/users/2";
			Response RESPONSE = RestAssured.get();
			String HEADER = RESPONSE.header("Connection");
			System.out.println(HEADER);
			Assert.assertEquals(HEADER, "keep-alive");
			
			
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
	}

}
