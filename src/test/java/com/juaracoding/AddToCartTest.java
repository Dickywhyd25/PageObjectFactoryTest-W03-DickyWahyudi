package com.juaracoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.juaracoding.HomePage;

public class AddToCartTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @Test
    public void testAddToCart() {
        homePage.addToCart();
        homePage.goToCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
