package utilities.readers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonTestDataReader {
    // Read JSON file and return it as JSON object
    public static JSONObject parseJson(String jsonFilePath) {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = null;
        String currentDirectory = System.getProperty("user.dir");

        try {
            reader = new FileReader(currentDirectory + jsonFilePath);
        } catch (FileNotFoundException e) {
            System.out.println("No file was found in the specified directory.");
            e.printStackTrace();
        }

        //Read JSON file
        JSONObject obj = null;
        try {
            obj = (JSONObject) jsonParser.parse(reader);
        } catch (IOException | ParseException e) {
            System.out.println("Failed to parse the file.");
            e.printStackTrace();
        }
        return obj;
    }

//    public static String getJsonValue(JSONObject jsonObj, String keyJSONPath) throws ParseException {
//        String[] pathLayers = keyJSONPath.split("\\.");
//        JSONObject getUser = jsonObj;
//        for (int i = 0; i < pathLayers.length - 1; i++) {
//            getUser = ((JSONObject) getUser.get(pathLayers[i]));
////            System.out.println("getUser before process : " + i + " : " + getUser);
//            getUser = (JSONObject) jsonParser.parse(String.valueOf(getUser));
//        }
////        System.out.println(getUser.get(pathLayers[pathLayers.length - 1]));
//        return (String) getUser.get(pathLayers[pathLayers.length - 1]);
//    }
}
