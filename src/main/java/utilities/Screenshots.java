package utilities;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshots extends TestBase{
    public String takeScreenShot(){
        try {
            //Convert web driver object to TakeScreenshot
            TakesScreenshot scrShot =((TakesScreenshot)getDriver());
            //Call getScreenshotAs method to create image file
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            //Move image file to new destination
            String imagePath = Paths.allureScreenshotsPath+ "/screenshot-" +getTimeStamp();
            System.out.println(imagePath);
            File DestFile=new File(imagePath);
            //Copy file at destination
            FileUtils.copyFile(SrcFile, DestFile);
            return imagePath;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void attachAllureScreenshot(){
        InputStream is = null;
        try {
            is = Files.newInputStream(java.nio.file.Paths.get(takeScreenShot()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Allure.attachment("image.png", is);
    }
    private String getTimeStamp(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        String formattedDate = formatter.format(date); // or formatter.format(currentTimeMillis)
        return formattedDate;
    }
}
