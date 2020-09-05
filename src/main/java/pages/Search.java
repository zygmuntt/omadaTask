package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Search extends Base {
    public Search(WebDriver driver){super(driver);}

    private final By searchInputNavBar = By.xpath("//form[@class='header__search']/input");
    private final By searchInputOnOutput = By.xpath("//div[@class='search-results__column--input']/input");
    private final By searchResults = By.xpath("//section[@class='search-results__item']");
    private final By boldTextInResult = By.xpath("//section[@class='search-results__item']//strong");
    private final By searchButtonSubmitOnOutput = By.xpath("//div[@class='search-results__column--button']/input");

    public Search fillSearchInputNavBar(String text){
        writeText(searchInputNavBar,text);
        return this;
    }
    public Search fillSearchInputOnOutput(String text){
        writeText(searchInputOnOutput,text);
        return this;
    }
    public Search confirmSearchOnOutput(){
        waitVisibleAndClick(searchButtonSubmitOnOutput);
        return this;
    }
    public Search clearSearchInput(){
        clearInput(searchInputOnOutput);
        return this;
    }

    public Search confirmSearchNavBar(){
        WebElement element = driver.findElement(searchInputNavBar);
        element.sendKeys(Keys.ENTER);
        return this;
    }
    public Search checkSearchResults(){
        List<WebElement> resultList = listGetter(searchResults,1);
        List<WebElement> boldTextList = listGetter(boldTextInResult,1);
        Assert.assertTrue(boldTextList.size()>1);
        Assert.assertTrue(resultList.size()>1);
        for (WebElement e: resultList ) {
            Assert.assertTrue(!e.getText().isEmpty());
        }
        return this;
    }

}
