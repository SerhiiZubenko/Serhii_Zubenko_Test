package BookingTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.ApartmentPage;
import pages.HomePage;
import pages.SearchResultPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTests {

    private WebDriver driver;
    protected final long DEFAULT_TIMEOUT = 500;
    private static final String BOOKING_URL = "https://www.booking.com/index.en-gb.html";

    @BeforeTest
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BOOKING_URL);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public ApartmentPage getApartmentPage() {
        return new ApartmentPage(getWebDriver());
    }

    public HomePage getHomePage() {
        return new HomePage(getWebDriver());
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(getWebDriver());
    }
}
