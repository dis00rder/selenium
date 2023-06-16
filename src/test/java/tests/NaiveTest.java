package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NaiveTest {

    @Test
    public void testLogInPositive(){
//        System.setProperty("webdriver.chrome.driver", "d:\\course\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#user-name12121")));
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
//        String urlActual = driver.getCurrentUrl();

//        Assert.assertEquals(urlActual, "https://www.saucedemo.com/inventory.html",
//                "The url is wrong");

        String titleText = driver.findElement(By.cssSelector(".app_logo")).getText();
        Assert.assertEquals(titleText, "Swag Labs");

        driver.close();
        driver.quit();
    }
}
