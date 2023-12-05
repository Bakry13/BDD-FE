package utilities;

import utilities.readers.PropertiesReader;

public class ConfigUtil {

    public static String browser;
    public static String headless;
    public static String environemnt;
    public static String webTestURL;
    public static String webStagingURL;
    //=======================Endpoints======================
    public static void loadTestConfigurations() {
        PropertiesReader reader = new PropertiesReader( "config.properties");
        browser = reader.getPropertyUsingKey("browser");
        headless = reader.getPropertyUsingKey("headless");
        environemnt = reader.getPropertyUsingKey("environment");
        webTestURL = reader.getPropertyUsingKey("webTestURL");
        webStagingURL = reader.getPropertyUsingKey("webStagingURL");
    }
}
