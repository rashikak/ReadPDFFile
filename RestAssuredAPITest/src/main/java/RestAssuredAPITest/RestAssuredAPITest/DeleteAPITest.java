package RestAssuredAPITest.RestAssuredAPITest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class DeleteAPITest {
@Test
public void test()
{
	JSONObject request=new JSONObject();
	
	given().body(request.toString()).when().delete("https://reqres.in/api/users/2").then().statusCode(204);
}
}
