package com.testek.study.lesson08.exercise;

import com.testek.study.common.Menu;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
        Actions mActions = new Actions(mWebDriver);


        // Handle your code here

        //Dynamic locator
        String LBL_TITLE_XPATH = "//h3[@id = '%s']";
        String LBL_FORM_XPATH = "//label[@test-id = '%s']";
        String LBL_INPUT_FORM_XPATH = "//input[@placeholder = '%s']";
        String RADIO_FORM_XPATH = "//input[@type = 'radio' and @id = '%s']";
        String DATEPICKER_FORM_XPATH = "//input[@type = 'date']";
        String CHECKBOX_FORM_XPATH = "//input[@type = 'checkbox' and @id = '%s']";
        String TEXTAREA_FORM_XPATH = "//textarea[@id='%s']";
        String BUTTON_XPATH = "//button[@type = '%s' and @id = '%s']";

        //Find elements & interact
        //Title
        String lblTitleXPath = String.format(LBL_TITLE_XPATH, "student-registration-title");
        WebElement lblTitleEle = mWebDriver.findElement(By.xpath(lblTitleXPath));
        String lblTitleText = lblTitleEle.getText();
        System.out.println(lblTitleText);

        //First name
        String lblFirstNameXPath = String.format(LBL_FORM_XPATH, "label-firstName");
        WebElement lblFirstNameEle = mWebDriver.findElement(By.xpath(lblFirstNameXPath));
        String inputFirstNameXPath = String.format(LBL_INPUT_FORM_XPATH, "Enter your first name");
        WebElement inputFirstNameEle = mWebDriver.findElement(By.xpath(inputFirstNameXPath));
        inputFirstNameEle.clear();
        mActions.sendKeys(inputFirstNameEle, "Hoang").perform();


        //Last name
        String lblLastNameXPath = String.format(LBL_FORM_XPATH, "label-lastName");
        WebElement lblLastNameEle = mWebDriver.findElement(By.xpath(lblLastNameXPath));
        String inputLastNameXPath = String.format(LBL_INPUT_FORM_XPATH, "Enter your last name");
        WebElement inputLastNameEle = mWebDriver.findElement(By.xpath(inputLastNameXPath));
        inputLastNameEle.clear();
        mActions.sendKeys(inputLastNameEle, "Vu").perform();


        //Email
        String lblEmailXPath = String.format(LBL_FORM_XPATH, "label-email");
        WebElement lblEmailEle = mWebDriver.findElement(By.xpath(lblEmailXPath));
        String inputEmailXPath = String.format(LBL_INPUT_FORM_XPATH, "Enter your email");
        WebElement inputEmailEle = mWebDriver.findElement(By.xpath(inputEmailXPath));
        inputEmailEle.clear();
        mActions.sendKeys(inputEmailEle, "hoangvu123@mail.com").perform();

        //Gender
        String lblGenderXPath = String.format(LBL_FORM_XPATH, "label-gender");
        WebElement lblGenderEle = mWebDriver.findElement(By.xpath(lblGenderXPath));
        String rdoMaleXPath = String.format(RADIO_FORM_XPATH, "male");
        WebElement rdoMaleEle = mWebDriver.findElement(By.xpath(rdoMaleXPath));
        rdoMaleEle.click();
        waitForDebug(2000);
        String rdoFemaleXPath = String.format(RADIO_FORM_XPATH, "female");
        WebElement rdoFemaleEle = mWebDriver.findElement(By.xpath(rdoFemaleXPath));
        rdoFemaleEle.click();


        //Mobile
        String lblMobileXPath = String.format(LBL_FORM_XPATH, "label-mobile");
        WebElement lblMobileEle = mWebDriver.findElement(By.xpath(lblMobileXPath));
        String inputMobileXPath = String.format(LBL_INPUT_FORM_XPATH, "Enter your mobile number");
        WebElement inputMobileEle = mWebDriver.findElement(By.xpath(inputMobileXPath));
        inputMobileEle.clear();
        mActions.sendKeys(inputMobileEle, "0123456589").perform();


        //DOB
        String lblDOBXPath = String.format(LBL_FORM_XPATH, "label-dob");
        WebElement lblDOBEle = mWebDriver.findElement(By.xpath(lblDOBXPath));
        String inputDOBXPath = String.format(DATEPICKER_FORM_XPATH);
        WebElement inputDOBEle = mWebDriver.findElement(By.xpath(inputDOBXPath));
        inputDOBEle.clear();
        mActions.sendKeys(inputDOBEle, "02/02/2002").perform();


        //Subjects
        String lblSubjectXPath = String.format(LBL_FORM_XPATH, "label-subjects");
        WebElement lblSubjectEle = mWebDriver.findElement(By.xpath(lblSubjectXPath));
        String inputSubjectXPath = String.format(LBL_INPUT_FORM_XPATH, "Enter your subjects");
        WebElement inputSubjectEle = mWebDriver.findElement(By.xpath(inputSubjectXPath));
        inputSubjectEle.clear();
        mActions.sendKeys(inputSubjectEle, "Literature, Music, Art").perform();


        //Hobbies
        String lblHobbiesXPath = String.format(LBL_FORM_XPATH, "label-hobbies");
        WebElement lblHobbiesEle = mWebDriver.findElement(By.xpath(lblHobbiesXPath));
        String chkReadingXPath = String.format(CHECKBOX_FORM_XPATH, "reading");
        WebElement chkReadingEle = mWebDriver.findElement(By.xpath(chkReadingXPath));
        chkReadingEle.click();
        waitForDebug(1000);
        String chkSportsXPath = String.format(CHECKBOX_FORM_XPATH, "sports");
        WebElement chkSportsDoubleClickEle = mWebDriver.findElement(By.xpath(chkSportsXPath));
        mActions.doubleClick(chkSportsDoubleClickEle).perform();
        waitForDebug(1000);
        String chkMusicXPath = String.format(CHECKBOX_FORM_XPATH, "music");
        WebElement chkMusicEle = mWebDriver.findElement(By.xpath(chkMusicXPath));
        mActions.click(chkMusicEle).perform();
        waitForDebug(1000);

        //Address
        String lblAddressXPath = String.format(LBL_FORM_XPATH, "label-address");
        WebElement lblAddressEle = mWebDriver.findElement(By.xpath(lblAddressXPath));
        String inputAddressXPath = String.format(TEXTAREA_FORM_XPATH, "address");
        WebElement inputAddressEle = mWebDriver.findElement(By.xpath(inputAddressXPath));
        inputAddressEle.clear();
        mActions.sendKeys(inputAddressEle, "Ha Noi - Viet Nam").perform();


        //Submit info
        String btnSubmitXPath = String.format(BUTTON_XPATH, "submit", "submit-button");
        WebElement btnSubmitEle = mWebDriver.findElement(By.xpath(btnSubmitXPath));
        btnSubmitEle.click();
        waitForDebug(2000);


        //Thông tin bạn đã nhập:
        String lblInputInfoXPath = String.format(LBL_TITLE_XPATH, "submitted-info-title");
        WebElement lblInputInfoEle = mWebDriver.findElement(By.xpath(lblInputInfoXPath));
        String textareaInputInfoXPath = String.format(TEXTAREA_FORM_XPATH, "outputTextStudent");
        WebElement textareaInputInfoEle = mWebDriver.findElement(By.xpath(textareaInputInfoXPath));
        String inputInfoText = lblInputInfoEle.getText();
        System.out.println(inputInfoText);
        System.out.println(textareaInputInfoEle.getAttribute("value"));

        //Clear input info
        String btnClearXPath = String.format(BUTTON_XPATH, "reset", "reset-button");
        WebElement btnClearEle = mWebDriver.findElement(By.xpath(btnClearXPath));
        btnClearEle.click();


    }

    @Test(description = "Login > Dashboard > Sản phẩm")
    public void testSearchProducts() {
        String url = "https://testek.vn/lab/auto/login";
        mWebDriver.get(url);

        // Handle your code here
        //Access menu > product > input keyword to textbox > press Enter button

        Actions actions = new Actions(mWebDriver);

        //Input username, pwd
        WebElement usernameInputEle = mWebDriver.findElement(By.id("normal_login_username"));
        usernameInputEle.clear();
        actions.sendKeys(usernameInputEle, "admin_com_role").perform();
        WebElement passwordInputEle = mWebDriver.findElement(By.id("normal_login_password"));
        passwordInputEle.clear();
        actions.sendKeys(passwordInputEle, "aA12345678@").perform();

        //Login
        String btnLoginXPath = "//span[contains(text(),'Đăng nhập')]";
        WebElement btnLoginEle = mWebDriver.findElement(By.xpath(btnLoginXPath));
        btnLoginEle.click();
        waitForDebug(3000);

        //Access menu > product
        WebElement mnuProductXPathEle = mWebDriver.findElement(By.xpath("//div[@class='flex items-center']//div[contains(text(),'Sản phẩm')]"));
        mnuProductXPathEle.click();
        actions.moveToElement(mnuProductXPathEle).build().perform();
        waitForDebug(3000);

        //Input keyword to textbox then press Enter key
        String inputKeyWordXPath = "//div[@class='search-text flex w-60 mr-4 items-center']//input[@testek='search-input']";
        WebElement inputKeyWordEle = mWebDriver.findElement(By.xpath(inputKeyWordXPath));
        inputKeyWordEle.clear();
        actions.sendKeys(inputKeyWordEle, "Tivi");
        actions.sendKeys(inputKeyWordEle, Keys.ENTER).perform();
        waitForDebug(4000);


    }

    @Test(description = "Element Interaction: Click, Double Click, Right Click")
    public void testClick() {
        gotoTestWebsite(Menu.WIDGETS, Menu.ACCORDION);
        Actions mActions = new Actions(mWebDriver);

        // Handle your code here
        //Giảng viên là các chuyên gia đầu ngành
        //Click
        WebElement btnTeacherAccordionEle = mWebDriver.findElement(By.id("accordion-item-1"));
        btnTeacherAccordionEle.click();
        waitForDebug(3000);
        //Double Click
        WebElement doubleClickTeacherAccordionEle = mWebDriver.findElement(By.id("accordion-header-1"));
        mActions.doubleClick(doubleClickTeacherAccordionEle).perform();
        waitForDebug(3000);

        //Print text
        String btnTeacherAccordion = btnTeacherAccordionEle.getText();
        System.out.println(btnTeacherAccordion);
        System.out.println("==============================");

        //Học để làm KHÔNG học để biết
        //Click
        WebElement btnStudyAccordionEle = mWebDriver.findElement(By.id("accordion-header-2"));
        btnStudyAccordionEle.click();
        waitForDebug(3000);
        //Double click
        WebElement doubleClickStudyAccordionEle = mWebDriver.findElement(By.id("accordion-header-2"));
        mActions.doubleClick(doubleClickStudyAccordionEle).perform();
        waitForDebug(3000);

        //Print text
        String btnStudyAccordionText = btnStudyAccordionEle.getText();
        System.out.println(btnStudyAccordionText);
        WebElement bodyStudyAccordionEle = mWebDriver.findElement(By.id("accordion-body-2"));
        String bodyStudyAccordionText = bodyStudyAccordionEle.getText();
        System.out.println(bodyStudyAccordionText);
        System.out.println("==============================");


        //Định hướng nghề nghiệp
        WebElement btnOrientedAccordionEle = mWebDriver.findElement(By.id("accordion-header-3"));
        btnOrientedAccordionEle.click();
        waitForDebug(3000);
        //Double click
        WebElement doubleClickBtnOrientedAccordionEle = mWebDriver.findElement(By.id("accordion-header-3"));
        mActions.doubleClick(doubleClickBtnOrientedAccordionEle).perform();
        waitForDebug(3000);

        //Print text
        String btnOrientedAccordionText = btnOrientedAccordionEle.getText();
        System.out.println(btnOrientedAccordionText);
        WebElement bodyOrientedAccordionEle = mWebDriver.findElement(By.id("accordion-body-3"));
        String bodyOrientedAccordionText = bodyOrientedAccordionEle.getText();
        System.out.println(bodyOrientedAccordionText);
    }

    @Test(description = "Element Interaction: Hover")
    public void testHover() {
        gotoTestWebsite(Menu.WIDGETS, Menu.MENU);
        Actions mActions = new Actions(mWebDriver);

        // Handle your code here
        //Dynamic locator
        String BTN_XPATH_FORM = "//a[@test-id='%s']";
        String SUBMENU_XPATH_FORM = "//ul[@id='%s']";

        //Home
        String btnHomeXPath = String.format(BTN_XPATH_FORM, "menu-link-home");
        WebElement btnHomeEle = mWebDriver.findElement(By.xpath(btnHomeXPath));
        mActions.moveToElement(btnHomeEle).perform();
        String btnHomeText = btnHomeEle.getText();
        System.out.println(btnHomeText + "\n");
        waitForDebug(3000);

        //Services
        String btnServicesXPath = String.format(BTN_XPATH_FORM, "menu-link-services");
        WebElement btnServicesEle = mWebDriver.findElement(By.xpath(btnServicesXPath));
        mActions.moveToElement(btnServicesEle).perform();
        String btnServicesText = btnServicesEle.getText();
        System.out.println(btnServicesText);
        String subMnuXPath = String.format(SUBMENU_XPATH_FORM, "submenu-services");
        WebElement subMnuEle = mWebDriver.findElement(By.xpath(subMnuXPath));
        String subMnuText = subMnuEle.getText();
        System.out.println(subMnuText + "\n");
        waitForDebug(3000);

        //About
        String btnAboutXPath = String.format(BTN_XPATH_FORM, "menu-link-about");
        WebElement btnAboutEle = mWebDriver.findElement(By.xpath(btnAboutXPath));
        mActions.moveToElement(btnAboutEle).perform();
        String btnAboutText = btnAboutEle.getText();
        System.out.println(btnAboutText + "\n");
        waitForDebug(3000);

        //Contact
        String btnContactXPath = String.format(BTN_XPATH_FORM, "menu-link-contact");
        WebElement btnContactEle = mWebDriver.findElement(By.xpath(btnContactXPath));
        mActions.moveToElement(btnContactEle).perform();
        String btnContactText = btnContactEle.getText();
        System.out.println(btnContactText);
        String subMnuContactXPath = String.format(SUBMENU_XPATH_FORM, "submenu-contact");
        WebElement subMnuContactEle = mWebDriver.findElement(By.xpath(subMnuContactXPath));
        String subMnuContactText = subMnuContactEle.getText();
        System.out.println(subMnuContactText);
        waitForDebug(3000);


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
}
