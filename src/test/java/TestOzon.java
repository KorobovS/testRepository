import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TestOzon {

    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void robot() {
        driver.get("https://www.ozon.ru");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.id("reload-button")).click();
    }

    @BeforeMethod
    public void getDriver() {
        driver.manage().window().maximize();
    }


    @Test(priority = 0)
    public void searchTest() {
        driver.get("https://www.ozon.ru");
//        WebElement search = driver.findElement(By.cssSelector(".ha0a_32.tsBody500Medium"));
//        WebElement search = driver.findElement(By.className("ha0a_32"));
//        WebElement search = driver.findElement(By.xpath("html/body/div/div/div/header/div/div/div/div/div/form/div/div/input"));
//        WebElement search = driver.findElement(By.xpath("//form/div/div/input"));
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Искать на Ozon']"));
        search.sendKeys("жилетка мужская");
        search.sendKeys(Keys.ENTER);
        Assert.assertEquals(driver.getTitle(), "жилетка мужская - купить на OZON");
    }

    @Test(priority = 1)
    public void putInBasket() {
        driver.get("https://www.ozon.ru/product/zhilet-uteplennyy-sheridi-shop-1136008418");
        driver.findElement(By.xpath("//div[@class='l7t_27 u0l_27']//button[@class='k3v_27 b2115-a0 b2115-b2 b2115-a4']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//div[@class='l7t_27 u0l_27']//div[@class='b2115-a']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertEquals(driver.getTitle(), "OZON.ru - Моя корзина");
    }

//    @AfterMethod
//    public void closeBrowser() {
//        driver.close();
//    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }

}

/*
Вопросы
1. xPath по классу с несколькими классами
2. Как работает close и quit
3. Запускаю через testng (priority указал) - работает. Запускаю через maven - не работает. Разные потоки?
 */