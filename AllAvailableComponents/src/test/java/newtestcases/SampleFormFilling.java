package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import page_objects.BasicControlsPage;
import page_objects.DropDownPage;
import page_objects.HomePage;
import utils.UtilsCommon;

import java.io.File;
import java.io.IOException;

public class SampleFormFilling {

    WebDriver chrome;
    Dimension dm;
    Assertion hardAssert = new Assertion();
    public String applicationUrl = "https://www.hyrtutorials.com/p/basic-controls.html";
    BasicControlsPage bcp = new BasicControlsPage();
    DropDownPage dp = new DropDownPage();
    HomePage hm = new HomePage();
    ChromeOptions co = new ChromeOptions();
    UtilsCommon uc = new UtilsCommon();

    public Dimension setBrwoserDimension() {
        int width = 1440, height = 779;
        dm = new Dimension(width, height);
        return dm;
    }

    public void assertDisplayedText(String currentExpected, By locator, WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("The String to compare is: " + currentExpected + "Locator available is: " + locator);
        String textDisplayed = driver.findElement(locator).getText();
        System.out.println("The text in the locator is:" + textDisplayed);
        Assert.assertEquals(currentExpected, textDisplayed);
        System.out.println("The displayed text is: " + textDisplayed + "And equals to " + currentExpected);
    }

    public void installBlockAdd() {
        System.out.println("Initialising the browser and blocking adds ");
        co.addExtensions(new File("./Extensions/AdBlock.crx"));
        chrome = WebDriverManager.chromedriver().capabilities(co).create();
    }

    @BeforeTest
    public WebDriver launchBrowser() throws InterruptedException, IOException {
        System.out.println("Initialising the browser and blocking adds ");
        co.addExtensions(new File("./Extensions/AdBlock.crx"));
        chrome = WebDriverManager.chromedriver().capabilities(co).create();
        Thread.sleep(10000);
        System.out.println("Launching Browser");
        chrome.get(applicationUrl);
        uc.performScreenShot(chrome, "launch.png");
        chrome.manage().window().setSize(setBrwoserDimension());
        return chrome;
    }


    @Test(priority = 2)
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

    @Test(priority = 1)
    public void dropDownSelection() throws InterruptedException, IOException {
        Thread.sleep(2000);
        bcp.mouseHover(chrome, dp.seleniumPracticeOption);
        bcp.attemptRadio(chrome, dp.dropdownPage);
        uc.performScreenShot(chrome, "dropdown.png");
        //Single Dropdown
        dp.selectOptionValue("js", dp.dropDownCourse, chrome, "storeValue");
        dp.selectOptionVIndex(1, dp.dropDownCourse, chrome, "storeValue");
        dp.selectOptionVisibleText("Python", dp.dropDownCourse, chrome, "storeValue");
        // MultiSelectDropdown
        dp.selectOptionValue("ec", dp.multiDropDown, chrome, "storeValue");
        dp.selectOptionVIndex(3, dp.multiDropDown, chrome, "storeValue");
        dp.selectOptionVisibleText("Visual Studio", dp.multiDropDown, chrome, "storeValue");
        dp.selectOptionValue("ij", dp.multiDropDown, chrome, "storeValue");
        dp.deSelectOptionVisibleText("Visual Studio", dp.multiDropDown, chrome, "storeValue");

    }


    @AfterTest
    public void quitBrowser() throws InterruptedException {
        System.out.println("Brower will Quit");
        Thread.sleep(2000);
        chrome.quit();

    }



}
