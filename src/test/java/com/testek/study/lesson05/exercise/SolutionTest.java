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

    }

    @Test(description = "Find element with XPath")
    public void findBasicLocatorWithXPath() {
        gotoTestWebsite();

        //Title
        String FORM_XPATH_H3_TEXT = "//h3[normalize-space()='%s']";

        //Label
        String FORM_XPATH_LABEL_TEXT = "//label[normalize-space()='%s']";

        //Input (textbox)
        String FORM_XPATH_INPUT_TEXT = "//input[@placeholder='%s']";

        //Input (textarea)
        String FORM_XPATH_INPUT_TXTAREA = "//textarea[@placeholder='%s']";

        //Input (radiobutton)
        String FORM_XPATH_INPUT_RDO = "//label[@test-id='%s']";

        //Input (datetime picker)
        String FORM_XPATH_INPUT_DTPICKER = "//input[@id='%s']";

        //Button
        String FORM_XPATH_BTN = "//button[@id='%s']";


        String ttlHeaderXPath = String.format(FORM_XPATH_H3_TEXT, "Browser Windows");
        webDriver.findElement(By.xpath(ttlHeaderXPath));

        String ttlFormXPath = String.format(FORM_XPATH_H3_TEXT, "Form đăng ký sinh viên");
        webDriver.findElement(By.xpath(ttlFormXPath));


        String lblFsttNmXPath = String.format(FORM_XPATH_LABEL_TEXT, "First Name:");
        String inputFstNmXPath = String.format(FORM_XPATH_INPUT_TEXT, "Enter your first name");
        webDriver.findElement(By.xpath(lblFsttNmXPath));
        webDriver.findElement(By.xpath(inputFstNmXPath));

        String lblLstNmXPath = String.format(FORM_XPATH_LABEL_TEXT, "Last Name:");
        String inputLstNmXPath = String.format(FORM_XPATH_INPUT_TEXT, "Enter your last name");
        webDriver.findElement(By.xpath(lblLstNmXPath));
        webDriver.findElement(By.xpath(inputLstNmXPath));


        String lblEmailXPath = String.format(FORM_XPATH_LABEL_TEXT, "Email:");
        String inputEmailXPath = String.format(FORM_XPATH_INPUT_TEXT, "Enter your email");
        webDriver.findElement(By.xpath(lblEmailXPath));
        webDriver.findElement(By.xpath(inputEmailXPath));

        String lblGenderXPath = String.format(FORM_XPATH_LABEL_TEXT, "Gender:");
        String inputMaleXPath = String.format(FORM_XPATH_INPUT_RDO, "label-male");
        String inputFemaleXPath = String.format(FORM_XPATH_INPUT_RDO, "label-female");
        webDriver.findElement(By.xpath(lblGenderXPath));
        webDriver.findElement(By.xpath(inputMaleXPath));
        webDriver.findElement(By.xpath(inputFemaleXPath));

        String lblMblXPath = String.format(FORM_XPATH_LABEL_TEXT, "Mobile:");
        String inputMblXPath = String.format(FORM_XPATH_INPUT_TEXT, "Enter your mobile number");
        webDriver.findElement(By.xpath(lblMblXPath));
        webDriver.findElement(By.xpath(inputMblXPath));

        String lblDateOfBirthXPath = String.format(FORM_XPATH_LABEL_TEXT, "Date of Birth:");
        String inputDtPickerXPath = String.format(FORM_XPATH_INPUT_DTPICKER, "dob");
        webDriver.findElement(By.xpath(lblDateOfBirthXPath));
        webDriver.findElement(By.xpath(inputDtPickerXPath));

        String lblSubjectsXPath = String.format(FORM_XPATH_LABEL_TEXT, "Subjects:");
        String inputSubjectsXpath = String.format(FORM_XPATH_INPUT_TEXT, "Enter your subjects");
        webDriver.findElement(By.xpath(lblSubjectsXPath));
        webDriver.findElement(By.xpath(inputSubjectsXpath));

        String lblHobbiesXPath = String.format(FORM_XPATH_LABEL_TEXT, "Hobbies:");
        String inputReadingXPath = String.format(FORM_XPATH_INPUT_RDO, "label-reading");
        String inputSportsXPath = String.format(FORM_XPATH_INPUT_RDO, "label-sports");
        String inputMusicXPath = String.format(FORM_XPATH_INPUT_RDO, "label-music");
        webDriver.findElement(By.xpath(lblHobbiesXPath));
        webDriver.findElement(By.xpath(inputReadingXPath));
        webDriver.findElement(By.xpath(inputSportsXPath));
        webDriver.findElement(By.xpath(inputMusicXPath));

        String lblAdrXPath = String.format(FORM_XPATH_LABEL_TEXT, "Address:");
        String inputAdrXPath = String.format(FORM_XPATH_INPUT_TXTAREA, "Enter your address");
        webDriver.findElement(By.xpath(lblAdrXPath));
        webDriver.findElement(By.xpath(inputAdrXPath));

        String btnSubmitXPath = String.format(FORM_XPATH_BTN, "submit-button");
        String btnClearXPath = String.format(FORM_XPATH_BTN, "reset-button");
        webDriver.findElement(By.xpath(btnSubmitXPath));
        webDriver.findElement(By.xpath(btnClearXPath));

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
