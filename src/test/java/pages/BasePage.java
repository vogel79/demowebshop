package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    private final By computers = By.xpath("//a[@href='/computers']");
    private final By desktops = By.xpath("//a[@title='Show products in category Desktops']");

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void getHomePage() {
        driver.get("http://demowebshop.tricentis.com/");
    }

    public ProductPage getProductPage() {
        driver.get("http://demowebshop.tricentis.com/build-your-own-expensive-computer-2");
        return new ProductPage(driver, wait);
    }

    public ProductPage getCategoryProduct() {
        driver.findElement(computers).click();
        driver.findElement(desktops).click();
        return new ProductPage(driver, wait);
    }
}
