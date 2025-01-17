package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PO3_AddToCart extends PageBase {

    // TODO: constructor to intailize webdriver
    public PO3_AddToCart(WebDriver driver) {
        super(driver);
    }


    // TODO: define locators using By
    private final By SHOPPINGCART = By.xpath("//a[@href='./cart.html']");
    private final By CHECKBTTN = By.xpath("//a[@href='./checkout-step-one.html']");


    // TODO: public action methods
    public PO3_AddToCart clickOnShopingCart() {

        driver.findElement(this.SHOPPINGCART).click();
        return this;
    }


    public PO3_AddToCart clickOnCheckout() {

        driver.findElement(this.CHECKBTTN).click();
        return this;
    }


}
