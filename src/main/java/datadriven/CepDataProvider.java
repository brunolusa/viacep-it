package datadriven;

import org.testng.annotations.DataProvider;

public class CepDataProvider {
    @DataProvider
    public Object[][] novoCep(){
        return new Object[][]{
                {"90550003","Avenida Benjamin Constant"},
                {"91060900","Avenida Assis Brasil 3940"},
                {"94480550","Rua Lisboa"},
        };
    }
}
