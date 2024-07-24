package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicControls {

    WebDriver chrome;
    Dimension dm;

    public String applicationUrl = "https://www.hyrtutorials.com/p/basic-controls.html";
    public By firstNameField = By.xpath("//input[@id='firstName']");
    public By lastNameField = By.xpath("//input[@id='lastName']");
    public By emailField = By.xpath("//input[@id='email']");
    public By passwordField = By.xpath("//input[@id='password']");



    public Dimension setBrwoserDimension() {
        int width = 1440, height = 779;
        dm = new Dimension(width, height);
        return dm;
    }


    @BeforeTest
    public WebDriver launchBrowser() {
        System.out.println("Launching Browser");
        chrome = WebDriverManager.chromedriver().create();
        chrome.get(applicationUrl);
        chrome.manage().window().setSize(setBrwoserDimension());
        return chrome;
    }

//    WebElement firstName = chrome.findElement(By.xpath("//input[@id='firstName']"));
//    WebElement lastName = chrome.findElement(By.xpath("//input[@id='lastName']"));
//    WebElement emailField = chrome.findElement(By.xpath("//input[@id='email']"));
//    WebElement passwordField = chrome.findElement(By.xpath("//input[@id='password']"));


    public void fillTextField(String testData, By locator) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Browser launched successful and entered Text Field" + locator + testData);
        chrome.findElement(locator).sendKeys(testData);
    }


    public void enterTextField(String testData, By locator) throws InterruptedException {
        if (chrome.findElement(locator).isDisplayed()) {
            Thread.sleep(1000);
            System.out.println("Locator is Displayed");
            if (chrome.findElement(locator).isEnabled()) {
                System.out.println("Locator is enabled");
                chrome.findElement(locator).sendKeys(testData);
                System.out.println("Browser launched Data inside locator: " + locator + "and entered Text data: " + testData);
                Thread.sleep(1000);
                String enteredTxt = chrome.findElement(locator).getAttribute("Value");
                System.out.println("Entered text in the locator is:"+enteredTxt);

            } else {
                System.err.println("Locator is disabled");


            }
        } else {
            System.err.println("Locator is Enabled");
        }
    }

    public void fillBasic() throws InterruptedException {
        fillTextField("Mac Air M1", firstNameField);
        fillTextField("Apple", lastNameField);

    }

    @Test
    public void fillBasicDetails() throws InterruptedException {
        enterTextField("Mac Air M1", firstNameField);
        enterTextField("Apple", lastNameField);
        enterTextField("test@gmail.com", emailField);
        enterTextField("test@123", passwordField);
    }


    @AfterTest
    public void quitBrowser() throws InterruptedException {
        System.out.println("Data is filled and Brower will Quit");
        Thread.sleep(2000);
        chrome.quit();

    }
}
