package com.juaracoding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CheckoutStepOnePage {
    private Actions actions;

    @FindBy(className = "title")
    private WebElement checkoutOneTitle;

    // TODO: Identify all of fields that used to fill
    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public CheckoutStepOnePage(WebDriver driver) {
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public String getCheckoutOneTitle() {
        return checkoutOneTitle.getText();
    }

    // TODO: Send keys for send value to insert the fields
    public void checkoutAction(String firstname, String lastname, String postalcode) {
        actions.click(firstNameField).sendKeys(firstname)
                .pause(Duration.ofSeconds(2))
                .click(lastNameField).sendKeys(lastname)
                .pause(Duration.ofSeconds(2))
                .click(postalCodeField).sendKeys(postalcode)
                .pause(Duration.ofSeconds(2))
                .moveToElement(continueButton).click().build().perform();
    }
}
