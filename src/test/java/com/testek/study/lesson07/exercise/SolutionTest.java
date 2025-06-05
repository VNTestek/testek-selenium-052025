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
//    @Test(description = "Element Interaction: Student Form")
//    public void testStudentForm() {
//        gotoTestWebsite(Menu.FORM, Menu.STUDENT_FORM);
//
//        // Handle your code here
//
//    }

    @Test(description = "Element Interaction: Small Frame")
    public void testSmallFrame() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.FRAME);

        // Handle your code here
        String frmSmall = "small-frame";
        WebElement frmSmallEle = mWebDriver.findElement(By.id(frmSmall));

        mWebDriver.switchTo().frame(frmSmall);

        WebElement lblTitleEle = mWebDriver.findElement(By.tagName("h1"));
        System.out.println(lblTitleEle.getText());

        WebElement lblTxtEle = mWebDriver.findElement(By.tagName("p"));
        System.out.println(lblTxtEle.getText());
    }

    @Test(description = "Switch windows/ tabs")
    public void testWindowTabs() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.WINDOWS);
        WebDriver newTab = mWebDriver.switchTo().newWindow(WindowType.TAB);
        String homepage = "https://testek.vn/lab/auto/web-elements/";
        newTab.get(homepage);

        WebDriver newWindow = mWebDriver.switchTo().newWindow(WindowType.WINDOW);
        newWindow.get(homepage);
        // các element khác đều có chung URL nên kb cách switch theo get
        System.out.println(mWebDriver.getWindowHandles());
    }

    @Test(description = "Element Interaction: Alert")
    public void testAlert() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.ALERT);

        // Handle your code here
        // Button Confirm Alert
        String btnConfirmMe = "//button[@id= 'confirmAlert']";
        WebElement btnConfirmMeEle = mWebDriver.findElement(By.xpath(btnConfirmMe));
        btnConfirmMeEle.click();
        Alert confirmAlert = mWebDriver.switchTo().alert();

        System.out.println(confirmAlert.getText());

        confirmAlert.dismiss();

        // Button Prompt Alert
        String btnPromptAlert = "//button[@id= 'promptAlert']";
        WebElement btnPromptAlertEle = mWebDriver.findElement(By.xpath(btnPromptAlert));
        btnPromptAlertEle.click();
        Alert promptAlert = mWebDriver.switchTo().alert();
        System.out.println(promptAlert.getText());
        waitForDebug(5000);
        promptAlert.sendKeys("Windy");
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
