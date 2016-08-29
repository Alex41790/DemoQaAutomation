package pages;

import org.openqa.selenium.By;
import utils.CommonUtils;

/**
 * Created by abradford on 8/25/2016.
 */
public class HomePage extends CommonUtils
{
    private final By MY_ACCOUNT = By.id("account");
    private final By SHOPPING_CART = By.id("header_cart");
    private final By CART_COUNT = By.className("count");

    public HomePage()
    {

    }

    public void navigateToHomePage()
    {
        String url = "http://store.demoqa.com";
        System.out.println("Navigating to demoqa.com: " + url);
        navigateToUrl(url);
    }


}
