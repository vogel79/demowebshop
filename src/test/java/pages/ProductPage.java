package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;

public class ProductPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By setDisplay = By.xpath("//select[@id='products-pagesize']");
    private final By orderBy = By.xpath("//select[@id='products-orderby']");
    private final By productBox = By.xpath("//div[@class='item-box']");
    private final By close = By.xpath("//span[@class='close']");
    private final By cart = By.xpath("//input[@value='Add to cart']");
    private final By addToCart = By.xpath("//input[@id='add-to-cart-button-74']");
    private final By cartLabel = By.xpath("//span[@class='cart-label']");
    private final By processorFast = By.xpath("//input[@id='product_attribute_74_5_26_82']");
    private final By ram8Gb = By.xpath("//input[@id='product_attribute_74_6_27_85']");
    private final By imageViewer = By.xpath("//input[@id='product_attribute_74_8_29_88']");
    private final By officeSuite = By.xpath("//input[@id='product_attribute_74_8_29_89']");
    private final By otherOfficeSuite = By.xpath("//input[@id='product_attribute_74_8_29_90']");
    private final By processorFastLabel = By.xpath(".//label[contains(text(),'Fast  [+100.00]')]");
    private final By ram8GbLabel = By.xpath(".//label[contains(text(),'8GB')]");
    private final By imageViewerLabel = By.xpath(".//label[contains(text(),'Image Viewer  [+5.00]')]");
    private final By officeSuiteLabel = By.xpath(".//label[contains(text(),'Office Suite  [+100.00]')]");
    private final By otherOfficeSuiteLabel = By.xpath(".//label[contains(text(),'Other Office Suite  [+40.00]')]");
    private final By productName = By.xpath("//h1[@itemprop='name']");
    private final By productPrice = By.xpath("//span[@itemprop='price']");
    private final By qty = By.xpath("//span[@class='cart-qty']");

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    void waitElementIsVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    void waitElementIsClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public int getProductsOnPage() {
        List<WebElement> products;
        waitElementIsVisible(productBox);
        products = driver.findElements(productBox);
        return products.size();
    }

    public void setDisplay() {
        Select display = new Select(driver.findElement(setDisplay));
        display.selectByIndex(0);
    }

    public void setSortBy() {
        Select display = new Select(driver.findElement(orderBy));
        display.selectByIndex(4);
    }

    public void selectProcessorFast() {
        driver.findElement(processorFast).click();
    }

    public void selectRAM8Gb() {
        driver.findElement(ram8Gb).click();
    }

    public void selectSoftware() {
        driver.findElement(imageViewer).click();
        driver.findElement(officeSuite).click();
        driver.findElement(otherOfficeSuite).click();
    }

    public void addToCart() {
        waitElementIsVisible(cart);
        driver.findElement(cart).click();
        waitElementIsVisible(addToCart);
        driver.findElement(addToCart).click();
        waitElementIsClickable(close);
        driver.findElement(close).click();
    }

    public CartPage openCart() {
        driver.findElement(cartLabel).click();
        return new CartPage(driver, wait);
    }

    public boolean checkCart() {
        WebElement webElement = driver.findElement(qty);
        String qtyString = webElement.getText().replaceAll("[()]", "");
        int qty = Integer.parseInt(qtyString);
        return qty > 0;
    }

    public String getProductName() {
        return driver.findElement(productName).getText().trim();
    }

    public String getProductPrice() {
        WebElement price = driver.findElement(productPrice);
        return price.getText().trim();
    }

    public String getProcPrice() {
        WebElement price = driver.findElement(processorFastLabel);
        return price.getText().replaceAll("[^\\d.]+", "");
    }

    public String getRAM8GBPrice() {
        WebElement price = driver.findElement(ram8GbLabel);
        return price.getText().replaceAll("8[^\\d]+", "").replace("]", "");
    }

    public String getImageViewer() {
        WebElement price = driver.findElement(imageViewerLabel);
        return price.getText().replaceAll("[^\\d.]+", "");
    }

    public String getOfficeSuite() {
        WebElement price = driver.findElement(officeSuiteLabel);
        return price.getText().replaceAll("[^\\d.]+", "");
    }

    public String getOtherOfficeSuite() {
        WebElement price = driver.findElement(otherOfficeSuiteLabel);
        return price.getText().replaceAll("[^\\d.]+", "");
    }

    public String getPriceOrderTotal() {
        double totalPrice = Double.parseDouble(getProductPrice()) + Double.parseDouble(getProcPrice()) +
            Double.parseDouble(getRAM8GBPrice()) + Double.parseDouble(getImageViewer()) +
            Double.parseDouble(getOfficeSuite()) + Double.parseDouble(getOtherOfficeSuite());
        return String.format(Locale.ROOT, "%.2f", totalPrice);
    }
}
