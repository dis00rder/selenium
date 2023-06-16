package mytests;

import com.google.common.collect.Comparators;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import myPageobjects.MyLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LogInPage;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;

public class MySortTest extends MyBaseTest{

    private final static String NAME = "standard_user";
    private final static String PASS = "secret_sauce";



    @Test
    @Description(" Sorting Z-A")
    public void testLoginPositive(){

        List<WebElement> linkTitleElements = new MyLoginPage(driver)
                .login(NAME,PASS)
                .filter("Name (Z to A)")
                        .getLinkTitleElements();

        List<String> linkTitleText = linkTitleElements.stream().map(WebElement::getText).toList();

        boolean isSortedActual = Comparators.isInOrder(linkTitleText, Comparator.reverseOrder());
        Assert.assertTrue(isSortedActual,"Items are not sorted");

    }

}
