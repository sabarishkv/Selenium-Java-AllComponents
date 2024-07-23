import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import

public class TestCaseNew {




    public void firstTestCase(){
        System.out.println("Entered browser");
        WebDriver driver = WebDriverManager.chromiumdriver().create();
        driver.get("Google.com");

    }
}
