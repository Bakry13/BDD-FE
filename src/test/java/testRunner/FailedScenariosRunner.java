package testRunner;

import io.cucumber.testng.CucumberOptions;
import utilities.TestBase;

@CucumberOptions(
        features = {"@test-output/rerun.txt"},
        glue = {"ui/stepDefinition", "api/stepDefinition","utilities"}
        ,plugin = {"pretty"
        ,"html:test-output/DefaultReport/DefaultReport.html"
        ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        ,"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
}
)
public class FailedScenariosRunner extends TestBase {
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}
