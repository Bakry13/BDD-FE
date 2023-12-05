package utilities.actions;

import org.openqa.selenium.JavascriptExecutor;
import utilities.TestBase;

import java.time.Duration;
import java.util.ArrayList;

public class BrowserActions extends TestBase {
    public void navigateToPage(String url) {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        System.out.println(url);
        getDriver().navigate().to(url);
    }

    public void  setBrowserLanguage(String language)
    {
        setChromePreferences();
        relaunchBrowser();
    }

    public void relaunchBrowser()
    {
        getDriver().quit();
        launchBrowser();
    }

    public void openNewTab()
    {
        ((JavascriptExecutor)getDriver()).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
    }

    public void switchToAnotherTab(int index)
    {
        ArrayList<String> tabs2 = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(index));
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public void navigateBack() {
        getDriver().navigate().back();
    }

    public void navigateForward() {
        getDriver().navigate().forward();
    }

    public void scrollToTop() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
    }
 //===========================================================================================
}
