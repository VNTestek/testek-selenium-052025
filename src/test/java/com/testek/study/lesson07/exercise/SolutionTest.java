package com.testek.study.lesson07.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
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
        String expSmallFrameTitleText = "This is a Small Frame  ";
        Assert.assertEquals(smallFrameContentText, expSmallFrameTitleText,
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
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.FRAME);

        // Handle your code here
        // 1. Save the first window ID
        String firstTabWinID = mWebDriver.getWindowHandle();

        // 2.Open new tab and access https://testek.vn/lab/auto/web-elements/
        mWebDriver.switchTo().newWindow(WindowType.TAB);
        mWebDriver.get("https://testek.vn/lab/auto/web-elements/");
        waitForDebug(2000);

        // 3. Back to the first window
        mWebDriver.switchTo().window(firstTabWinID);
        waitForDebug(2000);

        // 4. Print the list of all windows currently open
        Set<String> windowList = mWebDriver.getWindowHandles();
        System.out.println("List window: ");
        for (String win : windowList) {
            System.out.println(win);
        }

        // 5. Open a new window and access Home page of Testek and menu page in 2 tabs
        mWebDriver.switchTo().newWindow(WindowType.WINDOW);
        mWebDriver.get("https://testek.vn/lab/auto/web-elements/");
        waitForDebug(2000);
        mWebDriver.switchTo().newWindow(WindowType.TAB);
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.FRAME);

        // Back to home page
        mWebDriver.navigate().back();

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

        // Print the text of the simple alert and verify
        String actualSimpleAlertText = simpleAlert.getText();
        String expectedSimpleAlertText = "This is a simple alert!";
        System.out.println("Text of Simple Alert: " + actualSimpleAlertText);
        Assert.assertEquals(actualSimpleAlertText, expectedSimpleAlertText,
                "The text of simple alert is not same as expected");
        // Press OK button
        simpleAlert.accept();


        // 2. Click "Confirm Alert"
        String confirmAlertXPath = "//button[@id='confirmAlert']";
        WebElement confirmAlertEle = mWebDriver.findElement(By.xpath(confirmAlertXPath));
        confirmAlertEle.click();
        Alert confirmAlert = mWebDriver.switchTo().alert();

        // Print the text of the confirm alert and verify
        String actualConfirmAlertText = confirmAlert.getText();
        String expectedConfirmAlertText = "Do you confirm this action?";
        System.out.println("Text of Confirm Alert: " + actualConfirmAlertText);
        Assert.assertEquals(actualConfirmAlertText, expectedConfirmAlertText,
                "The text of confirm alert is not same as expected");
        waitForDebug(3000);

        // Press Cancel button
        confirmAlert.dismiss();

        // 3. Click "Prompt Alert"
        String promptAlertXPath = "//button[@id='promptAlert']";
        WebElement promptAlertEle = mWebDriver.findElement(By.xpath(promptAlertXPath));
        promptAlertEle.click();
        Alert promptAlert = mWebDriver.switchTo().alert();

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

        // Press OK button
        promptAlert.accept();

        // 4. Click "Timed Alert"
        String timedAlertXPath = "//button[@id='timedAlert']";
        WebElement timedAlertEle = mWebDriver.findElement(By.xpath(timedAlertXPath));
        timedAlertEle.click();
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

        waitForDebug(30000);
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
