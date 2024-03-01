package Test3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RAT {
    /*  -https://dummy.restapiexample.com/api/v1/create
          {
	     "name":"your name",
         "salary":"123",
	     "age":"23"
          }
        -Validate the response code is 201
        -Validate status should be success
        -Save the employee id in a variable called emp_id
*/
    @Test
    public void CreateEmployee(){

        RestAssured.baseURI="https://dummy.restapiexample.com/api/v1/create";
        RequestSpecification requestSpecification = RestAssured.given();
        JSONObject requestP = new JSONObject();
        requestP.put("Name","Mohanad");
        requestP.put("Salary","150");
        requestP.put("Age","26");
        requestP.put("emp_id", "125");
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.body(requestP.toString());
        Response response = requestSpecification.accept(ContentType.JSON).post();

        System.out.println();
        System.out.println("Status Code: "+response.statusCode());
        System.out.println();
        System.out.println("RESPONSE: "+response.asPrettyString());

        JsonPath jsonPath = response.jsonPath();
        String act = jsonPath.get("status");
        String exp = "success";
        Assert.assertEquals(act,exp);

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
