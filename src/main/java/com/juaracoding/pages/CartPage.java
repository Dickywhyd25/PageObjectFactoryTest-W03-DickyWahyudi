package com.juaracoding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    // TODO: identify all of item details
    @FindBy(className = "inventory_item_name")
    private WebElement itemName;

    @FindBy(className = "inventory_item_desc")
    private WebElement itemDesc;

    @FindBy(className = "title")
    private WebElement cartPageTitle;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getItemName() {
        return itemName.getText();
    }

    public String getItemDesc() {
        return itemDesc.getText();
    }

    public String getCartPageTitle() {
        return cartPageTitle.getText();
    }

    // TODO: After identify the item's details, then click Checkout
    public void clickCheckout() {
        checkoutButton.click();
    }

}

