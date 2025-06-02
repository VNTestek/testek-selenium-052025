package com.testek.study.lesson06.exercise;

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
    @Test(description = "Element Interaction Student Form")
    public void testInteractionStudentForm() {
        gotoTestWebsite(Menu.FORM, Menu.STUDENT_FORM);

        // Handle your code here
        System.out.println("\nStudent Form\n");
        //Title
        String lblTitleXpath = "//h3[normalize-space()='Form đăng ký sinh viên']";
        webDriver.findElement(By.xpath(lblTitleXpath));

        //First Name
        String lblFirstNameXPath = "//label[normalize-space()='First Name:']";
        webDriver.findElement(By.xpath(lblFirstNameXPath));
        WebElement txtFirstNameXpath = webDriver.findElement(By.xpath("//input[@type='text' and @id='firstName']"));
        txtFirstNameXpath.clear();
        txtFirstNameXpath.sendKeys("Doãn");

        // Last Name
        String lblLastNameXPath = "//label[normalize-space()='Last Name:']";
        webDriver.findElement(By.xpath(lblLastNameXPath));
        WebElement txtLastNameXpath = webDriver.findElement(By.xpath("//input[@type='text' and @id='lastName']"));
        txtLastNameXpath.clear();
        txtLastNameXpath.sendKeys("Kiên");

        // Email
        String lblEmailXpath = "//label[normalize-space()='Email:']";
        webDriver.findElement(By.xpath(lblEmailXpath));
        WebElement txtEmailXpath = webDriver.findElement(By.xpath("//input[@test-id='input-email']"));
        txtEmailXpath.clear();
        txtEmailXpath.sendKeys("kiendoan796@gmail.com");

        // Gender:
        String lblGenderXpath = "//label[normalize-space()='Gender:']";
        webDriver.findElement(By.xpath(lblGenderXpath));
        WebElement rdoMaleXpath = webDriver.findElement(By.xpath("//label[@test-id='label-male']"));
        WebElement rdoFemaleXpath = webDriver.findElement(By.xpath("//label[@test-id='label-female']"));
        rdoMaleXpath.click();
        rdoFemaleXpath.click();

        // Mobile
        String lblMobileXpath = "//label[normalize-space()='Mobile:']";
        webDriver.findElement(By.xpath(lblMobileXpath));
        WebElement txtMobileXpath = webDriver.findElement(By.xpath("//input[@test-id='input-mobile']"));
        txtMobileXpath.clear();
        txtMobileXpath.sendKeys("0989261459");

        // DOB
        String lblDOBXpath = "//label[normalize-space()='Date of Birth:']";
        webDriver.findElement(By.xpath(lblDOBXpath));
        WebElement txtDOBXpath = webDriver.findElement(By.xpath("//input[@test-id='input-dob']"));
        txtDOBXpath.clear();
        txtDOBXpath.sendKeys("14/04/1999");

        //Subjects
        String lblSubjectsXpath = "//label[normalize-space()='Subjects:']";
        webDriver.findElement(By.xpath(lblSubjectsXpath));
        WebElement txtSubjectXpath = webDriver.findElement(By.xpath("//input[@test-id='input-subjects']"));
        txtSubjectXpath.clear();
        txtSubjectXpath.sendKeys("Abc");

        // Hobbies
        String lblHobbiesXpath = "//label[normalize-space()='Hobbies:']";
        webDriver.findElement(By.xpath(lblHobbiesXpath));
        WebElement chkReadingXpath = webDriver.findElement(By.xpath("//label[@test-id='label-reading']"));
        WebElement chkSportsXpath = webDriver.findElement(By.xpath("//label[@test-id='label-sports']"));
        WebElement chkMusicXpath = webDriver.findElement(By.xpath("//label[@test-id='label-music']"));
        chkReadingXpath.click();
        chkSportsXpath.click();
        chkMusicXpath.click();

        // Address
        String lblAddressXpath = "//label[normalize-space()='Address:']";
        webDriver.findElement(By.xpath(lblAddressXpath));
        WebElement txtAddressXpath = webDriver.findElement(By.xpath("//textarea[@test-id='textarea-address']"));
        txtAddressXpath.clear();
        txtAddressXpath.sendKeys("Số 6 ngõ 89");

        // Click btn Gửi thông tin
        WebElement btnAddressXpath = webDriver.findElement(By.xpath("//button[normalize-space()='Submit']"));
        btnAddressXpath.click();

        // LẤy thôgn tin
        WebElement txtOutputXpath = webDriver.findElement(By.xpath("//textarea[@test-id='outputTextStudent']"));
        String  output = txtOutputXpath.getAttribute("value");
        System.out.println(output);

        // Click btn Clear
        WebElement btnClearXpath = webDriver.findElement(By.xpath("//button[@test-id='reset-button']"));
        btnAddressXpath.click();
    }

    @Test(description = "Element Interaction Buttons")
    public void testInteractionButtons() {
        gotoTestWebsite(Menu.ELEMENTS, Menu.BUTTONS);

        // Handle your code here
        System.out.println("\nButton\n");
        // Title Buttons
        String lblTitleButtonXpath = "//h3[@test-id='buttons-title']";
        webDriver.findElement(By.xpath(lblTitleButtonXpath));

        // Btn Click me
        WebElement btnClickMeEle = webDriver.findElement(By.xpath("//button[@test-id='button-click-me']"));
        btnClickMeEle.click();
        Alert alertClickMe = webDriver.switchTo().alert();
        System.out.println(alertClickMe.getText());
        alertClickMe.accept();

        // Btn Confirm me
        WebElement btnConfirmMeEle = webDriver.findElement(By.xpath("//button[@test-id='button-confirm-me']"));
        btnConfirmMeEle.click();
        Alert alertConfirmMe = webDriver.switchTo().alert();
        System.out.println(alertConfirmMe.getText());
        alertConfirmMe.accept();

        // Btn Prompt Me
        WebElement btnPromptMeEle = webDriver.findElement(By.xpath("//button[@test-id='button-prompt-me']"));
        btnPromptMeEle.click();
        Alert alertPromptMe = webDriver.switchTo().alert();
        System.out.println(alertPromptMe.getText());
        alertPromptMe.accept();

        // Title Buttons with Different Actions (Click, Right-Click, Double-Click):
        webDriver.findElement(By.xpath("//h3[@test-id='buttons-different-actions-title']"));

        // Result Txt default
        WebElement lblResultTextEle = webDriver.findElement(By.xpath("//p[@test-id='buttons-result-text']"));
        String output = lblResultTextEle.getAttribute("textContent");

        // Btn 1
        WebElement btnButtonOneEle = webDriver.findElement(By.xpath("//button[@test-id='button1']"));
        btnButtonOneEle.click();
        System.out.println(lblResultTextEle.getAttribute("textContent"));

        // Btn 2
        WebElement btnButtonTwoEle = webDriver.findElement(By.xpath("//button[@test-id='button2']"));
        btnButtonTwoEle.click();
        System.out.println(lblResultTextEle.getAttribute("textContent"));

        // btn 3
        WebElement btnButtonThreeEle = webDriver.findElement(By.xpath("//button[@test-id='button3']"));
        btnButtonThreeEle.click();
        System.out.println(lblResultTextEle.getAttribute("textContent"));
    }

    @Test (description = "Element Interaction Radio Buttons")
    public void testInteractionRadioButtons() {
        gotoTestWebsite(Menu.ELEMENTS, Menu.RADIO_BUTTON);

        // Handle your code here
        System.out.println("\nRadio Button\n");
        // Do you like the site?
        webDriver.findElement(By.xpath("//h3[@test-id='radio-title']"));

        // Result default
        WebElement lblResultRadioEle = webDriver.findElement(By.xpath("//div[@test-id = 'radio-result']"));
        System.out.println(lblResultRadioEle.isDisplayed());

        // Radio btn Yes
        WebElement rdoButtonYesEle = webDriver.findElement(By.xpath("//label[@test-id = 'radio-label-yes']"));
        rdoButtonYesEle.click();
        System.out.println(lblResultRadioEle.getText());

        // Radio btn Impressive
        WebElement rdoButtonImpressiveEle = webDriver.findElement(By.xpath("//label[@test-id = 'radio-label-impressive']"));
        rdoButtonImpressiveEle.click();
        System.out.println(lblResultRadioEle.getText());

        // Radio btn Impressive
        WebElement rdoButtonNoEle = webDriver.findElement(By.xpath("//label[@test-id = 'radio-label-no']"));
        rdoButtonNoEle.click();
        System.out.println(lblResultRadioEle.getText());
    }

    /**
     * Go to Test Website
     */
    private void gotoTestWebsite(Menu parent,Menu subMenu) {
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
