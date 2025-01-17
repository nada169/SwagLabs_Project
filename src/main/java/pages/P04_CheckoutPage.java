package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class P04_CheckoutPage extends PageBase {


    // TODO: constructor to intailize webdriver
    public P04_CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using By

    private final By FIRSTNAME = By.id("first-name");
    private final By LASTNAME = By.id("last-name");
    private final By POSTALCODE = By.id("postal-code");
    private final By CONTINUE = By.xpath("//input[@value='CONTINUE']");
    private final By SUMMARYTOTAL = By.xpath("//div[@class='summary_subtotal_label']");
    private final By TAX = By.xpath("//div[@class='summary_tax_label']");
    private final By FINALTOTAL = By.xpath("//div[@class='summary_total_label']");
    private final By FINISHBTTN = By.xpath("//a[@href='./checkout-complete.html']");
    private final By SUCCESSTEXT = By.xpath("//div[@class='complete-text']");


    // TODO: public action methods


    public P04_CheckoutPage getrandomfirstname(String F) {

        driver.findElement(this.FIRSTNAME).sendKeys(F);
        return this;

    }

    public P04_CheckoutPage getrandomlastname(String L) {

        driver.findElement(this.LASTNAME).sendKeys(L);
        return this;

    }

    public P04_CheckoutPage getrandomPostalcode(String P) {

        driver.findElement(this.POSTALCODE).sendKeys(P);
        return this;

    }

    public P04_CheckoutPage clickContinue() {

        driver.findElement(this.CONTINUE).click();
        return this;

    }

    public double getItemsPrice() {

        String pricevalue = driver.findElement(this.SUMMARYTOTAL).getText();
        String finalprice = pricevalue.replaceAll("[^\\d.]", "");
        double fprice = Double.parseDouble(finalprice);
        System.out.println("item Price inside checkout");
        System.out.println(finalprice);

        return fprice;

    }

    public double getItemstax() {

        String pricevaluetax = driver.findElement(this.TAX).getText();
        String taxprice = pricevaluetax.replaceAll("[^\\d.]", "");
        double ftax = Double.parseDouble(taxprice);
        System.out.println("Tax inside checkout");
        System.out.println(ftax);

        return ftax;

    }

    public double getfinaltotal() {

        String pricevaluetotal = driver.findElement(this.FINALTOTAL).getText();
        String ftotal = pricevaluetotal.replaceAll("[^\\d.]", "");
        double fpay = Double.parseDouble(ftotal);
        System.out.println("Totalprice after tax inside checkout");
        System.out.println(fpay);

        return fpay;

    }

    public P04_CheckoutPage finsihcheckout() {

        driver.findElement(this.FINISHBTTN).click();
        return this;

    }

    public String getsucesstext() {

        String messagetext = driver.findElement(this.SUCCESSTEXT).getText();
        String updated = messagetext.replaceAll("\\s+", " ").trim();

        return updated;

    }


}
