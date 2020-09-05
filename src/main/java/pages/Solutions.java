package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Solutions extends Base{
    public Solutions(WebDriver driver){super(driver);}

    private final By learnMoreButtons = By.xpath("//a[contains(text(),'Learn more')]");
    private final By requestDemoButton = By.xpath("//a[contains(text(),'Request Demo')]");
    private final By learnMoreOmadaEssential = By.xpath("//a[@href='/en-us/solutions/solution-overview/omada-essential']");

    public Solutions checkIf4ButtonsAreVisible(){
        List<WebElement> buttonsList = listGetter(learnMoreButtons,4);
        Assert.assertTrue(areButtonsFromListClickable(buttonsList));
        return this;
    }
    public Solutions clickOmadaEssentialButton(){

        waitVisibleAndClick(learnMoreOmadaEssential);
        return this;
    }
    public Solutions checkIfRequestDemoButtonIsAvailable(){
        waitVisibleAndClick(requestDemoButton);
        return this;
    }
    public void checkIfRequestDemoRedirectIsOK(String correctURL){
        String url= driver.getCurrentUrl();
        Assert.assertEquals(url,correctURL);
    }

}
