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
        String FORM_CSS_H3_TEXT = "h3[test-id*='%s']";
        String FORM_CSS_LABEL_TEXT = "label[test-id*='%s']";
        String FORM_CSS_INPUT_TEXT = "input[test-id*='%s']";
        String FORM_CSS_MARK_BUTTON = "input[test-id*='%s']";
        String FORM_CSS_INPUT_TXTAREA = "textarea[test-id*='%s']";
        String FORM_CSS_INPUT_BUTTON = "button[test-id*='%s']";

        String txtFormTitleCSS = String.format(FORM_CSS_H3_TEXT, "browser-windows-title");
        String txtStudentRegistrationCSS = String.format(FORM_CSS_H3_TEXT, "student-registration-title");
        String lblFirstNameCSS = String.format(FORM_CSS_LABEL_TEXT, "label-firstName");
        String txtFirstNameCSS = String.format(FORM_CSS_INPUT_TEXT, "input-firstName");
        String lblLastNameCSS = String.format(FORM_CSS_LABEL_TEXT, "label-lastName");
        String txtLastNameCSS = String.format(FORM_CSS_INPUT_TEXT, "input-lastName");
        String lblEmailCSS = String.format(FORM_CSS_LABEL_TEXT, "label-email");
        String txtEmailCSS = String.format(FORM_CSS_INPUT_TEXT, "input-email");
        String lblGenderCSS = String.format(FORM_CSS_LABEL_TEXT, "label-gender");
        String btnMaleCSS = String.format(FORM_CSS_MARK_BUTTON, "input-male");
        String btnFemaleCSS = String.format(FORM_CSS_MARK_BUTTON, "input-female");
        String lblMaleCSS = String.format(FORM_CSS_LABEL_TEXT, "label-male");
        String lblFemaleCSS = String.format(FORM_CSS_LABEL_TEXT, "label-female");
        String lblMobileCSS = String.format(FORM_CSS_LABEL_TEXT, "label-mobile");
        String txtMobileCSS = String.format(FORM_CSS_INPUT_TEXT, "input-mobile");
        String lblDobCSS = String.format(FORM_CSS_LABEL_TEXT, "label-dob");
        String txtDobCSS = String.format(FORM_CSS_INPUT_TEXT, "input-dob");
        String lblSubjectCSS = String.format(FORM_CSS_LABEL_TEXT, "label-subjects");
        String txtSubjectCSS = String.format(FORM_CSS_INPUT_TEXT, "input-subjects");
        String lblHobbyCSS = String.format(FORM_CSS_LABEL_TEXT, "label-hobbies");
        String btnReadingCSS = String.format(FORM_CSS_MARK_BUTTON, "input-reading");
        String lblReadingCSS = String.format(FORM_CSS_LABEL_TEXT, "label-reading");
        String btnSportsCSS = String.format(FORM_CSS_MARK_BUTTON, "input-sports");
        String lblSportsCSS = String.format(FORM_CSS_LABEL_TEXT, "label-sports");
        String btnMusicCSS = String.format(FORM_CSS_MARK_BUTTON, "input-music");
        String lblMusicCSS = String.format(FORM_CSS_LABEL_TEXT, "label-music");
        String lblAddressCSS = String.format(FORM_CSS_LABEL_TEXT, "label-address");
        String txtAreaAddressCSS = String.format(FORM_CSS_INPUT_TXTAREA, "textarea-address");
        String btnSubmitCSS = String.format(FORM_CSS_INPUT_BUTTON, "submit-button");
        String btnClearCSS = String.format(FORM_CSS_INPUT_BUTTON, "reset-button");
        String txtSubmittedTitleCSS = String.format(FORM_CSS_H3_TEXT, "submitted-info-title");
        String txtOutputTextStudentCSS = String.format(FORM_CSS_INPUT_TXTAREA, "outputTextStudent");

        //Find web element
        webDriver.findElement(By.cssSelector(txtFormTitleCSS));
        webDriver.findElement(By.cssSelector(txtStudentRegistrationCSS));
        webDriver.findElement(By.cssSelector(lblFirstNameCSS));
        webDriver.findElement(By.cssSelector(txtFirstNameCSS));
        webDriver.findElement(By.cssSelector(lblLastNameCSS));
        webDriver.findElement(By.cssSelector(txtLastNameCSS));
        webDriver.findElement(By.cssSelector(lblEmailCSS));
        webDriver.findElement(By.cssSelector(txtEmailCSS));
        webDriver.findElement(By.cssSelector(lblGenderCSS));
        webDriver.findElement(By.cssSelector(btnMaleCSS));
        webDriver.findElement(By.cssSelector(btnFemaleCSS));
        webDriver.findElement(By.cssSelector(lblFemaleCSS));
        webDriver.findElement(By.cssSelector(lblMaleCSS));
        webDriver.findElement(By.cssSelector(lblDobCSS));
        webDriver.findElement(By.cssSelector(lblMobileCSS));
        webDriver.findElement(By.cssSelector(txtMobileCSS));
        webDriver.findElement(By.cssSelector(txtDobCSS));
        webDriver.findElement(By.cssSelector(lblSubjectCSS));
        webDriver.findElement(By.cssSelector(txtSubjectCSS));
        webDriver.findElement(By.cssSelector(lblHobbyCSS));
        webDriver.findElement(By.cssSelector(btnReadingCSS));
        webDriver.findElement(By.cssSelector(lblReadingCSS));
        webDriver.findElement(By.cssSelector(btnSportsCSS));
        webDriver.findElement(By.cssSelector(lblSportsCSS));
        webDriver.findElement(By.cssSelector(btnMusicCSS));
        webDriver.findElement(By.cssSelector(lblMusicCSS));
        webDriver.findElement(By.cssSelector(lblAddressCSS));
        webDriver.findElement(By.cssSelector(txtAreaAddressCSS));
        webDriver.findElement(By.cssSelector(btnSubmitCSS));
        webDriver.findElement(By.cssSelector(btnClearCSS));
        webDriver.findElement(By.cssSelector(txtSubmittedTitleCSS));
        webDriver.findElement(By.cssSelector(txtOutputTextStudentCSS));














    }

    @Test(description = "Find element with XPath")
    public void findBasicLocatorWithXPath() {
        gotoTestWebsite();

        // Handle other elements similarly
        String FORM_XPATH_H3_TEXT = "//h3[contains(@test-id, '%s')]";
        String FORM_XPATH_LABEL_TEXT = "//label[contains(@test-id, '%s')]";
        String FORM_XPATH_INPUT_TEXT = "//input[contains(@test-id, '%s')]";
        String FORM_XPATH_MARK_BUTTON = "//input[contains(@test-id, '%s')]";
        String FORM_XPATH_INPUT_TXTAREA = "//textarea[contains(@test-id, '%s')]";
        String FORM_XPATH_INPUT_BUTTON = "//button[contains(@test-id, '%s')]";

        String txtFormTitleXpath = String.format(FORM_XPATH_H3_TEXT, "browser-windows-title");
        String txtStudentRegistrationXpath = String.format(FORM_XPATH_H3_TEXT, "student-registration-title");
        String lblFirstNameXpath = String.format(FORM_XPATH_LABEL_TEXT, "label-firstName");
        String txtFirstNameXpath = String.format(FORM_XPATH_INPUT_TEXT, "input-firstName");
        String lblLastNameXpath = String.format(FORM_XPATH_LABEL_TEXT, "label-lastName");
        String txtLastNameXpath = String.format(FORM_XPATH_INPUT_TEXT, "input-lastName");
        String lblEmailXpath = String.format(FORM_XPATH_LABEL_TEXT, "label-email");
        String txtEmailXpath = String.format(FORM_XPATH_INPUT_TEXT, "input-email");
        String lblGenderXpath = String.format(FORM_XPATH_LABEL_TEXT, "label-gender");
        String btnMaleXpath = String.format(FORM_XPATH_MARK_BUTTON, "input-male");
        String btnFemaleXpath = String.format(FORM_XPATH_MARK_BUTTON, "input-female");
        String lblMaleXpath = String.format(FORM_XPATH_LABEL_TEXT, "label-male");
        String lblFemaleXpath = String.format(FORM_XPATH_LABEL_TEXT, "label-female");
        String lblMobileXpath = String.format(FORM_XPATH_LABEL_TEXT, "label-mobile");
        String txtMobileXpath = String.format(FORM_XPATH_INPUT_TEXT, "input-mobile");
        String lblDobXpath = String.format(FORM_XPATH_LABEL_TEXT, "label-dob");
        String txtDobXpath = String.format(FORM_XPATH_INPUT_TEXT, "input-dob");
        String lblSubjectXpath = String.format(FORM_XPATH_LABEL_TEXT, "label-subjects");
        String txtSubjectXpath = String.format(FORM_XPATH_INPUT_TEXT, "input-subjects");
        String lblHobbyXpath = String.format(FORM_XPATH_LABEL_TEXT, "label-hobbies");
        String btnReadingXpath = String.format(FORM_XPATH_MARK_BUTTON, "input-reading");
        String lblReadingXpath = String.format(FORM_XPATH_LABEL_TEXT, "label-reading");
        String btnSportsXpath = String.format(FORM_XPATH_MARK_BUTTON, "input-sports");
        String lblSportsXpath = String.format(FORM_XPATH_LABEL_TEXT, "label-sports");
        String btnMusicXpath = String.format(FORM_XPATH_MARK_BUTTON, "input-music");
        String lblMusicXpath = String.format(FORM_XPATH_LABEL_TEXT, "label-music");
        String lblAddressXpath = String.format(FORM_XPATH_LABEL_TEXT, "label-address");
        String txtAreaAddressXpath = String.format(FORM_XPATH_INPUT_TXTAREA, "textarea-address");
        String btnSubmitXpath = String.format(FORM_XPATH_INPUT_BUTTON, "submit-button");
        String btnClearXpath = String.format(FORM_XPATH_INPUT_BUTTON, "reset-button");
        String txtSubmittedTitleXpath = String.format(FORM_XPATH_H3_TEXT, "submitted-info-title");
        String txtOutputTextStudentXpath = String.format(FORM_XPATH_INPUT_TXTAREA, "outputTextStudent");

        //Find web element
        webDriver.findElement(By.xpath(txtFormTitleXpath));
        webDriver.findElement(By.xpath(txtStudentRegistrationXpath));
        webDriver.findElement(By.xpath(lblFirstNameXpath));
        webDriver.findElement(By.xpath(txtFirstNameXpath));
        webDriver.findElement(By.xpath(lblLastNameXpath));
        webDriver.findElement(By.xpath(txtLastNameXpath));
        webDriver.findElement(By.xpath(lblEmailXpath));
        webDriver.findElement(By.xpath(txtEmailXpath));
        webDriver.findElement(By.xpath(lblGenderXpath));
        webDriver.findElement(By.xpath(btnMaleXpath));
        webDriver.findElement(By.xpath(btnFemaleXpath));
        webDriver.findElement(By.xpath(lblMaleXpath));
        webDriver.findElement(By.xpath(lblFemaleXpath));
        webDriver.findElement(By.xpath(lblMobileXpath));
        webDriver.findElement(By.xpath(txtMobileXpath));
        webDriver.findElement(By.xpath(lblDobXpath));
        webDriver.findElement(By.xpath(txtDobXpath));
        webDriver.findElement(By.xpath(lblSubjectXpath));
        webDriver.findElement(By.xpath(txtSubjectXpath));
        webDriver.findElement(By.xpath(lblHobbyXpath));
        webDriver.findElement(By.xpath(btnReadingXpath));
        webDriver.findElement(By.xpath(lblReadingXpath));
        webDriver.findElement(By.xpath(btnSportsXpath));
        webDriver.findElement(By.xpath(lblSportsXpath));
        webDriver.findElement(By.xpath(btnMusicXpath));
        webDriver.findElement(By.xpath(lblMusicXpath));
        webDriver.findElement(By.xpath(lblAddressXpath));
        webDriver.findElement(By.xpath(txtAreaAddressXpath));
        webDriver.findElement(By.xpath(btnSubmitXpath));
        webDriver.findElement(By.xpath(btnClearXpath));
        webDriver.findElement(By.xpath(txtSubmittedTitleXpath));
        webDriver.findElement(By.xpath(txtOutputTextStudentXpath));




    }

    /**
     * URL: <a href="https://testek.vn/lab/auto/web-elements">...</a>
     * Access to Elements navigation
     */
    @Test(description = "Dynamic Locator Test")
    public void testDynamicLocator() {
        gotoTestWebsite();



        // Define the locator format then apply to elements
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

        waitForDebug();
    }

    /**
     * Sleep for debugging
     */
    private void waitForDebug() {
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
