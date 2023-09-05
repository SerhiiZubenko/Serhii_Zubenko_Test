package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class SearchResultPage extends BasePage {
    private static final String SEARCH_RESULT = "//h1[contains(text(), 'New York')]";
    private static final String SEARCH_RESULT_ADDRESS_APARTMENT = "//span[@data-testid='address']";
    private static final String NAME_OF_APARTMENT = "//div[@data-testid='title']";
    private static final String SEE_AVAILABILITY_BUTTON = "(//div[@data-testid='availability-cta'])[1]";

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSeeAvailabilityButton() {
        driver.findElement(xpath(SEE_AVAILABILITY_BUTTON)).click();
    }

    public List<WebElement> getListApartments() {
        return driver.findElements(xpath(NAME_OF_APARTMENT));
    }

    public List<WebElement> getSearchResultApartmentList() {
        return driver.findElements(xpath(SEARCH_RESULT_ADDRESS_APARTMENT));
    }

    public boolean searchResultIsDisplayed() {
        return driver.findElement(xpath(SEARCH_RESULT)).isDisplayed();
    }
}
