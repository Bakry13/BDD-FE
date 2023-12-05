package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.actions.ElementActions;

import static org.testng.Assert.*;

public class Assertions extends ElementActions{
    //================================Assertions By locator============================
    //=================================Assert on existence of element=====================
    public void assertElementExist(By locator) {
        assert getElement(locator).isDisplayed();
    }

    public void assertElementNotExist(By locator) {
        // add wait of invisibility
        try {
            assert getElement(locator).isDisplayed();
            System.out.println("Assertions failed - Element by locator: [" + locator + "] exist");
            Assert.fail();
        } catch (Exception e) {
            System.out.println("Assertions passed - Element by locator: [" + locator + "] not exist.");
        }
    }
    //============================assert if element is enabled=================================
    public void assertElementEnabled(By locator) {
        assertTrue(getElement(locator).isEnabled());
    }

    public void assertElementDisabled(By locator) {
        Boolean buttonDisabled = getElement(locator).isEnabled() ;
        assertFalse(buttonDisabled);

    }

    public void buttonIsDisabled(By locator , String attribute){

            Boolean result = false;
            try {
                String value = getElement(locator).getAttribute(attribute);
                if (value != null){
                    result = true;
                }
            } catch (Exception e) {}

           assertFalse(result);
        }

    public void assertButtonEnabled(By locator, String disabledClassName) {
        String classes = getElement(locator).getAttribute("class");
        boolean isDisabled = classes.contains(disabledClassName);
        assertTrue((!isDisabled));
    }

    public void assertButtonDisabled(By locator, String disabledClassName) {
        String classes = getElement(locator).getAttribute("class");
        boolean isDisabled = classes.contains(disabledClassName);
        assertFalse((!isDisabled));

    }
    //===================================Assert element text=====================================
    public void assertElementText(By locator, String text) {
        String elementText;
        elementText = getElement(locator).getText();
        assertEquals(elementText, text);
    }
    public void assertElementTextFromHoverToolTip(By locator, String text) {
        String elementText;
        elementText = getDriver().findElement(locator).getText();
        assertEquals(elementText, text);
    }
    public void assertElementTextIgnoreCase(By locator, String text) {
        String elementText;
        elementText = getElement(locator).getText().toLowerCase();
        assertEquals(elementText, text.toLowerCase());
    }
    public void assertElementTextNotEqual(By locator, String text) {
        String elementText;
        elementText = getElement(locator).getText();
        assertNotEquals(elementText, text);
    }
    public void assertTextContainsElementText(By locator, String text) {
        String elementText;
        elementText = getElement(locator).getText();
        System.out.println(elementText);
        System.out.println(text);
        assertTrue(text.contains(elementText));
    }

    public void assertElementTextByAttribute(By locator, String text) {
        String attributeValue = getElement(locator).getAttribute("innerText");
        assertEquals(attributeValue, text);
    }

    public void assertAttributeValueContainsText(By locator, String attribute, String text) {
        String attributeValue = getElement(locator).getAttribute(attribute);
        assertTrue(attributeValue.contains(text));
    }

    public void assertURLText(String expectedURL) {
        String actualURL;
        actualURL = getDriver().getCurrentUrl();
        assertTrue(actualURL.contains(expectedURL));
    }

    public void assertPageTitleText(String expectedTitle) {
        String actualTitle;
        actualTitle = getDriver().getTitle();
        assertTrue(actualTitle.contains(expectedTitle));
    }
    //===================================Assert list size=====================================
    public void assertListSize(By locator, String size) {
        String listSize;
        int listSizeInt = getDriver().findElements(locator).size();
        listSize = Integer.toString(listSizeInt);
        assertEquals(listSize, size);
    }
    //========================================================================================
    //================================Assertions By Element============================
    //=================================Assert on existence of element=====================
    public void assertElementExist(WebElement element) {
        assert element.isDisplayed();
    }

    public void assertElementNotExist(WebElement element) {
        try {
            assert element.isDisplayed();
            System.out.println("Assertions failed - Element exist");
            Assert.fail();
        } catch (Exception e) {
            System.out.println("Assertions passed - Element does not exist.");
        }
    }
    //============================assert if element is enabled=================================
    public void assertElementEnabled(WebElement element) {
        assertTrue(element.isEnabled());
    }

    public void assertElementDisabled(WebElement element) {
        assertFalse(element.isEnabled());
    }

    public void assertButtonEnabled(WebElement element, String disabledClassName) {
        String classes = element.getAttribute("class");
        boolean isDisabled = classes.contains(disabledClassName);
        assertTrue((!isDisabled));
    }

    public void assertButtonDisabled(WebElement element, String disabledClassName) {
        String classes = element.getAttribute("class");
        boolean isDisabled = classes.contains(disabledClassName);
        assertFalse((!isDisabled));
    }
    //===================================Assert element text=====================================
    public void assertElementText(WebElement element, String text) {
        String elementText;
        elementText = element.getText();
        assertEquals(elementText, text);
    }
    public void assertElementTextIgnoreCase(WebElement element, String text) {
        String elementText;
        elementText = element.getText().toLowerCase();
        assertEquals(elementText, text.toLowerCase());
    }
    public void assertTextContainsElementText(WebElement element, String text) {
        String elementText;
        elementText = element.getText();
        assertTrue(text.contains(elementText));
    }

    public void assertElementTextContainsText(WebElement element, String text) {
        String elementText;
        elementText = element.getText();
        assertTrue(elementText.contains(text));
    }

    public void assertAttributeValueEqualText(WebElement element, String attribute, String text) {
        String attributeValue = element.getAttribute(attribute);
        assertEquals(attributeValue, text);
    }
}
