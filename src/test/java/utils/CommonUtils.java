package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by abradford on 8/24/2016.
 */
public class CommonUtils {

    public static int timeout = 10;

    public CommonUtils() {
        _driver = DriverUtils.getDriver();
    }

    public static WebDriver _driver;
    public WebDriverWait wait;
    public Actions actions;
    public Select select;

    public void navigateToUrl(String URL)
    {
        _driver.navigate().to(URL);
    }


}
