package myPageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageobjects.MainPage;

import java.util.List;

public class MyMainPage extends MyAbstractPageObject{

    private final By title = By.cssSelector(".app_logo");
    private final By filterDropdown = By.cssSelector(".product_sort_container");
    private final By linkTitle = By.cssSelector("a div");

    public MyMainPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText(){
        return  getElement(title).getText();
    }

    public MyMainPage filter(String visibleText){
        Select select = new Select(getElement(filterDropdown));
        select.selectByVisibleText(visibleText);
        return  this;
    }

    public List<WebElement> getLinkTitleElements(){
                return  getElements(linkTitle);
    }
}
