package assignments;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
 //Nested Frames
public class HandlingMultipleFrames extends base {

    @BeforeTest
    public void initMe() throws IOException, InterruptedException {

        initializeDriver();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void MultipleWindowsHandlingTest() throws InterruptedException {

        driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();

        System.out.println(driver.findElements(By.tagName("frame")).size());

        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());

    }
}
