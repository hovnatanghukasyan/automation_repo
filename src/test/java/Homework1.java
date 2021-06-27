import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homework1 {
        String driverPath = "/Users/hovnatan.ghukasyan/Downloads/chromedriver";
        WebDriver driver;

        @BeforeMethod
        public void initDriver() {
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
        }

        @Test
        public void myFirstTest() {
            driver.get("https://picsart.com");
            WebElement element = driver.findElement(By.cssSelector("[href=\"/gold\"]"));
            element.click();
            WebElement element1 = driver.findElement(By.cssSelector(".gold-pricing-title"));
            String text = element1.getText();
            String origin = "Try PicsArt Gold Free for 7-Days";
            System.out.println(text.equals(origin));
        }

        @AfterMethod
        public void kill() {
            driver.close();
            driver.quit();
        }
    }
