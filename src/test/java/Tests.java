import org.junit.Assert;
import org.junit.Test;
import pages.CartPage;
import pages.ProductPage;

public class Tests extends BaseTest {

    static final int PRODUCTS_PER_PAGE = 4;
    static final String COMPUTER = "Build your own expensive computer";

    @Test
    public void addProductToCart() {
        homePage.getHomePage();
        ProductPage productPage = homePage.getCategoryProduct();
        productPage.setDisplay();
        productPage.setSortBy();
        int productsPerPage = productPage.getProductsOnPage();
        Assert.assertEquals(PRODUCTS_PER_PAGE, productsPerPage);
        productPage.addToCart();
        CartPage cartPage = productPage.openCart();
        String productNameInCart = cartPage.getProductsInCart();
        Assert.assertEquals(COMPUTER, productNameInCart);
    }

    @Test
    public void removeProductFromCart() {
        ProductPage productPage = homePage.getProductPage();
        String priceOrderTotal = productPage.getPriceOrderTotal();
        productPage.selectProcessorFast();
        productPage.selectRAM8Gb();
        productPage.selectSoftware();
        productPage.addToCart();
        Assert.assertTrue(productPage.checkCart());
        String productName = productPage.getProductName();
        CartPage cartPage = productPage.openCart();
        Assert.assertEquals(productName, cartPage.getProductsInCart());
        // Assert.assertEquals("2105.00", cartPage.getPriceOrderTotal());
        Assert.assertEquals(priceOrderTotal, cartPage.getPriceOrderTotal());
        cartPage.removeFromCart();
        Assert.assertTrue(cartPage.emptyCart());
    }
}
