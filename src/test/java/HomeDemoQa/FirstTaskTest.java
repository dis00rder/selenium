package HomeDemoQa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTaskTest {



    @Test
    public void testClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get("https://demoqa.com/elements");
        driver.findElement(By.cssSelector("#item-4")).click();
      //  driver.findElement(By.xpath("//*[@id=\"item-4\"]/span")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button")).click();
        String text = driver.findElement(By.cssSelector("#dynamicClickMessage")).getText();

        Assert.assertEquals(text,"You have done a dynamic click");


//        driver.close();
//        driver.quit();

    }
}
