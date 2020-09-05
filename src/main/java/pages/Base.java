package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

class Base {
    final WebDriver driver;
    Base(WebDriver driver){
        this.driver=driver;
    }

    private void waitUntilElementVisible(By elementBy){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }


    void waitVisibleAndClick(By elementBy){
        waitUntilElementVisible(elementBy);
        driver.findElement(elementBy).click();
    }

     void writeText(By elementBy, String text){
         waitUntilElementVisible(elementBy);
         WebElement element = driver.findElement(elementBy);
         element.sendKeys(text);
     }

     void selectOption(By elementBy, String text){
        waitUntilElementVisible(elementBy);
         Select countrySelect = new Select(driver.findElement(elementBy));
         countrySelect.selectByVisibleText(text);
     }
     void clearInput(By elementBy){
        waitUntilElementVisible(elementBy);
         driver.findElement(elementBy).clear();
     }

    boolean isElementPresent(By elementBy){
         waitUntilElementVisible(elementBy);
         WebElement element = driver.findElement(elementBy);
        return element.isDisplayed();
     }

     boolean isElementPresentAndClickable(By elementBy){
       if(isElementPresent(elementBy)){
           WebDriverWait wait = new WebDriverWait(driver,15);
           wait.until(ExpectedConditions.elementToBeClickable(elementBy));
           return true;
       }
       else {
           return false;
       }
     }

     List<WebElement> listGetter(By elementBy, int minimumAmountFound){
        List<WebElement> list = driver.findElements(elementBy);
        if(list.size()<minimumAmountFound){
            for(int i=0;i<120;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list = driver.findElements(elementBy);
                if(list.size()>=minimumAmountFound){
                    break;
                }
            }
        }
        return list;
     }

     boolean areButtonsFromListClickable(List<WebElement> list){
         WebDriverWait wait = new WebDriverWait(driver,15);
         int listSize = list.size();
         int clickableElements=0;
         for (WebElement e:list) {
             wait.until(ExpectedConditions.elementToBeClickable(e));
             clickableElements++;
         }
         return clickableElements == listSize;
     }

}
