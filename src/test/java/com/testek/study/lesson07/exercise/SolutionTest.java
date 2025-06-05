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
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
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
        String frmSmallId = "small-frame";
        WebElement frmSmallEle = mWebDriver.findElement(By.id(frmSmallId));
        mWebDriver.switchTo().frame(frmSmallEle);

        WebElement lblTitleEle = mWebDriver.findElement(By.tagName("h1"));
        System.out.println(lblTitleEle.getText());

        WebElement lblDesEle = mWebDriver.findElement(By.tagName("p"));
        System.out.println(lblDesEle.getText());

        // Back to default frame
        mWebDriver.switchTo().defaultContent();
    }

    @Test(description = "Element Interaction: Alert")
    public void testAlert() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.ALERT);

        // Handle your code here

        // Confirm Alert buttonAdd commentMore actions
        String btnConfirmId = "confirmAlert";
        WebElement btnConfirmEle = mWebDriver.findElement(By.id(btnConfirmId));
        btnConfirmEle.click();

        Alert alert = mWebDriver.switchTo().alert();
        waitForDebug(1000);
        System.out.println(alert.getText());
        alert.accept();

        btnConfirmEle.click();
        alert = mWebDriver.switchTo().alert();
        waitForDebug(1000);
        alert.dismiss();

        // Prompt Alert button
        String btnPromptId = "promptAlert";
        WebElement btnPromptEle = mWebDriver.findElement(By.id(btnPromptId));
        btnPromptEle.click();

        alert = mWebDriver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("Ngoc Anh");
        waitForDebug(1000);
        alert.accept();

        btnPromptEle.click();
        alert = mWebDriver.switchTo().alert();
        waitForDebug(1000);
        alert.dismiss();
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
