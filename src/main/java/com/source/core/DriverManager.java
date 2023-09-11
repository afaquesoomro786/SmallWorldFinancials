package com.source.core;


import com.source.utils.TestResultsListner;
import com.source.utils.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Listeners(TestResultsListner.class)
public class DriverManager {

    public static int defaultTimeout = 2;
    private Properties prop;

    String filePath = "";

    public static Map<String, WebDriver> driverMap = new HashMap<>();

    private WebDriver driver;

    public Properties getProperties() {
        return prop;
    }

    @BeforeSuite(alwaysRun = true) // FOR TESTNG EXECUTION
    public void setBuildParams() {
        filePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        prop = Utility.readPropertiesFile(filePath);

    }

    public WebDriver getDriver(String testName) {
        return driverMap.get(testName);
    }

    public WebDriver launchDriver(String scenarioName, ArrayList<String> scenarioTags) {
        if (driver == null) {
            setBuildParams();
            driver = runTestsLocally(scenarioName);
        }
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver runTestsLocally(String testName) {
        WebDriver driver = null;

        System.out.println("Executing tests on local environment");
        String browserName = prop.getProperty("browser");
        String webUrl = prop.getProperty("webUrl");

        try {

            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);

            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(defaultTimeout, TimeUnit.SECONDS);
            driverMap.put(testName, driver);
            System.out.println(webUrl);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: Driver not launch successfully");
        }
        return driver;
    }
}