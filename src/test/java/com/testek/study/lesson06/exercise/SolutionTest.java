package com.testek.study.lesson06.exercise;

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

    /**
     * URL: <a href="https://testek.vn/lab/auto/web-elements">...</a>
     * Access to Elements navigation
     */
    @Test(description = "Element Interaction")
    public void testInteraction() {
        gotoTestWebsite();
        // Handle your code here

        //STUDENT FORM
        //Input (textbox)
        String FORM_XPATH_INPUT_TEXT = "//input[@placeholder='%s']";

        //Input (textarea)
        String FORM_XPATH_INPUT_TA = "//textarea[@placeholder='%s']";

        //Input (radiobutton)
        String FORM_XPATH_INPUT_RDO = "//label[@test-id='%s']";

        //Input (datetime picker)
        String FORM_XPATH_INPUT_DTP = "//input[@id='%s']";

        //Button
        String FORM_XPATH_BTN = "//button[@test-id='%s']";

        //Send key and click
        String inputFstNmXPath = String.format(FORM_XPATH_INPUT_TEXT, "Enter your first name");
        WebElement inputFstNmEle = webDriver.findElement(By.xpath(inputFstNmXPath));
        inputFstNmEle.sendKeys("Thao");

        String inputLstNmXPath = String.format(FORM_XPATH_INPUT_TEXT, "Enter your last name");
        WebElement inputLstNmEle = webDriver.findElement(By.xpath(inputLstNmXPath));
        inputLstNmEle.sendKeys("BP64");

        String inputEmailXPath = String.format(FORM_XPATH_INPUT_TEXT, "Enter your email");
        WebElement inputEmailEle = webDriver.findElement(By.xpath(inputEmailXPath));
        inputEmailEle.sendKeys("marukochan6497@gmail.com");

        String clickFemaleXPath = String.format(FORM_XPATH_INPUT_RDO, "label-female");
        WebElement clickFemaleEle = webDriver.findElement(By.xpath(clickFemaleXPath));
        clickFemaleEle.click();

        String inputMobileXPath = String.format(FORM_XPATH_INPUT_TEXT, "Enter your mobile number");
        WebElement inputMobileEle = webDriver.findElement(By.xpath(inputMobileXPath));
        inputMobileEle.sendKeys("0363294476");

        String inputDTPXPath = String.format(FORM_XPATH_INPUT_DTP, "dob");
        WebElement inputDTPEle = webDriver.findElement(By.xpath(inputDTPXPath));
        inputDTPEle.sendKeys("06/04/1997");

        String inputSubjectsXpath = String.format(FORM_XPATH_INPUT_TEXT, "Enter your subjects");
        WebElement inputSubjectsEle = webDriver.findElement(By.xpath(inputSubjectsXpath));
        inputSubjectsEle.sendKeys("Automation Testing");

        String clickReadingXPath = String.format(FORM_XPATH_INPUT_RDO, "label-reading");
        WebElement clickReadingEle = webDriver.findElement(By.xpath(clickReadingXPath));
        clickReadingEle.click();
        String clickSportsXPath = String.format(FORM_XPATH_INPUT_RDO, "label-sports");
        WebElement clickSportsEle = webDriver.findElement(By.xpath(clickSportsXPath));
        clickSportsEle.click();
        String clickMusicXPath = String.format(FORM_XPATH_INPUT_RDO, "label-music");
        WebElement clickMusicEle = webDriver.findElement(By.xpath(clickMusicXPath));
        clickMusicEle.click();


        String inputAddressXPath = String.format(FORM_XPATH_INPUT_TA, "Enter your address");
        WebElement inputAddressEle = webDriver.findElement(By.xpath(inputAddressXPath));
        inputAddressEle.sendKeys("Ha Noi, Viet Nam");

        String btnSubmitXPath = String.format(FORM_XPATH_BTN, "submit-button");
        WebElement btnSubmitEle = webDriver.findElement(By.xpath(btnSubmitXPath));
        btnSubmitEle.click();

    }

    @Test(description = "Element Interaction")
    public void testInteraction1() {
        gotoTest1Website();
        // Handle your code here

        //ELEMENTS BUTTON
        String FORM_XPATH_BTN = "//button[@test-id='%s']";

        String btnFirstButtonXPath = String.format(FORM_XPATH_BTN, "button1");
        WebElement btnFirstButtonEle = webDriver.findElement(By.xpath(btnFirstButtonXPath));
        btnFirstButtonEle.click();

        String btnSecondButtonXPath = String.format(FORM_XPATH_BTN, "button2");
        WebElement btnSecondButtonEle = webDriver.findElement(By.xpath(btnSecondButtonXPath));
        btnSecondButtonEle.click();

        String btnThirdButtonXPath = String.format(FORM_XPATH_BTN, "button3");
        WebElement btnThirdButtonEle = webDriver.findElement(By.xpath(btnThirdButtonXPath));
        btnThirdButtonEle.click();

    }

    @Test(description = "Element Interaction")
    public void testInteraction2() {
        gotoTest2Website();
        // Handle your code here

        //ELEMENTS RADIO BUTTON
        String FORM_XPATH_INPUT_RDO = "//label[@test-id='%s']";

        String clickYesXPath = String.format(FORM_XPATH_INPUT_RDO, "radio-label-yes");
        WebElement clickYesEle = webDriver.findElement(By.xpath(clickYesXPath));
        clickYesEle.click();

        String clickImpressiveXPath = String.format(FORM_XPATH_INPUT_RDO, "radio-label-impressive");
        WebElement clickImpressiveEle = webDriver.findElement(By.xpath(clickImpressiveXPath));
        clickImpressiveEle.click();

        String clickNoXPath = String.format(FORM_XPATH_INPUT_RDO, "radio-label-no");
        WebElement clickNoEle = webDriver.findElement(By.xpath(clickNoXPath));
        clickNoEle.click();

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

    private void gotoTest1Website() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);

        String XPATH_MENU_FORMAT = "//div[@test-id='%s']";

        // Access: Elements > [Button]
        WebElement mnuElementsEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, Menu.ELEMENTS.getName())));
        mnuElementsEle.click();

        WebElement mnuButtonsEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, Menu.BUTTONS.getName())));
        mnuButtonsEle.click();

        waitForDebug(5000);
    }

    private void gotoTest2Website() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);

        String XPATH_MENU_FORMAT = "//div[@test-id='%s']";

        // Access: Elements > [Radio Button]
        WebElement mnuElements2Ele = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, Menu.ELEMENTS.getName())));
        mnuElements2Ele.click();

        WebElement mnuRadioButtonEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, Menu.RADIO_BUTTON.getName())));
        mnuRadioButtonEle.click();

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
