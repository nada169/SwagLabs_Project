package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class PageBase {


    WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    // TODO: clear all browser data after each test
    public static void quitBrowser(WebDriver driver) {
        // clear browser localStorage , sessionStorage and delete All Cookies
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
        ((JavascriptExecutor) driver).executeScript("window.sessionStorage.clear();");
        driver.manage().deleteAllCookies();
        driver.quit();
        // kill browser process on background
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
//                Runtime.getRuntime().exec("taskkill /F /IM chrome.exe /T");
            } else if (os.contains("mac") || os.contains("nix") || os.contains("nux")) {
                Runtime.getRuntime().exec("pkill -f chromedriver");
                Runtime.getRuntime().exec("pkill -f chrome");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void scrollingmethod() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Get the total height of the page
        long totalHeight = (long) js.executeScript("return document.body.scrollHeight");

        // Set scroll duration and steps
        int scrollDuration = 5000; // Total scrolling time in milliseconds
        int steps = 50; // Number of steps for smooth scrolling
        long scrollStep = totalHeight / steps; // Pixels to scroll per step
        long delay = scrollDuration / steps; // Delay per step in milliseconds

        // Perform smooth scrolling
        for (int i = 0; i < steps; i++) {
            js.executeScript("window.scrollBy(0, " + scrollStep + ");");
            try {
                Thread.sleep(delay); // Pause between each scroll step
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
