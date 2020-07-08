package storied_test;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {

    @Test (dataProvider = "LoginDateProvider", dataProviderClass = LoginDateProviderClass.class)
    public void registerFailTest (String email, String password, String errorMessage) {
        loginPage.
                goTo().
                signIn(email, password);

        Assert.assertEquals(loginPage.getErrorMessage(), errorMessage);
    }

}
