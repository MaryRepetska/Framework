package basesClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestInit {

    //public WebDriver driver;
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setUpDriver() {
        //WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        driver.set(webDriver);
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void closeBrowser() {getDriver().quit();
        driver.remove();

    }
    public void openUrl(String url) {
        getDriver().get(url);
    }
}