package functionalTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AddToCart_SingleTest extends base {

    @BeforeTest
    public void initMe() throws IOException, InterruptedException {

        initializeDriver();
    }

    @Test
    public void testAddItem_Multiple() throws InterruptedException {

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};
        int j = 0;

        List<WebElement> product = driver.findElements(By.xpath("//h4[@class='product-name']"));

        for (int i = 0; i < product.size(); i++) {
            String[] name = product.get(i).getText().split("-");
            String formattedName = name[0].trim();

//format it to get actual vegetable name
//convert array into array list for easy search
//  check whether name you extracted is present in arrayList or not-

            List itemNeededList = Arrays.asList(itemsNeeded);
            if (itemNeededList.contains(formattedName)) {
                //click on Add to cart
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }

    }

    @AfterTest
    public void closeMe() throws IOException, InterruptedException {

        Thread.sleep(10000);
        driver.close();
    }
}

