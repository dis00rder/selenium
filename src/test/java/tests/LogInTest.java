package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LogInPage;

public class LogInTest extends BaseTest {
    private final static String NAME = "standard_user";
    private final static String PASS = "secret_sauce";

    @Test
    @Description("The test is checking positive case for login")
    public void testLogInPositive() {
        new LogInPage(driver)
                .logIn(NAME, PASS);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html"
                , "The logIn was not successful");
    }

}
