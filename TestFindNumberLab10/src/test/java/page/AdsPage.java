package page;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AdsPage  {
    private final Logger logger = LogManager.getRootLogger();
    public static void main(String args[]) throws InterruptedException{
        Thread.sleep(1000);
    }
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
            xpath = "//button[@class='card__actions-item' and @aria-pressed='true']"
    )
    private  WebElement CheckBookMark;
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
            xpath = "//div[@class='notification__box']"
    )
    private WebElement CheckComplain;
    @FindBy(
            xpath = "//span[@class='nav__link-text' and text()='Войти']"
    )
    private WebElement BottonLogin;
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
    private WebElement LogIn;//button[@class='button button--action']
    @FindBy(
            xpath = "//*[@class='listing-item__link'][1]"
    )
    private WebElement ListOfAds;
    @FindBy(
            xpath = "//span[@class='button__text' and text()='Пожаловаться…']"
    )
    private WebElement ButtonOfComplaint;
    @FindBy(
            xpath = "//*[@class='listing__items']"
    )
    private WebElement MoreListOfAds;
    @FindBy(
            xpath = "//button[@class='card__actions-item' and @aria-pressed='false' and @title='Добавить в закладки']"
    )
    private WebElement ButtonBookmarks;
    @FindBy(
            xpath = "//button[@class='card__actions-item' and @aria-pressed='true' and @title='Убрать из закладок']"
    )
    private WebElement ButtonBookmarksTrue;
    @FindBy(
            xpath = "//*[@id=\"__next\"]/div[3]/main/div/div/div[1]/div[1]/div[2]/div/div/form/div/div[1]/div[8]/label/span"
    )
    private WebElement ButtonOther;
    @FindBy(
            xpath = "//span[@class='button__text' and text()='Отправить']"
    )
    private WebElement ButtonSebdComplaint;
    @FindBy(
            xpath = "//button[@class='button button--link'][3]"
    )
    private WebElement buttonSaveParametrs;
    @FindBy(
            xpath = "//div[@class='modal__title' and text()='Поиск сохранён']"
    )
    private WebElement CheckForSaveParametr;
    public AdsPage(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(this.driver, Duration.ofMillis(50L));
        PageFactory.initElements(driver, this);
    }
    public AdsPage ClickForFistAds() {

        driver.findElement(By.xpath("//*[@class='listing-item__link'][1]")).click();
        return this;
    }
    public AdsPage ClickForThecondAds() {

        driver.findElement(By.xpath("//*[@class='listing-item__link'][2]")).click();
        return this;
    }
    public boolean Complaint(){
        ButtonOfComplaint.click();
        ButtonOther.click();
        ButtonSebdComplaint.click();
        if (CheckComplain.isEnabled()) return true;
        else {
            logger.info("OK! OK! OK! OK! OK! OK! OK! OK! OK! OK! OK! OK! OK!");
            return false;
        }
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

    public AdsPage Login(User user)  {

        BottonLogin.click();
        this.SwitchLogin.click();
        Login.sendKeys(user.getUsername());
        Pass.sendKeys(user.getPassword());
        logger.info("Login performed! Successfully!");
        return this;
    }
    public AdsPage LoginComment(User user)  {

        this.SwitchLogin.click();
        Login.sendKeys(user.getUsername());
        Pass.sendKeys(user.getPassword());
        logger.info("Login performed! Successfully!");
        return this;
    }
    public AdsPage ClickToButtonForLogin() throws InterruptedException {
        Thread.sleep(1000);
        LogIn.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        return this;
    }

    public AdsPage AddToBookmarks() throws InterruptedException {

        if (ButtonBookmarks.isEnabled())
        { ButtonBookmarks.click();  Thread.sleep(400); return this;}
        else {
            ButtonBookmarksTrue.click();  Thread.sleep(400);  ButtonBookmarks.click();    Thread.sleep(400); return this;}
        }


    }
    public boolean SaveSerchParam(){
        buttonSaveParametrs.click();
        if (CheckForSaveParametr.isEnabled()){
            logger.info("OK! OK! OK! OK! OK! OK! OK! OK! OK! OK! OK! OK! OK!");
            return true;
        }
        else {
            logger.info("Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad!");
        return false;
        }
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
    public  boolean SheckBookMarks(){

        if (CheckBookMark.isEnabled())
            return true;
        else
        return false;
    }
    public boolean SheckMark() {
        boolean IsAudi = false;
        String Mark = ListOfAds.getText();
        logger.info(Mark);
        if (Mark.contains("Audi"))
        {
            logger.info("OK! OK! OK! OK! OK! OK! OK! OK! OK! OK! OK! OK! OK!");
            return true;
        }
        else {
            logger.info("Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad!");
            return IsAudi;
        }
    }
    public boolean SheckThreeMark() {
        boolean IsAudi = false;
        List<WebElement> MarkList = driver.findElements(By.xpath("//*[@class='listing-item__link']"));
        int numberOfListElements = MarkList.size();
        int Audi = 0;
        int BMW = 0;
        int Mers = 0;
        for (int i = 0; i < numberOfListElements ; i++){
            if (MarkList.get(i).getText().contains("Audi"))
            {
                Audi++;
            } else  if (MarkList.get(i).getText().contains("BMW"))
            {
                BMW++;
            }else  if (MarkList.get(i).getText().contains("Mercedes-Benz"))
            {
                Mers++;
            }
        }
        if ((Audi != 0) && (BMW !=0) && (Mers != 0))
        {
            logger.info("OK! OK! OK! OK! OK! OK! OK! OK! OK! OK! OK! OK! OK!");
            return true;
        }
        else {
            logger.info("Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad!");
            return IsAudi;
        }
    }
}
