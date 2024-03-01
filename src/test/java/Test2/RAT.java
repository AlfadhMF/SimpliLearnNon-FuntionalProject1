package Test2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RAT {


    /*- https://dummy.restapiexample.com/api/v1/employee/1
      -Get Single employe
      -Check the status code is 200
      -Validate the employee name is employee_name":"Tiger Nixon
*/


    @Test
    public void GetSingleEmployee(){

        RestAssured.baseURI="https://dummy.restapiexample.com/api/v1/employee/1";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.accept(ContentType.JSON).get();
        String ResponseBody = response.body().asString();


        System.out.println("Status Code: "+response.getStatusCode());
        System.out.println();
        System.out.println("RESPONSE: "+response.asPrettyString());
        System.out.println();
        Assert.assertTrue(ResponseBody.contains("Tiger Nixon"));
        Assert.assertEquals(response.getStatusCode(), 200);


    }
}
