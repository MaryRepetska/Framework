package homePageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class HomePageTest {

//    завдання 1
    @Test
    public void checkCatalogButtonDisplay() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://allo.ua/");

        WebElement catalogButtonLocator = driver.findElement(By.xpath("//div[@class='ct-button']"));

        Assert.assertTrue(catalogButtonLocator.isDisplayed());

        sleep(5000);

        driver.quit();

    }

//    завдання 2

    @Test
    public void checkCatalogButtonOpened() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://allo.ua/");

        WebElement catalogButtonLocator = driver.findElement(By.xpath("//div[@class='ct-button']"));

        catalogButtonLocator.click();

        WebElement buttonPobytovaTechnika = driver.findElement(By.xpath("//a[contains(., 'Побутова техніка')]"));

        buttonPobytovaTechnika.click();

        sleep(5000);

        driver.quit();

    }


}




