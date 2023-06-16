package HomeDemoQa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class SecondTaskTest {


    @Test
    public void testAddRecord() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/webtables");
        driver.findElement(By.cssSelector("#item-3")).click();
        driver.findElement(By.cssSelector("#addNewRecordButton")).click();
        driver.findElement(By.cssSelector("#firstName")).sendKeys("Dmytro");
        driver.findElement(By.cssSelector("#lastName")).sendKeys("lastName");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("1@1.com");
        driver.findElement(By.cssSelector("#age")).sendKeys("13");
        driver.findElement(By.cssSelector("#salary")).sendKeys("133");
        driver.findElement(By.cssSelector("#department")).sendKeys("Development");
        driver.findElement(By.cssSelector("#submit")).click();

        List<WebElement> newRecord = driver.findElements(By.xpath("//div[contains(text(),'Dmytro')]"));

        Assert.assertTrue(newRecord.size() > 0);

        driver.findElement(By.xpath("//div[contains(text(),'Dmytro')]/following-sibling::div//span[@class='mr-2']")).click();
        driver.findElement(By.cssSelector("#firstName")).clear();
        driver.findElement(By.cssSelector("#firstName")).sendKeys("Eugen");
        driver.findElement(By.cssSelector("#submit")).click();
        List<WebElement> newRecordEdited = driver.findElements(By.xpath("//div[contains(text(),'Eugen')]"));

        Assert.assertTrue(newRecordEdited.size() > 0);

        driver.close();
        driver.quit();

    }
}
