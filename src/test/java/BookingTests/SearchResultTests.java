package BookingTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchResultTests extends BaseTests {

    private static final String CITY = "New York";
    private static final String CHECK_IN = "1 Dec";
    private static final String CHECK_OUT = "30 Dec";

    @Test
    public void checkChooseCityAndDate() {
        getHomePage().waitForPageLoadComplete(DEFAULT_TIMEOUT);
        getHomePage().enterCity(CITY);
        getHomePage().selectDate();
        getHomePage().clickSearchButton();
        Assert.assertTrue(getSearchResultPage().searchResultIsDisplayed());
    }

    @Test(dependsOnMethods = {"checkChooseCityAndDate"})
    public void checkSearchResultApartment() {
        for (WebElement webElement : getSearchResultPage().getSearchResultApartmentList()) {
            assertTrue(webElement.getText().contains(CITY));
        }
        for (WebElement webElement : getSearchResultPage().getListApartments()) {
            webElement.click();
            getSearchResultPage().switchBetweenWindows();
            assertTrue(getApartmentPage().getCheckIn().contains(CHECK_IN));
            assertTrue(getApartmentPage().getCheckOut().contains(CHECK_OUT));
            getApartmentPage().switchBetweenWindowsBack();
        }
    }

    @Test(dependsOnMethods = {"checkChooseCityAndDate"})
    public void checkingTheDisplayOfTheHotelOnTheMap() {
        getSearchResultPage().clickOnSeeAvailabilityButton();
        getSearchResultPage().switchBetweenWindows();
        getApartmentPage().waitForPageLoadComplete(DEFAULT_TIMEOUT);
        getApartmentPage().waitVisibilityOfElement(DEFAULT_TIMEOUT, getApartmentPage().waitNameOfHotel());
        String hotelName = getApartmentPage().getHotelName().replaceAll("Apartments\n", "");
        getApartmentPage().clickShowMap();
        getApartmentPage().explicitWait(By.cssSelector(getApartmentPage().getHotelNameOnMapElement()));
        assertTrue(getApartmentPage().getHotelNameOnMap().contains(hotelName));
    }
}
