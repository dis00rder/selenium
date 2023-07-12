package SauseDemo.tests;


import com.google.common.collect.Comparators;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;


public class SortingByPrice {

    public WebDriver setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
         options.addArguments("--headless");
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
    public void SortingByPrice() {
        WebDriver driver = setUp();
        logIn(driver);

        Select select = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        select.selectByVisibleText("Price (low to high)");

        var prices = driver.findElements(By.cssSelector(".inventory_item_price"));
//        Solution 1 for 1st and 2nd element comparing
//        Assert.assertTrue(Float.parseFloat(prices.get(0).getText().substring(1))
//                <Float.parseFloat(prices.get(1).getText().substring(1)));

        //        Solution 2 for  comparing all prices
//        List<Float> linkTitleText = prices.stream().map((webElement) -> {
//            return Float.parseFloat(webElement.getText().substring(1));
//        }).toList();
//        boolean isSortedActual = Comparators.isInOrder(linkTitleText, Comparator.naturalOrder());
//        Assert.assertTrue(isSortedActual,"Items are not sorted");

        //        Solution 3 for  comparing all prices
        for (int i = 0; i < prices.size()-1; i++) {
            Assert.assertTrue(Float.parseFloat(prices.get(i).getText().substring(1))
                <=Float.parseFloat(prices.get(i+1).getText().substring(1)));
        }


        driver.close();
        driver.quit();
    }


}
