package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultSamsungTV extends BasePage {

    public SearchResultSamsungTV(WebDriver driver) {
        super(driver);
    }

    private final String VIEW_MODE_BUTTON = "//button[@class='view-mode__button'and @title='Таблиця']";
    private final String SEARCHED_PRODUCTS_NAMES = "//div[@class='product-card__content']/a[@class='product-card__title']";
    private final String COMMENTS_NUMBER_BUTTON = "//span[@class='review-button__text review-button__text--count']";

    public WebElement viewModeButton() {
        return visibilityOfElementByXpath(VIEW_MODE_BUTTON);
    }

    public List<WebElement> searchedProductsNames() {
        return visibilityOfElementsByXpath(SEARCHED_PRODUCTS_NAMES);
    }

    public List<WebElement> commentsNumberButton() {
        return visibilityOfElementsByXpath(COMMENTS_NUMBER_BUTTON);
    }

    public boolean viewModeButtonDisplayed() {
        return displayElement(viewModeButton());

    }


}
