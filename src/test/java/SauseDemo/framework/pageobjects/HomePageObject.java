package SauseDemo.framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObject {

    private WebDriver driver;
    private WebElement shoppingCartButton;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
        shoppingCartButton = driver.findElement(By.cssSelector(".shopping_cart_link"));
    }

    public boolean isShoppingCartButtonDisplayed() {
        return shoppingCartButton.isDisplayed();

    }


}
