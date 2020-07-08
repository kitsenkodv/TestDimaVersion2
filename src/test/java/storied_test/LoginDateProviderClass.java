package storied_test;

import org.testng.annotations.DataProvider;

public class LoginDateProviderClass {


    public Object [][] getData() {
        Object [][] data = {
                {"qatestllc@gmail.com","123456", "Username and password combination was not found."},
                {"dancalya+7896@gmail.com","123456", "Your account has been removed."},
                {"dancalya+227@gmail.com","123456", "You must confirm the email."},
                {"dancalya+2@gmail.com","123456", "Your account has been blocked."},
                {"dancalya+229@gmail.com","123456", "Account is waiting for approval by administrator."}
        };
        return data;
    }

    @DataProvider(name = "LoginDateProvider")
    public Object [][] Data () {
        return new LoginDateProviderClass().getData();
    }
}
