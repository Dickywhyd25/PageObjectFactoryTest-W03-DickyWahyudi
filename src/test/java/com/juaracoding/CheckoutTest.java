package com.juaracoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.juaracoding.*;

public class CheckoutTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        HomePage homePage = new HomePage(driver);
        homePage.addToCart();
        homePage.goToCart();
    }

    @Test
    public void testCheckout() {
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutDetails("John", "Doe", "12345");
        checkoutPage.finishCheckout();

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete.html"));
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}