package pl.zygmuntt.desktopTests;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.Search;
import utility.BaseTest;
import utility.DataProviderClass;
import utility.Retry;

import static utility.TestData.*;

public class Tests extends BaseTest {
    @Test(retryAnalyzer = Retry.class)
    public void homepageShouldContainsAllRequiredLinksAndButtons() { //tc1
        MainPage mainPage = new MainPage(driver);
        mainPage
                .closeCookies()
                .sliderImageCheck()
                .spotsItemsGridCheck()
                .gartnerBrickCheck()
                .identityProcessFrameworkCheck()
                .clientBarCheck()
                .newsSliderCheck()
                .readyToGetStartedCheck();
    }

    @Test(retryAnalyzer = Retry.class)
    public void userShouldBeAbleToBookADemo() { //tc2
        MainPage mainPage = new MainPage(driver);
        mainPage
                .closeCookies()
                .clickBookDemo()
                .iframeSwitchForm()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillCompany(company)
                .fillJobTitle(jobTitle)
                .fillBusinessEmail(businessEmail)
                .fillPhone(phone)
                .choseCountry("China")
                .choseNumberOfEmployees("0-500")
                .clickPrivacyPolicy()
                .iframeSwitchCaptcha()
                .clickCaptcha()
                .iframeSwitchForm()
                .clickSubmit();
    }

    @Test(retryAnalyzer = Retry.class, dataProvider = "search-inputs", dataProviderClass = DataProviderClass.class)
    public void searchShouldBeShowingCorrectResults(String searchInput) { //tc5
        Search search = new Search(driver);
        search
                .fillSearchInputNavBar(searchInput)
                .confirmSearchNavBar()
                .checkSearchResults()
                .clearSearchInput()
                .fillSearchInputOnOutput(searchInput.substring(0, searchInput.length() - 1))
                .confirmSearchOnOutput()
                .checkSearchResults();
    }

    @Test(retryAnalyzer = Retry.class)
    public void shouldBeAbleToLearnMoreAboutSolutions() { //tc6
        MainPage mainPage = new MainPage(driver);
        mainPage
                .closeCookies()
                .goToSolutionsFromNavBar()
                .checkIf4ButtonsAreVisible()
                .clickOmadaEssentialButton()
                .checkIfRequestDemoButtonIsAvailable()
                .checkIfRequestDemoRedirectIsOK(correctURL);
    }

}
