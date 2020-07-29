package contrato;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class ContratoTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    public void contratoTest(){

        LOGGER.info("Executando: " + LOGGER.getName());

        String cep = "91060080";
        given().
            pathParam("cep",cep).
        when().
            get("{cep}/json").
        then().
            statusCode(200).
            body(matchesJsonSchema(new File("src/test/resources/json_schema/getCepSchema.json")));

    }
}
