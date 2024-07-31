package page_objects;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class WindowsPage {

    public void tabSwitch(WebDriver driver) throws InterruptedException {

        Thread.sleep(4000);
        String parentTab = driver.getWindowHandle();
        String parentTabTittle = driver.getTitle();

        System.out.println("Parent tab address: " + parentTab + "  Title of the tab:  " + parentTabTittle);
        Set<String> allTabs = driver.getWindowHandles();
        List<String> allWindows = new ArrayList<>();

        for (String tabs : allTabs) {
            driver.switchTo().window(tabs);
            System.out.println("Tabs Address are: " + tabs);
            allWindows.add(driver.getTitle());
        }
        for (String tabTittles : allWindows) {
            System.out.println("Tabs Tittles are: " + tabTittles);
        }

        addTabClose(driver);

        driver.switchTo().window(parentTab);


    }


    public void addTabClose(WebDriver driver) throws InterruptedException {
        Thread.sleep(4000);
        String currentUrl = driver.getTitle();
        if (currentUrl.contains("AdBlock")) {
            driver.close();
            System.out.println("Add block is closed");
        } else {
            System.out.println("Currently in parent window");
        }


    }
}
