package com.juaracoding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepTwoPage {

    @FindBy(className = "title")
    private WebElement checkoutTwoTitle;

    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckoutStepTwoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getCheckoutTwoTitle() {
        return checkoutTwoTitle.getText();
    }

    // TODO: After identify the item's details, then click Finish to final order
    public void clickFinish() {
        finishButton.click();
    }

}