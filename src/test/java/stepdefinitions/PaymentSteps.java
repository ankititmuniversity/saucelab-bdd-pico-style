package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.PaymentPage;

public class PaymentSteps {

    private final TestContext testContext;
    private final PaymentPage paymentPage;

    public PaymentSteps(TestContext testContext) {
        this.testContext = testContext;
        this.paymentPage = testContext.getPaymentPage();
    }

    @Given("User has opened the Payment page")
    public void user_has_opened_the_payment_page() {
        Assert.assertEquals(paymentPage.getTitle(), "Checkout: Overview");
    }

    @Then("The Payment page title should be {string}")
    public void the_payment_page_title_should_be(String expectedTitle) {
        Assert.assertEquals(paymentPage.getTitle(), expectedTitle);
    }

    @Then("User should see payment info")
    public void user_should_see_payment_info() {
        Assert.assertFalse(paymentPage.getPaymentInfo().isEmpty());
    }

    @Then("User should see shipping info")
    public void user_should_see_shipping_info() {
        Assert.assertFalse(paymentPage.getShippingInfo().isEmpty());
    }

    @Then("User should see subtotal and total")
    public void user_should_see_subtotal_and_total() {
        Assert.assertFalse(paymentPage.getsubTotalInfo().isEmpty());
        Assert.assertFalse(paymentPage.getTotalInfo().isEmpty());
    }

    @When("User clicks Finish")
    public void user_clicks_finish() {
        paymentPage.clickFinishBtn();
    }

    @Then("User should be navigated to the Order Confirmation page")
    public void user_should_be_navigated_to_the_order_confirmation_page() {
        // validated in OrderConfirmationSteps
    }
}
