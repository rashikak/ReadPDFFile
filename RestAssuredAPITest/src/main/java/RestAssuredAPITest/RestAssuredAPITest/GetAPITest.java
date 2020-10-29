package RestAssuredAPITest.RestAssuredAPITest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;
import static org.hamcrest.Matchers.*;

public class GetAPITest {

	@Test
	public void test()
	{
		Response response=new RestAssured().get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
		System.out.println(response.body().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getContentType());
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}
	
	@Test
	public void test1()
	{
		given().get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[0]", equalTo(7));
	}
	
	@Test
	public void test2()
	{
		given().get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[0]", equalTo(7))
		.body("data.first_name",hasItems("Michael","Lindsay","Tobias"));
	}
}
