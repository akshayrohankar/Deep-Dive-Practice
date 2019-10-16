package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

//Nested Frames
public class HandlingMultipleWindowsMultipleTabs extends base {

    @BeforeTest
    public void initMe() throws IOException, InterruptedException {

        initializeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
    }

    @Test
    public void MultipleWindowsTabHandlingTest() throws InterruptedException {

        System.out.println(driver.findElements(By.tagName("a")).size());

        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));// Limiting webdriver scope

        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        //3-
        WebElement coloumndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(coloumndriver.findElements(By.tagName("a")).size());

        //4- click on each link in the coloumn and check if the pages are opening-
        for (int i = 1; i < coloumndriver.findElements(By.tagName("a")).size(); i++) {

            String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

            coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
            Thread.sleep(5000L);

        }// opens all the tabs
        Set<String> abc = driver.getWindowHandles();//4
        Iterator<String> it = abc.iterator();

        while (it.hasNext()) {

            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());

        }
    }
}