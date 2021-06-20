import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
///Users/hovnatan.ghukasyan/Downloads/chromedriver
public class FirstTest {
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
        WebElement element = driver.findElement(By.cssSelector("li[data-test=\"headerNavigation-navigationListItem-Create\"] a"));
        element.click();
        WebElement element1 = driver.findElement(By.cssSelector("[class*='createDesignHeader'] [class*='bottomText']"));
        String text = element1.getText();
        System.out.println(text);

    }

    @AfterMethod
    public void kill() {
        driver.close();
        driver.quit();
    }


    @AfterSuite
    public void tearDown() {

    }


//    @BeforeSuite
//    public void f1(){
//        System.out.println("BeforeSuite");
//    }
//    @BeforeTest
//    public void f2(){
//        System.out.println("BeforeTest");
//    }
//    @BeforeClass
//    public void f3(){
//        System.out.println("BeforeClass");
//    }
//    @BeforeMethod
//    public void f4(){
//        System.out.println("BeforeMethod");
//    }
//    @Test
//    public void f5(){
//        System.out.println("Test");
//    }
//    @AfterMethod
//    public void f6(){
//        System.out.println("BeforeSuite");
//    }
//    @AfterClass
//    public void f7(){
//        System.out.println("BeforeTest");
//    }
//    @AfterTest
//    public void f8(){
//        System.out.println("BeforeClass");
//    }
//    @AfterSuite
//    public void f9(){
//        System.out.println("BeforeMethod");
//    }

}