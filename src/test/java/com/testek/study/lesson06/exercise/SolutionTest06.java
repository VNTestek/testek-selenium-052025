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
public class SolutionTest06 {
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

    @Test
    public void ex01() {
        gotoTestWebsite(Menu.FORM, Menu.STUDENT_FORM);
        String txtFirstName = "input[@id='firstName']";
        WebElement inputFirstNameEle = webDriver.findElement(By.xpath(txtFirstName));
        inputFirstNameEle.clear();
        inputFirstNameEle.sendKeys("Nguyen");

        String txtLastName = "input[@id='lastName']";
        WebElement inputLastNameELe = webDriver.findElement(By.xpath(txtLastName));
        inputLastNameELe.clear();
        inputLastNameELe.sendKeys("Viet Dung");

        String txtEmails = "form[@id='studentRegistrationForms']//input[@id='email']";
        WebElement inputEmailsEle = webDriver.findElement(By.xpath(txtEmails));
        inputEmailsEle.clear();
        inputEmailsEle.sendKeys("nguyendung5112004@gmail.com");

        String butMale = "label[normalize-space()='Male']";
        WebElement clMaleEle = webDriver.findElement(By.xpath(butMale));
        clMaleEle.click();
        boolean checkedMale = clMaleEle.isSelected();

        String butFemale = "label[normalize-space()='Female']";
        WebElement clFemaleEle = webDriver.findElement(By.xpath(butFemale));
        clFemaleEle.click();
        boolean checkedFemale = clFemaleEle.isSelected();

        String txtMobile = "input[@id='mobile']";
        WebElement inputMonileEle = webDriver.findElement(By.xpath(txtMobile));
        inputMonileEle.clear();
        inputMonileEle.sendKeys("097361276");

        String txtDob = "input[@id='dob']";
        WebElement inputDobEle = webDriver.findElement(By.xpath(txtDob));
        inputDobEle.clear();
        inputDobEle.sendKeys("5/11/2004");

        String txtSubjects = "input[@id='subjects']";
        WebElement inputSubEle = webDriver.findElement(By.xpath(txtSubjects));
        inputSubEle.clear();
        inputSubEle.sendKeys("Math");

        String butReading = "label[normalize-space()='Reading']";
        WebElement clReadEle = webDriver.findElement(By.xpath(butReading));
        clReadEle.click();
        boolean chekedReading = clReadEle.isSelected();

        String butSports = "label[normalize-space()='Sports']";
        WebElement clSportsEle = webDriver.findElement(By.xpath(butSports));
        clSportsEle.click();
        boolean chekedSports = clSportsEle.isSelected();

        String butMusic = "label[normalize-space()='Music']";
        WebElement clMusicEle = webDriver.findElement(By.xpath(butMusic));
        clMusicEle.click();
        boolean chekedMusic = clMusicEle.isSelected();

        String txtAdress = "textarea[@id='address']";
        WebElement inputAdressEle = webDriver.findElement(By.xpath(txtAdress));
        inputAdressEle.clear();
        inputAdressEle.sendKeys("Ha Noi");

        String submitCss = "#submit-button";
        WebElement submitCssEle = webDriver.findElement(By.xpath(submitCss));
        submitCssEle.click();
        waitForDebug(5000);

        String txtAreaInforXpath = "textarea[@id='outputTextStudent']";
        WebElement txtAreaInforEle = webDriver.findElement(By.xpath(txtAreaInforXpath));
        System.out.println(txtAreaInforEle.getAttribute("value"));
        System.out.println(txtAreaInforEle.getText());


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

    @Test
    public void ex03() {
        gotoTestWebsite(Menu.ELEMENTS, Menu.RADIO_BUTTON);
        String clickYesXpath = "//label[normalize-space()='Yes']";
        WebElement yesXpEle = webDriver.findElement(By.xpath(clickYesXpath));
        yesXpEle.click();

        String clickImpressiveXpath = "//label[normalize-space()='Yes']";
        WebElement imprXpEle = webDriver.findElement(By.xpath(clickImpressiveXpath));
        imprXpEle.click();

        String clickNoXpath = "//label[normalize-space()='Yes']";
        WebElement noXpEle = webDriver.findElement(By.xpath(clickNoXpath));
        noXpEle.click();
    }
}
