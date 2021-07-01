import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Homework2 {
    String driverPath = "/Users/hovnatan.ghukasyan/Downloads/chromedriver";
    WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void myFirstTest() throws InterruptedException {
//      driver.get("https://picsartstage2.com/"); if we are not using Thread sleeping
        driver.get("https://picsart.com/");
        WebElement element = driver.findElement(By.cssSelector("[href=\"/sign-in\"]"));
        element.click();
        WebElement element1 = driver.findElement(By.cssSelector("[name=\"username\"]"));
        element1.sendKeys("beatest");
        WebElement element2 = driver.findElement(By.cssSelector("[name=\"password\"]"));
        element2.sendKeys("beatest1");
        Thread.sleep(2000);
        WebElement element3 = driver.findElement(By.cssSelector("[class*=\"primary pa-uiLib-authentication-signIn\"]"));
        element3.click();
        Thread.sleep(2000);
        WebElement element4 = driver.findElement(By.cssSelector("[alt=\"User Profile\"]"));
        System.out.println(element4.isDisplayed());

    }

    @AfterMethod
    public void kill() {
        driver.close();
        driver.quit();
    }
}
