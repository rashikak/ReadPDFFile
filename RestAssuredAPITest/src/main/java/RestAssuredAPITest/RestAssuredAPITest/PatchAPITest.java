package RestAssuredAPITest.RestAssuredAPITest;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class PatchAPITest {

	@Test
	public void test()
	{
		JSONObject request=new JSONObject();
		
		request.put("name", "test");
		System.out.println(request);
		System.out.println(request.toString());
		
		given().body(request.toString()).when().patch("https://reqres.in/api/users").then().statusCode(200).log().all();
	}
}
