package com.testek.study.lesson04.exercise;

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
import com.testek.study.common.Menu;
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
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfTextBox() {
        gotoTestWebsite(Menu.TEXT_BOX);

        // find TextBox by contains CSS
        String FORM_CSS_TXT_INPUT = "//input[@test-id *='textbox-form-input-%s']";

        WebElement findTxtNameEle = webDriver.findElement(By.cssSelector(String.format(FORM_CSS_TXT_INPUT, "name")));
        WebElement findTxtEmailEle = webDriver.findElement(By.cssSelector(String.format(FORM_CSS_TXT_INPUT, "email")));
        WebElement findTxtPhoneEle = webDriver.findElement(By.cssSelector(String.format(FORM_CSS_TXT_INPUT, "phone")));
        WebElement findTxtAddressEle = webDriver.findElement(By.cssSelector(String.format(FORM_CSS_TXT_INPUT, "address")));

        // find CheckBox by contains CSS

    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfTextBox() {
        gotoTestWebsite(Menu.TEXT_BOX);

        // find TextBox by contains Xpath
        String FORM_XPATH_TXT_INPUT = "//input[contains(@test-id,'textbox-form-input-%s')]";

        WebElement findTxtNameEle = webDriver.findElement(By.xpath(String.format(FORM_XPATH_TXT_INPUT, "name")));
        WebElement findTxtEmailEle = webDriver.findElement(By.xpath(String.format(FORM_XPATH_TXT_INPUT, "email")));
        WebElement findTxtPhoneEle = webDriver.findElement(By.xpath(String.format(FORM_XPATH_TXT_INPUT, "phone")));
        WebElement findTxtAddressEle = webDriver.findElement(By.xpath(String.format(FORM_XPATH_TXT_INPUT, "address")));

    }

    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfRadioButton() {
        gotoTestWebsite(Menu.RADIO_BUTTON);

        // find TextBox by contains Xpath
        String FORM_CSS_RAD = "label[test-id = '%s']";
        WebElement findTxtNameEle = webDriver.findElement(By.cssSelector(String.format(FORM_CSS_RAD, "radio-label-yes")));
        WebElement findTxtEmailEle = webDriver.findElement(By.cssSelector(String.format(FORM_CSS_RAD, "radio-label-impressive")));
        WebElement findTxtPhoneEle = webDriver.findElement(By.cssSelector(String.format(FORM_CSS_RAD, "radio-label-no")));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfRadioButton() {
        gotoTestWebsite(Menu.RADIO_BUTTON);

        // find TextBox by contains Xpath
        String FORM_XPATH_RAD = "//label[@test-id = '%s']";
        WebElement findTxtNameEle = webDriver.findElement(By.xpath(String.format(FORM_XPATH_RAD, "radio-label-yes")));
        WebElement findTxtEmailEle = webDriver.findElement(By.xpath(String.format(FORM_XPATH_RAD, "radio-label-impressive")));
        WebElement findTxtPhoneEle = webDriver.findElement(By.xpath(String.format(FORM_XPATH_RAD, "radio-label-no")));
    }


    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfButtons() {
        gotoTestWebsite(Menu.BUTTONS);
        String FORM_CSS_BTN = "button[test-id ='%s']";
        WebElement findTxtNameEle = webDriver.findElement(By.cssSelector(String.format(FORM_CSS_BTN, "button-click-me")));
        WebElement findTxtEmailEle = webDriver.findElement(By.cssSelector(String.format(FORM_CSS_BTN, "button-confirm-me")));
        WebElement findTxtPhoneEle = webDriver.findElement(By.cssSelector(String.format(FORM_CSS_BTN, "button-prompt-me")));
    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfButtons() {
        gotoTestWebsite(Menu.BUTTONS);
        // Handle other elements similarly
        String FORM_XPATH_BTN = "//button[@test-id ='%s']";
        WebElement findTxtNameEle = webDriver.findElement(By.xpath(String.format(FORM_XPATH_BTN, "button-click-me")));
        WebElement findTxtEmailEle = webDriver.findElement(By.xpath(String.format(FORM_XPATH_BTN, "button-confirm-me")));
        WebElement findTxtPhoneEle = webDriver.findElement(By.xpath(String.format(FORM_XPATH_BTN, "button-prompt-me")));

    }


    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findLocatorWithCSSOfDynamicPro() {
        gotoTestWebsite(Menu.DYNAMIC_PROPERTIES);

        String FORM_CSS_BTN = "//button[@test-id ='%s']";
        WebElement findTxtNameEle = webDriver.findElement(By.xpath(String.format(FORM_CSS_BTN, "button-click-me")));
        WebElement findTxtEmailEle = webDriver.findElement(By.xpath(String.format(FORM_CSS_BTN, "button-confirm-me")));
        WebElement findTxtPhoneEle = webDriver.findElement(By.xpath(String.format(FORM_CSS_BTN, "button-prompt-me")));

    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findLocatorWithXPathOfDynamicPro() {
        gotoTestWebsite(Menu.DYNAMIC_PROPERTIES);

        // Handle other elements similarly


    }



    /**
     * Go to Test Website
     */
    void gotoTestWebsite(Menu menu) {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);

        // Access: Elements > [Menu]
        String mnuElementXPath = "//div[@test-id='menu-elements']";
        WebElement mnuElementEle = webDriver.findElement(By.xpath(mnuElementXPath));
        mnuElementEle.click();

        String mnuXPath = String.format("//div[@test-id='%s']", menu.getName());
        WebElement mnuEle = webDriver.findElement(By.xpath(mnuXPath));
        mnuEle.click();
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
