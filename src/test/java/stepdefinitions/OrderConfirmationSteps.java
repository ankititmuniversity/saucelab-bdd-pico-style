package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.OrderConfirmationPage;

public class OrderConfirmationSteps {

    private final TestContext testContext;
    private final OrderConfirmationPage orderConfirmationPage;

    public OrderConfirmationSteps(TestContext testContext) {
        this.testContext = testContext;
        this.orderConfirmationPage = testContext.getOrderConfirmationPage();
    }

    @Given("User has opened the Order Confirmation page")
    public void user_has_opened_the_order_confirmation_page() {
        Assert.assertEquals(orderConfirmationPage.getTitle(), "Checkout: Complete!");
    }

    @Then("The Order Confirmation page title should be {string}")
    public void the_order_confirmation_page_title_should_be(String expectedTitle) {
        Assert.assertEquals(orderConfirmationPage.getTitle(), expectedTitle);
    }

    @Then("User should see {string} message")
    public void user_should_see_message(String expectedMessage) {
        Assert.assertEquals(orderConfirmationPage.getWelcomeMsg(), expectedMessage);
    }

    @When("User clicks Back to Home")
    public void user_clicks_back_to_home() {
        orderConfirmationPage.clickBackBtn();
    }

    @Then("User should be navigated back to the Products page")
    public void user_should_be_navigated_back_to_the_products_page() {
        // validated in ProductSteps
    }
}
