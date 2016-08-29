package utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by abradford on 8/25/2016.
 */
public class DriverUtils {

    public static WebDriver _driver;

    @Before
    public static WebDriver getDriver()
    {
        if (_driver == null)
        {
            String chromeDriverLocation = "C:/Libraries/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
            _driver = new ChromeDriver();
        }
        return _driver;
    }

    @After
    public void tearDown()
    {
        _driver.close();
        _driver.quit();
    }


}
