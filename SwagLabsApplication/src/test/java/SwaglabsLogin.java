import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SwaglabsLogin {


    @Test
    public void loginClass() {
        System.out.println("login Successful");
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        System.out.println(webDriver.getTitle());
        System.out.println(webDriver.getCurrentUrl());
        webDriver.quit();
    }
}
