package Test1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RAT {


/* - https://dummy.restapiexample.com/api/v1/employees
   -Get all the employees
   -Check the status code is 200
*/



    @Test
    public void GetAllEmployees(){
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/employees";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.accept(ContentType.JSON).get();



        System.out.println("Status Code: "+response.statusCode());
        System.out.println();
        System.out.println("RESPONSE: "+response.asPrettyString());
        System.out.println();
        Assert.assertEquals(response.getStatusCode(), 200);




    }

}
