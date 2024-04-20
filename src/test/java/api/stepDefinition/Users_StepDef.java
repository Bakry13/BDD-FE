package api.stepDefinition;

import api.APIAssertions;
import api.endpoints.Users;
import api.endpoints.UsersEndpoints;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.testng.Assert;
import utilities.Paths;
import utilities.readers.JsonReader;

public class Users_StepDef extends UsersEndpoints {
//    Users users;
//    List<Users> usersList;
    Users[] users;
    Users createdUser;
    JSONObject usersData = (JSONObject) JsonReader.parseJson(Paths.usersDataPath).get(apiTestEnvironment);
    //==============================================================
    @Given("I request users api")
    public void i_request_users_api() {
        response = getUsersRequest();
    }
    @When("I extract users response")
    public void i_extract_users_response() throws JsonProcessingException {
//        users = response.as(Users.class);
//        usersList = new ObjectMapper().readValue(response.getBody().asString(), new TypeReference<List<Users>>(){});
        users = new ObjectMapper().readValue(response.getBody().asString(), Users[].class);
    }
    @When("I extract created users response")
    public void i_extract_created_users_response() throws JsonProcessingException {
        createdUser = new ObjectMapper().readValue(response.getBody().asString(), Users.class);
    }
    @Then("I assert on success status code")
    public void i_assert_on_success_status_code() {
        APIAssertions.assertSuccess(response);
    }
    @Then("I assert on post success status code")
    public void i_assert_on_post_success_status_code() {
        APIAssertions.assertPostSuccess(response);
    }
    @Then("I should find users response has the correct length")
    public void i_should_find_users_length_equal() {
//        System.out.println(usersList.get(0).title);
        Assert.assertEquals(users.length, 100);
    }
    @Then("I should find the correct {string} for 4th id")
    public void i_should_find_the_correct_for_4th_id(String title) {
        String titleValue = usersData.get(title).toString();
        Assert.assertEquals(users[3].getTitle(), titleValue);
    }
    @Given("I request post user api")
    public void i_request_post_user_api() {
        response = postUserRequest();
    }
    @Then("I should find the correct {string} for the created user")
    public void i_should_find_the_correct_for_the_created_user(String id) {
        int idValue = Integer.parseInt(usersData.get(id).toString());
        Assert.assertEquals(createdUser.getId(), idValue);
    }
}
