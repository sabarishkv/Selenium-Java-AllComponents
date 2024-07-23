import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class NewTestCase {
    @Test
    public void FirstTestcase(){
        System.out.println("New Test case");
        WebDriver chrome = WebDriverManager.chromedriver().create();
        chrome.get("google.com");
    }
}
