package com.juaracoding;

import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.CheckoutStepTwoPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutStepTwoTest {

    private CheckoutStepTwoPage checkoutStepTwoPage;
    private CartPage cartPage;
    private WebDriver driver;

    @BeforeClass
    public void init() {
        driver = DriverSingleton.getDriver();
        checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        cartPage = new CartPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // verify all of item details from CartPage that equals with getText
    @Test (priority = 1)
    public void verifyCheckoutTwoPage() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(checkoutStepTwoPage.getCheckoutTwoTitle(), "Checkout: Overview");
        Thread.sleep(1000);
        Assert.assertEquals(this.cartPage.getItemName(), "Sauce Labs Bike Light");
        Thread.sleep(1000);
        Assert.assertEquals(this.cartPage.getItemDesc(), "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.");
        Thread.sleep(1000);
    }

    @Test (priority = 2)
    public void clickFinish() {
        checkoutStepTwoPage.clickFinish();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

}