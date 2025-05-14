package com.juaracoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class MasterTest {
    protected WebDriver driver;
    protected Boolean isQuite = true;

    @BeforeClass
    @Parameters("url")
    public void init(String url) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setBinary("C:\\chrome-win64\\chrome.exe");
        driver = new ChromeDriver(options);
        driver.get(url);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        if (isQuite) {
            driver.quit();
        }
    }
}