package api;

import io.restassured.response.Response;
import org.testng.Assert;
import utilities.actions.APIActions;

public class APIAssertions extends APIActions {
    //==================================Errors Assertions=================================
    //-------------------------------Verify Success Code 200------------------------------
    public static void assertSuccess(Response response)
    {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

    public static void assertPostSuccess(Response response)
    {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,201);
    }
}
