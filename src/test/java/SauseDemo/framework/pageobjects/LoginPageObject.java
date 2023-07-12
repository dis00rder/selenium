package SauseDemo.framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {
    private WebDriver driver;

    private WebElement userNameField;
    private WebElement userPassField;
    private WebElement loginButton;


    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
         userNameField = driver.findElement(By.cssSelector("#user-name"));
         userPassField = driver.findElement(By.cssSelector("#password"));
         loginButton = driver.findElement(By.cssSelector("#login-button"));
    }


    public LoginPageObject fillUserName(String username) {
        userNameField.clear();
        userNameField.sendKeys(username);
        return this;
    }

    public LoginPageObject fillPass(String password) {
        userPassField.clear();
        userPassField.sendKeys(password);
        return this;
    }

    public HomePageObject loginClickSuccess() {
        loginButton.click();
        return new HomePageObject(driver);
    }

    public LoginPageObject loginClickNegative() {
        loginButton.click();
        return this;
    }

}
