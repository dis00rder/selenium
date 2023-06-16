package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends AbstractPageObject{

    private final By userNameField = By.cssSelector("#user-name");
    private final By passwordField = By.cssSelector("#password");
    private final By logInButton = By.cssSelector("#login-button");
    public LogInPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.saucedemo.com/");
    }

    @Step("The user logs in with creds [{0}, {1}]")
    public MainPage logIn(String userName, String password){
        getElement(userNameField).sendKeys(userName);
        getElement(passwordField).sendKeys(password);
        getElement(logInButton).click();
        return new MainPage(driver);
    }

}
