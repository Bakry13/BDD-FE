package utilities;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

public class TestBase extends AbstractTestNGCucumberTests {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>(); //in case running using testNG parallel testing
    public static ThreadLocal<String> browserType = new ThreadLocal<>();
    public static WebDriverWait wait;
    public static ThreadLocal<Integer> languageIndex = new ThreadLocal<>();
    public static ThreadLocal<String> testEnvironment = new ThreadLocal<>();
    public static ThreadLocal<String> environmentURL = new ThreadLocal<>();
    public static Actions actions;
    ChromeOptions chromeOptions = new ChromeOptions();
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    EdgeOptions edgeOptions = new EdgeOptions();
    //===================================Set Drivers Options and capabilities===========================
    //--------------------------------Driver Options------------------------------------
    public void setChromePreferences() {
        try {
            //CI/CD Integration Properties
            if (ConfigUtil.headless.equalsIgnoreCase("true"))
                chromeOptions.addArguments("--headless=new");
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
            chromeOptions.addArguments("--window-size=1920,1080");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getChromeDriver() {
            driver.set(new ChromeDriver(chromeOptions));
    }
    //------------------------------------------Firefox options---------------------------------
    public void setFirefoxCapabilities() {
        firefoxOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        firefoxOptions.addArguments("--no-sandbox"); // Bypass OS security model
        if (ConfigUtil.headless.equalsIgnoreCase("true"))
            firefoxOptions.addArguments("--headless");
    }

    public void getFirefoxDriver() {
        driver.set(new FirefoxDriver(firefoxOptions));
    }
    //-----------------------------------Edge Capabilities----------------------------------
    public void setEdgeCapabilities() {
        edgeOptions.addArguments("--disable-dev-shm-usage");
        edgeOptions.addArguments("--no-sandbox"); // Bypass OS security model
        edgeOptions.addArguments("--remote-allow-origins=*");
        if (ConfigUtil.headless.equalsIgnoreCase("true"))
            edgeOptions.addArguments("--headless");
    }


    public void getEdgeDriver() {
        driver.set(new EdgeDriver(edgeOptions));
    }

    //==============================Set BrowserType================================
    @BeforeTest
    @Parameters("browser")
    public void setBrowserType(@Optional("Chrome") String browser) {
        ConfigUtil.loadTestConfigurations();
        browserType.set(browser);
//        launchBrowser();
    }
    //=================================launch Browser================================
    public void launchBrowser(){
        if (getBrowserType().equalsIgnoreCase("Chrome")) {
            setChromePreferences();
            getChromeDriver();
        } else if (getBrowserType().equalsIgnoreCase("Firefox")) {
            setFirefoxCapabilities();
            getFirefoxDriver();
        } else if (getBrowserType().equalsIgnoreCase("Edge")) {
            setEdgeCapabilities();
            getEdgeDriver();
        }
        getDriver().manage().deleteAllCookies();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        actions = new Actions(getDriver());
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }

    public WebDriver getDriver() // call this method to get the driver object and launch the browser
    {
        return driver.get();
    }

    public String getBrowserType()
    {
        return browserType.get();
    }

    public int getLanguageIndex()
    {
        return languageIndex.get();
    }

    public void setLanguageIndex(int index)
    {
        languageIndex.set(index);
    }

    public String getTestEnvironment()
    {
        return testEnvironment.get();
    }

    public String getEnvironmentURL()
    {
        return environmentURL.get();
    }
    //============================Set Test Environment================================
    @BeforeTest
    public static void setEnvironment() {
        String environment = ConfigUtil.environemnt;
        if (environment.equalsIgnoreCase("test")) {
            environmentURL.set(ConfigUtil.webTestURL);
            testEnvironment.set("test");
        } else if (environment.equalsIgnoreCase("staging")) {
            environmentURL.set(ConfigUtil.webStagingURL);
            testEnvironment.set("staging");
        }
    }
//=================================Test Cases Annotations=============================
//   @AfterTest
    public void quitDriver()
    {
        getDriver().quit();
    }
}
