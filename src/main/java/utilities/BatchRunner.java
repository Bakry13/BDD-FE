package utilities;

import java.io.File;
import java.io.IOException;

public class BatchRunner {
    public static void runBatchFile(String filePath){
        try {
            File batchFile = new File(System.getProperty("user.dir")+filePath);
            ProcessBuilder processBuilder = new ProcessBuilder(batchFile.getAbsolutePath());
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println(filePath + " file executed successfully.");
            } else {
                System.out.println(filePath + " file execution failed with exit code: " + exitCode);
            }
            Thread.sleep(2000);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
