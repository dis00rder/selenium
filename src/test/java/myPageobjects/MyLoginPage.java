package myPageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.MainPage;

public class MyLoginPage extends MyAbstractPageObject {

    private final By userNameField = By.cssSelector("#user-name");
    private final By passwordField = By.cssSelector("#password");
    private final By loginButton = By.cssSelector("#login-button");

    public MyLoginPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.saucedemo.com/");
    }

    @Step("The user login with creds [{0},{1}]")
    public MyMainPage login(String userName, String password) {
        getElement(userNameField).sendKeys(userName);
        getElement(passwordField).sendKeys(password);
        getElement(loginButton).click();
        return new MyMainPage(driver);
    }

}
