package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultAirPodsPage extends BasePage {

    public SearchResultAirPodsPage(WebDriver driver) {
        super(driver);
    }

    private final String FIRST_PRODUCT_CARD_TITLE_AIR_PODS = "(//a[@class='product-card__title'])[1]";

    public WebElement firstProductCardAirPods() {
        return visibilityOfElementByXpath(FIRST_PRODUCT_CARD_TITLE_AIR_PODS);
    }

    public String getNameFirstAirPodsCard() {
        return firstProductCardAirPods().getText();
    }

    public void clickFirstProductCardAirPods() {
        clickElement(firstProductCardAirPods());
    }

}