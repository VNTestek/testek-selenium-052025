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
public class SolutionTest07 {
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
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.WINDOWS);
        // Handle your code here


    }

    @Test(description = "Element Interaction: Small Frame")
    public void testSmallFrame() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.FRAME);
        // Handle your code here
        String smallFrameId = "small-frame";
        WebElement smllFrameEle = mWebDriver.findElement(By.id(smallFrameId));
        mWebDriver.switchTo().frame(smllFrameEle);
        String titleSmllFrame = "//h1[text()='This is a Small Frame']";
        WebElement titleSmllFrameEle = mWebDriver.findElement(By.xpath(titleSmllFrame));
        System.out.println("Title small frame: " + titleSmllFrameEle.getText());
        WebElement lblTextEle = mWebDriver.findElement(By.tagName("p"));
        String txtValue = lblTextEle.getAttribute("Text");
        System.out.println("Value " + txtValue);
    }

    @Test(description = "Element Interaction: Alert")
    public void testAlert() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.ALERT);

        // Handle your code here
        String simpAlert = "simpleAlert";
        WebElement simpAlertEle = mWebDriver.findElement(By.id(simpAlert));
        simpAlertEle.click();
        Alert simpleAl = mWebDriver.switchTo().alert();
        System.out.println("Text: " + simpleAl.getText());
        simpleAl.accept();

        String confAlert = "confirmAlert";
        WebElement confAlertEle = mWebDriver.findElement(By.id(confAlert));
        confAlertEle.click();
        Alert confAl = mWebDriver.switchTo().alert();
        System.out.println("Text: " + confAl.getText());
        confAl.accept();

        String promptAlert = "promptAlert";
        WebElement promAlertEle = mWebDriver.findElement(By.id(promptAlert));
        promAlertEle.click();
        Alert promfAl = mWebDriver.switchTo().alert();
        System.out.println("Text: " + promfAl.getText());
        promfAl.sendKeys("Nguyen Viet Dung");
        promfAl.accept();

        String timeAlert = "timedAlert";
        WebElement timeAlerElet = mWebDriver.findElement(By.id(timeAlert));
        timeAlerElet.click();
        waitForDebug(5000);
        Alert timeAl = mWebDriver.switchTo().alert();
        System.out.println("Text: " + confAl.getText());
        timeAl.accept();
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
