package com.juaracoding.strategies;

import com.juaracoding.managers.ChromeManager;
import com.juaracoding.managers.FirefoxManager;
import com.juaracoding.utils.Browser;
import org.openqa.selenium.WebDriver;

public class DriverStrategies {

    public static WebDriver setStrategy(String browser) {
        if (browser.equals(Browser.CHROME)) {
            return ChromeManager.buildDriver();
        } else if (browser.equals(Browser.FIREFOX)) {
            return FirefoxManager.buildDriver();
        } else {
            return ChromeManager.buildDriver();
        }
    }
}
