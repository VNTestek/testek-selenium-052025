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

    }

    /**
     * URL: <a href="https://testek.vn/lab/auto/web-elements">...</a>
     * Access to Elements navigation
     */
    @Test(description = "Dynamic Locator Test")
    public void testDynamicLocator() {
        gotoTestWebsite();

        // Define the locator format then apply to elements
        // Find elements with dynamic locator
        String FORM_XPATH_TITLE_TEXT = "//h3[@id='%s']";
        String FORM_XPATH_LABLE_TEXT = "//label[@test-id='%s']";
        String FORM_XPATH_INPUT_PLACEHOlDER = "//input[@id='%s']";
        String FORM_XPATH_TEXTAREA_INPUT = "//textarea[@id='%s']";
        String FORM_XPATH_BUTTON_TEXT = "//button[@id='%s']";

        //Tittle
        String lblReTitleXPath = String.format(FORM_XPATH_TITLE_TEXT, "student-registration-title");
        String lblSubTitleXPath = String.format(FORM_XPATH_TITLE_TEXT, "submitted-info-title");

        //Label
        String lblFirstNameXPath = String.format(FORM_XPATH_LABLE_TEXT, "label-firstName");
        String lblLastNameXPath = String.format(FORM_XPATH_LABLE_TEXT, "label-lastName");
        String lblEmailXPath = String.format(FORM_XPATH_LABLE_TEXT, "label-email");
        String lblGenderXPath = String.format(FORM_XPATH_LABLE_TEXT, "label-gender");
        String lblMobileXPath = String.format(FORM_XPATH_LABLE_TEXT, "label-mobile");
        String lblDobXPath = String.format(FORM_XPATH_LABLE_TEXT, "label-dob");
        String lblSubjectsXPath = String.format(FORM_XPATH_LABLE_TEXT, "label-subjects");
        String lblHobbiesXPath = String.format(FORM_XPATH_LABLE_TEXT, "label-hobbies");
        String lblAddressXPath = String.format(FORM_XPATH_LABLE_TEXT, "label-address");
        String lblMaleXPath = String.format(FORM_XPATH_LABLE_TEXT, "label-male");
        String lblFemaleXPath = String.format(FORM_XPATH_LABLE_TEXT, "label-female");
        String lblReadingXPath = String.format(FORM_XPATH_LABLE_TEXT, "label-reading");
        String lblSportsXPath = String.format(FORM_XPATH_LABLE_TEXT, "label-sports");
        String lblMusicXPath = String.format(FORM_XPATH_LABLE_TEXT, "label-music");

        //Input text
        String txtFistNameXPath = String.format(FORM_XPATH_INPUT_PLACEHOlDER, "firstName");
        String txtLastNameXPath = String.format(FORM_XPATH_INPUT_PLACEHOlDER, "lastName");
        String txtEmailXPath = String.format(FORM_XPATH_INPUT_PLACEHOlDER, "email");
        String txtAddressXPath = String.format(FORM_XPATH_INPUT_PLACEHOlDER, "address");
        String txtMobileXPath = String.format(FORM_XPATH_INPUT_PLACEHOlDER, "mobile");
        String datDobXPath = String.format(FORM_XPATH_INPUT_PLACEHOlDER, "dob");
        String txtSubjectsXPath = String.format(FORM_XPATH_INPUT_PLACEHOlDER, "subjects");

        //Checkbox
        String chkRedingXPath = String.format(FORM_XPATH_INPUT_PLACEHOlDER, "reading");
        String chkSportsXPath = String.format(FORM_XPATH_INPUT_PLACEHOlDER, "sports");
        String chkMusicXPath = String.format(FORM_XPATH_INPUT_PLACEHOlDER, "music");


        //Textarea
        String txaAddressXPath = String.format(FORM_XPATH_TEXTAREA_INPUT, "address");
        String txaOutputTextStudentXPath = String.format(FORM_XPATH_TEXTAREA_INPUT, "outputTextStudent");

        //Button
        String bntSubmitXPath = String.format(FORM_XPATH_BUTTON_TEXT, "submit-button");
        String bntClearXPath = String.format(FORM_XPATH_BUTTON_TEXT, "reset-button");


        //Find Element: Tittle
        webDriver.findElement(By.xpath(lblReTitleXPath));
        webDriver.findElement(By.xpath(lblSubTitleXPath));

        //Find Element: Label
        webDriver.findElement(By.xpath(lblFirstNameXPath));
        webDriver.findElement(By.xpath(lblLastNameXPath));
        webDriver.findElement(By.xpath(lblEmailXPath));
        webDriver.findElement(By.xpath(lblGenderXPath));
        webDriver.findElement(By.xpath(lblMobileXPath));
        webDriver.findElement(By.xpath(lblDobXPath));
        webDriver.findElement(By.xpath(lblSubjectsXPath));
        webDriver.findElement(By.xpath(lblHobbiesXPath));
        webDriver.findElement(By.xpath(lblAddressXPath));
        webDriver.findElement(By.xpath(lblMaleXPath));
        webDriver.findElement(By.xpath(lblFemaleXPath));
        webDriver.findElement(By.xpath(lblReadingXPath));
        webDriver.findElement(By.xpath(lblSportsXPath));
        webDriver.findElement(By.xpath(lblMusicXPath));

        //Find element: Input text
        webDriver.findElement(By.xpath(txtFistNameXPath));
        webDriver.findElement(By.xpath(txtLastNameXPath));
        webDriver.findElement(By.xpath(txtEmailXPath));
        webDriver.findElement(By.xpath(txtAddressXPath));
        webDriver.findElement(By.xpath(txtMobileXPath));
        webDriver.findElement(By.xpath(datDobXPath));
        webDriver.findElement(By.xpath(txtSubjectsXPath));
        webDriver.findElement(By.xpath(datDobXPath));

        //Find element: Checkbox
        webDriver.findElement(By.xpath(chkRedingXPath));
        webDriver.findElement(By.xpath(chkSportsXPath));
        webDriver.findElement(By.xpath(chkMusicXPath));

        //Find element: Button
        webDriver.findElement(By.xpath(bntSubmitXPath));
        webDriver.findElement(By.xpath(bntClearXPath));

        //Find element: textarea
        webDriver.findElement(By.xpath(txaAddressXPath));
        webDriver.findElement(By.xpath(txaOutputTextStudentXPath));

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
