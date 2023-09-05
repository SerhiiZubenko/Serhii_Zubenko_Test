package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApartmentPage extends BasePage {

    private static final String CHECK_IN = "//div[@class='xp__dates-inner xp__dates__checkin']";
    private static final String CHECK_OUT = "//div[@class='xp__dates-inner xp__dates__checkout']";
    private static final String SHOW_MAP = "//a[@id='hotel_header']";
    private static final String HOTEL_NAME_ON_MAP = ".maps_iw__header_hotel_title a";
    private static final String HOTEL_NAME = "//*[@id='hp_hotel_name']";

    public ApartmentPage(WebDriver driver) {
        super(driver);
    }

    public String getHotelName() {
        return driver.findElement(By.xpath(HOTEL_NAME)).getText();
    }

    public WebElement waitNameOfHotel() {
        return driver.findElement(By.xpath(HOTEL_NAME));
    }

    public String getHotelNameOnMap() {
        return driver.findElement(By.cssSelector(HOTEL_NAME_ON_MAP)).getText();
    }

    public String getHotelNameOnMapElement() {
        return HOTEL_NAME_ON_MAP;
    }

    public void clickShowMap() {
        driver.findElement(By.xpath(SHOW_MAP)).click();
    }

    public String getCheckIn() {
        return driver.findElement(By.xpath(CHECK_IN)).getText();
    }

    public String getCheckOut() {
        return driver.findElement(By.xpath(CHECK_OUT)).getText();
    }
}
