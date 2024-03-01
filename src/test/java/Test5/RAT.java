package Test5;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
public class RAT {
    /*   -https://dummy.restapiexample.com/api/v1/employee/{emp_id}
         -Get Single employe
         -Check the status code is 404
*/
    @Test
    public void TestDeletedEmployee(){

        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/delete/2/";
        RequestSpecification requestSpecification = RestAssured.given();

        Response response = requestSpecification.get();

        System.out.println("Status Code: "+response.getStatusCode());
        System.out.println("RESPONSE: "+response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 404);
    }
}
