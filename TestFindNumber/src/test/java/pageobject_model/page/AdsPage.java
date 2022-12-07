package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdsPage {
    private WebDriver driver;
    @FindBy(
            xpath = "//*[@class='listing-item__link']"
    )
    private WebElement SerchFistElements;
    @FindBy(
            xpath = "//*[@class='button__text' and text()='Показать телефон']"
    )
    private WebElement SerchPhoneNumber;
    @FindBy(
            xpath = "//*[@class='phones__list']/li"
    )
    private WebElement LiOfNumber;

    public AdsPage(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(this.driver, Duration.ofMillis(50L));
        PageFactory.initElements(driver, this);
    }
    public AdsPage ClickForFistAds() {

        this.SerchFistElements.click();
        return this;
    }
    public AdsPage ClickToShowNumberButton() {
        new WebDriverWait(this.driver, Duration.ofMillis(50L));
        this.SerchPhoneNumber.click();
        return this;
    }
    public String GetTextInListNumber() {
        return LiOfNumber.getText();
    }
}
