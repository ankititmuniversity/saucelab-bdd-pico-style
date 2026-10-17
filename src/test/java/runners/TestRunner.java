package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions","hooks"},
        dryRun = false,
        monochrome = true,
     //   tags = "@EndToEnd",
        plugin = {"pretty",
        		  "html:target/cucumber-report.html",     
        		  "json:target/cucumber-report.json",     
        		  "rerun:target/rerun.txt",               
        		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" ,
        		  "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        		    }
)
public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
