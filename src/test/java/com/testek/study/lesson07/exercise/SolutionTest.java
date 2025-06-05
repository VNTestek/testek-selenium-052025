package com.testek.study.lesson07.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @Test(description = "Element Interaction: Windows & Tab")
    public void testWindowsAndTab() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.WINDOWS);

        // Handle your code here

    }

    @Test(description = "Element Interaction: Small Frame")
    public void testSmallFrame() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.FRAME);

        // Handle your code here
        String smallFrameID = "small-frame";
        WebElement smallFrameEle = mWebDriver.findElement(By.id(smallFrameID));

        // frame interaction
        mWebDriver.switchTo().frame(smallFrameEle);
        WebElement lblSmallFrameTitleEle = mWebDriver.findElement(By.tagName("h1"));
        System.out.println("Small Frame Title: " + lblSmallFrameTitleEle.getText());
        WebElement lblSmallFrameTextContentEle = mWebDriver.findElement(By.tagName("p"));
        System.out.println("Small Frame Text Content: " + lblSmallFrameTextContentEle.getText());

        // Back to page contents
        mWebDriver.switchTo().defaultContent();

    }

    @Test(description = "Element Interaction: Alert")
    public void testAlert() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.ALERT);

        // Handle your code here
        String XPATH_BUTTON_FORM = "//button[@id = '%s']";

        //Confirm Alert btn
        String btnConfirmAlertXPath = String.format(XPATH_BUTTON_FORM, "confirmAlert");
        WebElement btnConfirmAlertEle = mWebDriver.findElement(By.xpath(btnConfirmAlertXPath));
        btnConfirmAlertEle.click();
        Alert confirmAlert = mWebDriver.switchTo().alert();
        System.out.println("Simple Alert text value: " + confirmAlert.getText());
        confirmAlert.accept();

        //Prompt Alert
        String btnPromptAlertXPath = String.format(XPATH_BUTTON_FORM, "promptAlert");
        WebElement btnPromptAlertEle = mWebDriver.findElement(By.xpath(btnPromptAlertXPath));
        btnPromptAlertEle.click();
        Alert promptAlert = mWebDriver.switchTo().alert();
        System.out.println("Prompt Alert text value: " + promptAlert.getText());
        promptAlert.sendKeys("ToanTK test prompt alert");
        waitForDebug(2000);
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
}
