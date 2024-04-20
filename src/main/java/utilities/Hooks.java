package utilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.actions.APIActions;

public class Hooks extends TestBase{
    Screenshots screenshots = new Screenshots();
    //=========================Open the browser then write test environment in the report===================
    //In case of using parallel execution using cucumber
//    @Before(order = 0, value = "@FERegression")
//    public void setTestEnvironment() {
//        ConfigUtil.loadTestConfigurations();
//        browserType.set(ConfigUtil.browser);
//        String environment = ConfigUtil.environment;
//        if (environment.equalsIgnoreCase("test")) {
//            environmentURL.set(ConfigUtil.webTestURL);
//            testEnvironment.set("test");
//        } else if (environment.equalsIgnoreCase("staging")) {
//            environmentURL.set(ConfigUtil.webStagingURL);
//            testEnvironment.set("staging");
//        }
//    }
    @Before(order = 1, value = "@FERegression")
    public void openBrowser() {
        launchBrowser();
    }
    @Before(order = 2, value = "@FERegression")
    public void testCaseEnvironment(Scenario scenario) {
        scenario.log("Browser type is: "+getBrowserType()
                        +"\n, Test environment is: "+getTestEnvironment());
    }
    @Before(order = 0, value = "@APIRegression")
    public void apiTestCaseEnvironment(Scenario scenario) {
        scenario.log("API test environment is: "+ APIActions.apiTestEnvironment);
    }

    @After(order = 0, value = "@APIRegression")
    public void apiResponseAttachment(Scenario scenario) {
        scenario.log("API response is: "+ APIActions.response.asString());
    }
//===========================To attach screenshots in the extent report then quite the browser======================
    @After(order = 1, value = "@FERegression")
    public void takeScreenshot(Scenario scenario) {
//        if(scenario.isFailed()){
            //----------------------------extent report-----------------------------
            byte[] src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(src,"image/png", scenario.getName()+ ".png" );
            //----------------------------allure report-----------------------------
//            screenshots.attachAllureScreenshot();
//        }
    }
    @After(order = 0, value = "@FERegression")
    public void quitBrowser() {
        getDriver().quit();
    }
}