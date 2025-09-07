package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final String CATALOG_BUTTON = "//div[@class='ct-button']";
    private final String HOUSEHOLD_APPLIANCES_BUTTON = "(//a[@class='mm__a'])[5]";

    public WebElement catalogButton() {
        return visibilityofElementByXpath(CATALOG_BUTTON);
    }

    public WebElement householdAppliancesButton() {
        return visibilityofElementByXpath(HOUSEHOLD_APPLIANCES_BUTTON);
    }

    public void clickCatalogButton() {
        clickElement(catalogButton());
    }

    public void clickHouseholdAppliancesButton() {
        clickElement(householdAppliancesButton());
    }

    public boolean displayCatalogButton() {
        return displayElement(catalogButton());
    }

    public boolean displayHouseholdAppliancesButton() {
        return displayElement(householdAppliancesButton());
    }

}