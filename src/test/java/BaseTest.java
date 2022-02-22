import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected BasePage homePage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        //  System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
        driver = new ChromeDriver();
        //   driver = new SafariDriver();

        wait = new WebDriverWait(driver, 10);
        homePage = new BasePage(driver, wait);
        //  driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
}
