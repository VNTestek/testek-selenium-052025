package com.testek.study.lesson06.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
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
    private WebDriver webDriver;

    /**
     * Method will be executed before each class, configure Chrome Driver and initialize
     */
    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--max-window-size");
        chromeOptions.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(chromeOptions);
    }

    /**
     * Method will be executed after each class, will close all running chrome sessions - Debug Mode
     **/
    @AfterClass
    public void afterClass() {
        if (Objects.nonNull(webDriver)) webDriver.quit();
    }

    /**
     * URL: <a href="https://testek.vn/lab/auto/web-elements">...</a>
     * Access to Elements navigation
     */
    @Test(description = "Element Interaction")
    public void testInteraction() {
        gotoTestWebsite();

        // Declare Dynamic XPathAdd commentMore actions
        String FORM_XPATH_LABEL_TEXT = "//label[@test-id='%s']";
        String FORM_XPATH_INPUT_TEXT = "//input[@test-id = '%s']";
        String FORM_XPATH_TEXTAREA_INPUT = "//textarea[@id='%s']";
        String FORM_XPATH_BUTTON_TEXT = "//button[@id='%s']";

        // Interact with element
        // 1. Input First Name
        String txtFistNameXPath = String.format(FORM_XPATH_INPUT_TEXT, "input-firstName");
        WebElement txtFistNameEle = webDriver.findElement(By.xpath(txtFistNameXPath));
        txtFistNameEle.clear();
        txtFistNameEle.sendKeys("Ngoc Anh");

        // 2. Input Last Name
        String txtLastNameXPath = String.format(FORM_XPATH_INPUT_TEXT, "input-lastName");
        WebElement txtLastNameEle = webDriver.findElement((By.xpath(txtLastNameXPath)));
        txtLastNameEle.clear();
        txtLastNameEle.sendKeys("Nguyen");

        // 3. Input Email
        String txtEmailXPath = String.format(FORM_XPATH_INPUT_TEXT, "input-email");
        WebElement txtEmailEle = webDriver.findElement((By.xpath(txtEmailXPath)));
        txtEmailEle.clear();
        txtEmailEle.sendKeys("ngocanh@gmail.com");

        // 4. Select gender is male
        String rdoMaleXPath = String.format(FORM_XPATH_LABEL_TEXT, "label-male");
        WebElement rdoMaleEle = webDriver.findElement((By.xpath(rdoMaleXPath)));
        rdoMaleEle.click();

        // 5. Input Phone
        String txtMobileXPath = String.format(FORM_XPATH_INPUT_TEXT, "input-mobile");
        WebElement txtMobileEle = webDriver.findElement((By.xpath(txtMobileXPath)));
        txtMobileEle.clear();
        txtMobileEle.sendKeys("0931101896");

        // 6. Select date
        String datDobXPath = String.format(FORM_XPATH_INPUT_TEXT, "input-dob");
        WebElement datDobEle = webDriver.findElement((By.xpath(datDobXPath)));
        datDobEle.click();
        datDobEle.sendKeys("06/02/2025");

        // 7. Input Subject
        String txtSubjectsXPath = String.format(FORM_XPATH_INPUT_TEXT, "input-subjects");
        WebElement txtSubjectsEle = webDriver.findElement((By.xpath(txtSubjectsXPath)));
        txtSubjectsEle.clear();
        txtSubjectsEle.sendKeys("test");

        // 8. Select hobbies
        String chkRedingXPath = String.format(FORM_XPATH_LABEL_TEXT, "label-reading");
        String chkSportsXPath = String.format(FORM_XPATH_LABEL_TEXT, "label-sports");
        String chkMusicXPath = String.format(FORM_XPATH_LABEL_TEXT, "label-music");
        WebElement chkRedingXEle = webDriver.findElement((By.xpath(chkRedingXPath)));
        WebElement chkSportsEle = webDriver.findElement((By.xpath(chkSportsXPath)));
        WebElement chkMusicEle = webDriver.findElement((By.xpath(chkMusicXPath)));
        chkRedingXEle.click();
        chkSportsEle.click();
        chkMusicEle.click();

        //9. Input Address
        String txtAddressXPath = String.format(FORM_XPATH_TEXTAREA_INPUT, "address");
        WebElement txtAddressEle = webDriver.findElement((By.xpath(txtAddressXPath)));
        txtAddressEle.clear();
        txtAddressEle.sendKeys("Ha Noi");

        // 10. Submit
        String bntSubmitXPath = String.format(FORM_XPATH_BUTTON_TEXT, "submit-button");
        WebElement bntSubmitEle = webDriver.findElement((By.xpath(bntSubmitXPath)));
        bntSubmitEle.click();

        // Handle your code here

    }

    /**
     * Go to Test Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);

        String XPATH_MENU_FORMAT = "//div[@test-id='%s']";

        // Access: Form > [Student Form]
        WebElement mnuElementEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, Menu.FORM.getName())));
        mnuElementEle.click();

        WebElement mnuEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, Menu.STUDENT_FORM.getName())));
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
