package com.juaracoding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage {

    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartBadge;

    @FindBy(className = "btn_inventory")
    private List<WebElement> btnInventories;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;

    public InventoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getShoppingCartBadge() {
        return shoppingCartBadge.getText();
    }

    public void addToCart(int index) {
        btnInventories.get(index).click();
    }

    // TODO: After choose item for added to Cart, then click icon Cart to direct to Cart Page
    public void clickCart() {
        shoppingCartLink.click();
    }

}

