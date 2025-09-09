package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeliveryAndPaymentPage extends BasePage {

    public DeliveryAndPaymentPage(WebDriver driver) {
        super(driver);
    }

    private final String DELIVERY_AND_PAYMENT_HEADER_TITLE = "//h2[@class='sp-page-title sp-h2 page-header']";
    private final String HOW_TO_ORDER_TITLE = "(//h3[@class='sub-block-header'])[1]";

    public WebElement deliveryAndPayment() {
        return visibilityOfElementByXpath(DELIVERY_AND_PAYMENT_HEADER_TITLE);
    }

    public WebElement howToOrderTitle() {
        return visibilityOfElementByXpath(HOW_TO_ORDER_TITLE);
    }

    public String getNameDeliveryAndPayment() {
        return deliveryAndPayment().getText();
    }

    public boolean displayHowToOrderTitle() {
        return displayElement(howToOrderTitle());
    }

    public String getNameHowToOrderTitle() {
        return howToOrderTitle().getText();
    }

}