package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AvByHomePage {
    private WebDriver driver ;
    @FindBy(
            xpath = "//*[@class='button__text' and text()='Закрыть']"
    )
    private WebElement buttonCloseForm;

    @FindBy(
            xpath = "//*[@class='button__text' and text()='Показать']"
    )
    private WebElement buttonOpenAdsPage;

    public AvByHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AvByHomePage openPage(String url) {
        this.driver.get(url);
        new WebDriverWait(this.driver, Duration.ofMillis(50L));
        return this;
    }

    public AvByHomePage ClickToCloseButton() {
        this.buttonCloseForm.click();
        return this;
    }

    public AdsPage OpenAdsPage() {
        this.buttonOpenAdsPage.click();
      return new AdsPage(driver);
    }

}
