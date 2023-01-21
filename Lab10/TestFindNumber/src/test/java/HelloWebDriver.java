import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelloWebDriver {

    public static void main(String[] args) throws InterruptedException {


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

        new WebDriverWait(driver, Duration.ofSeconds(2000))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='__next']/div[2]/div[2]/div[1]/main/div/div/div/div[1]/div[1]/div[2]/div/ul[1]/li[1]")));

        List<WebElement> serchBtn2 = driver.findElements(By.xpath("//*[@id='__next']/div[2]/div[2]/div[1]/main/div/div/div/div[1]/div[1]/div[2]/div/ul[1]/li[1]"));
        serchBtn2.get(0).click();

        driver.quit();

    }
    private static WebElement WaitgettingElement(WebDriver driver,By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(2000)).
                until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
