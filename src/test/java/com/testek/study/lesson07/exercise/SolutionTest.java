package com.testek.study.lesson07.exercise;

import com.testek.study.common.Menu;
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
    @Test(description = "Element Interaction: Student Form")
    public void testStudentForm() {
        gotoTestWebsite(Menu.FORM, Menu.STUDENT_FORM);

        // Handle your code here

    }

    @Test(description = "Element Interaction: Small Frame")
    public void testSmallFrame() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.FRAME);

        // Handle your code here
    }

    @Test(description = "Element Interaction: Alert")
    public void testAlert() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.ALERT);

        // Handle your code here
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
    public void Ex1() {
        mWebDriver.get("https://testek.vn/lab/auto/web-elements/");
        waitForDebug(5000);
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.ALERT);
        waitForDebug(5000);
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.FRAME);
        waitForDebug(5000);
        mWebDriver.switchTo().newWindow(WindowType.WINDOW);
        mWebDriver.get("https://testek.vn/lab/auto/web-elements/");
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.FRAME);
    }

    @Test
    public void testFrame() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.FRAME);
        String frameId = "small-frame";
        WebElement frmSmallEle = mWebDriver.findElement(By.id(frameId));
        mWebDriver.switchTo().frame(frmSmallEle);
        WebElement textEle = mWebDriver.findElement(By.tagName("p"));
        String text = textEle.getAttribute("textContent");
        System.out.println(text);
        /// back to father frame
        mWebDriver.switchTo().defaultContent();
    }

    @Test
    public void Ex2() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.FRAME);
        String tab1Handle = mWebDriver.getWindowHandle();
        waitForDebug(5000);
        WebDriver newTab = mWebDriver.switchTo().newWindow(WindowType.TAB);
        String tab2Handle = mWebDriver.getWindowHandle();
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.ALERT);
        mWebDriver.switchTo().window(tab1Handle);
    }

    @Test
    public void Ex3() {
        mWebDriver.get("https://testek.vn/lab/auto/web-elements/");
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.ALERT);
        String alertConfirmXpath = "//button[@id='simpleAlert']";
        WebElement alertConfirmElement = mWebDriver.findElement(By.xpath(alertConfirmXpath));
        alertConfirmElement.click();
        WebElement confirmButton = mWebDriver.findElement(By.xpath("//button[text()='Ok']"));
        confirmButton.click();
        Alert alert = mWebDriver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        waitForDebug(5000);
        alert.dismiss();

    }
}
