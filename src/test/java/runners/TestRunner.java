package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        plugin = {"pretty"
                        },
        tags = "",
        features = {"src/test/resources/features"},
        glue = {"stepDefination","com.source.core"}
        )

public class TestRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = false)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}