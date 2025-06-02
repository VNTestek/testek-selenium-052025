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

import java.sql.SQLOutput;
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
    public void testInteractionOfStudentForm() {
        gotoTestWebsite(Menu.FORM, Menu.STUDENT_FORM);

        // Print labels
        String lblTitleId = "browser-windows-title";
        WebElement lblTitleEle = webDriver.findElement(By.id(lblTitleId));
        System.out.println("Title: " + lblTitleEle.getAttribute("textContent"));

        String lblFormTitleId = "student-registration-title";
        WebElement lblFormTitleEle = webDriver.findElement(By.id(lblFormTitleId));
        System.out.println("Form Title: " + lblFormTitleEle.getAttribute("textContent"));

        System.out.println("Label of textboxes:");
        String lblFirstNameXPath = "//label[@test-id = 'label-firstName']";
        WebElement lblFirstNameEle = webDriver.findElement(By.xpath(lblFirstNameXPath));
        System.out.println(lblFirstNameEle.getAttribute("textContent"));

        String lblLastNameXPath = "//label[@test-id = 'label-lastName']";
        WebElement lblLastNameEle = webDriver.findElement(By.xpath(lblLastNameXPath));
        System.out.println(lblLastNameEle.getAttribute("textContent"));

        String lblEmailXPath = "//label[@test-id = 'label-email']";
        WebElement lblEmailEle = webDriver.findElement(By.xpath(lblEmailXPath));
        System.out.println(lblEmailEle.getAttribute("textContent"));

        String lblGenderXPath = "//label[@test-id = 'label-gender']";
        WebElement lblGenderEle = webDriver.findElement(By.xpath(lblGenderXPath));
        System.out.println(lblGenderEle.getAttribute("textContent"));

        String lblMobileXPath = "//label[@test-id = 'label-mobile']";
        WebElement lblMobileEle = webDriver.findElement(By.xpath(lblMobileXPath));
        System.out.println(lblMobileEle.getAttribute("textContent"));

        String lblDobXPath = "//label[@test-id = 'label-dob']";
        WebElement lblDobEle = webDriver.findElement(By.xpath(lblDobXPath));
        System.out.println(lblDobEle.getAttribute("textContent"));

        String lblSubjectXPath = "//label[@test-id = 'label-subjects']";
        WebElement lblSubjectEle = webDriver.findElement(By.xpath(lblSubjectXPath));
        System.out.println(lblSubjectEle.getAttribute("textContent"));

        String lblHobbyXPath = "//label[@test-id = 'label-hobbies']";
        WebElement lblHobbyEle = webDriver.findElement(By.xpath(lblHobbyXPath));
        System.out.println(lblHobbyEle.getAttribute("textContent"));

        String lblAddressXPath = "//label[@test-id ='label-address']";
        WebElement lblAddressEle = webDriver.findElement(By.xpath(lblAddressXPath));
        System.out.println(lblAddressEle.getAttribute("textContent"));

        String lblOutputInfoXPath = "//h3[@test-id ='submitted-info-title']";
        WebElement lblOutputInfoEle = webDriver.findElement(By.xpath(lblOutputInfoXPath));
        System.out.println(lblOutputInfoEle.getAttribute("textContent"));

        // Input First Name
        String txtFirstNameXPath = "//input[@test-id = 'input-firstName']";
        WebElement txtFirstNameEle = webDriver.findElement(By.xpath(txtFirstNameXPath));
        txtFirstNameEle.clear();
        txtFirstNameEle.sendKeys("Pham");

        // Input Last Name
        String txtLastNameXPath = "//input[@test-id = 'input-lastName']";
        WebElement txtLastNameEle = webDriver.findElement(By.xpath(txtLastNameXPath));
        txtLastNameEle.clear();
        txtLastNameEle.sendKeys("Huong");

        // Input email
        String txtEmailXPath = "//input[@test-id = 'input-email']";
        WebElement txtEmailEle = webDriver.findElement(By.xpath(txtEmailXPath));
        txtEmailEle.clear();
        txtEmailEle.sendKeys("phamhuong@gmail.com");

        // Select Male radio button
        String rdoMaleXPath = "//input[@test-id = 'input-male']/ancestor::label";
        WebElement rdoMaleEle = webDriver.findElement(By.xpath(rdoMaleXPath));
        rdoMaleEle.click();

        // Select Female radio button
        String rdoFemaleXPath = "//input[@test-id = 'input-female']/ancestor::label";
        WebElement rdoFemaleEle = webDriver.findElement(By.xpath(rdoFemaleXPath));
        rdoFemaleEle.click();

        // Input mobile
        String txtMobileXPath = "//input[@test-id = 'input-mobile']";
        WebElement txtMobileEle = webDriver.findElement(By.xpath(txtMobileXPath));
        txtMobileEle.clear();
        txtMobileEle.sendKeys("023465121");

        // Input Dob
        String txtDobXPath = "//input[@test-id = 'input-dob']";
        WebElement txtDobEle = webDriver.findElement(By.xpath(txtDobXPath));
        txtDobEle.clear();
        txtDobEle.sendKeys("10291999");

        // Input Subject
        String txtSubjectXPath = "//input[@test-id = 'input-subjects']";
        WebElement txtSubjectEle = webDriver.findElement(By.xpath(txtSubjectXPath));
        txtSubjectEle.clear();
        txtSubjectEle.sendKeys("Math");

        // Check all hobbies
        String chkReadingXPath = "//input[@value = 'Reading']/ancestor::label";
        WebElement chkReadingEle = webDriver.findElement(By.xpath(chkReadingXPath));
        if (!chkReadingEle.isSelected()){
            chkReadingEle.click();
        }

        String chkSportsXPath = "//input[@value = 'Sports']/ancestor::label";
        WebElement chkSportsEle = webDriver.findElement(By.xpath(chkSportsXPath));
        if (!chkSportsEle.isSelected()){
            chkSportsEle.click();
        }

        String chkMusicXPath = "//input[@value = 'Music']/ancestor::label";
        WebElement chkMusicEle = webDriver.findElement(By.xpath(chkMusicXPath));
        if (!chkMusicEle.isSelected()){
            chkMusicEle.click();
        }

        // Input Address
        String txtAddressXPath = "//textarea[@test-id = 'textarea-address']";
        WebElement txtAddressEle = webDriver.findElement(By.xpath(txtAddressXPath));
        txtAddressEle.clear();
        txtAddressEle.sendKeys("Ha Noi");

        // Click Submit button
        String btnSubmitXPath = "//button[@test-id = 'submit-button']";
        WebElement btnSubmitEle = webDriver.findElement(By.xpath(btnSubmitXPath));
        btnSubmitEle.click();

        // Check info from Output info textbox
        String txtOutputXPath = "//textarea[@test-id = 'outputTextStudent']";
        WebElement txtOutputEle = webDriver.findElement(By.xpath(txtOutputXPath));
        System.out.println("Info after submitting: ");
        System.out.println(txtOutputEle.getAttribute("value"));

        // Click Clear button
        String btnClearXPath = "//button[@test-id = 'reset-button']";
        WebElement btnClearEle = webDriver.findElement(By.xpath(btnClearXPath));
        btnClearEle.click();
        System.out.println("Info after clearing: ");
        System.out.println(txtOutputEle.getAttribute("value"));

    }

    /**
     * Go to Test Website
     */
    private void gotoTestWebsite(Menu menu, Menu subMenu) {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);

        String XPATH_MENU_FORMAT = "//div[@test-id='%s']";

        // Access: Form > [Student Form]
        WebElement mnuElementEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, menu.getName())));
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
