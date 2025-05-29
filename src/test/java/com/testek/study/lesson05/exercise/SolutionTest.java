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

        // Handle other elements similarly
        // Label
        String lblTitleXpath = "//h3[normalize-space()='Form đăng ký sinh viên']";
        webDriver.findElement(By.xpath(lblTitleXpath));
        String lblFirstNameXpath = "//label[normalize-space()='First Name:']";
        webDriver.findElement(By.xpath(lblFirstNameXpath));
        String lblLastNameXpath = "//label[normalize-space()='Last Name:']";
        webDriver.findElement(By.xpath(lblLastNameXpath));
        String lblEmailXpath = "//label[normalize-space()='Email:']";
        webDriver.findElement(By.xpath(lblEmailXpath));
        String lblGenderXpath = "//label[normalize-space()='Gender:']";
        webDriver.findElement(By.xpath(lblGenderXpath));
        String lblMobileXpath = "//label[normalize-space()='Mobile:']";
        webDriver.findElement(By.xpath(lblMobileXpath));
        String lblDOBXpath = "//label[normalize-space()='Date of Birth:']";
        webDriver.findElement(By.xpath(lblDOBXpath));
        String lblSubjectsXpath = "//label[normalize-space()='Subjects:']";
        webDriver.findElement(By.xpath(lblSubjectsXpath));

        // Textbox
        String txtFirstNameXpath = "//input[@type='text' and @id='firstName']";
        webDriver.findElement(By.xpath(txtFirstNameXpath));
        String txtLastNameXpath = "//input[@type='text' and @id='lastName']";
        webDriver.findElement(By.xpath(txtLastNameXpath));
        String txtEmailXpath = "//input[@type='email' and @id='email']";
        webDriver.findElement(By.xpath(txtEmailXpath));

        // Radio
        String rdoMaleXpath = "//input[@type='radio' and @id='male']";
        webDriver.findElement(By.xpath(rdoMaleXpath));
        String rdoFemaleXpath = "//input[@type='radio' and @id='female']";
        webDriver.findElement(By.xpath(rdoFemaleXpath));

        // Checkbox
        String chkFemaleXpath = "//input[@type='checkbox' and @id='reading']";
        webDriver.findElement(By.xpath(chkFemaleXpath));

        // Btn
        String btnSubmitXpath = "//button[normalize-space()='Submit']";
        webDriver.findElement(By.xpath(btnSubmitXpath));
        String btnClearXpath = "//button[normalize-space()='Clear']";
        webDriver.findElement(By.xpath(btnClearXpath));

        // Text area
        String textareaClearXpath = "//textarea[@id='address']";
        webDriver.findElement(By.xpath(textareaClearXpath));
    }

    /**
     * URL: <a href="https://testek.vn/lab/auto/web-elements">...</a>
     * Access to Elements navigation
     */
    @Test(description = "Dynamic Locator Test")
    public void testDynamicLocator() {
        gotoTestWebsite();

        // Define the locator format then apply to elements
        //Format
        String FORM_XPATH_LABEL_TITLE_TEXT= "//h3[normalize-space()='%s']";
        String FORM_XPATH_LABEL_INPUT_TEXT= "//label[normalize-space()='%s']";
        String FORM_XPATH_TXT_RDO_CHK_INPUT= "//input[@type='%s' and @id='%s']";
        String FORM_XPATH_TEXTAREA_INPUT= "//textarea[@id='%s']";
        String FORM_XPATH_BTN= "//button[normalize-space()='%s']";

        // Title
        String lblTitleXpath = String.format(FORM_XPATH_LABEL_TITLE_TEXT,"Form đăng ký sinh viên");
        webDriver.findElement(By.xpath(lblTitleXpath));

        // Label
        String lblFirstNameXpath = String.format(FORM_XPATH_LABEL_INPUT_TEXT,"First Name:");
        webDriver.findElement(By.xpath(lblFirstNameXpath));
        String lblLastNameXpath = String.format(FORM_XPATH_LABEL_INPUT_TEXT,"Last Name:");
        webDriver.findElement(By.xpath(lblLastNameXpath));
        String lblEmailXpath = String.format(FORM_XPATH_LABEL_INPUT_TEXT,"Email:");
        webDriver.findElement(By.xpath(lblEmailXpath));
        String lblGenderXpath = String.format(FORM_XPATH_LABEL_INPUT_TEXT,"Gender:");
        webDriver.findElement(By.xpath(lblGenderXpath));
        String lblMobileXpath = String.format(FORM_XPATH_LABEL_INPUT_TEXT,"Mobile:");
        webDriver.findElement(By.xpath(lblMobileXpath));
        String lblDOBXpath = String.format(FORM_XPATH_LABEL_INPUT_TEXT,"Date of Birth:");
        webDriver.findElement(By.xpath(lblDOBXpath));
        String lblSubjectsXpath = String.format(FORM_XPATH_LABEL_INPUT_TEXT,"Subjects:");
        webDriver.findElement(By.xpath(lblSubjectsXpath));

        // Textbox
        String txtFirstNameXpath = String.format(FORM_XPATH_TXT_RDO_CHK_INPUT,"text","firstName");
        webDriver.findElement(By.xpath(txtFirstNameXpath));
        String txtLastNameXpath = String.format(FORM_XPATH_TXT_RDO_CHK_INPUT,"text","lastName");
        webDriver.findElement(By.xpath(txtLastNameXpath));
        String txtEmailXpath = String.format(FORM_XPATH_TXT_RDO_CHK_INPUT,"email","email");
        webDriver.findElement(By.xpath(txtEmailXpath));

        // Radio
        String rdoMaleXpath = String.format(FORM_XPATH_TXT_RDO_CHK_INPUT,"radio","male");
        webDriver.findElement(By.xpath(rdoMaleXpath));
        String rdoFemaleXpath = String.format(FORM_XPATH_TXT_RDO_CHK_INPUT,"radio","female");
        webDriver.findElement(By.xpath(rdoFemaleXpath));

        // Checkbox
        String chkFemaleXpath = String.format(FORM_XPATH_TXT_RDO_CHK_INPUT,"checkbox","reading");
        webDriver.findElement(By.xpath(chkFemaleXpath));

        // Btn
        String btnSubmitXpath = String.format(FORM_XPATH_BTN,"Submit");
        webDriver.findElement(By.xpath(btnSubmitXpath));
        String btnClearXpath = String.format(FORM_XPATH_BTN,"Clear");
        webDriver.findElement(By.xpath(btnClearXpath));

        // Text area
        String textareaClearXpath = String.format(FORM_XPATH_TEXTAREA_INPUT,"address");
        webDriver.findElement(By.xpath(textareaClearXpath));
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
