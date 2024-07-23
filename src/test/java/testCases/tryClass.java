import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.te

public class tryClass {

    public static String radioButton = "//a[text()='Radio Buttons Demo']";
    public static String loginButton = "//a[text()='Login']";

    public By  testButton = By.xpath("//a[text()='Login']");


    // int dimension;

    // WebDriver mfdrive = WebDriverManager.firefoxdriver().create();

    WebDriver cdrive = WebDriverManager.chromedriver().create();

  //  WebDriver sDrive = WebDriverManager.chromedriver().proxy("localhost:8080").create();

        int width = 1440;
        int height = 779;
        Dimension dimension = new Dimension(width, height);



    @BeforeTest
    public void launchBrowser() {

        System.out.println("testWebDriver Successful");
        //  mfdrive.get("https://www.lambdatest.com/selenium-playground/");
        cdrive.get("https://www.lambdatest.com/selenium-playground/");
       cdrive.manage().window().setSize(dimension); // This is based on the dimentsions.
      //  cdrive.manage().window().fullscreen();// not working use the dimensios itself
        // for the chrome driver
     //   cdrive.manage().window().maximize(); // this statement is not working for Chrome browser.
    }

    @Test
    public void navigateRadioButtonPage() throws InterruptedException {
        System.out.println("Enterd the Test");
        Thread.sleep(1000);
      //  cdrive.findElement(By.xpath("//a[text()='Radio Buttons Demo']")).click();
        cdrive.findElement(By.xpath(radioButton)).click();

        cdrive.findElement(testButton).click();

        Thread.sleep(1000);
        //cdrive.findElement(By.xpath("//a[text()='Dashboard']")).click();
     //   cdrive.findElement(By.name(loginButton)).click();
        System.out.println(cdrive.getTitle());
        System.out.println(cdrive.getCurrentUrl());
    }

    @Test
    public  void  copyElements(){
        
    }



    @AfterTest
    public void quitBrowser() {
        System.out.println("Entered quitBrowser");
        cdrive.quit();
    }
}
