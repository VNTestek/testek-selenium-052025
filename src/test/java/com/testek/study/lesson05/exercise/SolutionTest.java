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
        //Form đăng ký sinh viên
        //h3[@test-id='textbox-form-output-title']
        String lblTtlXPath = "//h3[@test-id='textbox-form-output-title']";
        WebElement lblTtlEle = webDriver.findElement(By.xpath(lblTtlXPath));

        //First Name:
        //label[@test-id='label-firstName']
        String lblFirstNameFieldXPath = "//label[@test-id='label-firstName']";
        WebElement firstNameFieldEle = webDriver.findElement(By.xpath(lblFirstNameFieldXPath));
        //input[@placeholder='Nhập họ tên']
        String lblFirstNamePlaceholderXPath = "//input[@placeholder='Nhập họ tên']";
        WebElement firstNamPlaceholderEle = webDriver.findElement(By.xpath(lblFirstNamePlaceholderXPath));

        //label[@test-id='label-lastName']
        String lblLastNameFieldXPath = "//label[@test-id='label-lastName']";
        WebElement lastNameFieldEle = webDriver.findElement(By.xpath(lblLastNameFieldXPath));
        //input[@placeholder='Enter your last name']
        String lblLastNamePlaceholderXPath = "//input[@placeholder='Enter your last name']";
        WebElement lastNamePlaceholderEle = webDriver.findElement(By.xpath(lblLastNamePlaceholderXPath));

        //Email:
        //label[@test-id='label-email']
        String lblEmailFieldXPath = "//label[@test-id='label-email']";
        WebElement emailFieldEle = webDriver.findElement(By.xpath(lblEmailFieldXPath));
        //input[@placeholder='Enter your email']
        String lblEmailPlaceholderXPath = "//input[@placeholder='Enter your email']";
        WebElement emailPlaceholderEle = webDriver.findElement(By.xpath(lblEmailPlaceholderXPath));

        //Gender:
        //label[@test-id='label-gender']
        String lblGenderFieldXPath = "//label[@test-id='label-gender']";
        WebElement genderFieldEle = webDriver.findElement(By.xpath(lblGenderFieldXPath));
        //input[@id='male']
        String rdoMaleXPath = "//input[@id='male']";
        WebElement rdoMaleEle = webDriver.findElement(By.xpath(rdoMaleXPath));
        //input[@id='female']
        String rdoFemaleXPath = "//input[@id='female']";
        WebElement rdoFemaleEle = webDriver.findElement(By.xpath(rdoFemaleXPath));

        //Mobile:
        //label[@test-id='label-mobile']
        String lblMobileFieldXPath = "//label[@test-id='label-mobile']";
        WebElement mobileFieldEle = webDriver.findElement(By.xpath(lblMobileFieldXPath));
        //input[@placeholder='Enter your mobile number']
        String lblMobilePlaceholderXPath = "//input[@placeholder='Enter your mobile number']";
        WebElement mobilePlaceholderEle = webDriver.findElement(By.xpath(lblMobilePlaceholderXPath));

        //Date of Birth:
        //label[@test-id='label-dob']
        String lblDobFieldXPath = "//label[@test-id='label-dob']";
        WebElement dobFieldEle = webDriver.findElement(By.xpath(lblDobFieldXPath));
        //input[@type='date']
        String lblDatePickerXPath = "//input[@type='date']";
        WebElement datePickerEle = webDriver.findElement(By.xpath(lblDatePickerXPath));

        //Subjects:
        //label[@test-id='label-subjects']
        String lblSubjectsFieldXPath = "//label[@test-id='label-subjects']";
        WebElement subjectsFieldEle = webDriver.findElement(By.xpath(lblSubjectsFieldXPath));
        //input[@placeholder='Enter your subjects']
        String lblSbjPlaceholderXPath = "//input[@placeholder='Enter your subjects']";
        WebElement subjectsPlaceholderEle = webDriver.findElement(By.xpath(lblSbjPlaceholderXPath));

        //Hobbies:
        //label[@test-id='label-hobbies']
        String lblHobbiesFieldXPath = "//label[@test-id='label-hobbies']";
        WebElement hobbiesFieldEle = webDriver.findElement(By.xpath(lblHobbiesFieldXPath));
        //input[@id='reading']
        String chkReadingXPath = "//input[@id='reading']";
        WebElement chkReadingEle = webDriver.findElement(By.xpath(chkReadingXPath));
        //input[@id='sports']
        String chkSportsXPath = "//input[@id='sports']";
        WebElement chkSportsEle = webDriver.findElement(By.xpath(chkSportsXPath));
        //input[@id='music']
        String chkMusicXPath = "//input[@id='music']";
        WebElement chkMusicEle = webDriver.findElement(By.xpath(chkMusicXPath));

        //Address:
        //label[@test-id='label-address']
        String lblAddressXPath = "//label[@test-id='label-address']";
        WebElement addressFieldEle = webDriver.findElement(By.xpath(lblAddressXPath));
        //textarea[@placeholder='Enter your address']
        String textareaXPath = "//textarea[@placeholder='Enter your address']";
        WebElement textareaEle = webDriver.findElement(By.xpath(textareaXPath));

        //Buttons
        //button[@id='submit-button']
        String btnSubmitXPath = "//button[@id='submit-button']";
        WebElement btnSubmitEle = webDriver.findElement(By.xpath(btnSubmitXPath));
        //button[@id='reset-button']
        String btnClearXPath = "//button[@id='reset-button']";
        WebElement btnClearEle = webDriver.findElement(By.xpath(btnClearXPath));

        //Thông tin bạn đã nhập:
        //h3[@test-id='submitted-info-title']
        String lblInputInfoFieldXPath = "//h3[@test-id='submitted-info-title']";
        WebElement inputInfoFieldEle = webDriver.findElement(By.xpath(lblInputInfoFieldXPath));
        //textarea[@test-id='outputTextStudent']
        String textareaInfoFieldXPath = "//textarea[@test-id='outputTextStudent']";
        WebElement textareaInfoFieldEle = webDriver.findElement(By.xpath(textareaInfoFieldXPath));


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
        //input[@type and @placeholder]
        String FORM_XPATH_INPUT_PLACEHOLDER = "//input[@type='%s' and @placeholder='%s']";
        String lblFirstNamePlaceholderXPath = String.format(FORM_XPATH_INPUT_PLACEHOLDER, "text", "Enter your first name");
        String lblLastNamePlaceholderXPath = String.format(FORM_XPATH_INPUT_PLACEHOLDER, "text", "Enter your last name");
        String lblEmailPlaceholderXPath = String.format(FORM_XPATH_INPUT_PLACEHOLDER, "email", "Enter your email");
        String lblMobilePlaceholderXPath = String.format(FORM_XPATH_INPUT_PLACEHOLDER, "text", "Enter your mobile number");
        String lblSbjPlaceholderXPath = String.format(FORM_XPATH_INPUT_PLACEHOLDER, "text", "Enter your subjects");
        WebElement lblFirstNameEle = webDriver.findElement(By.xpath(lblFirstNamePlaceholderXPath));
        WebElement lblLastNameEle = webDriver.findElement(By.xpath(lblLastNamePlaceholderXPath));
        WebElement lblEmailEle = webDriver.findElement(By.xpath(lblEmailPlaceholderXPath));
        WebElement lblMobileEle = webDriver.findElement(By.xpath(lblMobilePlaceholderXPath));
        WebElement lblSbjEle = webDriver.findElement(By.xpath(lblSbjPlaceholderXPath));

        //input[@type and @id and @name]
        String FORM_BUTTON_SELECT_XPATH_TYPE = "//input[@type='%s' and @id='%s' and @name='%s']";
        String rdoGenderMXPath = String.format(FORM_BUTTON_SELECT_XPATH_TYPE, "radio", "male", "gender");
        String rdoGenderFXPath = String.format(FORM_BUTTON_SELECT_XPATH_TYPE, "radio", "female", "gender");
        String chkReadingXPath = String.format(FORM_BUTTON_SELECT_XPATH_TYPE, "checkbox", "reading", "hobbies");
        String chkSportsXPath = String.format(FORM_BUTTON_SELECT_XPATH_TYPE, "checkbox", "sports", "hobbies");
        String chkMusicXPath = String.format(FORM_BUTTON_SELECT_XPATH_TYPE, "checkbox", "music", "hobbies");
        WebElement rdoGenderMEle = webDriver.findElement(By.xpath(rdoGenderMXPath));
        WebElement rdoGenderFEle = webDriver.findElement(By.xpath(rdoGenderFXPath));
        WebElement chkReadingMEle = webDriver.findElement(By.xpath(chkReadingXPath));
        WebElement chkSportsMEle = webDriver.findElement(By.xpath(chkSportsXPath));
        WebElement chkMusicMEle = webDriver.findElement(By.xpath(chkMusicXPath));

        //input[@id]
        String FORM_XPATH_DOB = "//input[@id='%s']";
        String lblDobXPath = String.format(FORM_XPATH_DOB, "dob");
        WebElement lblDobEle = webDriver.findElement(By.xpath(lblDobXPath));

        //button[@type]
        String FORM_XPATH_BTN = "//button[@type ='%s']";
        String btnSubmitXPath = String.format(FORM_XPATH_BTN, "submit");
        String btnClearXPath = String.format(FORM_XPATH_BTN, "reset");
        WebElement btnSubmitEle = webDriver.findElement(By.xpath(btnSubmitXPath));
        WebElement btnClearEle = webDriver.findElement(By.xpath(btnClearXPath));

        //textarea[@id]
        String FORM_XPATH_TEXTAREA = "//textarea[@id = '%s']";
        String lblAddressTxtAraXPath = String.format(FORM_XPATH_TEXTAREA, "address");
        String lblInfoTxtAreaXPath = String.format(FORM_XPATH_TEXTAREA, "outputTextStudent");
        WebElement lblAddressEle = webDriver.findElement(By.xpath(lblAddressTxtAraXPath));
        WebElement lblTxtAreaEle = webDriver.findElement(By.xpath(lblInfoTxtAreaXPath));


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
