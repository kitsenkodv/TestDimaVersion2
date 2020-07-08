package automationpractice_test;


import automationpractice.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import storied.LoginPage;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    public WebDriver driver;
    public MainPage mainPage;


    @BeforeTest
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "D:\\QA AUTO\\test-selenium-dima\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        mainPage = new MainPage(driver);
    }

    @Test
    public void addToCart () {
        mainPage.selectProduct();
       // mainPage.testExpectedConditions();
        mainPage.AssertProductCart();
    }

//    @AfterTest
//    public void tearDown () {
//        driver.quit();
//    }

}