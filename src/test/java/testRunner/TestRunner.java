package testRunner;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import utilities.TestBase;

@CucumberOptions(features = {"src/test/java/features"}
        ,glue = {"stepDefinition", "pages", "utilities"}
        ,tags = ("@FERegression") //("@StoryId and @Regression and not @APIRegression")
        ,plugin = {"pretty","html:test-output/DefaultReport/DefaultReport.html"
        ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
}
)
public class TestRunner extends TestBase {
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}