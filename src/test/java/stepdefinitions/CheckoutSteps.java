package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CheckoutPage;

public class CheckoutSteps {

    private final TestContext testContext;
    private final CheckoutPage checkoutPage;

    public CheckoutSteps(TestContext testContext) {
        this.testContext = testContext;
        this.checkoutPage = testContext.getCheckoutPage();
    }

    @Given("User has opened the Checkout page")
    public void user_has_opened_the_checkout_page() {
        Assert.assertEquals(checkoutPage.getTitle(), "Checkout: Your Information");
    }

    @Then("The Checkout page title should be {string}")
    public void the_checkout_page_title_should_be(String expectedTitle) {
        Assert.assertEquals(checkoutPage.getTitle(), expectedTitle);
    }

    @When("User enters first name {string}")
    public void user_enters_first_name(String fname) {
        checkoutPage.enterfName(fname);
    }

    @When("User enters last name {string}")
    public void user_enters_last_name(String lname) {
        checkoutPage.enterlName(lname);
    }

    @When("User enters postal code {string}")
    public void user_enters_postal_code(String postCode) {
        checkoutPage.enterPostalCode(postCode);
    }

    @When("User clicks Continue")
    public void user_clicks_continue() {
        checkoutPage.clickContinueBtn();
    }

    @Then("User should be navigated to the Payment page")
    public void user_should_be_navigated_to_the_payment_page() {
        // validated in PaymentSteps
    }
    
}
