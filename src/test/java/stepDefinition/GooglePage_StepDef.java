package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GooglePage;

public class GooglePage_StepDef extends GooglePage {
    @Given("I open google website")
    public void i_open_google_website() {
        openGoogle();
    }
    @When("I set {string}")
    public void i_set(String language) {
        setLanguage(language);
    }
    @Then("I should see Google Setting word has the correct text")
    public void i_should_see_google_setting_word_has_the_correct_text() {
        assertGoogleSettingText();
    }
    @Then("I should see Google title has the correct text")
    public void i_should_see_google_title_has_the_correct_text() {
        assertOnPageTitle();
    }
}