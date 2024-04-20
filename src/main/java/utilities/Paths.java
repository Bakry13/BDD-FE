package utilities;

public class  Paths {
    public static String dataPath = "/src/test/resources/testData";
    //=======reading from json files in the following path...
    //System.getProperty("user.dir") + "/src/test/resources/"; //which is included in json test data reader
    public static String usersDataPath = dataPath+"/users.json";
    public static String allureScreenshotsPath = "test-output/allureScreenshots";
    public static String mainResources = "/src/main/resources";
    public static void setDataPath()
    {
        ConfigUtil.loadTestConfigurations();
    }
}