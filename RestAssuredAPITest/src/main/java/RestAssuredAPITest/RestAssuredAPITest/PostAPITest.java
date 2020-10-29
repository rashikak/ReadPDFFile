package RestAssuredAPITest.RestAssuredAPITest;

import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PostAPITest {
	
	
	
	@Test
	public void test()
	{
		JSONObject request=new JSONObject();
		request.put("name","RK");
		
		System.out.println(request);
		System.out.println(request.toString());
		
		given().body(request.toString()).when().post("https://reqres.in/api/users").then().statusCode(201)
		.log().all();
	}
	
	@Test
	public void test1()
	{
		
	}

}
