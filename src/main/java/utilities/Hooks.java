package utilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.actions.BrowserActions;

public class Hooks extends TestBase{
    //=========================Open the browser then write test environment in the report===================
    @Before(order = 1, value = "@FERegression")
    public void openBrowser() {
        launchBrowser();
    }
    @Before(order = 0, value = "@FERegression")
    public void testCaseEnvironment(Scenario scenario) {
        scenario.log("Browser type is: "+getBrowserType()
                        +"\n, Test environment is: "+getTestEnvironment());
    }
//===========================To attach screenshots in the extent report then quite the browser======================
    @After(order = 1, value = "@FERegression")
    public void takeScreenshot(Scenario scenario) {
        byte[] src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(src,"image/png", scenario.getName()+ ".png" );
    }
    @After(order = 0, value = "@FERegression")
    public void quitBrowser() {
        getDriver().quit();
    }
}