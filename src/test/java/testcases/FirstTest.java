package testcases;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import utils.CommonUtils;
//import utils.DriverUtils;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by abradford on 8/2/2016.
 */
public class FirstTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void setupChromeDriverLocation()
    {
        String chromeDriverLocation = "C:/Libraries/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Before
    public void goToHomepage() {
        driver.navigate().to("http://www.amazon.com");
    }

    @Test
    public void test_HomepageTitle()
    {

        assertTrue("Error with title of homepage", driver.getTitle().equals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"));
    }

    @Test
    public void test_logInAsUser()
    {
        WebElement myAccount = driver.findElement(By.id("nav-link-yourAccount"));
        myAccount.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_email")));

        WebElement userName = driver.findElement(By.id("ap_email"));
        userName.clear();
        userName.sendKeys("alexbradfordautomation@gmail.com");

        WebElement password = driver.findElement(By.id("ap_password"));
        password.clear();
        password.sendKeys("AutomationDemo");

        WebElement loginButton = driver.findElement(By.id("signInSubmit"));
        loginButton.click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-yourAccount")));
        WebElement myAccountIcon = driver.findElement(By.xpath("//*[@id=\"nav-link-yourAccount\"]/span[1]"));
        System.out.println(myAccountIcon.getText());
        String myAccountIconText = myAccountIcon.getText();
        assertEquals("Did not successfully log in", myAccountIconText, "Hello, Alex");
    }



//    @Test
//    public void test_logOut()
//    {
//        test_logInAsUser();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-yourAccount")));
//        //WebElement signOut = driver.findElement(By.id("nav-item-signout"));
//        //signOut.click();
//        driver.findElement(By.className("nav-link                                    nav-item")).click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInSubmit")));
//
//        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div[3]/div/div/form/div/div/div/h1"));
//        String signInText = signIn.getText();
//        assertEquals("Did not successfully sign out", signInText, "Sign In");
//    }



    @AfterClass
    public static void quitDriver()
    {
        driver.quit();
    }
}
