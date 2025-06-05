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
        // access small frame
        String frmXpath = "//iframe[@test-id='small-frame']";
        WebElement smallFrameEle = mWebDriver.findElement(By.xpath(frmXpath));
        mWebDriver.switchTo().frame(smallFrameEle);

        WebElement childFrameEle = mWebDriver.findElement(By.tagName("h1"));
        String actChildFrameText = childFrameEle.getText();
        System.out.println("text in small frame: " + actChildFrameText);
    }

    @Test(description = "Element Interaction: Alert")
    public void testAlert() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.ALERT);
        // Handle your code here
        // access Alert
        String btnConfirmXpath = "//button[@test-id='confirmAlert']";
        WebElement btnConfirmEle = mWebDriver.findElement(By.xpath(btnConfirmXpath));
        btnConfirmEle.click();
        waitForDebug(10000);

        Alert alert = mWebDriver.switchTo().alert();
        System.out.println("confirm alert content: " + alert.getText());
        alert.accept();

    }

    /**
     *
     */
    @Test(description = "Practice Exercise 2")
    public void testTabAndWindow() {
        // Mở cac menu trong tab mới
        openMenuInTabs();
        // Mở cac menu trong window mới, moi window co 2 tab
        openMenuInWindow();
    }

    private void openMenuInWindow() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        mWebDriver.get(url);
        String currentId = mWebDriver.getWindowHandle();
        waitForDebug(3000);

        newTabInFirstWindow(url);

        // Switch to a new window
        switchToTabHome(currentId);

        mWebDriver.switchTo().newWindow(WindowType.WINDOW);
        mWebDriver.get(url);
        String currentIdInNewWindow = mWebDriver.getWindowHandle();
        waitForDebug(3000);

        newTabInFirstWindow(url);
        waitForDebug(10000);

        // Switch to a first window
        switchToTabHome(currentIdInNewWindow);


    }

    private void switchToTabHome(String currentId) {
        for (String win : mWebDriver.getWindowHandles()) {
            if (!win.equals(currentId)) {
                mWebDriver.switchTo().window(win);
            }
        }
    }

    private void newTabInFirstWindow(String url) {
        // mo tab moi
        mWebDriver.switchTo().newWindow(WindowType.TAB);
        mWebDriver.get(url);

        // click vao element menu
        String elementMenuXpath2 = "//div[@test-id='menu-elements']";
        WebElement elementMenu2 =  mWebDriver.findElement(By.xpath(elementMenuXpath2));
        elementMenu2.click();
        waitForDebug(3000);

        // click vao checkbox menu
        String checkboxXpath = "//div[@test-id='submenu-checkbox']";
        WebElement checkboxEle =  mWebDriver.findElement(By.xpath(checkboxXpath));
        checkboxEle.click();
    }

    /**
     * Open menu in two tab greater
     */
    private void openMenuInTabs() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        mWebDriver.get(url);
        String currentId = mWebDriver.getWindowHandle();
        waitForDebug(3000);

        // click vao element menu
        String elementMenuXpath = "//div[@test-id='menu-elements']";
        WebElement elementMenu =  mWebDriver.findElement(By.xpath(elementMenuXpath));
        elementMenu.click();

        waitForDebug(3000);
        // click vao textbox menu
        String textBoxXpath = "//div[@test-id='submenu-textbox']";
        WebElement textboxEle =  mWebDriver.findElement(By.xpath(textBoxXpath));
        textboxEle.click();

        waitForDebug(3000);

        // mo tab moi
        mWebDriver.switchTo().newWindow(WindowType.TAB);
        mWebDriver.get(url);

        // click vao element menu
        String elementMenuXpath2 = "//div[@test-id='menu-elements']";
        WebElement elementMenu2 =  mWebDriver.findElement(By.xpath(elementMenuXpath2));
        elementMenu2.click();
        waitForDebug(3000);

        // click vao checkbox menu
        String checkboxXpath = "//div[@test-id='submenu-checkbox']";
        WebElement checkboxEle =  mWebDriver.findElement(By.xpath(checkboxXpath));
        checkboxEle.click();
        waitForDebug(10000);
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
