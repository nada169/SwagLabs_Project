package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static util.UtilityCodes.generateRandomIndex;
import static util.UtilityCodes.generateRandomInt;

public class PO2_ProductPage extends PageBase {
    // TODO: constructor to intailize webdriver
    public PO2_ProductPage(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using By
    private final By PRODUCTLIST = By.className("inventory_item");
    private final By BUTTONADDTOCART = By.xpath("//div[@class='pricebar']/button[text()='ADD TO CART']");
    private final By PRICESS = By.xpath("//div[@class='inventory_item_price']");
    static public double totalPrice = 0.0;

    // TODO: public action methods
    public PO2_ProductPage genrateRandomProducts() throws InterruptedException {


        List<WebElement> productElements = driver.findElements(this.PRODUCTLIST);
        List<WebElement> addToCartButtons = driver.findElements(this.BUTTONADDTOCART);
        List<WebElement> priceElements = driver.findElements(this.PRICESS);

        // Generate a random number of products to add to the cart using the imported static method
        int randomCount = generateRandomInt(6);  // Random number between 1 and 6
        System.out.println("Random Count: " + randomCount);
        List<Integer> selectedIndices = new ArrayList<>();
        // Variable to store the summation of selected product prices

        for (int i = 0; i < randomCount; i++) {
            int randomIndex;
            do {
                // Generate a random index between 0 and productElements.size() - 1
                randomIndex = generateRandomInt(productElements.size()) - 1;
            } while (selectedIndices.contains(randomIndex));  // Ensure that index is unique

            // Click the "Add to Cart" button for the selected product
            addToCartButtons.get(randomIndex).click();
            selectedIndices.add(randomIndex);  // Store the index to avoid duplicates

            // Extract the price for the selected product
            String priceText = priceElements.get(randomIndex).getText();
            String cleanPrice = priceText.replaceAll("[^\\d.]", "");  // Remove anything that's not a digit or period
            double price = Double.parseDouble(cleanPrice);  // Convert to double for floating point precision

            // Add the current product's price to the totalPrice
            totalPrice += price;

            // Debugging - Print each random index selection and its price
            System.out.println("Random index: " + randomIndex + ", Price: " + price);
        }

        // Print the total sum of selected product prices
        System.out.println("Total price of selected products: " + totalPrice);


        return this;
    }


}