package mytests;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import mytests.MyBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LogInPage;

import java.time.Duration;

public class MyLoginTest extends MyBaseTest {

    private final static String NAME = "standard_user";
    private final static String PASS = "secret_sauce";



    @Test
    @Description(" Positive case for Login")
    public void testLoginPositive(){

       String  titleTextActual = new LogInPage(driver)
                .logIn(NAME,PASS)
                .getTitleText();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html", "The login was not successful");

    }

}
