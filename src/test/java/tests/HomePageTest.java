package tests;

import basesClass.TestInit;
import org.openqa.selenium.WebElement;
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

        Assert.assertTrue(homePage.catalogButtonDisplay());

    }

    @Test
    public void shouldNavigateToHouseholdAppliancesPage() {

        HomePage homePage = new HomePage(driver);
        HouseholdAppliancesPage householdAppliancesPage = new HouseholdAppliancesPage(driver);

        openUrl(alloUrl);

        homePage.clickCatalogButton();

        Assert.assertTrue(homePage.householdAppliancesButtonDisplay());

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

        Assert.assertTrue(homePage.alloLogoDisplay());

        homePage.enterValueInSearchInput(airPods);
        homePage.clickSearchButton();

        String expectedNameFirstProductCard = searchResultAirPodsPage.getNameFirstAirPodsCard();
        Assert.assertTrue(expectedNameFirstProductCard.contains("AirPods 3"));

        searchResultAirPodsPage.clickFirstProductCardAirPods();

        String actualProductTitle = goodsPage.getNameProductHeaderTitle();
        Assert.assertEquals(actualProductTitle, expectedNameFirstProductCard);

    }

    @Test
    public void verifyCustomerMenuNavigationToDeliveryAndPayment() {

        HomePage homePage = new HomePage(driver);
        DeliveryAndPaymentPage deliveryAndPaymentPage = new DeliveryAndPaymentPage(driver);

        String headerTitle = "Доставка і оплата";
        String howToOrder = "Як оформити замовлення?";

        openUrl(alloUrl);

        Assert.assertTrue(homePage.customerButtonDisplay());
        homePage.clickCustomerButton();

        Assert.assertTrue(homePage.dropDownMenuDisplay());

        Assert.assertTrue(homePage.deliveryPaymentButtonDisplay());
        homePage.clickDeliveryPaymentButton();

        String actualTextDeliveryAndPaymentHeaderTitle = deliveryAndPaymentPage.getNameDeliveryAndPayment();
        Assert.assertTrue(actualTextDeliveryAndPaymentHeaderTitle.contains(headerTitle));

        deliveryAndPaymentPage.displayHowToOrderTitle();

        String actualTextHowToOrderTitle = deliveryAndPaymentPage.getNameHowToOrderTitle();
        Assert.assertTrue(actualTextHowToOrderTitle.contains(howToOrder));
    }

    @Test
    public void checkResultSearchField() {

        HomePage homePage = new HomePage(driver);
        SearchResultSamsungTV searchResultSamsungTV = new SearchResultSamsungTV(driver);

        String samsungTV = "Телевізор Samsung";
        int expectedSizeProducts = 60;

        openUrl(alloUrl);

        homePage.enterValueInSearchInput(samsungTV);
        homePage.clickSearchButton();

        searchResultSamsungTV.viewModeButtonDisplayed();
        int sizeProducts = searchResultSamsungTV.searchedProductsNames().size();

        Assert.assertEquals(sizeProducts, expectedSizeProducts);

        for (WebElement element : searchResultSamsungTV.searchedProductsNames()) {
            Assert.assertTrue(element.getText().contains(samsungTV));
        }

    }

    @Test
    public void checkSamsungTVSearchCommentsCount() {

        HomePage homepage = new HomePage(driver);
        SearchResultSamsungTV searchResultSamsungTV = new SearchResultSamsungTV(driver);

        openUrl(alloUrl);

        String samsungTV = "Телевізор Samsung";
        int expectedNumberComments = 27;

        homepage.enterValueInSearchInput(samsungTV);
        homepage.clickSearchButton();

        searchResultSamsungTV.viewModeButtonDisplayed();

        for (WebElement element : searchResultSamsungTV.commentsNumberButton()){
            String numberComments = element.getText();
            int number = Integer.parseInt(numberComments);
            if (number > expectedNumberComments) {
                System.out.println(number);
            }
        }
    }

}