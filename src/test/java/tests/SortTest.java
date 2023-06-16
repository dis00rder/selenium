package tests;

import com.google.common.collect.Comparators;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LogInPage;

import java.util.Comparator;
import java.util.List;

public class SortTest extends BaseTest {
    private final static String NAME = "standard_user";
    private final static String PASS = "secret_sauce";

    @Test
    @Description("The test is checking that reverse order sorting works fine")
    public void testReverseSortTest() {
        List<WebElement> linkTitleElements = new LogInPage(driver)
                .logIn(NAME, PASS)
                .sort("Name (Z to A)")
                .getLinkTitleElements();

        List<String> linkTitleTexts = linkTitleElements.stream().map(WebElement::getText).toList();

        boolean isSortedActual = Comparators.isInOrder(linkTitleTexts, Comparator.reverseOrder());

        Assert.assertTrue(isSortedActual, "The items were not sorted");
    }

}
