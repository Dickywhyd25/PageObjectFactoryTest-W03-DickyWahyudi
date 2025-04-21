package com.juaracoding;

import com.juaracoding.pages.CheckoutStepOnePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutStepOneTest {
    private CheckoutStepOnePage checkoutStepOnePage;
    private WebDriver driver;

    @BeforeClass
    public void init() {
        driver = DriverSingleton.getDriver();
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // verify the title that equals from getText
    @Test (priority = 1)
    public void verifyCheckoutOnePage() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(checkoutStepOnePage.getCheckoutOneTitle(), "Checkout: Your Information");
        Thread.sleep(1000);
    }

    // ensure that parameters had the same value that called by sendkeys
    @Test (priority = 2)
    @Parameters({ "firstname", "lastname", "postalcode" })
    public void checkoutAction(String firstname, String lastname, String postalcode) {
        checkoutStepOnePage.checkoutAction(firstname, lastname, postalcode);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

}