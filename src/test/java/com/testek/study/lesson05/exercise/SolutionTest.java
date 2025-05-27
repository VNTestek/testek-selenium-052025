package com.testek.study.lesson05.exercise;

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


    @Test(description = "Find element with CSS")
    public void findBasicLocatorWithCSS() {
        gotoTestWebsite();

        // Handle other elements similarly

        // Browser Windows
        String lblTitleCSS = "h3[test-id = 'browser-windows-title']";
        webDriver.findElement(By.cssSelector(lblTitleCSS));

        // Form đăng ký sinh viên
        String lblFormTitleCSS = "h3[test-id = 'student-registration-title']";
        webDriver.findElement(By.cssSelector(lblFormTitleCSS));

        // First Name
        String lblFirstNameCSS = "label[test-id = 'label-firstName']";
        webDriver.findElement(By.cssSelector(lblFirstNameCSS));
        String txtFirstNameCSS = "input[test-id = 'input-firstName']";
        webDriver.findElement(By.cssSelector(txtFirstNameCSS));

        // Last Name
        String lblLastNameCSS = "label[test-id = 'label-lastName']";
        webDriver.findElement(By.cssSelector(lblLastNameCSS));
        String txtLastNameCSS = "input[test-id = 'input-lastName']";
        webDriver.findElement(By.cssSelector(txtLastNameCSS));

        // Email
        String lblEmailCSS = "label[test-id = 'label-email']";
        webDriver.findElement(By.cssSelector(lblEmailCSS));
        String txtEmailCSS = "input[test-id = 'input-email']";
        webDriver.findElement(By.cssSelector(txtEmailCSS));

        // Gender
        String lblGenderCSS = "label[test-id = 'label-gender']";
        webDriver.findElement(By.cssSelector(lblGenderCSS));
        String rdoMaleCSS = "input[value = 'Male']";
        webDriver.findElement(By.cssSelector(rdoMaleCSS));
        String rdoFemaleCSS = "input[value = 'Female']";
        webDriver.findElement(By.cssSelector(rdoFemaleCSS));

        // Mobile
        String lblMobileCSS = "label[test-id = 'label-mobile']";
        webDriver.findElement(By.cssSelector(lblMobileCSS));
        String txtMobileCSS = "input[test-id = 'input-mobile']";
        webDriver.findElement(By.cssSelector(txtMobileCSS));

        // Date of Birth
        String lblDobCSS = "label[test-id = 'label-dob']";
        webDriver.findElement(By.cssSelector(lblDobCSS));
        String txtDobCSS = "input[test-id = 'input-dob']";
        webDriver.findElement(By.cssSelector(txtDobCSS));

        // Subjects
        String lblSubjectCSS = "label[test-id = 'label-subjects']";
        webDriver.findElement(By.cssSelector(lblSubjectCSS));
        String txtSubjectCSS = "input[test-id = 'input-subjects']";
        webDriver.findElement(By.cssSelector(txtSubjectCSS));

        // Hobbies
        String lblHobbyCSS = "label[test-id = 'label-hobbies']";
        webDriver.findElement(By.cssSelector(lblHobbyCSS));
        String chkReadingCSS = "input[value = 'Reading']";
        webDriver.findElement(By.cssSelector(chkReadingCSS));
        String chkSportsCSS = "input[value = 'Sports']";
        webDriver.findElement(By.cssSelector(chkSportsCSS));
        String chkMusicCSS = "input[value = 'Music']";
        webDriver.findElement(By.cssSelector(chkMusicCSS));

        // Address
        String lblAddressCSS = "label[test-id ='label-address']";
        webDriver.findElement(By.cssSelector(lblAddressCSS));
        String txtAddressCSS = "textarea[test-id ='textarea-address']";
        webDriver.findElement(By.cssSelector(txtAddressCSS));

        // Submit button
        String btnSubmitCSS = "button[id ='submit-button']";
        webDriver.findElement(By.cssSelector(btnSubmitCSS));

        // Reset button
        String btnResetCSS = "button[id ='reset-button']";
        webDriver.findElement(By.cssSelector(btnResetCSS));

        // Thông tin bạn đã nhập
        String lblOutputInfoCSS = "h3[test-id ='submitted-info-title']";
        webDriver.findElement(By.cssSelector(lblOutputInfoCSS));
        String txtOutputInfoCSS = "textarea[test-id ='outputTextStudent']";
        webDriver.findElement(By.cssSelector(txtOutputInfoCSS));

    }

    @Test(description = "Find element with XPath")
    public void findBasicLocatorWithXPath() {
        gotoTestWebsite();

        // Handle other elements similarly

        // Browser Windows
        String lblTitleXPath = "//h3[@test-id = 'browser-windows-title']";
        webDriver.findElement(By.xpath(lblTitleXPath));

        // Form đăng ký sinh viên
        String lblFormTitleXPath = "//h3[@test-id = 'student-registration-title']";
        webDriver.findElement(By.xpath(lblFormTitleXPath));

        // First Name
        String lblFirstNameXPath = "//label[@test-id = 'label-firstName']";
        webDriver.findElement(By.xpath(lblFirstNameXPath));
        String txtFirstNameXPath = "//input[@test-id = 'input-firstName']";
        webDriver.findElement(By.xpath(txtFirstNameXPath));

        // Last Name
        String lblLastNameXPath = "//label[@test-id = 'label-lastName']";
        webDriver.findElement(By.xpath(lblLastNameXPath));
        String txtLastNameXPath = "//input[@test-id = 'input-lastName']";
        webDriver.findElement(By.xpath(txtLastNameXPath));

        // Email
        String lblEmailXPath = "//label[@test-id = 'label-email']";
        webDriver.findElement(By.xpath(lblEmailXPath));
        String txtEmailXPath = "//input[@test-id = 'input-email']";
        webDriver.findElement(By.xpath(txtEmailXPath));

        // Gender
        String lblGenderXPath = "//label[@test-id = 'label-gender']";
        webDriver.findElement(By.xpath(lblGenderXPath));
        String rdoMaleXPath = "//input[@value = 'Male']";
        webDriver.findElement(By.xpath(rdoMaleXPath));
        String rdoFemaleXPath = "//input[@value = 'Female']";
        webDriver.findElement(By.xpath(rdoFemaleXPath));

        // Mobile
        String lblMobileXPath = "//label[@test-id = 'label-mobile']";
        webDriver.findElement(By.xpath(lblMobileXPath));
        String txtMobileXPath = "//input[@test-id = 'input-mobile']";
        webDriver.findElement(By.xpath(txtMobileXPath));

        // Date of Birth
        String lblDobXPath = "//label[@test-id = 'label-dob']";
        webDriver.findElement(By.xpath(lblDobXPath));
        String txtDobXPath = "//input[@test-id = 'input-dob']";
        webDriver.findElement(By.xpath(txtDobXPath));

        // Subjects
        String lblSubjectXPath = "//label[@test-id = 'label-subjects']";
        webDriver.findElement(By.xpath(lblSubjectXPath));
        String txtSubjectXPath = "//input[@test-id = 'input-subjects']";
        webDriver.findElement(By.xpath(txtSubjectXPath));

        // Hobbies
        String lblHobbyXPath = "//label[@test-id = 'label-hobbies']";
        webDriver.findElement(By.xpath(lblHobbyXPath));
        String chkReadingXPath = "//input[@value = 'Reading']";
        webDriver.findElement(By.xpath(chkReadingXPath));
        String chkSportsXPath = "//input[@value = 'Sports']";
        webDriver.findElement(By.xpath(chkSportsXPath));
        String chkMusicXPath = "//input[@value = 'Music']";
        webDriver.findElement(By.xpath(chkMusicXPath));

        // Address
        String lblAddressXPath = "//label[@test-id ='label-address']";
        webDriver.findElement(By.xpath(lblAddressXPath));
        String txtAddressXPath = "//textarea[@test-id ='textarea-address']";
        webDriver.findElement(By.xpath(txtAddressXPath));

        // Submit button
        String btnSubmitXPath = "//button[@id ='submit-button']";
        webDriver.findElement(By.xpath(btnSubmitXPath));

        // Reset button
        String btnResetXPath = "//button[@id ='reset-button']";
        webDriver.findElement(By.xpath(btnResetXPath));

        // Thông tin bạn đã nhập
        String lblOutputInfoXPath = "//h3[@test-id ='submitted-info-title']";
        webDriver.findElement(By.xpath(lblOutputInfoXPath));
        String txtOutputInfoXPath = "//textarea[@test-id ='outputTextStudent']";
        webDriver.findElement(By.xpath(txtOutputInfoXPath));

    }

    /**
     * URL: <a href="https://testek.vn/lab/auto/web-elements">...</a>
     * Access to Elements navigation
     */
    @Test(description = "Dynamic Locator Test")
    public void testDynamicLocator() {
        gotoTestWebsite();

        // Define the locator format then apply to elements
        String FORM_H3_TEXT_XPATH = "//h3[normalize-space() = '%s']";
        String FORM_LABEL_TEST_ID_XPATH = "//label[@test-id = 'label-%s']";
        String FORM_INPUT_TEST_ID_XPATH = "//input[@test-id = 'input-%s']";
        String FORM_INPUT_VALUE_XPATH = "//input[@value = '%s']";
        String FORM_TEXTAREA_TEST_ID_XPATH = "//textarea[@test-id = '%s']";
        String FORM_BUTTON_TEST_ID_XPATH = "//button[@test-id = '%s-button']";

        // Specific XPath

        String lblTitleXPath = String.format(FORM_H3_TEXT_XPATH, "Browser Windows");
        String lblFormTitleXPath = String.format(FORM_H3_TEXT_XPATH, "Form đăng ký sinh viên");
        String lblInfoTitleXPath = String.format(FORM_H3_TEXT_XPATH, "Thông tin bạn đã nhập:");

        String lblFirstNameXPath = String.format(FORM_LABEL_TEST_ID_XPATH, "firstName");
        String lblLastNameXPath = String.format(FORM_LABEL_TEST_ID_XPATH, "lastName");
        String lblEmailXPath = String.format(FORM_LABEL_TEST_ID_XPATH, "email");
        String lblGenderXPath = String.format(FORM_LABEL_TEST_ID_XPATH, "gender");
        String lblMobileXPath = String.format(FORM_LABEL_TEST_ID_XPATH, "mobile");
        String lblDobXPath = String.format(FORM_LABEL_TEST_ID_XPATH, "dob");
        String lblSubjectXPath = String.format(FORM_LABEL_TEST_ID_XPATH, "subjects");
        String lblHobbyXPath = String.format(FORM_LABEL_TEST_ID_XPATH, "hobbies");
        String lblAddressXPath = String.format(FORM_LABEL_TEST_ID_XPATH, "address");

        String txtFirstNameXPath = String.format(FORM_INPUT_TEST_ID_XPATH, "firstName");
        String txtLastNameXPath = String.format(FORM_INPUT_TEST_ID_XPATH, "lastName");
        String txtEmailXPath = String.format(FORM_INPUT_TEST_ID_XPATH, "email");
        String txtMobileXPath = String.format(FORM_INPUT_TEST_ID_XPATH, "mobile");
        String txtDobXPath = String.format(FORM_INPUT_TEST_ID_XPATH, "dob");
        String txtSubjectXPath = String.format(FORM_INPUT_TEST_ID_XPATH, "subjects");

        String rdoMaleXPath = String.format(FORM_INPUT_VALUE_XPATH, "Male");
        String rdoFemaleXPath = String.format(FORM_INPUT_VALUE_XPATH, "Female");
        String chkReadingXPath = String.format(FORM_INPUT_VALUE_XPATH, "Reading");
        String chkSportsXPath = String.format(FORM_INPUT_VALUE_XPATH, "Sports");
        String chkMusicXPath = String.format(FORM_INPUT_VALUE_XPATH, "Music");

        String txtAddressXPath = String.format(FORM_TEXTAREA_TEST_ID_XPATH, "textarea-address");
        String txtOutputXPath = String.format(FORM_TEXTAREA_TEST_ID_XPATH, "outputTextStudent");

        String btnSubmitXPath = String.format(FORM_BUTTON_TEST_ID_XPATH, "submit");
        String btnResetXPath = String.format(FORM_BUTTON_TEST_ID_XPATH, "reset");

        // Test
        webDriver.findElement(By.xpath(lblTitleXPath));
        webDriver.findElement(By.xpath(lblFormTitleXPath));
        webDriver.findElement(By.xpath(lblInfoTitleXPath));

        webDriver.findElement(By.xpath(lblFirstNameXPath));
        webDriver.findElement(By.xpath(lblLastNameXPath));
        webDriver.findElement(By.xpath(lblEmailXPath));
        webDriver.findElement(By.xpath(lblGenderXPath));
        webDriver.findElement(By.xpath(lblMobileXPath));
        webDriver.findElement(By.xpath(lblDobXPath));
        webDriver.findElement(By.xpath(lblSubjectXPath));
        webDriver.findElement(By.xpath(lblHobbyXPath));
        webDriver.findElement(By.xpath(lblAddressXPath));

        webDriver.findElement(By.xpath(txtFirstNameXPath));
        webDriver.findElement(By.xpath(txtLastNameXPath));
        webDriver.findElement(By.xpath(txtEmailXPath));
        webDriver.findElement(By.xpath(txtMobileXPath));
        webDriver.findElement(By.xpath(txtDobXPath));
        webDriver.findElement(By.xpath(txtSubjectXPath));

        webDriver.findElement(By.xpath(rdoMaleXPath));
        webDriver.findElement(By.xpath(rdoFemaleXPath));
        webDriver.findElement(By.xpath(chkReadingXPath));
        webDriver.findElement(By.xpath(chkSportsXPath));
        webDriver.findElement(By.xpath(chkMusicXPath));

        webDriver.findElement(By.xpath(txtAddressXPath));
        webDriver.findElement(By.xpath(txtOutputXPath));

        webDriver.findElement(By.xpath(btnSubmitXPath));
        webDriver.findElement(By.xpath(btnResetXPath));
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
