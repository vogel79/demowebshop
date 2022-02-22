package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By products = By.xpath("//a[@class='product-name']");
    private final By priceOrderTotal = By.xpath("//span[@class='product-price order-total']");
    private final By removeFromCart = By.xpath("//input[@name='removefromcart']");
    private final By updateCart = By.xpath("//input[@name='updatecart']");
    private final By emptyCart = By.xpath("//div[@class='order-summary-content']");

    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    void waitElementIsVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public String getProductsInCart() {
        waitElementIsVisible(products);
        return driver.findElement(products).getText().trim();
    }

    public String getPriceOrderTotal() {
        return driver.findElement(priceOrderTotal).getText();
    }

    public void removeFromCart() {
        driver.findElements(removeFromCart).get(0).click();
        driver.findElement(updateCart).click();
    }

    public boolean emptyCart() {
        return driver.findElement(emptyCart).isDisplayed();
    }
}
