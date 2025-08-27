package homePageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static java.lang.Thread.sleep;

public class HomePageTest {
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://allo.ua/");

    }

    @Test
    public void checkCatalogButton() throws InterruptedException {

        sleep(5000);

        WebElement catalogButtonLocator = driver.findElement(By.xpath("//div[@class='ct-button']"));
        Assert.assertTrue(catalogButtonLocator.isDisplayed());

    }

    @Test
    public void checkPobytovaTechnikaButton() throws InterruptedException {

        WebElement catalogButtonLocator = driver.findElement(By.xpath("//div[@class='ct-button']"));
        catalogButtonLocator.click();

        sleep(5000);

        WebElement PobytovaTechnikaButton = driver.findElement(By.xpath("(//a[@class='mm__a'])[5]"));
        PobytovaTechnikaButton.click();

    }

    @Test
    public void checkProductDetailsAfterSearch() throws InterruptedException {

        WebElement alloLogo = driver.findElement(By.xpath("//a[@class='v-logo']"));
        Assert.assertTrue(alloLogo.isDisplayed(), "Логотип allo відображається!");

        sleep(5000);

        WebElement searchInput = driver.findElement(By.xpath("//input[@ id='search-form__input']"));
        searchInput.sendKeys("AirPods 3");

        WebElement searchButton = driver.findElement(By.xpath("//button[@class='search-form__submit-button']"));
        searchButton.click();

        sleep(5000);

        WebElement firstItemTitle = driver.findElement(By.xpath("(//a[@class='product-card__title' and contains(., 'AirPods 3')])[1]"));
        String actual = firstItemTitle.getText();
        Assert.assertTrue(actual.contains("AirPods 3"));

        WebElement expectedProductName = driver.findElement(By.xpath("(//a[@class='product-card__title'])[1]"));
        String expectedName = expectedProductName.getText();
        firstItemTitle.click();

        sleep(5000);

        WebElement productTitleOnPage = driver.findElement(By.xpath("//h1[@class='p-view__header-title']"));
        String actualProductName = productTitleOnPage.getText();
        Assert.assertEquals(actualProductName, expectedName);

    }

    @Test
    public void checkPokupciamHeaderButton() throws InterruptedException {

        WebElement PokupciamButton = driver.findElement(By.xpath("//div[@class='mh-button__wrap']"));
        Assert.assertTrue(PokupciamButton.isDisplayed());

        sleep(5000);

        PokupciamButton.click();

        sleep(5000);

        WebElement dropDownMenu = driver.findElement(By.xpath("//div[@class='mh-button__dropdown']"));
        Assert.assertTrue(dropDownMenu.isDisplayed());

        WebElement DostavkaiOplataButton = driver.findElement(By.xpath("(//a[@class='mh-button'])[5]"));
        Assert.assertTrue(DostavkaiOplataButton.isDisplayed());
        DostavkaiOplataButton.click();

        WebElement oplataiDostavkaTitleElement = driver.findElement(By.xpath("//h2[@class='sp-page-title sp-h2 page-header']"));
        String OplataiDostavkaTitleText = oplataiDostavkaTitleElement.getText();
        Assert.assertTrue(OplataiDostavkaTitleText.contains("Доставка і оплата"));

        WebElement yakOformytyZamovleniaTitle = driver.findElement(By.xpath("(//h3[@class='sub-block-header'])[1]"));
        Assert.assertTrue(yakOformytyZamovleniaTitle.isDisplayed());

        String checkyakOformytyZamovlenia = yakOformytyZamovleniaTitle.getText();
        Assert.assertTrue(checkyakOformytyZamovlenia.contains("Як оформити замовлення?"));

    }

    @AfterMethod
    public void close() {
        driver.quit();
    }

}




