package com.juaracoding;


import com.juaracoding.pages.CheckoutCompletePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutCompleteTest {

    private CheckoutCompletePage checkoutCompletePage;
    private WebDriver driver;

    @BeforeClass
    public void init() {
        driver = DriverSingleton.getDriver();
        checkoutCompletePage = new CheckoutCompletePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // verify all of details that had value who equals from getText
    @Test(priority = 1)
    public void verifyOrder() throws InterruptedException {
        Thread.sleep(1500);
        Assert.assertEquals(checkoutCompletePage.getCompleteHeader(), "Thank you for your order!");
        Thread.sleep(1500);
        Assert.assertEquals(checkoutCompletePage.getCompleteText(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        Thread.sleep(1500);
    }

    @Test (priority = 2)
    public void clickBackHome() {
        checkoutCompletePage.clickBackHome();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

}
