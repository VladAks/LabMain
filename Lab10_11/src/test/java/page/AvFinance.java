
package page;

import model.User;
import org.apache.commons.lang3.StringUtils;
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

public class AvFinance {
    private WebDriver driver;
    private final Logger logger = LogManager.getRootLogger();
    @FindBy(
            xpath = "//button[@class='dropdown__control dropdown__control--active dropdown-floatlabel' and @aria-pressed='false']"
    )
    private WebElement ChooseCategory;
    @FindBy(
            xpath = "//button[@class='dropdown__listbutton' and @data-item-label='Новый автомобиль']"
    )
    private WebElement ChooseNewAuto;
    @FindBy(
            xpath = "//div[@class='finance-item finance-item--leasing']"
    )
    private WebElement ChooseAktivLising;
    @FindBy(
            xpath = "//input[@class='form-control form-control--large']"
    )
    private WebElement InputTextArea;
    @FindBy(
            xpath = "//div[@class='finance-card__output']/div"
    )
    private WebElement CheckSumOfLising;
    public AvFinance(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(this.driver, Duration.ofMillis(50L));
        PageFactory.initElements(driver, this);
    }
    public boolean CheckLisingForSum() {
        ChooseCategory.click();
        ChooseNewAuto.click();
        ChooseAktivLising.click();
        for (int j = 0; j < 5; ++j)
        {
            InputTextArea.sendKeys(Keys.BACK_SPACE);
        }
        InputTextArea.sendKeys("88000");
        logger.info(CheckSumOfLising.getText());

        if (CheckSumOfLising.getText().contains("1989")) {
            logger.info("OK! OK! OK! OK! OK! OK! OK! OK! OK! OK! OK! OK! OK!");
            return true;}
        else { logger.info("Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad! Bad!");
            return false;}
    }
}
