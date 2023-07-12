package mytests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ConfigurationNotInvokedException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


@Test

public class LoginSelenideTest {

    @BeforeTest
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.headless = true;
    }

    public void testLoginPagePos() {

        Selenide.open("https://www.saucedemo.com/");
        $(".login_logo").shouldBe(Condition.visible);
        $(".login_logo").shouldHave(Condition.text("Swag Labs"));
    }

    public void testLoginPos() {

        Selenide.open("https://www.saucedemo.com/");
        $("#user-name").sendKeys("standard_user");
        $("#password").sendKeys("secret_sauce");
        $("#login-button").click();
        $(".shopping_cart_link").shouldBe(Condition.visible);
    }

    public void testLoginNeg() {

        Selenide.open("https://www.saucedemo.com/");
        $("#user-name").sendKeys("standard_user");
        $("#password").sendKeys("secret_sauce1");
        $("#login-button").click();

        $(".error-button").shouldBe(Condition.visible);
        Assert.assertEquals($x("//*[@id=\"login_button_container\"]/div/form/div[3]/h3").getText(),
                "Epic sadface: Username and password do not match any user in this service");

    }
}
