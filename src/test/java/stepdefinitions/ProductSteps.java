package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.ProductPage;

public class ProductSteps {

    private final TestContext testContext;
    private final ProductPage productPage;

    public ProductSteps(TestContext testContext) {
        this.testContext = testContext;
        this.productPage = testContext.getProductPage();
    }

    @Then("The Products page title should be {string}")
    public void the_products_page_title_should_be(String expectedTitle) {
        Assert.assertEquals(productPage.getPageTitle(), expectedTitle);
    }

    @When("User views the product {string}")
    public void user_views_the_product(String productName) {
        Assert.assertEquals(productPage.getInventoryItem(), productName);
    }

    @When("User clicks on Add to Cart")
    public void user_clicks_on_add_to_cart() {
        productPage.addToCart();
    }

    @Then("The cart icon should show the product")
    public void the_cart_icon_should_show_the_product() {
        productPage.clickOnCartBtn();
    }
}
