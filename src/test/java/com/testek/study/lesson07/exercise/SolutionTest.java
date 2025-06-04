package com.testek.study.lesson07.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Objects;
import java.util.Set;

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
    @Test(description = "Element Interaction: New Window, New tab")
    public void testWindow() {
        String baseURL = "https://testek.vn/lab/auto/web-elements/";
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.WINDOWS);

        // Handle your code here

        //List sub-menu in menu
        String[] listMenu = {
                "#browser-windows",
                "#alerts",
                "#frames",
                "#nested-frames",
                "#modal-dialogs",
        };

        //Open each menu in new tab
        for (String menu : listMenu) {
            WebDriver newTab = mWebDriver.switchTo().newWindow(WindowType.TAB);
            newTab.get(baseURL + menu);

        }
        waitForDebug(2000);

        for (String menu : listMenu) {
            //Open new window
            WebDriver newWindow = mWebDriver.switchTo().newWindow(WindowType.WINDOW);
            newWindow.get(baseURL);
            //Open 2nd tab in this window
            WebDriver secondTab = mWebDriver.switchTo().newWindow(WindowType.TAB);
            secondTab.get(baseURL + menu);
        }
        waitForDebug(2000);

        //Back to homepage
        Set<String> windowHandles = mWebDriver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            mWebDriver.switchTo().window(windowHandle);
            mWebDriver.get(baseURL);
        }
        //Print window list
        Set<String> windowList = mWebDriver.getWindowHandles();
        System.out.println("Current window list: ");
        for (String windowHandle : windowList) {
            System.out.println(" - " + windowHandle);
        }

    }

    @Test(description = "Element Interaction: Small Frame")
    public void testSmallFrame() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.FRAME);

        // Handle your code here

        //Access small frame
        String smallFrId = "small-frame";
        WebElement smallFrmEle = mWebDriver.findElement(By.id(smallFrId));
        mWebDriver.switchTo().frame(smallFrmEle);
        WebElement lblTitleEle = mWebDriver.findElement(By.tagName("h1"));
        WebElement lblTxtEle = mWebDriver.findElement(By.tagName("p"));

        //Print text in small frame
        String txtTitle = lblTitleEle.getText();
        System.out.println("Title in small frame: " + txtTitle);
        String txtInFrm = lblTxtEle.getText();
        System.out.println("Text in small frame: " + txtInFrm);

        //Back to default content
        mWebDriver.switchTo().defaultContent();


    }

    @Test(description = "Element Interaction: Alert")
    public void testAlert() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.ALERT);

        // Handle your code here
        String FORM_XPATH_BTN = "//button[@id='%s']";
        String btnConfirmAlert = String.format(FORM_XPATH_BTN, "confirmAlert");
        WebElement btnAlert = mWebDriver.findElement(By.xpath(btnConfirmAlert));
        btnAlert.click();
        Alert confirmAlert = mWebDriver.switchTo().alert();
        System.out.println("Confirm alert text: " + confirmAlert.getText());
        confirmAlert.accept();
        waitForDebug(5000);

        String btnPromptAlert = String.format(FORM_XPATH_BTN, "promptAlert");
        WebElement btnPrompt = mWebDriver.findElement(By.xpath(btnPromptAlert));
        btnPrompt.click();
        Alert promptAlert = mWebDriver.switchTo().alert();
        System.out.println("Prompt alert text: " + promptAlert.getText());
        waitForDebug(4000);
        promptAlert.sendKeys("Test test!");
        promptAlert.accept();
        waitForDebug(3000);


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
