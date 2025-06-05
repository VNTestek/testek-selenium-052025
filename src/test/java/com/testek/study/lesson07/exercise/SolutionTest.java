package com.testek.study.lesson07.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
    @Test(description = "Element Interaction: Student Form")
    public void testPracticeWindows() {
        // Handle your code here
        String dantriURL = "https://dantri.com.vn/";
        String testekURL = "https://testek.vn/lab/auto/web-elements/";

        // Get current windows
        mWebDriver.get(dantriURL);
        String currentWin = mWebDriver.getWindowHandle();
        System.out.println(currentWin);

        //NEW TAB
        WebDriver newTab = mWebDriver.switchTo().newWindow(WindowType.TAB);
        newTab.get(testekURL);
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.WINDOWS);

        // Back to the first window
        mWebDriver.switchTo().window(currentWin);
        waitForDebug(2000);

        //NEW WINDOW
        WebDriver newWindow = mWebDriver.switchTo().newWindow(WindowType.WINDOW);
        newWindow.get(testekURL);
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.ALERT);
    }

    @Test(description = "Element Interaction: Small Frame")
    public void testSmallFrame() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.FRAME);
        // Handle your code here
        String SMALL_FRAME = "//iframe[@id = '%s']";

        //confirmAlert
        String frmSmallXPath = String.format(SMALL_FRAME, "small-frame");
        WebElement frmSmallEle = mWebDriver.findElement(By.xpath(frmSmallXPath));

        mWebDriver.switchTo().frame(frmSmallEle);

        String smallFrmTitle = "//h1[normalize-space()='This is a Small Frame']";
        WebElement smallFrmTitleEle = mWebDriver.findElement(By.xpath(smallFrmTitle));
        System.out.println(smallFrmTitleEle.getText());

        String smallFrmDescription= "//p[normalize-space()='Smaller content can be displayed here.']";
        WebElement smallFrmDescriptionEle = mWebDriver.findElement(By.xpath(smallFrmDescription));
        System.out.println(smallFrmDescriptionEle);

        // Back to page contents
        mWebDriver.switchTo().defaultContent();
        log.info("Back to the main page");
        String lblMainPageXpath = "//h1[@id='frames-title']";
        WebElement lblMainPageEle = mWebDriver.findElement(By.xpath(lblMainPageXpath));
        String lblMainPage = lblMainPageEle.getAttribute("textContent");
        System.out.println("Main page title: " + lblMainPage);

    }

    @Test(description = "Element Interaction: Alert")
    public void testAlert() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.ALERT);
        // Handle your code here
        String XPATH_BUTTON = "//button[@id = '%s']";

        //confirmAlert
        String btnConfirmAlertXPath = String.format(XPATH_BUTTON, "confirmAlert");
        WebElement btnConfirmAlertEle = mWebDriver.findElement(By.xpath(btnConfirmAlertXPath));
        System.out.println(btnConfirmAlertEle.getText());
        btnConfirmAlertEle.click();
        waitForDebug(1000);
        Alert alertConfirm = mWebDriver.switchTo().alert();
        System.out.println("ConfirmAlert: " + alertConfirm.getText());
        alertConfirm.accept();

        //promptAlert
        String btnPromptAlertXPath = String.format(XPATH_BUTTON, "promptAlert");
        WebElement btnPromptAlertEle = mWebDriver.findElement(By.xpath(btnPromptAlertXPath));
        System.out.println(btnPromptAlertEle.getText());
        btnPromptAlertEle.click();
        waitForDebug(2000);
        Alert alertPrompt = mWebDriver.switchTo().alert();
        System.out.println("PromptAlert: " + alertPrompt.getText());
        alertPrompt.sendKeys("anhTraiSayHi");
        alertPrompt.accept();

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
