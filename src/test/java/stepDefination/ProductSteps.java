package stepDefination;

import com.source.core.TestContext;
import com.source.pages.HomeScreen;
import com.source.pages.LoginScreen;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductSteps {
    TestContext context;
    WebDriver driver;
    LoginScreen loginScreen;
    HomeScreen homeScreen;

    public ProductSteps(TestContext context) {
        this.context = context;
        this.driver = context.getDriverManager().getDriver();
        loginScreen = context.getPageObjectManager().getLoginScreen();
        homeScreen = context.getPageObjectManager().getHomeScreen();

    }

    @When("I select the {string} filter")
    public void filterProduct(String filter) {
        System.out.println(filter);
        Assert.assertTrue(homeScreen.selectFilter(filter));
    }

    @Then("I should see the products sorted by price in ascending order")
    public void verifyProductsSortedInAscendingOrder() {
        Assert.assertTrue(homeScreen.areProductsSortedByPriceAscending());
    }

    @Then("I should see the products sorted by price in descending order")
    public void verifyProductsSortedInDescendingOrder() {
        Assert.assertTrue(homeScreen.areProductsSortedByPriceDescending());
    }

    @Then("I should see the products sorted by name in ascending order")
    public void verifyProductsSortedByNameInAscendingOrder() {
        Assert.assertTrue(homeScreen.areProductsSortedByNameAscending());
    }

    @Then("I should see the products sorted by name in descending order")
    public void verifyProductsSortedByNameInAscendingDescending() {
        Assert.assertTrue(homeScreen.areProductsSortedByNameDescending());
    }
}
