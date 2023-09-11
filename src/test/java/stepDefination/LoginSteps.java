package stepDefination;

import com.source.core.TestContext;
import com.source.data.UserData;
import com.source.pages.HomeScreen;
import com.source.pages.LoginScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;
import java.util.Properties;


public class LoginSteps {
    TestContext context;
    WebDriver driver;
    LoginScreen loginScreen;
    HomeScreen homeScreen;

    private Properties prop;

    public LoginSteps(TestContext context) {
        this.context = context;
        this.driver = context.getDriverManager().getDriver();
        loginScreen = context.getPageObjectManager().getLoginScreen();
        homeScreen = context.getPageObjectManager().getHomeScreen();
        prop = context.getDriverManager().getProperties();
    }

    @Given("I am on the Login page")
    public void navigateToPage() {
        String url = prop.getProperty("webUrl");
        loginScreen.navigateToURL(url);
    }

    @Given("I login with {} user")
    public void loginUser(String userType) {
        Map<String, String> user = UserData.getLoginUserCredentails(userType);
        //if (userType.equalsIgnoreCase("standard")) {
            System.out.println(user.get("username"));
            Assert.assertTrue(loginScreen.performLogin(user.get("username"), user.get("password")));
        //}
    }

    @When("^I login user with different \"(.*)\" and \"(.*)\"$")
    public void loginWithDifferentUsers(String username, String password) {
        Assert.assertTrue(loginScreen.performLogin(username, password));
    }

    @Then("^I am on the Swag Labs homepage$")
    public void iShouldBeLoggedInSuccessfully() {
        Assert.assertTrue(homeScreen.productLabelIsDisplayed());
    }
}
