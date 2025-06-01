package com.testek.study.lesson06.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
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
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--max-window-size");
        chromeOptions.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize(); // Set the window size to maximum
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

        // Handle your code here
        // Declare Dynamic XPath
        String FORM_XPATH_LABEL_TEXT = "//label[@test-id='%s']";
        String FORM_XPATH_INPUT_TEXT = "//input[@test-id = '%s']";
        String FORM_XPATH_TEXTAREA_INPUT = "//textarea[@id='%s']";
        String FORM_XPATH_BUTTON_TEXT = "//button[@id='%s']";

        // Interact with element
        // 1. Input First Name
        String txtFistNameXPath = String.format(FORM_XPATH_INPUT_TEXT, "input-firstName");
        WebElement txtFistNameEle = webDriver.findElement(By.xpath(txtFistNameXPath));
        txtFistNameEle.clear();
        txtFistNameEle.sendKeys("Lien");

        // 2. Input Last Name
        String txtLastNameXPath = String.format(FORM_XPATH_INPUT_TEXT, "input-lastName");
        WebElement txtLastNameEle = webDriver.findElement((By.xpath(txtLastNameXPath)));
        txtLastNameEle.clear();
        txtLastNameEle.sendKeys("Bi");

        // 3. Input Email
        String txtEmailXPath = String.format(FORM_XPATH_INPUT_TEXT, "input-email");
        WebElement txtEmailEle = webDriver.findElement((By.xpath(txtEmailXPath)));
        txtEmailEle.clear();
        txtEmailEle.sendKeys("lien@gmail.com");

        // 4. Select gender is male
        String rdoMaleXPath = String.format(FORM_XPATH_LABEL_TEXT, "label-male");
        WebElement rdoMaleEle = webDriver.findElement((By.xpath(rdoMaleXPath)));
        rdoMaleEle.click();

        // 5. Input Phone
        String txtMobileXPath = String.format(FORM_XPATH_INPUT_TEXT, "input-mobile");
        WebElement txtMobileEle = webDriver.findElement((By.xpath(txtMobileXPath)));
        txtMobileEle.clear();
        txtMobileEle.sendKeys("0387123123");

        // 6. Select date
        String datDobXPath = String.format(FORM_XPATH_INPUT_TEXT, "input-dob");
        WebElement datDobEle = webDriver.findElement((By.xpath(datDobXPath)));
        datDobEle.click();
        datDobEle.sendKeys("06/01/2025");

        // 7. Input Subject
        String txtSubjectsXPath = String.format(FORM_XPATH_INPUT_TEXT, "input-subjects");
        WebElement txtSubjectsEle = webDriver.findElement((By.xpath(txtSubjectsXPath)));
        txtSubjectsEle.clear();
        txtSubjectsEle.sendKeys("Subject test");

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
        txtAddressEle.sendKeys("Hà nội");

        // 10. Submit
        String bntSubmitXPath = String.format(FORM_XPATH_BUTTON_TEXT, "submit-button");
        WebElement bntSubmitEle = webDriver.findElement((By.xpath(bntSubmitXPath)));
        bntSubmitEle.click();

        // 11. Get info and verify
        String txaOutputTextXPath = String.format(FORM_XPATH_TEXTAREA_INPUT, "outputTextStudent");
        WebElement txaOutputTextEle = webDriver.findElement((By.xpath(txaOutputTextXPath)));
        String actualText = txaOutputTextEle.getAttribute("value");
        System.out.println("Info Student: " + actualText);
        waitForDebug(5000);

        // Verify contain "First Name: Lien"
        Assert.assertTrue(
                actualText.contains("First Name: Lien"),
                "Not found line First Name in output"
        );

        // Verify contain "Last Name: Lien"
        Assert.assertTrue(
                actualText.contains("Last Name: Bi"),
                "Not found line Last Name in output"
        );

        // Verify contain "Email: lien@gmail.com"
        Assert.assertTrue(
                actualText.contains("Email: lien@gmail.com"),
                "Not found line Email in output"
        );

        // Verify contain "Subjects: Subject test"
        Assert.assertTrue(
                actualText.contains("Subjects: Subject test"),
                "Not found line Subjects in output"
        );

        // Verify contain "Address: Hà nội"
        Assert.assertTrue(
                actualText.contains("Address: Hà nội"),
                "Not found line Address in output"
        );

        System.out.println("All fields have been verified successfully!!");

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

    @Test
    private void gotoTestWebsite(Menu parent, Menu subMenu) {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);

        String XPATH_MENU_FORMAT = "//div[@test-id='%s']";

        // Access: Form > [Student Form]
        WebElement mnuElementEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, parent.getName())));
        mnuElementEle.click();

        WebElement mnuEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, subMenu.getName())));
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
