package com.juaracoding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {

    // TODO: identify all of page's details to ensure the text that appears are the same
    @FindBy(className = "complete-header")
    private WebElement completeHeader;

    @FindBy(className = "complete-text")
    private WebElement completeText;

    @FindBy(id = "back-to-products")
    private WebElement backToProductsLink;

    public CheckoutCompletePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getCompleteHeader() {
        return completeHeader.getText();
    }

    public String getCompleteText() {
        return completeText.getText();
    }

    // TODO: After final order, then click Back Home for direct back to Products / Inventory page
    public void clickBackHome() {
        backToProductsLink.click();
    }

}
