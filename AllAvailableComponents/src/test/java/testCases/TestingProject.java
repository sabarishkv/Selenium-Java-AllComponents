package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestingProject {

    public String applicationUrl = "https://www.hyrtutorials.com/p/basic-controls.html";

    @Test
    public void newModule() throws InterruptedException {

      WebDriver chrome = WebDriverManager.chromedriver().create();
        chrome.get(applicationUrl);
        Thread.sleep(2000);

    }
}
