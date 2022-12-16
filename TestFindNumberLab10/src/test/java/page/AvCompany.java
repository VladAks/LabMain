package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class AvCompany {
    private WebDriver driver;
    private final Logger logger = LogManager.getRootLogger();
    @FindBy(
            xpath = "//a[@class='organization-item__link' and @href='/company/1163406']"
    )
    private WebElement buttonDriveMotors;
    @FindBy(
            xpath = "//button[@class='dropdown__control dropdown__control--active dropdown-link' and @aria-pressed='false']"
    )
    private WebElement ShowList;
    @FindBy(
            xpath = "//button[@class='dropdown__listbutton' and @data-item-label='дешёвые']"
    )
    private WebElement ChooseCheap;

    @FindBy(
            xpath = "//div[@class='listing-item__price']"
    )
    private WebElement returnPriceOfCar;

    public AvCompany(WebDriver driver) throws InterruptedException{
        this.driver = driver;
        new WebDriverWait(this.driver, Duration.ofMillis(50L));
        PageFactory.initElements(driver, this);
    }
    public AvCompany ChooseCompanyDriveMotors() {
        buttonDriveMotors.click();
        return this;
    }
    public AvCompany ChangeSort() throws InterruptedException {
        ShowList.click();
        ChooseCheap.click();
        return this;
    }
    public boolean CheckPriceCar() throws InterruptedException {
        sleep(1000);

        if (Integer.parseInt(returnPriceOfCar.getText().substring(0,2))<30) return true;
        else return false;
    }

}
