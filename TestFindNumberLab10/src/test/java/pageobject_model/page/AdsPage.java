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
            xpath = "//*[@class='link-text']"
    )
    private WebElement SerchFistElements;
    @FindBy(
            xpath = "//button[@class='card__actions-item']"
    )
    private WebElement ButtonComment;
    @FindBy(
            xpath = "//*[@class='button__text' and text()='Показать телефон']"
    )
    private WebElement SerchPhoneNumber;

    @FindBy(
            xpath = "//*[@class='phones__list']/li"
    )
    private WebElement LiOfNumber;

    @FindBy(
            xpath = "//button[@class='button button--primary button--large button--block button button--primary']"
    )
    private WebElement Cookie;
    @FindBy(
            xpath = "//textarea[@class='dynamic-note__text']"
    )
    private WebElement textComment;
    @FindBy(
            xpath = "//button[@class='dynamic-note__save']"
    )
    private WebElement ButtonSaveComment;
    @FindBy(
            xpath = "//button[@aria-selected='false']"
    )
    private WebElement SwitchLogin;
    @FindBy(
            xpath =  "//input[@name='login']"
    )
    private WebElement Login;
    @FindBy(
            xpath = "//input[@name='password']"
    )
    private WebElement Pass;
    @FindBy(
            xpath = "//button[@class='button button--action']"
    )
    private WebElement LogIn;
    public AdsPage(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(this.driver, Duration.ofMillis(50L));
        PageFactory.initElements(driver, this);
    }
    public AdsPage ClickForFistAds() {

        driver.findElement(By.xpath("//*[@class='listing-item__link'][1]")).click();
        return this;
    }
    public AdsPage ClickCook() {

        new WebDriverWait(this.driver, Duration.ofMillis(50L));
        this.Cookie.click();
        return this;
    }

    public AdsPage ClickToComment(String login){
        new WebDriverWait(this.driver, Duration.ofMillis(50L));
        this.ButtonComment.click();
        textComment.sendKeys(login);
        ButtonSaveComment.click();
        return this;
    }
    public AdsPage Login(String login, String pass) {

        new WebDriverWait(this.driver, Duration.ofMillis(50L));
        this.SwitchLogin.click();
        Login.sendKeys(login);
        Pass.sendKeys(pass);
        LogIn.click();
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
    public String GetTextInListComment() {
        return textComment.getText();
    }
}
