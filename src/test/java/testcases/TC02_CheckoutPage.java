package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static drivers.DriverHolder.getDriver;
import static pages.PO2_ProductPage.totalPrice;
import static util.UtilityCodes.*;

public class TC02_CheckoutPage extends TestBase {

    String fName = generateRandomFirstName();
    String lName = generateRandomLasttName();
    String pCode = generateRandomPostalCode(5);


    @Test(priority = 1, description = "CompleteCheckpout")
    public void CompleteCheckout_P() throws InterruptedException {
        new P01_LoginPage(getDriver()).enterUsername(username).enterPassword(password).clickLoginButton();


        new PO2_ProductPage(getDriver()).genrateRandomProducts();
        Thread.sleep(3000);

        new PO3_AddToCart(getDriver()).clickOnShopingCart().clickOnCheckout();

        new P04_CheckoutPage(getDriver()).getrandomfirstname(fName).getrandomlastname(lName).getrandomPostalcode(pCode);
        Thread.sleep(2000);
        double chekoutsummationprice = new P04_CheckoutPage(getDriver()).clickContinue().getItemsPrice();
        new PageBase(getDriver()).scrollingmethod();
        System.out.println("chekout summation price");
        System.out.println(chekoutsummationprice);
        Assert.assertEquals(totalPrice, chekoutsummationprice);
         Thread.sleep(1000);

        double taxs = new P04_CheckoutPage(getDriver()).getItemstax();
        double finalpurchases = new P04_CheckoutPage(getDriver()).getfinaltotal();
        System.out.println("finalpurchases");
        System.out.println(finalpurchases);
        double sum = totalPrice + taxs;
        sum = Math.round(sum * 100.0) / 100.0;
        System.out.println("sum");
        System.out.println(sum);
        Assert.assertEquals(sum, finalpurchases);
        Thread.sleep(1000);

        String sucesstext = new P04_CheckoutPage(getDriver()).finsihcheckout().getsucesstext();
        Assert.assertEquals(sucesstext, "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        Thread.sleep(2000);


    }

}