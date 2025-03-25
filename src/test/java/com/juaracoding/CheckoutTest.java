package com.juaracoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.juaracoding.CartPage;
import com.juaracoding.CheckoutPage;

public class CheckoutTest {
    WebDriver driver;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void testCheckout() {
        cartPage.proceedToCheckout();
        checkoutPage.enterCheckoutDetails("John", "Doe", "12345");
        checkoutPage.finishCheckout();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete"));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

