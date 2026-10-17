package context;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.OrderConfirmationPage;
import pages.PaymentPage;
import pages.ProductPage;
import pages.CartPage;
import pages.CheckoutPage;

public class TestContext {

    private WebDriver driver;
    private LoginPage loginPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private ProductPage productPage;
    private PaymentPage paymentPage;
    private OrderConfirmationPage orderConfirmationPage;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public CartPage getCartPage() {
        if (cartPage == null) {
            cartPage = new CartPage(driver);
        }
        return cartPage;
    }

    public CheckoutPage getCheckoutPage() {
        if (checkoutPage == null) {
            checkoutPage = new CheckoutPage(driver);
        }
        return checkoutPage;
    }

    public ProductPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductPage(driver);
        }
        return productPage;
    }

    public PaymentPage getPaymentPage() {
        if (paymentPage == null) {
            paymentPage = new PaymentPage(driver);
        }
        return paymentPage;
    }

    public OrderConfirmationPage getOrderConfirmationPage() {
        if (orderConfirmationPage == null) {
            orderConfirmationPage = new OrderConfirmationPage(driver);
        }
        return orderConfirmationPage;
    }
}
