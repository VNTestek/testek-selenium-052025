package com.testek.study.lesson07.exercise;

import com.testek.study.common.Menu;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Objects;

import static java.lang.Thread.sleep;


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
        mWebDriver.manage().window().maximize(); // Set the window size to maximum
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
    public void testStudentForm() {
        gotoTestWebsite(Menu.FORM, Menu.STUDENT_FORM);

        // Handle your code here

    }

    @Test(description = "Element Interaction: Small Frame")
    public void testSmallFrame() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.FRAME);

        // Handle your code here
        // Find the small frame
        String smallFrame = "small-frame";
        WebElement smallFrameEle = mWebDriver.findElement(By.id(smallFrame));

        // Interact with frame
        mWebDriver.switchTo().frame(smallFrameEle);

        // Print the text in the small frame
        // Print Tittle
        WebElement lblSmallFrameTitleEle = mWebDriver.findElement(By.tagName("h1"));
        String smallFrameTitleText = lblSmallFrameTitleEle.getText();
        System.out.println("Title of small frame: " + smallFrameTitleText);

        // Print content
        WebElement lblSmallFrameContentEle = mWebDriver.findElement(By.tagName("p"));
        String smallFrameContentText = lblSmallFrameContentEle.getText();
        System.out.println("Content of small frame: " + smallFrameContentText);

        // Verify interaction small frame successfully
        String expSmallFrameTitleText = "This is a Small Frame";
        Assert.assertEquals(smallFrameTitleText, expSmallFrameTitleText,
                "The title of small frame is not same as expected");

        // Back to page contents
        mWebDriver.switchTo().defaultContent();
        WebElement ltbTitlePageEle = mWebDriver.findElement(By.id("frames-title"));

        // Verify back to page contents (out of frame) successfully
        String actTitlePageText = ltbTitlePageEle.getText();
        System.out.println("Title Page: " + actTitlePageText);
        String expTitlePageText = "Frames Example";
        Assert.assertEquals(actTitlePageText, expTitlePageText,
                "The title of page is not same as expected");

    }

    @Test(description = "Interaction: Windows")
    public void testInteractionWindows() {
        // 1. Open Menu Page
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.FRAME);
        WebElement ltbTitleSubMenuPageEle = mWebDriver.findElement(By.id("frames-title"));
        String actTitleSubMenuPageText = ltbTitleSubMenuPageEle.getText();
        System.out.println("Title Sub Menu Page: " + actTitleSubMenuPageText);

        // Save the first window ID
        String firstWindowID = mWebDriver.getWindowHandle();

        // 2.Open new tab and go to Home Page
        mWebDriver.switchTo().newWindow(WindowType.TAB);
        mWebDriver.get("https://testek.vn/lab/auto/web-elements/");
        waitForDebug(2000);

        // Verify switch Home Page
        WebElement ltbTitleHomePageEle = mWebDriver.findElement(By.xpath("//b[normalize-space(.)='TESTEK - KIỂM THỬ THỰC CHIẾN']"));
        String actTitleHomePageText = ltbTitleHomePageEle.getText();
        System.out.println("Title Home Page: " + actTitleHomePageText);
        String expTitleHomePageText = "TESTEK - KIỂM THỬ THỰC CHIẾN";
        Assert.assertEquals(actTitleHomePageText, expTitleHomePageText,
                "The title of page is not same as expected");

        // 3. Back to the before TAB: Menu Page
        mWebDriver.switchTo().window(firstWindowID);
        waitForDebug(2000);

        // Verify switch Menu Page
        System.out.println("Title Sub Menu Page: " + actTitleSubMenuPageText);
        String expTitleSubMenuPageText = "Frames Example";
        Assert.assertEquals(actTitleSubMenuPageText, expTitleSubMenuPageText,
                "The title of page is not same as expected");


        // 4. Open a new window and access Home page of Testek and menu page in 2 tabs
        mWebDriver.switchTo().newWindow(WindowType.WINDOW);
        // Switch Menu Page
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.FRAME);
        String secondWindowID = mWebDriver.getWindowHandle();
        System.out.println("The second window: " + secondWindowID);
        waitForDebug(2000);

        // Verify switch Menu Page
        System.out.println("Title Sub Menu Page: " + actTitleSubMenuPageText);
        Assert.assertEquals(actTitleSubMenuPageText, expTitleSubMenuPageText,
                "The title of page is not same as expected");

//        mWebDriver.switchTo().window(secondWindowID);
//        mWebDriver.switchTo().newWindow(WindowType.TAB);
        // Switch to Home Page
        ((JavascriptExecutor) mWebDriver).executeScript("window.open('https://testek.vn/lab/auto/web-elements/', '_blank');");
//        mWebDriver.get("https://testek.vn/lab/auto/web-elements/");
        waitForDebug(5000);

        // Verify switch Home Page
        System.out.println("Title Home Page: " + actTitleHomePageText);
        Assert.assertEquals(actTitleHomePageText, expTitleHomePageText,
                "The title of page is not same as expected");

        //5. Switch to Menu Page
        mWebDriver.switchTo().window(secondWindowID);
        waitForDebug(5000);
        System.out.println("The current window: " + mWebDriver.getWindowHandle());

        // Verify switch Menu Page
        System.out.println("Title Sub Menu Page: " + actTitleSubMenuPageText);
        Assert.assertEquals(actTitleSubMenuPageText, expTitleSubMenuPageText,
                "The title of page is not same as expected");

    }

    @Test(description = "Element Interaction: Alert")
    public void testAlert() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.ALERT);

        // Handle your code here

        // 1. Click "Simple Alert"
        String simpleAlertXPath = "//button[@id='simpleAlert']";
        WebElement simpleAlertEle = mWebDriver.findElement(By.xpath(simpleAlertXPath));
        simpleAlertEle.click();
        Alert simpleAlert = mWebDriver.switchTo().alert();
        waitForDebug(3000);

        // Print the text of the simple alert and verify
        String actualSimpleAlertText = simpleAlert.getText();
        String expectedSimpleAlertText = "This is a simple alert!";
        System.out.println("Text of Simple Alert: " + actualSimpleAlertText);
        Assert.assertEquals(actualSimpleAlertText, expectedSimpleAlertText,
                "The text of simple alert is not same as expected");
        // Press OK button
        simpleAlert.accept();
        waitForDebug(5000);


        // 2. Click "Confirm Alert"
        String confirmAlertXPath = "//button[@id='confirmAlert']";
        WebElement confirmAlertEle = mWebDriver.findElement(By.xpath(confirmAlertXPath));
        confirmAlertEle.click();
        Alert confirmAlert = mWebDriver.switchTo().alert();
        waitForDebug(3000);

        // Print the text of the confirm alert and verify
        String actualConfirmAlertText = confirmAlert.getText();
        String expectedConfirmAlertText = "Do you confirm this action?";
        System.out.println("Text of Confirm Alert: " + actualConfirmAlertText);
        Assert.assertEquals(actualConfirmAlertText, expectedConfirmAlertText,
                "The text of confirm alert is not same as expected");

        // Press Cancel button
        confirmAlert.dismiss();
        waitForDebug(2000);

        // 3. Click "Prompt Alert"
        String promptAlertXPath = "//button[@id='promptAlert']";
        WebElement promptAlertEle = mWebDriver.findElement(By.xpath(promptAlertXPath));
        promptAlertEle.click();
        Alert promptAlert = mWebDriver.switchTo().alert();
        waitForDebug(1000);

        // Print the text of the prompt alert and verify
        String actualPromptAlertText = promptAlert.getText();
        String expectedPromptAlertText = "Please enter your name:";
        System.out.println("Text of Prompt Alert: " + actualPromptAlertText);
        Assert.assertEquals(actualPromptAlertText, expectedPromptAlertText,
                "The text of prompt alert is not same as expected");

        // Type your name into the prompt alert
        String yourName = "Lien test";
        promptAlert.sendKeys(yourName);

        System.out.println("Your name: " + yourName);
        waitForDebug(3000);

        // Press OK button
        promptAlert.accept();
        waitForDebug(5000);

        // 4. Click "Timed Alert"
        String timedAlertXPath = "//button[@id='timedAlert']";
        WebElement timedAlertEle = mWebDriver.findElement(By.xpath(timedAlertXPath));
        timedAlertEle.click();
        waitForDebug(5000);
        Alert timedAlert = mWebDriver.switchTo().alert();

        // Print the text of the timed alert and verify
        String actualTimedAlertText = timedAlert.getText();
        String expectedTimedAlertText = "This alert appeared after 5 seconds!";
        System.out.println("Text of Timed Alert: " + actualTimedAlertText);
        Assert.assertEquals(actualTimedAlertText, expectedTimedAlertText,
                "The text of timed alert is not same as expected");
        // Wait for 5 seconds before accepting the alert
        waitForDebug(5000);

        // Press OK button
        timedAlert.accept();

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
