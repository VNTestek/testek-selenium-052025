package com.testek.study.lesson08.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

import static java.lang.Thread.sleep;

@Getter
@Setter
public class SolutionTest {
    // The driver for interacting with the webpage
    private WebDriver mWebDriver;

    /**
     * Method will be executed before each class, configure Chrome Driver and initialize
     */
    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--max-window-size");
        chromeOptions.addArguments("--remote-allow-origins=*");
        mWebDriver = new ChromeDriver(chromeOptions);
    }

    /**
     * Method will be executed after each class, will close all running chrome sessions - Debug Mode
     **/
    @AfterClass
    public void afterClass() {
        if (Objects.nonNull(mWebDriver)) mWebDriver.quit();
    }

    /**
     * URL: <a href="https://testek.vn/lab/auto/web-elements">...</a>
     * Access to Elements navigation
     */
    @Test(description = "Element Interaction: Student Form")
    public void testStudentForm() {
        gotoTestWebsite(Menu.FORM, Menu.STUDENT_FORM);

        // Handle your code here

    }

    @Test(description = "Login > Dashboard > Sản phẩm")
    public void testSearchProducts() {
        String url = "https://testek.vn/lab/auto/login";
        mWebDriver.get(url);

        // Handle your code here
    }

    @Test(description = "Element Interaction: Click, Double Click, Right Click")
    public void testClick() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.ACCORDION);

        // Handle your code here
    }

    @Test(description = "Element Interaction: Hover")
    public void testHover() {
        gotoTestWebsite(Menu.ALERT_FRAME_AND_WINDOWS, Menu.MENU);

        // Handle your code here
    }

     /**
     * Go to Test Website
     */
    private void gotoTestWebsite(Menu parent, Menu subMenu) {
        String url = "https://testek.vn/lab/auto/web-elements/";
        mWebDriver.get(url);

        String XPATH_MENU_FORMAT = "//div[@test-id='%s']";

        // Access: Form > [Student Form]
        WebElement mnuElementEle = mWebDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, parent.getName())));
        mnuElementEle.click();

        WebElement mnuEle = mWebDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, subMenu.getName())));
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
    public void studentForm(){
        gotoTestWebsite(Menu.FORM, Menu.STUDENT_FORM);

        String h3Title = "//h3[@id = 'student-registration-title']";
        WebElement h3TitleEle = mWebDriver.findElement(By.xpath(h3Title));
        String lblFirstName = "//label[@test-id = 'label-firstName']";
        WebElement lblFirstNameEle = mWebDriver.findElement(By.xpath(lblFirstName));
        String inputFirstName = "//input[@id = 'firstName']";
        WebElement inputFirstNameEle = mWebDriver.findElement(By.xpath(inputFirstName));

        String lblLastName = "//label[@test-id = 'label-lastName']";
        WebElement lblLastNameEle = mWebDriver.findElement(By.xpath(lblLastName));
        String inputLastName = "//input[@id = 'lastName']";
        WebElement inputLastNameEle = mWebDriver.findElement(By.xpath(inputLastName));

        String lblEmail = "//label[@test-id = 'label-email']";
        WebElement lblEmailEle = mWebDriver.findElement(By.xpath(lblEmail));
        String inputEmail = "//input[@id = 'email']";
        WebElement inputEmailEle = mWebDriver.findElement(By.xpath(inputEmail));

        String lblGender = "//label[@test-id = 'label-gender']";
        WebElement lblGenderEle = mWebDriver.findElement(By.xpath(lblGender));
        String inputGenderMale = "//input[@id = 'male']";
        WebElement inputGenderMaleEle = mWebDriver.findElement(By.xpath(inputGenderMale));
        String inputGenderFemale = "//input[@id = 'female']";
        WebElement inputGenderFemaleEle = mWebDriver.findElement(By.xpath(inputGenderFemale));

        String lblMobi = "//label[@test-id = 'label-mobile']";
        WebElement lblMobiEle = mWebDriver.findElement(By.xpath(lblMobi));
        String inputMobi = "//input[@id = 'mobile']";
        WebElement inputMobiEle = mWebDriver.findElement(By.xpath(inputMobi));

        String lblDOB = "//label[@test-id = 'label-dob']";
        WebElement lblDOBEle = mWebDriver.findElement(By.xpath(lblDOB));
        String inputDOB = "//input[@id = 'dob']";
        WebElement inputDOBEle = mWebDriver.findElement(By.xpath(inputDOB));

        String lblSubjects = "//label[@test-id = 'label-subject']";
        WebElement lblSubjectsEle = mWebDriver.findElement(By.xpath(lblSubjects));
        String inputSubjects = "//input[@id = 'subjects']";
        WebElement inputSubjectsEle = mWebDriver.findElement(By.xpath(inputSubjects));

        String lblHobbies = "//label[@test-id = 'label-hobbies']";
        WebElement lblHobbiesEle = mWebDriver.findElement(By.xpath(lblHobbies));
        String inputHobbies = "//input[@id = 'hobbies']";
        WebElement inputHobbiesEle = mWebDriver.findElement(By.xpath(inputHobbies));
        String inputReading = "//input[@id = 'reading']";
        WebElement inputReadingEle = mWebDriver.findElement(By.xpath(inputReading));
        String inputSports = "//input[@id = 'sports']";
        WebElement inputSportsEle = mWebDriver.findElement(By.xpath(inputSports));
        String inputMusic = "//input[@id = 'music']";
        WebElement inputMusicEle = mWebDriver.findElement(By.xpath(inputMusic));

        String lblAddress = "//label[@test-id = 'label-address']";
        WebElement lblAddressEle = mWebDriver.findElement(By.xpath(lblAddress));
        String inputAddress = "//textarea[@id = 'address']";
        WebElement inputAddressEle = mWebDriver.findElement(By.xpath(inputAddress));

        String btnSubmit = "//button[@id = 'submit-button']";
        WebElement btnSubmitEle = mWebDriver.findElement(By.xpath(btnSubmit));
        String btnClear = "//button[@id = 'clear-button']";
        WebElement btnClearEle = mWebDriver.findElement(By.xpath(btnClear));
    }

    @Test
    public void login () {
        mWebDriver.get("https://testek.vn/lab/auto/login");
        waitForDebug(5000);

        Actions actions = new Actions(mWebDriver);
        String username = "admin_com_role";
        String password = "aA12345678@";
        waitForDebug(5000);

        WebElement txtLoginAccountEle = mWebDriver.findElement(By.id("normal_login_username"));
        txtLoginAccountEle.clear();
        txtLoginAccountEle.sendKeys(username);
        waitForDebug(5000);

        WebElement txtLoginPassEle = mWebDriver.findElement(By.id("normal_login_password"));
        txtLoginPassEle.clear();
        txtLoginPassEle.sendKeys(password);
        waitForDebug(5000);

        //Login BTN
        String btnLoginXPath = "//button[@type = 'submit']";
        WebElement btnLoginEle = mWebDriver.findElement(By.xpath(btnLoginXPath));
        btnLoginEle.click();
        waitForDebug(5000);

        String productXPath = "//div[@class='flex items-center']//div[contains(text(),'Sản phẩm')]";
        WebElement productEle = mWebDriver.findElement(By.xpath(productXPath));
        actions.click(productEle).perform();
        waitForDebug(5000);

        String txtKeywordXPath = "//input[@class='ant-input css-16pw25h h-8']";
        WebElement txtKeywordEle = mWebDriver.findElement(By.xpath(txtKeywordXPath));
        txtKeywordEle.clear();
        txtKeywordEle.sendKeys("Tivi");

        String btnSearchXPath = "//button[@testek='btn-search']";
        WebElement btnSearchEle = mWebDriver.findElement(By.xpath(btnSearchXPath));
        btnSearchEle.click();

        waitForDebug(5000);
    }

    @Test
    public void clickAction() {
        Actions mActions = new Actions(mWebDriver);
        gotoTestWebsite(Menu.WIDGETS, Menu.ACCORDION);
        String accordion1Xpath = "//div[@id='accordion-header-1']";
        WebElement accordion1Ele = mWebDriver.findElement(By.xpath(accordion1Xpath));
        mActions.click(accordion1Ele).perform();

        String accordion1Text = "//div[@id='accordion-body-1']";
        WebElement accordion1TextEle = mWebDriver.findElement(By.xpath(accordion1Text));
        System.out.println(accordion1TextEle.getText());

        gotoTestWebsite(Menu.WIDGETS, Menu.ACCORDION);
        String accordion2Xpath = "//div[@id='accordion-header-2']";
        WebElement accordion2Ele = mWebDriver.findElement(By.xpath(accordion2Xpath));
        mActions.click(accordion2Ele).perform();

        String accordion2Text = "//div[@id='accordion-body-2']";
        WebElement accordion2TextEle = mWebDriver.findElement(By.xpath(accordion2Text));
        System.out.println(accordion2TextEle.getText());

        gotoTestWebsite(Menu.WIDGETS, Menu.ACCORDION);
        String accordion3Xpath = "//div[@id='accordion-header-3']";
        WebElement accordion3Ele = mWebDriver.findElement(By.xpath(accordion3Xpath));
        mActions.click(accordion3Ele).perform();

        String accordion3Text = "//div[@id='accordion-body-3']";
        WebElement accordion3TextEle = mWebDriver.findElement(By.xpath(accordion3Text));
        System.out.println(accordion3TextEle.getText());
    }

    @Test
    public void hover() {
        gotoTestWebsite(Menu.WIDGETS, Menu.MENU);
        Actions actions = new Actions(mWebDriver);
        System.out.println("\nExercise4: Element Interaction: Hover");

        //define list menu element
        String mnuLstXPath = "//a[starts-with(@test-id,'menu')]";
        List<WebElement> mnuEleLst = mWebDriver.findElements(By.xpath(mnuLstXPath));
        for (WebElement menu : mnuEleLst) {
            actions.moveToElement(menu).click().build().perform();
            waitForDebug(3000);

            String menuTitle = menu.getText();
            System.out.print(menuTitle + ": ");

            //define lst submenu
            String XPATH_SUB_MNU_FORM = "//li[contains(@id,'%s')]//a[starts-with(@test-id,'submenu')]";
            String subMnuXPath = String.format(XPATH_SUB_MNU_FORM, menuTitle.toLowerCase());
            List<WebElement> subMenus = mWebDriver.findElements(By.xpath(subMnuXPath));

            //print res
            if (!subMenus.isEmpty()) {
                System.out.print("[");
                for (int i = 0; i < subMenus.size(); i++) {
                    System.out.print(subMenus.get(i).getText());
                    if (i < subMenus.size() - 1) System.out.print(", ");
                }
                System.out.println("]");
            } else {
                System.out.println("[No submenu]");
            }
            waitForDebug(3000);
        }
    }
}
