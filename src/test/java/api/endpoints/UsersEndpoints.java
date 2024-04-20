package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.actions.APIActions;

import static io.restassured.RestAssured.given;

public class UsersEndpoints extends APIActions {
    static String getUsers = "posts";
    static String postUser = "posts";
    //=====================================Request Body===================================
    String requestBody = "{\n" +
            "\"title\": \"foo\",\n" +
            "\"body\": \"bar\",\n" +
            "\"userId\": 102\n" +
            "}";
    //-----------------------------------Using Serialization-----------------------------
    Users user = new Users();
    private Users bodyBuilder(){
        user.setTitle("foo");
        user.setBody("bar");
        user.setUserId(102);
        return user;
    }
    //====================================Main Request====================================
    //-------------------------------Success Code 200------------------------------
    public Response getUsersRequest()
    {
        try {
            RestAssured.baseURI = baseURL+getUsers;
            response = given()
                    .get();
            System.out.println("getUsersRequest status code is "+ response.getStatusCode());
        } catch (Exception e) { e.printStackTrace(); }
        return response;
    }
    //------------------------------------Get specific user-----------------------------------
    public Response getSpecificUserRequest(int id)
    {
        try {
            RestAssured.baseURI = baseURL+getUsers;
            response = given()
                    .queryParam("id",id)
                    .get();
            System.out.println("getSpecificUserRequest status code is "+ response.getStatusCode());
        } catch (Exception e) { e.printStackTrace(); }
        return response;
    }
    //----------------------------------Success Code 201------------------------------------------
    public Response postUserRequest()
    {
        try {
            RestAssured.baseURI = baseURL+postUser;
            response = given()
//                    .header("Cookie",accessToken)
                    .contentType(ContentType.JSON)
//                    .body(requestBody)
                    .body(bodyBuilder())
                    .post();
            System.out.println("postUserRequest status code is "+ response.getStatusCode());
        } catch (Exception e) { e.printStackTrace(); }
        return response;
    }
    //=================================Error Handling Requests==================================
    //----------------------------------Verify Unauthorized 401---------------------------------
    //-------------------------------Verify Method Not Allowed 405------------------------------
    //---------------------------------------Error Code 404-------------------------------------
    //================================Test our code using main==================================
    public void main( String[] args )
    {
        postUserRequest();
    }
}
