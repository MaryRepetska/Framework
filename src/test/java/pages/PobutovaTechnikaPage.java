package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PobutovaTechnikaPage extends BasePage {
    public PobutovaTechnikaPage(WebDriver driver) {
        super(driver);

    }

private final String EXPECTED_FIRST_ITEM_POBUTOVA_TECHNIKA = "//h1[@class='v-catalog__title']";

    public WebElement expectedFirstItemPobutovaTechnika(){
        return visibilityofElementByXpath(EXPECTED_FIRST_ITEM_POBUTOVA_TECHNIKA);

    }
    public String getNameExpectedFirstItem(){
        return expectedFirstItemPobutovaTechnika().getText();

    }
}
