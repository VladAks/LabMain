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

public class AdsSpareParts {
    private WebDriver driver;
    private final Logger logger = LogManager.getRootLogger();
    @FindBy(
            xpath = "//a[@href='/accessories/avtozvuk']"
    )
    private WebElement SerchFistElements;
    @FindBy(
            xpath = "//span[@class='nav__link-text' and text()='Запчасти']"
    )
    private WebElement ListOfSerchParametrs;
    @FindBy(
            xpath = "//button[@class='dropdown__control dropdown__control--active dropdown-link' and @aria-pressed='false']"
    )
    private WebElement ChangeParametrsForSerch;
    @FindBy(
            xpath = "//button[@class='dropdown__listbutton' and @data-item-label='новые объявления']"
    )
    private WebElement ChangeParametrsForNewAds;
    @FindBy(
            xpath = "//div[@class='listing-item__date']"
    )
    private WebElement CheckDayOfPart;
    public AdsSpareParts(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(this.driver, Duration.ofMillis(50L));
        PageFactory.initElements(driver, this);
    }
    public boolean ClickToAutoSound() {
        boolean isNewDays = false;
        ListOfSerchParametrs.click();
        SerchFistElements.click();
        ChangeParametrsForSerch.click();
        ChangeParametrsForNewAds.click();
        if (StringUtils.containsAny(CheckDayOfPart.getText(),"1","2","2","4","5","6","7")) {
            logger.info("OK! OK! OK! OK! OK! OK! OK! OK! OK! OK! OK! OK! OK!");
            isNewDays = true;}
        return isNewDays;
    }
}
