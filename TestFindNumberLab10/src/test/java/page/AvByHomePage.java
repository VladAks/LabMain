package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

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
    @FindBy(
            xpath = "//div[@class='filter__show-result']/a[@href='https://cars.av.by/audi']/span"
    )
    private WebElement buttonOpenAdsPageFilter;
    @FindBy(
            xpath = "//div[@class='filter__show-result']/a[@href='https://cars.av.by/filter?brands[0][brand]=6&brands[1][brand]=8&brands[2][brand]=683']/span"
    )
    private WebElement buttonOpenAdsPageFilterWithManyOptions;
    @FindBy(
            xpath = "//button[text()='Audi']"
    )
    private WebElement Audi;
    @FindBy(
            xpath = "//*[@id='p-6-1-2-brand']/div/div/ul/li[9]/button"
    )
    private WebElement BMW;
    @FindBy(
            xpath = "//*[@id='p-6-2-2-brand']/div/div/ul/li[59]/button"
    )
    private WebElement MercedesBenz;
    @FindBy(
            xpath = "//button[text()='A6']"
    )
    private WebElement A6;
    @FindBy(
            xpath = "//div[@class='dropdown' and @id='p-6-0-2-brand']"
    )
    private WebElement ListOfMark;

    @FindBy(
            xpath = "//div[@class='dropdown' and @id='p-6-0-3-model']"
    )
    private WebElement ListOfModel;

    @FindBy(
            xpath = "//div[@class='price-compound']/div[@class='richinput-control'][1]"
    )
    private WebElement Price;
    @FindBy(
            xpath = "//div[@class='richinput-control richinput-control--active']"
    )
    private WebElement PriceDo;
    @FindBy(
            xpath = "//button[@class='button button--primary button--large button--block button button--primary']"
    )
    private WebElement Cookie;
    @FindBy(
            xpath = "//span[@class='button__text' and text()='Марка']"
    )
    private  WebElement buttonAddMark;
    @FindBy(
            xpath = "//button[@class='dropdown__control dropdown-floatlabel' and @title='Марка']"
    )
    private WebElement ClickToMarkButton;
    @FindBy(
            xpath = "//a[@href='https://parts.av.by']"
    )
    private WebElement AutoProducts;
    @FindBy(
            xpath = "//*[@id='__next']/div[2]/header/div/nav/ul[1]/li[3]/a"
    )
    private WebElement SpareParts;
    @FindBy(
            xpath = "//span[@class='nav__link-text' and text()='Финансы']"
    )
    private WebElement ButtonFinance;
    @FindBy(
            xpath = "//a[@class='footer__link' and @href='https://av.by/company']"
    )
    private WebElement ButtonCompany;
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
    public AdsPage OpenAdsPageOption() {
        this.buttonOpenAdsPageFilter.click();
        return new AdsPage(driver);
    }
    public AvByHomePage ClickCooks() {

        new WebDriverWait(this.driver, Duration.ofMillis(50L));
        this.Cookie.click();
        return this;
    }
    //WebElement fromButton =new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("p-9-price_usd")));
    public AdsPage SelectOptionsAudi(){
        ListOfMark.click();
        Audi.click();
        buttonOpenAdsPageFilter.click();        //Audi.click();
        return new AdsPage(driver);
    }
    public AdsPage SelectThreeOptions(){
        ListOfMark.click();
        Audi.click();
        buttonAddMark.click();
        buttonAddMark.click();
        ClickToMarkButton.click();
        BMW.click();
        ClickToMarkButton.click();
        MercedesBenz.click();
        buttonOpenAdsPageFilterWithManyOptions.click();
        return new AdsPage(driver);
    }
    public AvCompany SelectCompany() throws InterruptedException {
        ButtonCompany.click();
        return new AvCompany(driver);
    }
    public AdsSpareParts SelectAutoProducts (){
        AutoProducts.click();
        return new AdsSpareParts(driver);
    }
    public AvFinance SelectFinance (){
        ButtonFinance.click();
        return new AvFinance(driver);
    }


}
