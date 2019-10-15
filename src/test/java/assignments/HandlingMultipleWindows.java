package assignments;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class HandlingMultipleWindows extends base {

    @BeforeTest
    public void initMe() throws IOException, InterruptedException {

        initializeDriver();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void MultipleWindowsHandlingTest() throws InterruptedException {

        driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();

        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentId = it.next();
        String childId = it.next();

        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText());

        driver.switchTo().window(parentId);
        System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText());
    }



}
