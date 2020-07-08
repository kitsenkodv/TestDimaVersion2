package storied_test;

import storied.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPageTest extends BaseTest {

    @Test (dataProvider = "LoginDateProvider", dataProviderClass = LoginDateProviderClass.class)
    public void registerFailTest (String email, String password, String errorMessage) {
        loginPage.
                goTo().
                signIn(email, password).
                checkErrorMessage(errorMessage);
    }

}
