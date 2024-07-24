package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownPage {

    public By dropDownCourse = By.xpath("//select[@id='course']");

    public  By seleniumPracticeOption = By.xpath("//a[contains(text(),'Selenium Practice')]");

    public By dropdownPage = By.xpath("//a[contains(text(),'Dropdowns')]");

    public By multiDropDown = By.xpath("//select[@id='ide']");


    public void listOfDropdownElements(By locator, WebDriver driver){
        Select coursesList = new Select(driver.findElement(locator));
        List<WebElement> dropdownOptions = coursesList.getOptions();
        for(WebElement listOption: dropdownOptions){
            System.out.println("The List of Options in dropdown are:  "+listOption.getText());
            System.out.println("The List of Options in dropdown using the Value Attribute:  "+listOption.getAttribute("Value"));
        }
    }

    public void selectedValue(String selectedVal, WebDriver driver, Select objName){
        selectedVal = objName.getFirstSelectedOption().getText();
        System.out.println("The selected option is: "+ selectedVal);

    }

    public void multiSelectedValue(String selectedVal, WebDriver driver, Select objName, By locator){
        objName = new Select(driver.findElement(locator));
        List<WebElement> ideOptions = objName.getAllSelectedOptions();
        for(WebElement selectedOptions: ideOptions) {
            System.out.println("The multi-selected options is: " + selectedOptions.getText());
        }
    }

    public void selectOptionValue(String dropdownValue, By locator, WebDriver driver, String varName) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Locator to click: "+locator+"; DropdownValue: "+dropdownValue);
        Select courseNameDrop = new Select(driver.findElement(locator));
        listOfDropdownElements(locator,driver);
        courseNameDrop.selectByValue(dropdownValue);
        selectedValue(varName,driver,courseNameDrop);
        multiSelectedValue(varName,driver,courseNameDrop,locator);

    }

    public void selectOptionVIndex(int dropdownIndex, By locator, WebDriver driver, String varName) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Locator to click: "+locator+"; DropdownIndex: "+dropdownIndex);
        Select courseNameDrop = new Select(driver.findElement(locator));
        listOfDropdownElements(locator,driver);
        courseNameDrop.selectByIndex(dropdownIndex);
        selectedValue(varName,driver,courseNameDrop);
        multiSelectedValue(varName,driver,courseNameDrop,locator);

    }

    public void selectOptionVisibleText(String dropdownValue, By locator, WebDriver driver, String varName) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Locator to click: "+locator+"; DropdownVisibleText: "+dropdownValue);
        Select courseNameDrop = new Select(driver.findElement(locator));
        listOfDropdownElements(locator,driver);
        courseNameDrop.selectByVisibleText(dropdownValue);
        selectedValue(varName,driver,courseNameDrop);
        multiSelectedValue(varName,driver,courseNameDrop,locator);

    }

    public void deSelectOptionVisibleText(String dropdownValue, By locator, WebDriver driver, String varName) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Locator to click: "+locator+"; DropdownVisibleText: "+dropdownValue);
        Select courseNameDrop = new Select(driver.findElement(locator));
        listOfDropdownElements(locator,driver);
        courseNameDrop.deselectByVisibleText(dropdownValue);
        selectedValue(varName,driver,courseNameDrop);

    }

}
