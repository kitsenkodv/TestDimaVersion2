package storied;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    String SITE_URL = "https://stage.storied.co/auth/login";
    private By userEmailField = By.xpath("//*[@id='login']");
    private By passwordField = By.xpath("//*[@id='password']");
    private By signInButton = By.xpath("//button[text()='Sign in']");
    private By error = By.xpath("//div[@class='error']/p");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goTo () {
        driver.get(SITE_URL);
        return this;
    }

    public LoginPage signIn (String email, String password) {
        sendKeys(userEmailField, email);
        sendKeys(passwordField, password);
        click(signInButton);
        return this;
    }

    public String getErrorMessage () {
        return getText(error);
    }

}
