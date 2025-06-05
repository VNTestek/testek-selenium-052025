package com.testek.study.lesson07.exercise;

import com.testek.study.common.Menu;
import io.cucumber.java.cs.Ale;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Objects;

import static java.lang.Thread.sleep;

@Getter
@Setter
public class SolutionTest {
    // The driver for interacting with the webpage
    private WebDriver mWebDriver;

    /**
     * Method will be executed before each class, configure Chrome Driver and initialize
     */
    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--max-window-size");
        chromeOptions.addArguments("--remote-allow-origins=*");
        mWebDriver = new ChromeDriver(chromeOptions);
    }

    /**
     * Method will be executed after each class, will close all running chrome sessions - Debug Mode
     **/
    @AfterClass
    public void afterClass() {
        if (Objects.nonNull(mWebDriver)) mWebDriver.quit();
    }

    /**
     * URL: <a href="https://testek.vn/lab/auto/web-elements">...</a>
     * Access to Elements navigation
     */

    @Test(description = "Element Interaction: Small Frame")
    public void testSmallFrame() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.FRAME);

        // Handle your code here
        //Find and access to small frame
        String frmSmallID = "small-frame";
        WebElement frmSmallEle = mWebDriver.findElement(By.id(frmSmallID));
        mWebDriver.switchTo().frame(frmSmallEle);

        //get text in small frame
        WebElement lblTitleEle = mWebDriver.findElement(By.tagName("h1"));
        String title = lblTitleEle.getText();
        WebElement lblTextEle = mWebDriver.findElement(By.tagName("p"));
        String text = lblTextEle.getText();

        //Print text
        System.out.println("Title: " + title);
        System.out.println("Text: " + text);

        //Back to default content
        mWebDriver.switchTo().defaultContent();
    }

    @Test(description = "Element Interaction: Alert")
    public void testAlert() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.ALERT);

        // Handle your code here
        String FORM_XPATH_BUTTON = "//button[@id='%s']";

        String btnConfirmAlert = String.format(FORM_XPATH_BUTTON, "confirmAlert");
        WebElement btnConfirmAlertELe = mWebDriver.findElement(By.xpath(btnConfirmAlert));
        btnConfirmAlertELe.click();
        Alert confirmAlert = mWebDriver.switchTo().alert();
        waitForDebug(5000);
        System.out.println("Confirm alert text : " + confirmAlert.getText());
        confirmAlert.accept();

        String btnPromptAlert = String.format(FORM_XPATH_BUTTON, "promptAlert");
        WebElement btnPromptAlertEle = mWebDriver.findElement(By.xpath(btnPromptAlert));
        btnPromptAlertEle.click();
        Alert promptAlert = mWebDriver.switchTo().alert();
        System.out.println("Prompt alert text : " + promptAlert.getText());
        waitForDebug(5000);
        promptAlert.sendKeys("Minh Hiep");
        waitForDebug(5000);
        promptAlert.accept();

    }

     /**
     * Go to Test Website
     */
    private void gotoTestWebsite(Menu parent, Menu subMenu) {
        String url = "https://testek.vn/lab/auto/web-elements/";
        mWebDriver.get(url);

        String XPATH_MENU_FORMAT = "//div[@test-id='%s']";

        // Access: Form > [Student Form]
        WebElement mnuElementEle = mWebDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, parent.getName())));
        mnuElementEle.click();

        WebElement mnuEle = mWebDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, subMenu.getName())));
        mnuEle.click();

        waitForDebug(5000);
    }

    /**
     * Sleep for debugging
     *
     * @param milliseconds : number of milliseconds
     */
    private void waitForDebug(long milliseconds) {
        try {
            sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testWindowsInteraction(){
        mWebDriver.get("https://testek.vn/lab/auto/web-elements/");
        waitForDebug(3000);
        String homePageID = mWebDriver.getWindowHandle();


    }
}
