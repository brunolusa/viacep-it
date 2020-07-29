package funcional;

import base.BaseTest;
import builder.Cep;
import datadriven.CepDataProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class FuncionalTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger();

    @Test(invocationCount = 1, dataProvider = "novoCep", dataProviderClass = CepDataProvider.class)
    public void BuscarCepTest(String cep, String rua){

        LOGGER.info("Executando: " + LOGGER.getName());

        Cep cepObject =
        given().
            pathParam("cep",cep).
        when().
            get("{cep}/json").
        then().
            statusCode(200).
            extract().
                body().
                    as(Cep.class);

        Assert.assertEquals(cepObject.getLogradouro(), rua);

        LOGGER.info("logradouro = " + cepObject.getLogradouro());
    }

    @Test
    public void BuscarListaDeCepsTest(){

        LOGGER.info("Executando: " + LOGGER.getName());

        List<Cep> listaDeCeps =
            given().
                pathParam("cidade","Gravatai").
                pathParam("rua","Barroso").
            when().
                get("RS/{cidade}/{rua}/json").
            then().
                statusCode(200).
                extract().
                    body().
                        jsonPath().getList(".",Cep.class);

        System.out.println("listaDeCeps = " + listaDeCeps);
    }
}
