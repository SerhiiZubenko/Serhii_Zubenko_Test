package pages;

import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage {
    private static final String CITY_INPUT_FIELD = "sb-destination-label-sr";
    private static final String CHECK_IN_INPUT = "//div[@data-mode='checkin']//span[@aria-hidden='true']";
    private static final String NEXT_MONTH_BUTTON = "//div[@class='bui-calendar__control bui-calendar__control--next']";
    private static final String CURRENT_MONTH_CHECK_IN = "(//div[@class='bui-calendar__month'])[2]";
    private static final String SELECT_DATE_CHECK_IN = "//span[@aria-label='1 December 2022']";
    private static final String SELECT_DATE_CHECK_OUT = "//span[@aria-label='30 December 2022']";
    private static final String SEARCH_BUTTON = "//button[@class='sb-searchbox__button ']";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickSearchButton() {
        driver.findElement(xpath(SEARCH_BUTTON)).click();
    }

    public void selectDate() {
        driver.findElement(xpath(CHECK_IN_INPUT)).click();

        for (int i = 1; i < 100; i++) {
            String month = "December 2022";
            if (driver.findElement(xpath(CURRENT_MONTH_CHECK_IN)).getText().equals(month))
                break;
            driver.findElement(xpath(NEXT_MONTH_BUTTON)).click();
        }
        driver.findElement(xpath(SELECT_DATE_CHECK_IN)).click();
        driver.findElement(xpath(SELECT_DATE_CHECK_OUT)).click();
    }

    public void enterCity(final String city) {
        driver.findElement(className(CITY_INPUT_FIELD)).sendKeys(city);
    }
}
