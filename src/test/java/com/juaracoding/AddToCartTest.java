package com.juaracoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.juaracoding.LoginPage;
import com.juaracoding.HomePage;

public class AddToCartTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void testAddToCart() {
        HomePage homePage = new HomePage(driver);
        homePage.addToCart();
        homePage.goToCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"));
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}