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

        String FORM_RADIO_TEST_ID_XPATH = "//input[@test-id = 'input-%s']/ancestor::label";
        String FORM_CHECKBOX_VALUE_XPATH = "//input[@value = '%s']/ancestor::label";

        // Handle your code here
        // Input First Name
        String txtFirstNameId = "firstName";
        WebElement txtFirstNameEle = mWebDriver.findElement(By.id(txtFirstNameId));
        txtFirstNameEle.clear();
        mActions.sendKeys(txtFirstNameEle, "Dang").perform();


        // Input Last Name
        String txtLastNameId = "lastName";
        WebElement txtLastNameEle = mWebDriver.findElement(By.id(txtLastNameId));
        txtLastNameEle.clear();
        mActions.sendKeys(txtLastNameEle, "Huong").perform();

        // Input email
        String txtEmailXPath = "//input[@test-id = 'input-email']";
        WebElement txtEmailEle = mWebDriver.findElement(By.xpath(txtEmailXPath));
        txtEmailEle.clear();
        mActions.sendKeys(txtEmailEle, "danghuong@gmail.com").perform();

        // Select Male radio button
        String rdoMaleXPath = String.format(FORM_RADIO_TEST_ID_XPATH, "male");
        WebElement rdoMaleEle = mWebDriver.findElement(By.xpath(rdoMaleXPath));
        mActions.click(rdoMaleEle).perform();

        // Select Female radio button
        String rdoFemaleXPath = String.format(FORM_RADIO_TEST_ID_XPATH, "female");
        WebElement rdoFemaleEle = mWebDriver.findElement(By.xpath(rdoFemaleXPath));
        mActions.click(rdoFemaleEle).perform();

        // Input mobile
        String txtMobileId = "mobile";
        WebElement txtMobileEle = mWebDriver.findElement(By.id(txtMobileId));
        txtMobileEle.clear();
        mActions.sendKeys(txtMobileEle, "0984729574").perform();

        // Input Dob
        String txtDobId = "dob";
        WebElement txtDobEle = mWebDriver.findElement(By.id(txtDobId));
        txtDobEle.clear();
        mActions.sendKeys(txtDobEle, "22121999").perform();

        // Input Subject
        String txtSubjectId = "subjects";
        WebElement txtSubjectEle = mWebDriver.findElement(By.id(txtSubjectId));
        txtSubjectEle.clear();
        mActions.sendKeys(txtSubjectEle, "Math").perform();

        // Check all hobbies
        String chkReadingXPath = String.format(FORM_CHECKBOX_VALUE_XPATH, "Reading");
        WebElement chkReadingEle = mWebDriver.findElement(By.xpath(chkReadingXPath));
        if (!chkReadingEle.isSelected()) {
            mActions.click(chkReadingEle).perform();
        }

        String chkSportsXPath = String.format(FORM_CHECKBOX_VALUE_XPATH, "Sports");
        WebElement chkSportsEle = mWebDriver.findElement(By.xpath(chkSportsXPath));
        if (!chkSportsEle.isSelected()) {
            mActions.click(chkSportsEle).perform();
        }

        String chkMusicXPath = String.format(FORM_CHECKBOX_VALUE_XPATH, "Music");
        WebElement chkMusicEle = mWebDriver.findElement(By.xpath(chkMusicXPath));
        if (!chkMusicEle.isSelected()) {
            mActions.click(chkMusicEle).perform();
        }

        // Input Address
        String txtAddressXPath = "//textarea[@test-id ='textarea-address']";
        WebElement txtAddressEle = mWebDriver.findElement(By.xpath(txtAddressXPath));
        txtAddressEle.clear();
        mActions.sendKeys(txtAddressEle, "Hanoi").perform();

        // Click Submit button
        String btnSubmitId = "submit-button";
        WebElement btnSubmitEle = mWebDriver.findElement(By.id(btnSubmitId));
        mActions.click(btnSubmitEle).perform();
        waitForDebug(1000);

        // Check info from Output info textbox
        String txtOutputId = "outputTextStudent";
        WebElement txtOutputEle = mWebDriver.findElement(By.id(txtOutputId));
        System.out.println("Info after submitting: ");
        System.out.println(txtOutputEle.getAttribute("value"));

        // Click Clear button
        String btnClearId = "reset-button";
        WebElement btnClearEle = mWebDriver.findElement(By.id(btnClearId));
        mActions.click(btnClearEle).perform();
        System.out.println("Info after clearing: ");
        System.out.println(txtOutputEle.getAttribute("value"));
    }

    @Test(description = "Login > Dashboard > Sản phẩm")
    public void testSearchProducts() {
        String url = "https://testek.vn/lab/auto/login";
        mWebDriver.get(url);

        // Handle your code here
        Actions mActions = new Actions(mWebDriver);

        // Input Username
        String txtUsernameId = "normal_login_username";
        WebElement txtUsernameEle = mWebDriver.findElement(By.id(txtUsernameId));
        mActions.sendKeys(txtUsernameEle, "admin_com_role").perform();

        // Input password
        String txtPwdId = "normal_login_password";
        WebElement txtPwdEle = mWebDriver.findElement(By.id(txtPwdId));
        mActions.sendKeys(txtPwdEle, "aA12345678@").perform();

        // Click Login button
        String btnLoginXPath = "//div[@class = 'ant-form-item-control-input-content']//button";
        WebElement btnLoginEle = mWebDriver.findElement(By.xpath(btnLoginXPath));
        mActions.click(btnLoginEle).perform();
        waitForDebug(5000);

        // Access Sản phẩm
        String mnuProductXPath = "//div[normalize-space() = 'Sản phẩm']/ancestor::div[contains(@class, 'menu flex items-center')]";
        WebElement mnuProductEle = mWebDriver.findElement(By.xpath(mnuProductXPath));
        mActions.click(mnuProductEle).perform();

        // Input Tivi in the Search textbox
        String txtSearchXPath = "//div[@testek = 'the-header']//input[@placeholder = 'keyword']";
        WebElement txtSearchEle = mWebDriver.findElement(By.xpath(txtSearchXPath));
        mActions.sendKeys(txtSearchEle, "Tivi").keyDown(Keys.ENTER).build().perform();
        waitForDebug(1000);
        mActions.keyUp(Keys.ENTER).perform();

    }

    @Test(description = "Element Interaction: Click, Double Click, Right Click")
    public void testClick() {
        gotoTestWebsite(Menu.WIDGETS, Menu.ACCORDION);

        // Handle your code here
        Actions mActions = new Actions(mWebDriver);

        // Section Giảng viên là các chuyên gia đầu ngành
        String secTeacherId = "accordion-header-1";
        WebElement secTeacherEle = mWebDriver.findElement(By.id(secTeacherId));

        // Click 1 time
        mActions.click(secTeacherEle).perform();
        String txtTeacherId = "accordion-body-1";
        WebElement txtTeacherEle = mWebDriver.findElement(By.id(txtTeacherId));
        System.out.println(txtTeacherEle.getText());
        waitForDebug(1000);
        mActions.click(secTeacherEle).perform();

        // Double click
        mActions.doubleClick(secTeacherEle).perform();
        waitForDebug(1000);

        // Section Học để làm KHÔNG học để biết
        String secLearnId = "accordion-header-2";
        WebElement secLearnEle = mWebDriver.findElement(By.id(secLearnId));

        // Click 1 time
        mActions.click(secLearnEle).perform();
        String txtLearnId = "accordion-body-2";
        WebElement txtLearnEle = mWebDriver.findElement(By.id(txtLearnId));
        System.out.println(txtLearnEle.getText());
        waitForDebug(1000);
        mActions.click(secLearnEle).perform();

        // Double click
        mActions.doubleClick(secLearnEle).perform();
        waitForDebug(1000);

        // Section Định hướng nghề nghiệp
        String secCareerId = "accordion-header-3";
        WebElement secCareerEle = mWebDriver.findElement(By.id(secCareerId));

        // Click 1 time
        mActions.click(secCareerEle).perform();
        String txtCareerId = "accordion-body-3";
        WebElement txtCareerEle = mWebDriver.findElement(By.id(txtCareerId));
        System.out.println(txtCareerEle.getText());
        waitForDebug(1000);
        mActions.click(secCareerEle).perform();

        // Double click
        mActions.doubleClick(secCareerEle).perform();
        waitForDebug(1000);
    }

    @Test(description = "Element Interaction: Hover")
    public void testHover() {
        gotoTestWebsite(Menu.WIDGETS, Menu.MENU);

        // Handle your code here
        String FORM_MENU_TEST_ID_XPATH = "//a[@test-id = 'menu-link-%s']";
        String FORM_SUBMENU_TEST_ID_XPATH = "//a[@test-id = 'submenu-link-%s']";
        Actions mActions = new Actions(mWebDriver);

        // Hover home
        String mnuHomeXPath = String.format(FORM_MENU_TEST_ID_XPATH, "home");
        WebElement mnuHomeEle = mWebDriver.findElement(By.xpath(mnuHomeXPath));
        mActions.moveToElement(mnuHomeEle).perform();
        waitForDebug(1000);

        // Hover services
        String mnuServiceXPath = String.format(FORM_MENU_TEST_ID_XPATH, "services");
        WebElement mnuServiceEle = mWebDriver.findElement(By.xpath(mnuServiceXPath));
        mActions.moveToElement(mnuServiceEle).perform();
        waitForDebug(1000);

        String subMnuWebXPath = String.format(FORM_SUBMENU_TEST_ID_XPATH, "web-design");
        WebElement subMnuWebEle = mWebDriver.findElement(By.xpath(subMnuWebXPath));
        String subMnuDevXPath = String.format(FORM_SUBMENU_TEST_ID_XPATH, "development");
        WebElement subMnuDevEle = mWebDriver.findElement(By.xpath(subMnuDevXPath));
        String subMnuMarketingXPath = String.format(FORM_SUBMENU_TEST_ID_XPATH, "marketing");
        WebElement subMnuMarketingEle = mWebDriver.findElement(By.xpath(subMnuMarketingXPath));
        System.out.println(mnuServiceEle.getText() + ": [" +
                subMnuWebEle.getText() + ", " +
                subMnuDevEle.getText() + ", " +
                subMnuMarketingEle.getText() + "]");

        // Hover About
        String mnuAboutXPath = String.format(FORM_MENU_TEST_ID_XPATH, "about");
        WebElement mnuAboutEle = mWebDriver.findElement(By.xpath(mnuAboutXPath));
        mActions.moveToElement(mnuAboutEle).perform();
        waitForDebug(1000);

        // Hover Contact
        String mnuContactXPath = String.format(FORM_MENU_TEST_ID_XPATH, "contact");
        WebElement mnuContactEle = mWebDriver.findElement(By.xpath(mnuContactXPath));
        mActions.moveToElement(mnuContactEle).perform();
        waitForDebug(1000);

        String subMnuEmailXPath = String.format(FORM_SUBMENU_TEST_ID_XPATH, "email");
        WebElement subMnuEmailEle = mWebDriver.findElement(By.xpath(subMnuEmailXPath));
        String subMnuPhoneXPath = String.format(FORM_SUBMENU_TEST_ID_XPATH, "phone");
        WebElement subMnuPhoneEle = mWebDriver.findElement(By.xpath(subMnuPhoneXPath));
        System.out.println(mnuContactEle.getText() + ": [" +
                subMnuEmailEle.getText() + ", " +
                subMnuPhoneEle.getText() + "]");

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
