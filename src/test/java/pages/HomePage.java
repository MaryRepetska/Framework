package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final String ALLO_LOGO = "//a[@class='v-logo']";
    private final String CATALOG_BUTTON = "//div[@class='ct-button']";
    private final String HOUSEHOLD_APPLIANCES_BUTTON = "(//a[@class='mm__a'])[5]";
    private final String SEARCH_INPUT = "//input[@ id='search-form__input']";
    private final String SEARCH_BUTTON = "//button[@class='search-form__submit-button']";
    private final String CUSTOMER_BUTTON = "//div[@class='mh-button__wrap']";
    private final String DROP_DOWN_MENU = "//div[@class='mh-button__dropdown']";
    private final String DELIVERY_PAYMENT_BUTTON = "(//a[@class='mh-button'])[5]";


    public WebElement alloLogo() {
        return visibilityOfElementByXpath(ALLO_LOGO);
    }

    public WebElement catalogButton() {
        return visibilityOfElementByXpath(CATALOG_BUTTON);
    }

    public WebElement householdAppliancesButton() {
        return visibilityOfElementByXpath(HOUSEHOLD_APPLIANCES_BUTTON);
    }

    public WebElement searchInput() {
        return visibilityOfElementByXpath(SEARCH_INPUT);
    }

    public WebElement searchButton() {
        return visibilityOfElementByXpath(SEARCH_BUTTON);
    }

    public WebElement customerButton() {
        return visibilityOfElementByXpath(CUSTOMER_BUTTON);
    }

    public WebElement dropDownMenu() {
        return visibilityOfElementByXpath(DROP_DOWN_MENU);
    }

    public WebElement deliveryPaymentButton() {
        return visibilityOfElementByXpath(DELIVERY_PAYMENT_BUTTON);
    }

    public boolean displayAlloLogo() {
        return displayElement(alloLogo());
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

    public void enterValueInSearchInput(String value) {
        searchInput().sendKeys(value);
    }

    public void clickSearchButton() {
        clickElement(searchButton());
    }

    public boolean displayCustomerButton() {
        return displayElement(customerButton());
    }

    public void clickCustomerButton() {
        clickElement(customerButton());
    }

    public boolean displayDropDownMenu() {
        return displayElement(dropDownMenu());
    }

    public boolean displayDeliveryPaymentButton() {
        return displayElement(deliveryPaymentButton());
    }

    public void clickDeliveryPaymentButton() {
        clickElement(deliveryPaymentButton());
    }

}