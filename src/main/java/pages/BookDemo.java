package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookDemo extends Base {
    private BookDemo(WebDriver driver){super(driver);}

    private final By firstName = By.xpath("//p[@class='form-field  first_name pd-text required required-custom    ']/input");
    private final By lastName = By.xpath("//p[@class='form-field  last_name pd-text required required-custom    ']/input");
    private final By company = By.xpath("//p[@class='form-field  company pd-text required required-custom    ']/input");
    private final By jobTitle = By.xpath("//p[@class='form-field  job_title pd-text required required-custom    ']/input");
    private final By businessEmail = By.xpath("//p[@class='form-field  email pd-text required required-custom    ']/input");
    private final By phone = By.xpath("//p[@class='form-field  phone pd-text required required-custom    ']/input");
    private final By country = By.xpath("//p[@class='form-field  country pd-select required required-custom    ']/select");
    private final By numberOfEmployees = By.xpath("//p[@class='form-field  sf_Number_of_Employees pd-select required required-custom    ']/select");
    private final By acceptPrivacyPolicy = By.xpath("//p[@class='form-field  Lead_Marketing_Permission pd-radio required required-custom    ']//label[@class='inline']");
    private final By captchaCheckbox = By.xpath("//label[@id='recaptcha-anchor-label']");
    private final By submitButton = By.xpath("//p[@class='submit']/input");

    public BookDemo iframeSwitchForm(){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='https://go.omada.net/l/581103/2018-09-28/3l8q68']")));
        return this;
    }

    public BookDemo fillFirstName(String text){
        writeText(firstName, text);
        return this;
    }
    public BookDemo fillLastName(String text){
        writeText(lastName, text);
        return this;
    }
    public BookDemo fillCompany(String text){
        writeText(company, text);
        return this;
    }
    public BookDemo fillJobTitle(String text){
        writeText(jobTitle,text);
        return this;
    }
    public BookDemo fillBusinessEmail(String text){
        writeText(businessEmail,text);
        return this;
    }
    public BookDemo fillPhone(String text){
        writeText(phone,text);
        return this;
    }
    public BookDemo choseCountry(String countryName){
        selectOption(country,countryName);
        return this;
    }
    public BookDemo choseNumberOfEmployees(String employeesNumber){
        selectOption(numberOfEmployees, employeesNumber);
        return this;
    }
    public BookDemo clickPrivacyPolicy(){
        waitVisibleAndClick(acceptPrivacyPolicy);
        return this;
    }

    public BookDemo iframeSwitchCaptcha(){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'google.com/recaptcha')]")));
        return this;
    }

    public BookDemo clickCaptcha(){
        //i belive on test enviroment, this is always set to click checkbox(no images), or even disabled.
        waitVisibleAndClick(captchaCheckbox);
        return this;
    }

    public void clickSubmit(){
        waitVisibleAndClick(submitButton);
    }

}
