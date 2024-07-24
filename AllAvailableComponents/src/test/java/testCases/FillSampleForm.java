package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import page_objects.BasicControlsPage;
import page_objects.HomePage;

import java.io.File;

public class FillSampleForm {

    WebDriver chrome;
    Dimension dm;
    Assertion hardAssert = new Assertion();
    public String applicationUrl = "https://www.hyrtutorials.com/p/basic-controls.html";
    BasicControlsPage bcp = new BasicControlsPage();
    HomePage hm = new HomePage();
    ChromeOptions co = new ChromeOptions();

    public Dimension setBrwoserDimension() {
        int width = 1440, height = 779;
        dm = new Dimension(width, height);
        return dm;
    }

    public void assertDisplayedText(String currentExpected, By locator, WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("The String to compare is: " + currentExpected + "Locator available is: " + locator);
        String textDisplayed = driver.findElement(locator).getText();
        System.out.println("The text in the locator is:"+ textDisplayed);
        Assert.assertEquals(currentExpected, textDisplayed);
        System.out.println("The displayed text is: " + textDisplayed + "And equals to " + currentExpected);
    }

    public void installBlockAdd(){
        System.out.println("Initialising the browser and blocking adds ");
        co.addExtensions(new File("./Extensions/AdBlock.crx"));
        chrome = WebDriverManager.chromedriver().capabilities(co).create();
    }

    @BeforeTest
    public WebDriver launchBrowser() throws InterruptedException {
        System.out.println("Initialising the browser and blocking adds ");
        co.addExtensions(new File("./Extensions/AdBlock.crx"));
        chrome = WebDriverManager.chromedriver().capabilities(co).create();
        Thread.sleep(60000);
        System.out.println("Launching Browser");
        chrome.get(applicationUrl);
        chrome.manage().window().setSize(setBrwoserDimension());
        return chrome;
    }


    @Test
    public void fillForm() throws InterruptedException {
        Thread.sleep(2000);
        bcp.enterTextField(chrome, "MacBook M1", bcp.firstNameField);
        bcp.enterTextField(chrome, "Apple", bcp.lastNameField);
        bcp.attemptRadio(chrome, bcp.femaleRadioBtn);
        bcp.attemptRadio(chrome, bcp.maleRadioBTn);
        bcp.attemptRadio(chrome, bcp.englishLanguage);
        bcp.attemptRadio(chrome, bcp.lainLanguage);
        bcp.enterTextField(chrome, "test@test.com", bcp.emailField);
        bcp.enterTextField(chrome, "test@123", bcp.passwordField);
        bcp.attemptRadio(chrome, bcp.registrationButton);
        assertDisplayedText("Registration is Successful", bcp.successMessage, chrome);
        bcp.attemptRadio(chrome, bcp.navigateHome);
        System.out.println("Home Page URL" + chrome.getCurrentUrl());

    }


    @AfterTest
    public void quitBrowser() throws InterruptedException {
        System.out.println("Brower will Quit");
        Thread.sleep(2000);
        chrome.quit();

    }
}
