import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Homework3 {
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
        driver.get("https://picsartstage2.com/create/editor?templateSize=insta_story");
        WebDriver.Navigation navigate = driver.navigate();
        Cookie cookie = new Cookie("user_key","b6409bcb-3cc8-4644-9eb4-897da417ca2d");
        Cookie cookie1 = new Cookie("we-editor-first-open","true");
        Cookie cookie2 = new Cookie("OptanonAlertBoxClosed","2021-06-26T13:47:26.654Z");
        driver.manage().addCookie(cookie);
        driver.manage().addCookie(cookie1);
        driver.manage().addCookie(cookie2);
        driver.navigate().refresh();
        Thread.sleep(5000);      //to see the result

    }

    @AfterMethod
    public void kill() {
        driver.close();
        driver.quit();
    }
}
