package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import java.util.List;

public class MainPage extends Base {
    public MainPage(WebDriver driver){super(driver);}

    private final By sliderImage = By.xpath("//img[@class='slider__image']");
    private final By sliderImageButtonBookDemo = By.xpath("//a[@class='slider__button']");
    private final By spotsItemsGrid = By.xpath("//div[contains(@class,('spots__items grid'))]");
    private final By spotsItemsGridButtons = By.xpath("//div[contains(@class,('spots__items grid'))]//a[@class='spots__button']");
    private final By gartnerBrick = By.xpath("//section[@id='brick-15794']");
    private final By gartnerAccessReportsButton = By.xpath("//section[@id='brick-15794']//a[@class='text__button button--variant1']");
    private final By identityProcessFrameworkBrick = By.xpath("//section[@class='text__content']//h1[contains(text(),'framework for solution design and implementation')]");
    private final By identityProcessFrameworkButton = By.xpath("//section[@class='text__content']//a[contains(text(),'IdentityPROCESS+')]");
    private final By clientBarBrick = By.xpath("//div[@class='clientbar__container']");
    private final By clientBarBrickImages = By.xpath("//div[@class='clientbar__container']//img");
    private final By clientBarBrickCustomerCasesButton = By.xpath("//div[@class='clientbar__container']//a[@class='clientbar__button button--variant2']");
    private final By newsSlider = By.xpath("//div[@id='brick-15801']");
    private final By readyToGetStartedBrick = By.xpath("//section[@id='brick-15803']");
    private final By readyToGetStartedBrickContactUsButton = By.xpath("//section[@id='brick-15803']//a[@href='/en-us/more/company/contact']");
    private final By navBarSolutions = By.xpath("//a[contains(text(),'Solutions')]");
    private final By closeCookiesButton = By.xpath("//span[@class='cookiebar__button button--variant1']");
    public BookDemo clickBookDemo(){
        waitVisibleAndClick(sliderImageButtonBookDemo);
        return new BookDemo(driver);
    }
    public Solutions goToSolutionsFromNavBar(){
        waitVisibleAndClick(navBarSolutions);
        return new Solutions(driver);
    }

    public MainPage closeCookies(){
        waitVisibleAndClick(closeCookiesButton);
        return this;
    }

    public MainPage sliderImageCheck(){
        Assert.assertTrue(isElementPresent(sliderImage));
        Assert.assertTrue(isElementPresentAndClickable(sliderImageButtonBookDemo));
        return this;
    }
    public MainPage spotsItemsGridCheck(){
        Assert.assertTrue(isElementPresent(spotsItemsGrid));
        List<WebElement> buttons = listGetter(spotsItemsGridButtons,2);
        Assert.assertTrue(areButtonsFromListClickable(buttons));
        return this;
    }
    public MainPage gartnerBrickCheck(){
        Assert.assertTrue(isElementPresent(gartnerBrick));
        Assert.assertTrue(isElementPresentAndClickable(gartnerAccessReportsButton));
        return this;
    }
    public MainPage identityProcessFrameworkCheck(){
        Assert.assertTrue(isElementPresent(identityProcessFrameworkBrick));
        Assert.assertTrue(isElementPresentAndClickable(identityProcessFrameworkButton));
        return this;
    }
    public MainPage clientBarCheck(){
        Assert.assertTrue(isElementPresent(clientBarBrick));
        List<WebElement> images = listGetter(clientBarBrickImages,6);
        Assert.assertTrue(areButtonsFromListClickable(images));
        Assert.assertTrue(isElementPresentAndClickable(clientBarBrickCustomerCasesButton));
        return this;
    }
    public MainPage newsSliderCheck(){
        Assert.assertTrue(isElementPresent(newsSlider));
        return this;
    }
    public void readyToGetStartedCheck(){
        Assert.assertTrue(isElementPresent(readyToGetStartedBrick));
        Assert.assertTrue(isElementPresentAndClickable(readyToGetStartedBrickContactUsButton));
    }
}
