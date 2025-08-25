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
    // 3 завдання
    @Test
    public void checkLogoDisplayed() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://allo.ua/");

        WebElement alloLogoDisplayed = driver.findElement(By.xpath("//a[@class='v-logo']"));

        Assert.assertTrue(alloLogoDisplayed.isDisplayed(), "Логотип allo відображається!");

        sleep(5000);

        WebElement searchMenu = driver.findElement(By.xpath("//input[@ id='search-form__input']"));

        searchMenu.sendKeys("AirPods 3");

        WebElement buttonLupa = driver.findElement(By.xpath("//button[@class='search-form__submit-button']"));

        buttonLupa.click();

        sleep(5000);

        WebElement firstItem = driver.findElement(By.xpath("(//a[@class='product-card__title' and contains(., 'AirPods 3')])[1]"));

        String actual = firstItem.getText();

        Assert.assertTrue(actual.contains("AirPods 3"));

        WebElement fullName = driver.findElement(By.xpath("(//a[@class='product-card__title'])[1]"));

        String name = fullName.getText();

        System.out.println(name);

        firstItem.click();

        sleep(5000);

        WebElement checkName = driver.findElement(By.xpath("//h1[@class='p-view__header-title']"));

        String checkEqualsName = checkName.getText();

        Assert.assertEquals(checkEqualsName, name);

        driver.quit();
    }
    // 4 завдання
    @Test
    public void checkHeaderButtons() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://allo.ua/");

        WebElement buttonPokupciamDisplayed = driver.findElement(By.xpath("//div[@class='mh-button__wrap']"));

        Assert.assertTrue(buttonPokupciamDisplayed.isDisplayed());

        sleep(5000);

        buttonPokupciamDisplayed.click();

        sleep(5000);

        WebElement dropDownMenuOpened = driver.findElement(By.xpath("//div[@class='mh-button__dropdown']"));

        Assert.assertTrue(dropDownMenuOpened.isDisplayed());

        WebElement buttonDostavkaiOplataDisplayed = driver.findElement(By.xpath("(//a[@class='mh-button'])[5]"));

        Assert.assertTrue(buttonDostavkaiOplataDisplayed.isDisplayed());

        buttonDostavkaiOplataDisplayed.click();

        WebElement checkTitleOplataiDostavka = driver.findElement(By.xpath("//h2[@class='sp-page-title sp-h2 page-header']"));

        String textOplataiDostavkaCheck = checkTitleOplataiDostavka.getText();

        //System.out.println(textOplataiDostavkaCheck);

        Assert.assertTrue(textOplataiDostavkaCheck.contains("Доставка і оплата"));

        WebElement yakOformytyZamovleniaDisplayed = driver.findElement(By.xpath("(//h3[@class='sub-block-header'])[1]"));

        Assert.assertTrue(yakOformytyZamovleniaDisplayed.isDisplayed());

        String checkyakOformytyZamovlenia = yakOformytyZamovleniaDisplayed.getText();

        Assert.assertTrue(checkyakOformytyZamovlenia.contains("Як оформити замовлення?"));

        driver.quit();

    }

}




