package myPageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.List;

public class MyAbstractPageObject {
    private final static int DURATION_TO_WAIT_DEFAULT = 4;
    protected WebDriver driver;

    public MyAbstractPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By by, int waitForSec) {
        return new WebDriverWait(driver, Duration.ofSeconds(waitForSec))
                .until(ExpectedConditions.presenceOfElementLocated(by));

    }

    public WebElement getElement(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(DURATION_TO_WAIT_DEFAULT))
                .until(ExpectedConditions.presenceOfElementLocated(by));

    }

    public List<WebElement> getElements(By by, int waitForSec) {
        return new WebDriverWait(driver, Duration.ofSeconds(waitForSec))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));

    }

    public List<WebElement> getElements(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(DURATION_TO_WAIT_DEFAULT))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));

    }

    public void  waitTillAppears(By by, int waitForSec) {
         new WebDriverWait(driver, Duration.ofSeconds(waitForSec))
                .until(ExpectedConditions.presenceOfElementLocated(by));

    }

    public void  waitTillDisappears(By by) {
        new WebDriverWait(driver, Duration.ofSeconds(DURATION_TO_WAIT_DEFAULT))
                .until(ExpectedConditions.invisibilityOfElementLocated(by));

    }

}
