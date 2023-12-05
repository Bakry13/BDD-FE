package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.Assertions;
import utilities.Paths;
import utilities.actions.BrowserActions;
import utilities.actions.ElementActions;
import utilities.readers.JsonTestDataReader;

public class GooglePage extends ElementActions {
    JSONObject customerData = (JSONObject) JsonTestDataReader.parseJson(Paths.usersDataPath).get(getTestEnvironment());
    Assertions assertions = new Assertions();
    BrowserActions browserActions = new BrowserActions();
    //=============================Locators==================================
    By language = By.cssSelector("div.L3eUgb:nth-child(2) div.o3j99.qarstb:nth-child(4) div.vcVZ7d:nth-child(2) div:nth-child(2) > a:nth-child(1)");
    By googleSetting = By.cssSelector(".ayzqOc.pHiOh");
    //=============================Strings==================================
    String googlePageTitle = "Google";
    String[] googleSettingText =
            {"Settings"
                    , "الإعدادات"};
    //===================================Actions===================================
    public void openGoogle()
    {
        browserActions.navigateToPage(getEnvironmentURL());
    }

    public void clickOnLanguage() {
        getElement(language).click();
    }

    public void setLanguage(String languageValue) {
        if (getElement(language).getText().equals(languageValue))
        {
            clickOnLanguage();
        }
        if (getElement(language).getText().equals("English"))
        {
            setLanguageIndex(1);
        }
        else
        {
            setLanguageIndex(0);
        }
    }
    //-----------------------------------Assertions--------------------------------
    public void assertOnPageTitle()
    {
        assertions.assertPageTitleText(googlePageTitle);
    }
    //------------------------------Text Assertions----------------------------------
    public void assertGoogleSettingText()
    {
        assertions.assertElementText(googleSetting,googleSettingText[getLanguageIndex()]);
    }
}



