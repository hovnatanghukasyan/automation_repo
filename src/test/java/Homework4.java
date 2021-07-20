import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;


public class Homework4 {
    String driverPath = "/Users/hovnatan.ghukasyan/Downloads/chromedriver";
    WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }

    @Test
    public void myFirstTest() {
        driver.get("https://picsartstage2.com/create/editor?templateSize=insta_story");
        cookiePolicy();
        WebElement element = driver.findElement(By.cssSelector("[id='photos-category']"));
        element.click();
        WebElement element1 = driver.findElement(By.cssSelector(".pa-uiLib-sidebar-sidebarItem-0-2-270"));
        element1.click();

        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver input) {
                List<WebElement> element45 = driver.findElements(By.cssSelector("[data-test='layers-item']"));
                return element45.size() > 1;
            }
        });
        WebElement createButton = driver.findElement(By.cssSelector(".konvajs-content"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(createButton, 20, 20).build().perform();
    }

    public void cookiePolicy() {
        driver.manage().addCookie(new Cookie("user_key", "b6409bcb-3cc8-4644-9eb4-897da417ca2d"));
        driver.manage().addCookie(new Cookie("we-editor-first-open", "true"));
        driver.manage().addCookie(new Cookie("OptanonAlertBoxClosed", "2021-06-26T13:47:26.654Z"));
        driver.manage().addCookie(new Cookie("we-editor-photo-first-open", "true"));
        driver.navigate().refresh();
    }

    @AfterMethod
    public void kill() {
        driver.close();
        driver.quit();
    }
}

