package base;

import org.testng.annotations.*;
import static io.restassured.RestAssured.*;

public class BaseTest {

    @BeforeClass
    public void setUp(){

        baseURI = "https://viacep.com.br/";
        basePath = "ws/";
        port = 8080;

        enableLoggingOfRequestAndResponseIfValidationFails();
    }

}

