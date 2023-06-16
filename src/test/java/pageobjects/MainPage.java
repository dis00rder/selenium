package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MainPage extends AbstractPageObject{
    private final By title = By.cssSelector(".app_logo");
    private final By filterDropDown = By.cssSelector(".product_sort_container");
    private final By linkTitle = By.cssSelector("a div");
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText(){
        return getElement(title).getText();
    }

    public MainPage sort(String visibleText){
        Select select = new Select(getElement(filterDropDown));
        select.selectByVisibleText(visibleText);
        return this;
    }

    public List<WebElement> getLinkTitleElements(){
        return getElements(linkTitle);
    }
}
