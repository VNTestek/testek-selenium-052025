package com.testek.study.lesson05;

import com.testek.study.common.Menu;
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


public class FindingElementTest {

    // The driver for interacting with the webpage
    private WebDriver webDriver;


    @BeforeClass
    public void beforeClass() {
        //WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
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
    @Test(description = "Dynamic Locator Test")
    public void testDynamicLocator() {
        gotoTestWebsite();
        // Step 1: Evaluate the components on the website, guess which components have something in common and may share information about the locator
        // Same type (https://testek.vn/lab/auto/web-elements):
        // Elements { Textbox, Checkbox, Radio Button, Web Tables, Buttons, Links, Dynamic Properties, etc. }

        // Step 2: Find all elements on the website and group them by common attributes
        String mnuTextboxXPath = "//div[@test-id='submenu-textbox']";
        String mnuCheckboxXPath = "//div[@test-id='submenu-checkbox']";
        String mnuRadioXPath = "//div[@test-id='submenu-radio']";
        String mnuWebTablesXPath = "//div[@test-id='submenu-webtables']";
        String mnuButtonXPath = "//div[@test-id='submenu-buttons']";
        String mnuLinkXPath = "//div[@test-id='submenu-links']";
        String mnuDynamicProperXPath = "//div[@test-id='submenu-dynamic']";

        // => All elements have div tag and [test-id] attribute, except for subject which is different from the others.

        // Step 3: Optimize the locators just found
        String XPATH_DYNAMIC_TEST_ID_FORM = "//div[@test-id='%s']";

        // Step 4: Test and evaluate
        String finalTextboxXPath = String.format(XPATH_DYNAMIC_TEST_ID_FORM, "submenu-textbox");
        String finalCheckboxXPath = String.format(XPATH_DYNAMIC_TEST_ID_FORM, "submenu-checkbox");
        String finalRadioXPath = String.format(XPATH_DYNAMIC_TEST_ID_FORM, "submenu-radio");
        String finalWebTablesXPath = String.format(XPATH_DYNAMIC_TEST_ID_FORM, "submenu-webtables");
        String finalButtonXPath = String.format(XPATH_DYNAMIC_TEST_ID_FORM, "submenu-buttons");
        String finalLinkXPath = String.format(XPATH_DYNAMIC_TEST_ID_FORM, "submenu-links");
        String finalDynamicProperXPath = String.format(XPATH_DYNAMIC_TEST_ID_FORM, "submenu-dynamic");

        // Find web elements
        webDriver.findElement(By.xpath(finalTextboxXPath));
        webDriver.findElement(By.xpath(finalCheckboxXPath));
        webDriver.findElement(By.xpath(finalRadioXPath));
        webDriver.findElement(By.xpath(finalWebTablesXPath));
        webDriver.findElement(By.xpath(finalButtonXPath));
        webDriver.findElement(By.xpath(finalLinkXPath));
        webDriver.findElement(By.xpath(finalDynamicProperXPath));

        // Find specific elements
        webDriver.findElement(By.xpath(mnuTextboxXPath));
        webDriver.findElement(By.xpath(mnuCheckboxXPath));
        webDriver.findElement(By.xpath(mnuRadioXPath));
        webDriver.findElement(By.xpath(mnuWebTablesXPath));
        webDriver.findElement(By.xpath(mnuButtonXPath));
        webDriver.findElement(By.xpath(mnuLinkXPath));
        webDriver.findElement(By.xpath(mnuDynamicProperXPath));

        // Practice with the other elements
    }


    /**
     * Create a xpath expression
     *
     * @param format : Expression format
     * @param values : Values for the expression
     * @return : The xpath
     */
    private String getStringXPath(String format, String... values) {
        return String.format(format, values);
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

    @Test

    public void testImproveLocator() {

        gotoTestWebsite(Menu.ELEMENTS, Menu.TEXT_BOX);

        // Init format

        String FORM = "//div[@test-id='%s']";

        // Find elements with dynamic locator
        String FORM_XPATH_INPUT_PLACEHODER = "//input[@id='%s']";
        String FORM_XPATH_LABLE_TEXT = "//label[@for='%s']";
        String FORM_XPATH_BUTTON_TEXT = "//button[@test-id='%s']";
        String FORM_XPATH_TITLE_TEXT = "//h3[@test-id='%s']";

        //Input
        String txtNameXpath = String.format(FORM_XPATH_INPUT_PLACEHODER, "name");
        String txtEmailXpath = String.format(FORM_XPATH_INPUT_PLACEHODER, "email");
        String txtPhoneXpath = String.format(FORM_XPATH_INPUT_PLACEHODER, "phone");
        String txtAddressXpath = String.format(FORM_XPATH_INPUT_PLACEHODER, "address");

        //Label
        String lblNameXpath = String.format(FORM_XPATH_LABLE_TEXT, "name");
        String lblEmailXpath = String.format(FORM_XPATH_LABLE_TEXT, "email");
        String lblPhoneXpath = String.format(FORM_XPATH_LABLE_TEXT, "phone");
        String lblAddressXpath = String.format(FORM_XPATH_LABLE_TEXT, "address");

        //Button
        String bntSubmitXPath = String.format(FORM_XPATH_BUTTON_TEXT, "textbox-form-submit");
        String bntClearXPath = String.format(FORM_XPATH_BUTTON_TEXT, "textbox-form-reset");

        //Tittle
        String lblTitleXPath = String.format(FORM_XPATH_TITLE_TEXT, "textbox-form-title");
        String lblOutputTitleXPath = String.format(FORM_XPATH_TITLE_TEXT, "textbox-form-output-title");


        //Find Element
        webDriver.findElement(By.xpath(txtNameXpath));
        webDriver.findElement(By.xpath(txtEmailXpath));
        webDriver.findElement(By.xpath(txtPhoneXpath));
        webDriver.findElement(By.xpath(txtAddressXpath));

        webDriver.findElement(By.xpath(lblNameXpath));
        webDriver.findElement(By.xpath(lblEmailXpath));
        webDriver.findElement(By.xpath(lblPhoneXpath));
        webDriver.findElement(By.xpath(lblAddressXpath));

        webDriver.findElement(By.xpath(bntSubmitXPath));
        webDriver.findElement(By.xpath(bntClearXPath));

        webDriver.findElement(By.xpath(lblTitleXPath));
        webDriver.findElement(By.xpath(lblOutputTitleXPath));

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
}