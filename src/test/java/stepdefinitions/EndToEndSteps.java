//package stepdefinitions;
//
//import context.TestContext;
//import io.cucumber.java.en.*;
//import org.testng.Assert;
//import pages.*;
//
//public class EndToEndSteps {
//
//    private final TestContext testContext;
//    private final LoginPage loginPage;
//    private final ProductPage productPage;
//    private final CartPage cartPage;
//    private final CheckoutPage checkoutPage;
//    private final PaymentPage paymentPage;
//    private final OrderConfirmationPage orderConfirmationPage;
//
//    public EndToEndSteps(TestContext testContext) {
//        this.testContext = testContext;
//        this.loginPage = testContext.getLoginPage();
//        this.productPage = testContext.getProductPage();
//        this.cartPage = testContext.getCartPage();
//        this.checkoutPage = testContext.getCheckoutPage();
//        this.paymentPage = testContext.getPaymentPage();
//        this.orderConfirmationPage = testContext.getOrderConfirmationPage();
//    }
//
//    // Login
//    @Given("User is on the login page")
//    public void user_is_on_the_login_page() {
//        testContext.getDriver().get("https://www.saucedemo.com/");
//    }
//
//    @When("User enters username {string} and password {string}")
//    public void user_enters_username_and_password(String username, String password) {
//        loginPage.enterUsername(username);
//        loginPage.enterPassword(password);
//    }
//
//    @When("User clicks on the login button")
//    public void user_clicks_on_the_login_button() {
//        loginPage.clickLoginBtn();
//    }
//
//    @Then("User is logged in")
//    public void user_is_logged_in() {
//        Assert.assertEquals(productPage.getPageTitle(), "Products");
//    }
//
//    @Then("The page title should be {string}")
//    public void the_page_title_should_be(String expectedTitle) {
//        Assert.assertEquals(productPage.getPageTitle(), expectedTitle);
//    }
//
//    // Product
//    @When("User views the product {string}")
//    public void user_views_the_product(String productName) {
//        Assert.assertEquals(productPage.getInventoryItem(), productName);
//    }
//
//    @When("User clicks on Add to Cart")
//    public void user_clicks_on_add_to_cart() {
//        productPage.addToCart();
//    }
//
//    @When("User clicks on the cart icon")
//    public void user_clicks_on_the_cart_icon() {
//        productPage.clickOnCartBtn();
//    }
//
//    // Cart
//    @Then("The cart page title should be {string}")
//    public void the_cart_page_title_should_be(String expectedTitle) {
//        Assert.assertEquals(cartPage.getCartTitle(), expectedTitle);
//    }
//
//    @Then("The cart should display {string}")
//    public void the_cart_should_display(String productName) {
//        Assert.assertEquals(cartPage.checkCartItem(), productName);
//    }
//
//    @When("User clicks on Checkout")
//    public void user_clicks_on_checkout() {
//        cartPage.clickCheckoutBtn();
//    }
//
//    // Checkout
//    @Then("User is on the Checkout page")
//    public void user_is_on_the_checkout_page() {
//        Assert.assertEquals(checkoutPage.getTitle(), "Checkout: Your Information");
//    }
//
//    @When("User enters first name {string}")
//    public void user_enters_first_name(String fname) {
//        checkoutPage.enterfName(fname);
//    }
//
//    @When("User enters last name {string}")
//    public void user_enters_last_name(String lname) {
//        checkoutPage.enterlName(lname);
//    }
//
//    @When("User enters postal code {string}")
//    public void user_enters_postal_code(String postCode) {
//        checkoutPage.enterPostalCode(postCode);
//    }
//
//    @When("User clicks Continue")
//    public void user_clicks_continue() {
//        checkoutPage.clickContinueBtn();
//    }
//
//    // Payment
//    @Then("User is on the Payment page")
//    public void user_is_on_the_payment_page() {
//        Assert.assertEquals(paymentPage.getTitle(), "Checkout: Overview");
//    }
//
//    @Then("User should see payment info")
//    public void user_should_see_payment_info() {
//        Assert.assertFalse(paymentPage.getPaymentInfo().isEmpty());
//    }
//
//    @Then("User should see shipping info")
//    public void user_should_see_shipping_info() {
//        Assert.assertFalse(paymentPage.getShippingInfo().isEmpty());
//    }
//
//    @Then("User should see subtotal and total")
//    public void user_should_see_subtotal_and_total() {
//        Assert.assertFalse(paymentPage.getsubTotalInfo().isEmpty());
//        Assert.assertFalse(paymentPage.getTotalInfo().isEmpty());
//    }
//
//    @When("User clicks Finish")
//    public void user_clicks_finish() {
//        paymentPage.clickFinishBtn();
//    }
//
//    // Order Confirmation
//    @Then("User is on the Order Confirmation page")
//    public void user_is_on_the_order_confirmation_page() {
//        Assert.assertEquals(orderConfirmationPage.getTitle(), "Checkout: Complete!");
//    }
//
//    @Then("User should see {string} title")
//    public void user_should_see_title(String expectedTitle) {
//        Assert.assertEquals(orderConfirmationPage.getTitle(), expectedTitle);
//    }
//
//    @Then("User should see {string} message")
//    public void user_should_see_message(String expectedMessage) {
//        Assert.assertEquals(orderConfirmationPage.getWelcomeMsg(), expectedMessage);
//    }
//
//    @When("User clicks Back to Home")
//    public void user_clicks_back_to_home() {
//        orderConfirmationPage.clickBackBtn();
//    }
//
//    @Then("User should be navigated back to the Product page")
//    public void user_should_be_navigated_back_to_the_product_page() {
//        Assert.assertEquals(productPage.getPageTitle(), "Products");
//    }
//}
