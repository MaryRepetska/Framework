package basesClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestInit {

    //public WebDriver driver;
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setUpDriver() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // 🧠 Додаємо аргументи, щоб браузер коректно працював у CI (GitHub Actions)
//        options.addArguments("--headless=new");            // запускає браузер без UI
        options.addArguments("--no-sandbox");              // потрібне для Linux runner'а
        options.addArguments("--disable-dev-shm-usage");   // уникає обмежень пам’яті
        options.addArguments("--disable-gpu");             // вимикає GPU-рендеринг
        options.addArguments("--window-size=1920,1080");   // фіксований розмір екрана
        options.addArguments("--incognito");
        //WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver(options);
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