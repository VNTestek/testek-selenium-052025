package com.testek.study.lesson05.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    }

    @Test(description = "Find element with XPath")
    public void findBasicLocatorWithXPath() {
        gotoTestWebsite();

        // Handle other elements similarly

    }

    /**
     * URL: <a href="https://testek.vn/lab/auto/web-elements">...</a>
     * Access to Elements navigation
     */
    @Test(description = "Dynamic Locator Test")
    public void testDynamicLocator() {
        gotoTestWebsite();

        // Define the locator format then apply to elements

        //dynamic locators
        String XPATH_H3_TITLE_FORM = "//h3[@id = '%s']";
        String XPATH_LBL_FORM = "//label[@for = '%s']";
        String XPATH_INPUT_TEXT_FORM = "//input[@placeholder = '%s']";
        String XPATH_RADIO_FORM = "//input[@type = 'radio' and @id = '%s']";
        String XPATH_DATE_FORM = "//input[@type = 'date' and @id = '%s']";
        String XPATH_CHECKBOX_FORM = "//input[@type = 'checkbox' and @id = '%s']";
        String XPATH_BUTTON_FORM = "//button[id='%s']";
        String XPATH_TXT_AREA_FORM = "//textarea[@id = '%s']";

        // Browser Windows
        String lblBrowserWindowsTitleXPath = String.format(XPATH_H3_TITLE_FORM, "browser-windows-title");
        webDriver.findElement(By.xpath(lblBrowserWindowsTitleXPath));
        // Form đăng ký sinh viên
        String lblFormTitleXPath = String.format(XPATH_H3_TITLE_FORM, "student-registration-title");
        webDriver.findElement(By.xpath(lblFormTitleXPath));
        //First Name lbl
        String lblFirstNameXPath = String.format(XPATH_LBL_FORM, "firstName");
        webDriver.findElement(By.xpath(lblFirstNameXPath));
        //First Name txt
        String txtFirstNameXPath = String.format(XPATH_INPUT_TEXT_FORM, "Enter your first name");
        webDriver.findElement(By.xpath(txtFirstNameXPath));
        //Last Name lbl
        String lblLastNameXPath = String.format(XPATH_LBL_FORM, "lastName");
        webDriver.findElement(By.xpath(lblLastNameXPath));
        //Last Name txt
        String txtLastNameXPath = String.format(XPATH_INPUT_TEXT_FORM, "Enter your last name");
        webDriver.findElement(By.xpath(txtLastNameXPath));
        //Email lbl
        String lblEmailXPath = String.format(XPATH_LBL_FORM, "email");
        webDriver.findElement(By.xpath(lblEmailXPath));
        //Email txt
        String txtEmailXPath = String.format(XPATH_INPUT_TEXT_FORM, "Enter your email");
        webDriver.findElement(By.xpath(txtEmailXPath));
        //Gender lbl
        String lblGenderXPath = String.format(XPATH_LBL_FORM, "gender");
        webDriver.findElement(By.xpath(lblGenderXPath));
        //Male RDO
        String rdoMaleXPath = String.format(XPATH_RADIO_FORM, "male");
        webDriver.findElement(By.xpath(rdoMaleXPath));
        //Female RDO
        String rdoFemaleXPath = String.format(XPATH_RADIO_FORM, "female");
        webDriver.findElement(By.xpath(rdoFemaleXPath));
        //Mobile lbl
        String lblMobileXPath = String.format(XPATH_LBL_FORM, "mobile");
        webDriver.findElement(By.xpath(lblMobileXPath));

        //Mobile txt
        String txtMobileXPath = String.format(XPATH_INPUT_TEXT_FORM, "Enter your mobile number");
        webDriver.findElement(By.xpath(txtMobileXPath));

        //Date of Birth lbl
        String lblDobXPath = String.format(XPATH_LBL_FORM, "dob");
        webDriver.findElement(By.xpath(lblDobXPath));

        //Date of Birth input
        String dateDobXPath = String.format(XPATH_DATE_FORM, "dob");
        webDriver.findElement(By.xpath(dateDobXPath));

        //Subjects lbl
        String lblSubjectsXPath = String.format(XPATH_LBL_FORM, "subjects");
        webDriver.findElement(By.xpath(lblSubjectsXPath));

        //Subjects txt
        String txtSubjectsXPath = String.format(XPATH_INPUT_TEXT_FORM, "Enter your subjects");
        webDriver.findElement(By.xpath(txtSubjectsXPath));

        //Hobbies lbl
        String lblHobbiesXPath = String.format(XPATH_LBL_FORM, "hobbies");
        webDriver.findElement(By.xpath(lblHobbiesXPath));

        //Reading CHK
        String chkReadingXPath = String.format(XPATH_CHECKBOX_FORM, "reading");
        webDriver.findElement(By.xpath(chkReadingXPath));

        //Sports CHK
        String chkSportsXPath = String.format(XPATH_CHECKBOX_FORM, "sports");
        webDriver.findElement(By.xpath(chkSportsXPath));

        //Music CHK
        String chkMusicXPath = String.format(XPATH_CHECKBOX_FORM, "music");
        webDriver.findElement(By.xpath(chkMusicXPath));

        //Address lbl
        String lblAddressXPath = String.format(XPATH_LBL_FORM, "address");
        webDriver.findElement(By.xpath(lblAddressXPath));

        //Address txt
        String txtAddressXPath = String.format(XPATH_TXT_AREA_FORM, "address");
        webDriver.findElement(By.xpath(txtAddressXPath));

        //submit btn
        String btnSubmitXPath = String.format(XPATH_BUTTON_FORM, "Submit");
        webDriver.findElement(By.xpath(btnSubmitXPath));

        //clear btn
        String btnClearFormXPath = String.format(XPATH_BUTTON_FORM, "Clear");
        webDriver.findElement(By.xpath(btnClearFormXPath));

        //Thông tin bạn đã nhập lbl
        String lblSubmittedInfoXPath = String.format(XPATH_H3_TITLE_FORM, "submitted-info-title");
        webDriver.findElement(By.xpath(lblSubmittedInfoXPath));

        //outputTextStudent txt area
        String txtAreaOutputTextXPath = String.format(XPATH_TXT_AREA_FORM, "outputTextStudent");
        webDriver.findElement(By.xpath(txtAreaOutputTextXPath));

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
