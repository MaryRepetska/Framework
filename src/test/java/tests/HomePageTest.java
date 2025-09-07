package tests;

import basesClass.TestInit;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import pages.SearchResultAirPodsPage;

public class HomePageTest extends TestInit {

    public String alloUrl = "https://allo.ua/";

    @Test
    public void checkCatalogButton() {

        HomePage homePage = new HomePage(driver);

        openUrl(alloUrl);

        Assert.assertTrue(homePage.displayCatalogButton());

    }

    @Test
    public void shouldNavigateToHouseholdAppliancesPage() {

        HomePage homePage = new HomePage(driver);
        HouseholdAppliancesPage householdAppliancesPage = new HouseholdAppliancesPage(driver);

        openUrl(alloUrl);

        homePage.clickCatalogButton();

        Assert.assertTrue(homePage.displayHouseholdAppliancesButton());

        homePage.clickHouseholdAppliancesButton();

        Assert.assertTrue(householdAppliancesPage.isExpectedFirstTitleHouseholdAppliancesDisplayed());

        String firstTitleText = householdAppliancesPage.getExpectedFirstTitleText();

        Assert.assertTrue(firstTitleText.contains("Побутова техніка"));

    }

    @Test
    public void verifyProductDetailsMatchAfterSearch() {

        HomePage homePage = new HomePage(driver);
        SearchResultAirPodsPage searchResultAirPodsPage = new SearchResultAirPodsPage(driver);
        GoodsPage goodsPage = new GoodsPage(driver);

        openUrl(alloUrl);

        String airPods = "AirPods 3";

        Assert.assertTrue(homePage.displayAlloLogo());

        homePage.enterValueInSearchInput(airPods);
        homePage.clickSearchButton();

        String actualNameFirstProductCard = searchResultAirPodsPage.getNameFirstAirPodsCard();
        Assert.assertTrue(actualNameFirstProductCard.contains("AirPods 3"));

        searchResultAirPodsPage.clickFirstProductCardAirPods();

        String expectedProductTitle = goodsPage.getNameProductHeaderTitle();
        Assert.assertEquals(actualNameFirstProductCard, expectedProductTitle);

    }

    @Test
    public void verifyCustomerMenuNavigationToDeliveryAndPayment() {

        HomePage homePage = new HomePage(driver);
        DeliveryAndPaymentPage deliveryAndPaymentPage = new DeliveryAndPaymentPage(driver);

        String headerTitle = "Доставка і оплата";
        String howToOrder = "Як оформити замовлення?";

        openUrl(alloUrl);

        Assert.assertTrue(homePage.displayCustomerButton());
        homePage.clickCustomerButton();

        Assert.assertTrue(homePage.displayDropDownMenu());

        Assert.assertTrue(homePage.displayDeliveryPaymentButton());
        homePage.clickDeliveryPaymentButton();

        String actualTextDeliveryAndPaymentHeaderTitle = deliveryAndPaymentPage.getNameDeliveryAndPayment();
        Assert.assertTrue(actualTextDeliveryAndPaymentHeaderTitle.contains(headerTitle));

        deliveryAndPaymentPage.displayHowToOrderTitle();

        String actualTextHowToOrderTitle = deliveryAndPaymentPage.getNameHowToOrderTitle();
        Assert.assertTrue(actualTextHowToOrderTitle.contains(howToOrder));
    }

}