package Test4;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RAT {

    /*    -https://dummy.restapiexample.com/api/v1/delete/{emp_id}
          -VAlidate the status code is 200
          -Validate the message shows as "successfully! deleted Records"
*/
    @Test
    public void DeleteEmployee(){

        RestAssured.baseURI="https://dummy.restapiexample.com/api/v1/delete";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.delete("/4");

       Response response1 = requestSpecification.get("/message");

        ResponseBody body = response1.getBody();

        String bodyString = body.asString();

        System.out.println("RESPONSE: "+response.asPrettyString());
        System.out.println("Status Code:"+response.getStatusCode());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(bodyString.contains("message")/*Successfully! Record has been deleted*/
                , true /*Successfully! Record has been deleted*/);

    }
    }