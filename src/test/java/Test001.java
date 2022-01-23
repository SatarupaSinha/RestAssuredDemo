import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test001 {
    @Test
    void test_01(){

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        System.out.println(response.getBody());
        System.out.println(response.asString());
        response.prettyPrint();
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        response.then().statusCode(200);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
//        TestBody tb = response.as(TestBody.class);
//        System.out.println("********************"+tb.getPage()+"********************");

    }

    @Test
    void test_02(){


        RequestBody rb = new RequestBody();
        rb.setName("Satarupa");
        rb.setJob("TestLead");
        String url = "https://reqres.in/api/users";
        Response response = RestAssured.
                given().
                contentType("application/json").
                log().all(true).
                body(rb).
                post("https://reqres.in/api/users").andReturn();
        response.prettyPrint();
        response.then().statusCode(201);

        ResponseBody reBody = response.as(ResponseBody.class);
        System.out.println(reBody.getName());
        String name = reBody.getName();

//        Serenity.sessionVariableCalled("name");

    }

}
