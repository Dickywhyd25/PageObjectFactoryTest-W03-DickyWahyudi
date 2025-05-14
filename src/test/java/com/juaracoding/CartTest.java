package com.juaracoding;

import com.juaracoding.pages.CartPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTest {
    private CartPage cartPage;
    private WebDriver driver;

    @BeforeClass
    public void init() {
        driver = DriverSingleton.getDriver();
        cartPage = new CartPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // verify all of cart details that equals from getText
    @Test (priority = 1)
    public void verifyCartDetail() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(cartPage.getCartPageTitle(), "Your Cart");
        Thread.sleep(1000);
        Assert.assertEquals(cartPage.getItemName(), "Sauce Labs Bike Light");
        Thread.sleep(1000);
        Assert.assertEquals(cartPage.getItemDesc(), "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.");
        Thread.sleep(1000);
    }

    @Test (priority = 2)
    public void clickCheckout() {
        cartPage.clickCheckout();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

}