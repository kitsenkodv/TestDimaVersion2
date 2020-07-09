package automationpractice_test;

import automationpractice.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import storied.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public MainPage mainPage;

    @BeforeTest
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
    }

    @AfterTest
    public void tearDown () {
        driver.quit();
    }

}
