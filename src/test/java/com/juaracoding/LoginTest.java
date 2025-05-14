package com.juaracoding;

import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    private LoginPage loginPage;
    private WebDriver driver;

    @BeforeClass
    public void init() {
        driver = DriverSingleton.getDriver();

        loginPage = new LoginPage(driver);

        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    @Parameters({ "username", "password" })
    public void loginTest(String username, String password) {
        loginPage.loginAction(username, password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
}