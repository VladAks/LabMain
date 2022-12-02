package first_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebDriverSeleniumHQTest {

    @Test

    public void commonSearchTermReResultsNotEmpty() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
        driver.get("http://av.by");

        new WebDriverWait(driver, Duration.ofSeconds(2000))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='modal-root']/div[1]/div/div/div/div/div/div[3]/button")));

        WebElement serchIput = new WebDriverWait(driver, Duration.ofSeconds(2000))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='modal-root']/div[1]/div/div/div/div/div/div[3]/button")));

        serchIput.click();
        WebElement serchIput2 = new WebDriverWait(driver, Duration.ofSeconds(2000))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='button__text' and text()='Показать']")));
        serchIput2.click();

        driver.findElement(By.xpath("//*[@class='listing-item__link'][1]")).click();
        driver.findElement(By.xpath("//*[@class='button__text' and text()='Показать телефон']")).click();

        WebElement serchIput3 = new WebDriverWait(driver, Duration.ofSeconds(2000))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='phones__list']/li")));
        String flag;
        Assert.assertFalse(serchIput3.getText().isEmpty(),"results are empty!");
        flag =serchIput3.getText();
        driver.quit();

    }
    private static WebElement WaitgettingElement(WebDriver driver,By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(200)).
                until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
