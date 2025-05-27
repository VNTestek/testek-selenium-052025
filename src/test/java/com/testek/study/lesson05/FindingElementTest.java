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

    @Test
    public void testImproveLocator() {
        gotoTestWebsite(Menu.ELEMENTS, Menu.TEXT_BOX);
        // Init format
        String FORM_INPUT_TEST_ID_XPATH = "//input[@test-id = 'textbox-form-input-%s']";
        String FORM_BUTTON_TEST_ID_XPATH = "//button[@test-id = 'textbox-form-%s']";
        String FORM_TEXTAREA_TEST_ID_XPATH = "//textarea[@test-id = '%s-form-output']";
        String FORM_H3_TEXT_XPATH = "//h3[normalize-space() = '%s']";
        String FORM_LABEL_TEST_ID_XPATH = "//label[@test-id = 'textbox-form-label-%s']";

        // Find elements with dynamic locator
        String inputNameXPath = String.format(FORM_INPUT_TEST_ID_XPATH, "name");
        String inputEmailXPath = String.format(FORM_INPUT_TEST_ID_XPATH, "email");
        String inputPhoneXPath = String.format(FORM_INPUT_TEST_ID_XPATH, "phone");
        String inputAddressXPath = String.format(FORM_INPUT_TEST_ID_XPATH, "address");

        String buttonSubmitXPath = String.format(FORM_BUTTON_TEST_ID_XPATH, "submit");
        String buttonResetXPath = String.format(FORM_BUTTON_TEST_ID_XPATH, "reset");

        String textareaTextboxXPath = String.format(FORM_TEXTAREA_TEST_ID_XPATH, "textbox");

        String lblTitleXPath = String.format(FORM_H3_TEXT_XPATH, "Nhập thông tin người dùng:");
        String lblTextareaXPath = String.format(FORM_H3_TEXT_XPATH, "Thông tin bạn đã nhập:");

        String lblNameXPath = String.format(FORM_LABEL_TEST_ID_XPATH, "name");
        String lblEmailXPath = String.format(FORM_LABEL_TEST_ID_XPATH, "email");
        String lblPhoneXPath = String.format(FORM_LABEL_TEST_ID_XPATH, "phone");
        String lblAddressXPath = String.format(FORM_LABEL_TEST_ID_XPATH, "address");

        // Test
        webDriver.findElement(By.xpath(inputNameXPath));
        webDriver.findElement(By.xpath(inputEmailXPath));
        webDriver.findElement(By.xpath(inputPhoneXPath));
        webDriver.findElement(By.xpath(inputAddressXPath));

        webDriver.findElement(By.xpath(buttonSubmitXPath));
        webDriver.findElement(By.xpath(buttonResetXPath));

        webDriver.findElement(By.xpath(textareaTextboxXPath));

        webDriver.findElement(By.xpath(lblTitleXPath));
        webDriver.findElement(By.xpath(lblTextareaXPath));

        webDriver.findElement(By.xpath(lblNameXPath));
        webDriver.findElement(By.xpath(lblEmailXPath));
        webDriver.findElement(By.xpath(lblPhoneXPath));
        webDriver.findElement(By.xpath(lblAddressXPath));

    }

    /**
     * Go to Test Website
     */
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

    /**
     * Go to Test Website
     */
    void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);

        // Access: Elements > [Menu]
        String mnuElementXPath = "//div[@test-id='menu-elements']";
        WebElement mnuElementEle = webDriver.findElement(By.xpath(mnuElementXPath));
        mnuElementEle.click();
    }

}
