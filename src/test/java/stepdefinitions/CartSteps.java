package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CartPage;

public class CartSteps {

    private final TestContext testContext;
    private final CartPage cartPage;

    public CartSteps(TestContext testContext) {
        this.testContext = testContext;
        this.cartPage = testContext.getCartPage();
    }

    @Given("User has added {string} to the cart")
    public void user_has_added_to_the_cart(String productName) {
        Assert.assertEquals(testContext.getCartPage().checkCartItem(), productName);
    }

    @When("User opens the cart")
    public void user_opens_the_cart() {
        cartPage.checkCartItem();
    }

    @Then("The cart page title should be {string}")
    public void the_cart_page_title_should_be(String expectedTitle) {
        Assert.assertEquals(cartPage.getCartTitle(), expectedTitle);
    }

    @Then("The cart should display {string}")
    public void the_cart_should_display(String productName) {
        Assert.assertEquals(cartPage.checkCartItem(), productName);
    }

    @When("User clicks on Checkout")
    public void user_clicks_on_checkout() {
        cartPage.clickCheckoutBtn();
    }

    @Then("User should be navigated to the Checkout page")
    public void user_should_be_navigated_to_the_checkout_page() {
        // validated in CheckoutSteps
    }
}
