package page_objects;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.security.PublicKey;

public class BasicControlsPage {
    WebDriver driver;
    @FindBy(xpath = "//input[@id='femalerb']")
    WebElement femaleRadio;

    public By femaleRadioBtn = By.xpath("//input[@id='femalerb']");
    public By maleRadioBTn = By.xpath("//input[@id='malerb']");

    public By lainLanguage = By.xpath("//input[@id='latinchbx']");
    public By englishLanguage = By.xpath("//input[@id='englishchbx']");
    public By firstNameField = By.xpath("//input[@id='firstName']");
    public By lastNameField = By.xpath("//input[@id='lastName']");
    public By emailField = By.xpath("//input[@id='email']");
    public By passwordField = By.xpath("//input[@id='password']");
    public By successMessage = By.xpath("//label[@id='msg']");

    public By navigateHome = By.xpath("//a[@id='navigateHome']");

    public By registrationButton = By.xpath("//button[@id='registerbtn']");



    public void attemptRadio(WebDriver driver, By locator) {

        if (driver.findElement(locator).isEnabled()) {
            System.out.println("The locator: " + locator + "state is enabled ");
            if (driver.findElement(locator).isSelected()) {
                System.out.println("Element is already selected");
            } else {
                driver.findElement(locator).click();
                System.out.println(locator + "Option is selected");
            }
        } else {
            System.out.println("The locator: " + locator + "state is disabled ");

        }
    }

    public void enterTextField(WebDriver driver, String testData, By locator) throws InterruptedException {
        if (driver.findElement(locator).isDisplayed()) {
            Thread.sleep(1000);
            System.out.println("Locator is Displayed");
            if (driver.findElement(locator).isEnabled()) {
                System.out.println("Locator is enabled");
                driver.findElement(locator).sendKeys(testData);
                System.out.println("Browser launched Data inside locator: " + locator + "and entered Text data: " + testData);
                Thread.sleep(1000);
                String enteredTxt = driver.findElement(locator).getAttribute("Value");
                System.out.println("Entered text in the locator is:" + enteredTxt);

            } else {
                System.err.println("Locator is disabled");
            }
        } else {
            System.err.println("Locator is Enabled");
        }
    }


}

