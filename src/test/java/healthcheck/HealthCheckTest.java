package healthcheck;

import base.BaseTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class HealthCheckTest extends BaseTest{

    @Test
    public void HealthCheckTest(){
        given().
            pathParam("cep","01001000").
        when().
            get("{cep}/json").
        then().
            statusCode(200);
    }
}
