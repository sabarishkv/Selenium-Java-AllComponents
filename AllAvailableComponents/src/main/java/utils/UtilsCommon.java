package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class UtilsCommon {


    public void performScreenShot(WebDriver driver, String fileName) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("./Attachments/"+fileName);
        FileUtils.copyFile(source, dest);
        System.out.println("The screenshot is captured and stored in" + dest);

    }
}
