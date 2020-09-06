package utility;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name = "search-inputs")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"career"}, {"test"}, {"Omada Identity Suite"}, {"Audit"}, {"news"}};
    }
}
