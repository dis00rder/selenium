package mytests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;


public class CheckOutSelenium {

    public WebDriver setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public void logIn(WebDriver driver) {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(".shopping_cart_link")).isDisplayed());
    }

    @Test
    public void CheckOut() {
        WebDriver driver = setUp();
        logIn(driver);
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
