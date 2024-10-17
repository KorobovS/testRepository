package automatenow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestHomePage {
    WebDriver driver;

    @BeforeTest
    public void getDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automatenow.io/");
    }

    @AfterTest
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testPageTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "automateNow | The Best FREE Software Online Training Platform");
    }

    @Test
    public void testGreeting() {
        WebElement element = driver.findElement(By.xpath("//h2[@class='wp-block-heading']"));
        String greeting = element.getText();
        Assert.assertTrue(greeting.contains("Start"));
    }
}
