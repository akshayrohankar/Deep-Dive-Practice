package pageObjects;

import org.openqa.selenium.WebDriver;
import resources.base;

public class HomePage extends base {

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    WebDriver driver;
}
