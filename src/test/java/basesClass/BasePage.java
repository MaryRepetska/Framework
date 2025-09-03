package basesClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// ми будемо зберігати методи, які будуть взаємодіяти з нашою пейджею.(find element, click, sendkeys, getText).
//всі методи будуть абстрактні, ніякі значення передаватися туди не будуть.
// а будемо передавати потрібний тип даних в наші параметри методів,
// і потім передавати в ці методи потрібні нам значення, які будуть відпрацьовувати в нашому тесті
public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;


    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    public WebElement visibilityofElementByXpath( String locator){
      return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));



    }
}
