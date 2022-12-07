package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.AvByHomePage;

import java.util.concurrent.TimeUnit;


public class AvTest {
    private WebDriver driver;

    public void AvTest() {
    }

    @BeforeMethod(
            alwaysRun = true
    )
    public void browserSetup() {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod(
            alwaysRun = true
    )
    public void quitDriver() {
        this.driver.quit();
        this.driver = null;
    }

    @Test

    public void SearchTermNumberInThePage() {

       String expectedSearchResultsNumber = new AvByHomePage(driver)
               .openPage( "http://av.by")
               .ClickToCloseButton()
               .OpenAdsPage()
               .ClickForFistAds()
                       .ClickToShowNumberButton()
                               .GetTextInListNumber();

        Assert.assertFalse(expectedSearchResultsNumber.isEmpty());
    }

}
