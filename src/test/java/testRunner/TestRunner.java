package testRunner;

import io.cucumber.testng.CucumberOptions;
import utilities.TestBase;

@CucumberOptions(features = {"src/test/java"}
        ,glue = {"ui/stepDefinition", "api/stepDefinition","utilities"}
        ,tags = ("@FERegression and @TC2") //("@StoryId and @Regression and not @APIRegression")
        ,plugin = {"pretty"
                ,"html:test-output/DefaultReport/DefaultReport.html"
                ,"rerun:test-output/rerun.txt"
                ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                ,"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class TestRunner extends TestBase {
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}