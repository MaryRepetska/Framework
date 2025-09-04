package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HouseholdAppliancesPage extends BasePage {

    public HouseholdAppliancesPage(WebDriver driver) {
        super(driver);
    }

    private final String FIRST_TITLE_ON_HOUSEHOLD_APPLIANCES_PAGE = "//h1[@class='v-catalog__title']";

    public WebElement expectedFirstTitleHouseholdAppliances() {
        return visibilityofElementByXpath(FIRST_TITLE_ON_HOUSEHOLD_APPLIANCES_PAGE);
    }

    public String getExpectedFirstTitleText() {
        return expectedFirstTitleHouseholdAppliances().getText();
    }

    public boolean displayExpectedFirstTitleHouseholdAppliances() {
        return displayElement(expectedFirstTitleHouseholdAppliances());
    }

}