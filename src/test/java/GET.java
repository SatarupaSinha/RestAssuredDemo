import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GET {
    @Test
    public void test_01(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
//        System.out.println(response.getBody().toString());
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
        System.out.println(response.getHeaders());
        System.out.println("Time -> "+response.getTime());
        response.prettyPrint();
    }

    @Test
    public void test_02() {
        given().
                get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[0]",equalTo(7));
    }
}
