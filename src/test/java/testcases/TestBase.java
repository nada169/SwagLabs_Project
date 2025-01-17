package testcases;

import drivers.DriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.setDriver;
import static pages.PageBase.quitBrowser;


public class TestBase {


    String username = "standard_user";
    String password = "secret_sauce";

    @Parameters("browsername")
    @BeforeTest
    public void OpenBrower(@Optional String browsername) {
        setDriver(DriverFactory.getNewInstance(""));

        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        getDriver().get("https://www.saucedemo.com/v1/");


    }

    @AfterTest
    public void TearDown() {
        quitBrowser(getDriver());
    }

}
