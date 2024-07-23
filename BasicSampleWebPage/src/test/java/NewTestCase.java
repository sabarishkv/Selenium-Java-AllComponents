import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class NewTestCase {

    public By PlatformButton = By.xpath("//a[contains(text(),'Platform')]");
    public By platformLinks = By.xpath("//div[contains(@class,'product__dropdown')]//a");


    @Test
    public void FirstTestcase() throws InterruptedException {
        System.out.println("New Test case");
        WebDriver chrome = WebDriverManager.chromedriver().create();
        chrome.get("https://www.lambdatest.com/selenium-playground/");
        Thread.sleep(5000);
        Actions actions = new Actions(chrome);
        actions.moveToElement(chrome.findElement(PlatformButton)).build().perform();
        Thread.sleep(5000);
        List<WebElement> elements = chrome.findElements(platformLinks);

        for (WebElement element : elements) {
            System.out.println("Locator Names:" + element.getTagName());
            System.out.println("Link Names:" + element.getText());
            System.out.println("Link URL: "+ element.getAttribute("href"));
        }

    }
}
