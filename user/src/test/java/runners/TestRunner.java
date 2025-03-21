package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",  // Path to your feature files
        glue = "stepDefinitions",  // Package where step definition classes are located
        plugin = {"pretty", "html:target/cucumber-reports"}  // Report formats
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // This class is used to run the Cucumber tests with JUnit
}