package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final String CATALOG_BUTTON = "//div[@class='ct-button']";
    private final String POBYTOBATECHNIKA_BUTTON = "(//a[@class='mm__a'])[5]";


    public WebElement catalogButton() {
        return visibilityofElementByXpath(CATALOG_BUTTON);
    }

    public WebElement pobytovaTechnikaButton() {
        return visibilityofElementByXpath(POBYTOBATECHNIKA_BUTTON);

    }

    public void catalogButtonClick() {
        catalogButton().click();
    }

    public void pobytovaTechnikaButtonClick(){
        pobytovaTechnikaButton().click();

    }

}
