package utilities.actions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import utilities.ConfigUtil;
import utilities.TestBase;

public class APIActions extends AbstractTestNGCucumberTests {
//    private static RequestSpecification request = given().relaxedHTTPSValidation();
    public static String baseURL = "https://jsonplaceholder.typicode.com/";
    public static final String wrongEndpoint = "/test";
    public static Response response;
    public static String token;
    public static String value;
    public static String apiTestEnvironment = "test";

    @BeforeTest
//    @Parameters("environment")
//    public static void setAPIEnvironment(@Optional("ST") String environment) {
    public static void setEnvironment() {
        ConfigUtil.loadTestConfigurations();
        String environment = ConfigUtil.environment;
        if (environment.equalsIgnoreCase("test")) {
            baseURL = ConfigUtil.apiTestURL;
            TestBase.environmentURL.set(ConfigUtil.webTestURL);
            apiTestEnvironment = "test";
        } else if (environment.equalsIgnoreCase("staging")) {
            baseURL = ConfigUtil.apiStagingURL;
            TestBase.environmentURL.set(ConfigUtil.webStagingURL);
            apiTestEnvironment = "staging";
        }
    }

    /**
     * @param response         Response from API Request.
     * @param responseJsonPath JSON responseJsonPath to retrieve the desired value.
     * @return Return the value from JSON Path provided.
     */
    public static String getJSONResponseAsValue(Response response, String responseJsonPath) {
        String result = "";
        try {
            String jsonString = response.getBody().asString();
            JsonPath jsonPath = new JsonPath(jsonString);
            result = jsonPath.getString(responseJsonPath);
        } catch (JsonPathException e) {
            System.out.println("Failed to parse the JSON Path: [ " + responseJsonPath + " ]");
        }

        if (result != null) {
            System.out.println("Value is: [" + result + "]");
        } else {
            System.out.println("JSON responseJsonPath retrieved value is NULL.");
        }
        return result;
    }
    //===========================================================================================
//    /**
//     * @param targetPortal Set the target URL to hit
//     * @return Returns the base URI
//     */
//    @SuppressWarnings("Method need to be modified with URLs for WTT in configuration file first.")
//    private static String setBaseUrl(TargetPortal targetPortal) {
//        switch (targetPortal) {
//            case ST:
//                return ConfigUtil.API_ST_URL;
//            case SIT:
//                return ConfigUtil.API_SIT_URL;
//            case ChangeManagementST:
////                return ConfigUtil.ChangeManagement_API_BASE_URL;
//            default:
//                break;
//        }
//        return null;
//    }
//
//    /**
//     * @param targetPortal  The URL to hit.
//     * @param endPoint      The endpoint appended on the URL to hit.
//     * @param formParams    To send the request with form parameters
//     * @param contentType   Use contentType.ANY when not sending form parameters or JSON.
//     *                      Use contentType.URLENC when sending form parameters.
//     *                      Use contentType.JSON when sending JSON Object.
//     * @return Building the request specs
//     */
//    @SuppressWarnings("Methods needs to be refactored to be more generic in the term of headers.")
//    private static RequestSpecification prepareRequestSpecification(String targetPortal, String endPoint,
//                                                                    List<List<Object>> formParams, Map<String, String> headers, ContentType contentType) {
//        RequestSpecBuilder builder = new RequestSpecBuilder();
////        builder.setBaseUri(setBaseUrl(targetPortal));
//        builder.setBaseUri(targetPortal);
//        builder.setBasePath(endPoint);
//        builder.setContentType((contentType.toString()));
//
//        if (formParams != null) {
//            formParams.forEach(param -> {
//                builder.addFormParam(param.get(0).toString(), param.get(1));
//            });
//        }
//        if (headers != null && !headers.isEmpty()) {
//            headers.forEach((headerName, headerValue) -> builder.addHeader(headerName, headerValue));
//        }
//
//        builder.setRelaxedHTTPSValidation();
//
//        builder.setConfig(
//                (new RestAssuredConfig()).encoderConfig((new EncoderConfig()).defaultContentCharset("UTF-8")).and()
//                        .httpClient(HttpClientConfig.httpClientConfig()
//                                .setParam("http.connection.timeout", 10000)
//                                .setParam("http.socket.timeout", 10000)
//                                .setParam("http.connection-manager.timeout", 10000)));
//        return builder.build();
//    }
//
//    /**
//     * @param targetPortal  The main URI to send request.
//     * @param endPoint      The endpoint to hit which is appended on target portal
//     * @param requestType   HTTP Method type, example: POST, GET
//     * @param JSONObject    JSON body to send in request if exist
//     * @return Returns response as Response
//     */
//    public static Response sendRequest(String targetPortal, String endPoint, RequestType requestType,
//                                       int statusCode, String JSONObject, List<List<Object>> formParams, Map<String, String> headers, ContentType contentType) {
//        Response response = null;
//
//        System.out.println("Start performing API request on: [" + endPoint + "].");
//        if (JSONObject != null) {
//            request = given().spec(prepareRequestSpecification(targetPortal, endPoint, formParams, headers, contentType)).body(JSONObject);
//        } else if (JSONObject == null) {
//            request = given().spec(prepareRequestSpecification(targetPortal, endPoint, formParams, headers, contentType));
//        } else {
//            System.out.println("Method sendRequest in APIActions class needs to be refactored.");
//        }
//
//        switch (requestType) {
//            case POST:
//                response = request.when().post().then().extract().response();
//                System.out.println("Response: [" + response.asString() + "].");
//                Assert.assertEquals(response.getStatusCode(), statusCode);
//                return response;
//            case PATCH:
//                response = request.when().patch().then().extract().response();
//                System.out.println("Response: [" + response.asString() + "].");
//                Assert.assertEquals(response.getStatusCode(), statusCode);
//                return response;
//            case PUT:
//                response = request.when().put().then().extract().response();
//                System.out.println("Response: [" + response.asString() + "].");
//                Assert.assertEquals(response.getStatusCode(), statusCode);
//                return response;
//            case GET:
//                response = request.when().get().then().extract().response();
//                System.out.println("Response: [" + response.asString() + "].");
//                Assert.assertEquals(response.getStatusCode(), statusCode);
//                return response;
//            case DELETE:
//                response = request.when().delete().then().extract().response();
//                System.out.println("Response: [" + response.asString() + "].");
//                Assert.assertEquals(response.getStatusCode(), statusCode);
//                return response;
//            default:
//                break;
//        }
//        System.out.println("Response is null.");
//        return response;
//    }
//
//    /**
//     * Adding enumerations to handle only the possible values that can be provided
//     */
//    public enum RequestType {
//        POST, GET, PATCH, DELETE, PUT
//    }
//
//    /**
//     * Adding enumerations to handle only the possible values that can be provided
//     */
//    @SuppressWarnings("To be refactored to have the URL from configuration file.")
//    public enum TargetPortal {
//        CMST, UMST, ChangeManagementST ,ST ,SIT
//    }
}
