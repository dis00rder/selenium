package SauseDemo.tests;

import SauseDemo.framework.pageobjects.HomePageObject;
import SauseDemo.framework.pageobjects.LoginPageObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class CheckOutSeleniumPO {

    public WebDriver setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    @Test
    public void logIn() {
        WebDriver driver = setUp();
        driver.get("https://www.saucedemo.com/");
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.fillUserName("standard_user");
        loginPageObject.fillPass("secret_sauce");
        HomePageObject homePageObject = loginPageObject.loginClickSuccess();
        Assert.assertTrue(homePageObject.isShoppingCartButtonDisplayed());

        driver.close();
        driver.quit();
    }


    @Test
    public void logIn2() {
        WebDriver driver = setUp();
        driver.get("https://www.saucedemo.com/");
        boolean isShoppingCartButtonDisplayed = new LoginPageObject(driver)
                .fillUserName("standard_user")
                .fillPass("secret_sauce")
                .loginClickSuccess().isShoppingCartButtonDisplayed();
        Assert.assertTrue(isShoppingCartButtonDisplayed);

        driver.close();
        driver.quit();
    }

    @Test
    public void CheckOut() {
        WebDriver driver = setUp();
        logIn();
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/../../..//button")).click();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        driver.findElement(By.cssSelector("#checkout")).click();
        driver.findElement(By.cssSelector("#first-name")).sendKeys("Dmytro");
        driver.findElement(By.cssSelector("#last-name")).sendKeys("Lehenkyi");
        driver.findElement(By.cssSelector("#postal-code")).sendKeys("00843");
        driver.findElement(By.cssSelector("#continue")).click();
        driver.findElement(By.cssSelector("#finish")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".complete-text")).getText(),
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!");

        driver.close();
        driver.quit();
    }


}
