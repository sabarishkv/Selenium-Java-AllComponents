import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class SeleniumJava {


    public void testClass() {
        System.out.println("testClass Successful");
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.saucedemo.com/");
        System.out.println(webDriver.getTitle());
        System.out.println(webDriver.getCurrentUrl());
        webDriver.quit();
    }

    public void testWebDriverChrome() {
        //new way of implementing not required to have the individual drivers
        System.out.println("testWebDriver Successful");
        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.get("https://www.saucedemo.com/");
        System.out.println(webDriver.getTitle());
        System.out.println(webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @Test
    public void allBrowserTest() {
        System.out.println("allBrowserTest Successful");
        WebDriverManager.firefoxdriver().setup();
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.saucedemo.com/");
        System.out.println(webDriver.getTitle());
        System.out.println(webDriver.getCurrentUrl());
        webDriver.quit();
    }

}
