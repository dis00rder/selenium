package mytests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.ConfigurationNotInvokedException;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Test
public class LoginSelenideTest {


    public void testLoginPagePos() {
        Configuration.browser = "chrome";
        Configuration.headless = true;

        Selenide.open("https://www.saucedemo.com/");
        $(".login_logo").shouldBe(Condition.visible);
        $(".login_logo").shouldHave(Condition.text("Swag Labs"));


    }

    public void testLoginPos() {
        Configuration.browser = "chrome";
        Configuration.headless = true;

        Selenide.open("https://www.saucedemo.com/");
        $("#user-name").sendKeys("standard_user");
        $("#password").sendKeys("secret_sauce");
        $("#login-button").click();

        $(".shopping_cart_link").shouldBe(Condition.visible);

    }

    public void testLoginNeg() {
        Configuration.browser = "chrome";
        Configuration.headless = true;

        Selenide.open("https://www.saucedemo.com/");
        $("#user-name").sendKeys("standard_user");
        $("#password").sendKeys("secret_sauce1");
        $("#login-button").click();


        $(".error-button").shouldBe(Condition.visible);
        $x("//*[@id=\"login_button_container\"]/div/form/div[3]/h3/text()");


    }

}
