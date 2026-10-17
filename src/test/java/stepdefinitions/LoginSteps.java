package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductPage;

public class LoginSteps {

    private final TestContext testContext;
    private final LoginPage loginPage;
    private final ProductPage productPage;

    public LoginSteps(TestContext testContext) {
        this.testContext = testContext;
        this.loginPage = testContext.getLoginPage();
        this.productPage = testContext.getProductPage();
    }

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        testContext.getDriver().get("https://www.saucedemo.com/");
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.clickLoginBtn();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        Assert.assertEquals(productPage.getPageTitle(), "Products");
    }

    @Then("User should see an error message")
    public void user_should_see_an_error_message() {
        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"));
    }
}
