package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class WindowHanling {

    WebDriver chrome;

    public  void  navigateWindow(){
        chrome = WebDriverManager.chromedriver().create();
        chrome.get("google.com");
    }
}
