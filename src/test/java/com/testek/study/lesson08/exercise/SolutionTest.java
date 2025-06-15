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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Thread.sleep;

@Getter
@Setter
public class SolutionTest {
    // The driver for interacting with the webpage
    private WebDriver mWebDriver;
    private Actions actions;

    /**
     * Method will be executed before each class, configure Chrome Driver and initialize
     */
    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--max-window-size");
        chromeOptions.addArguments("--remote-allow-origins=*");
        mWebDriver = new ChromeDriver(chromeOptions);
        actions = new Actions(mWebDriver);
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

        String FORM_RADIO_TEST_ID_XPATH = "//input[@test-id = 'input-%s']/ancestor::label";
        String FORM_CHECKBOX_VALUE_XPATH = "//input[@value = '%s']/ancestor::label";

        // Input First Name
        String txtFirstNameId = "firstName";
        WebElement txtFirstNameEle = mWebDriver.findElement(By.id(txtFirstNameId));
        txtFirstNameEle.clear();
        actions.sendKeys(txtFirstNameEle, "Pho").perform();


        // Input Last Name
        String txtLastNameId = "lastName";
        WebElement txtLastNameEle = mWebDriver.findElement(By.id(txtLastNameId));
        txtLastNameEle.clear();
        actions.sendKeys(txtLastNameEle, "Mai").perform();

        // Input email
        String txtEmailXPath = "//input[@test-id = 'input-email']";
        WebElement txtEmailEle = mWebDriver.findElement(By.xpath(txtEmailXPath));
        txtEmailEle.clear();
        actions.sendKeys(txtEmailEle, "phomai@gmail.com").perform();

        // Select Male radio button
        String rdoMaleXPath = String.format(FORM_RADIO_TEST_ID_XPATH, "male");
        WebElement rdoMaleEle = mWebDriver.findElement(By.xpath(rdoMaleXPath));
        actions.click(rdoMaleEle).perform();

        // Select Female radio button
        String rdoFemaleXPath = String.format(FORM_RADIO_TEST_ID_XPATH, "female");
        WebElement rdoFemaleEle = mWebDriver.findElement(By.xpath(rdoFemaleXPath));
        actions.click(rdoFemaleEle).perform();

        // Input mobile
        String txtMobileId = "mobile";
        WebElement txtMobileEle = mWebDriver.findElement(By.id(txtMobileId));
        txtMobileEle.clear();
        actions.sendKeys(txtMobileEle, "0901231239").perform();

        // Input Dob
        String txtDobId = "dob";
        WebElement txtDobEle = mWebDriver.findElement(By.id(txtDobId));
        txtDobEle.clear();
        actions.sendKeys(txtDobEle, "01012000").perform();

        // Input Subject
        String txtSubjectId = "subjects";
        WebElement txtSubjectEle = mWebDriver.findElement(By.id(txtSubjectId));
        txtSubjectEle.clear();
        actions.sendKeys(txtSubjectEle, "Math").perform();

        // Check all hobbies
        String chkReadingXPath = String.format(FORM_CHECKBOX_VALUE_XPATH, "Reading");
        WebElement chkReadingEle = mWebDriver.findElement(By.xpath(chkReadingXPath));
        if (!chkReadingEle.isSelected()) {
            actions.click(chkReadingEle).perform();
        }

        String chkSportsXPath = String.format(FORM_CHECKBOX_VALUE_XPATH, "Sports");
        WebElement chkSportsEle = mWebDriver.findElement(By.xpath(chkSportsXPath));
        if (!chkSportsEle.isSelected()) {
            actions.click(chkSportsEle).perform();
        }

        String chkMusicXPath = String.format(FORM_CHECKBOX_VALUE_XPATH, "Music");
        WebElement chkMusicEle = mWebDriver.findElement(By.xpath(chkMusicXPath));
        if (!chkMusicEle.isSelected()) {
            actions.click(chkMusicEle).perform();
        }

        // Input Address
        String txtAddressXPath = "//textarea[@test-id ='textarea-address']";
        WebElement txtAddressEle = mWebDriver.findElement(By.xpath(txtAddressXPath));
        txtAddressEle.clear();
        actions.sendKeys(txtAddressEle, "Hanoi").perform();

        // Click Submit button
        String btnSubmitId = "submit-button";
        WebElement btnSubmitEle = mWebDriver.findElement(By.id(btnSubmitId));
        actions.click(btnSubmitEle).perform();
        waitForDebug(1000);

        // Check info from Output info textbox
        String txtOutputId = "outputTextStudent";
        WebElement txtOutputEle = mWebDriver.findElement(By.id(txtOutputId));
        System.out.println("Info after submitting: ");
        System.out.println(txtOutputEle.getAttribute("value"));

        // Click Clear button
        String btnClearId = "reset-button";
        WebElement btnClearEle = mWebDriver.findElement(By.id(btnClearId));
        actions.click(btnClearEle).perform();

        // Check info from Output info textbox after clearing
        System.out.println("Info after clearing: ");
        System.out.println(txtOutputEle.getAttribute("value"));

    }

    @Test(description = "Login > Dashboard > Sản phẩm")
    public void testSearchProducts() {
        String url = "https://testek.vn/lab/auto/login";
        mWebDriver.get(url);
        waitForDebug(3000);
        // Handle your code here
        // Login credentials
        String username = "admin_com_role";
        String password = "aA12345678@";

        // Login input
        // Username input
        WebElement txtLoginAccountEle = mWebDriver.findElement(By.id("normal_login_username"));
        txtLoginAccountEle.clear();
        txtLoginAccountEle.sendKeys(username);

        // Password input
        WebElement txtLoginPassEle = mWebDriver.findElement(By.id("normal_login_password"));
        txtLoginPassEle.clear();
        txtLoginPassEle.sendKeys(password);

        // Click login button
        String btnLoginXPath = "//span[contains(text(),'Đăng nhập')]";
        WebElement btnLoginEle = mWebDriver.findElement(By.xpath(btnLoginXPath));
        btnLoginEle.click();

        waitForDebug(5000);

        //Access menu > product
        String mnuProductXPath = "//div[@class='flex items-center']//div[contains(text(),'Sản phẩm')]";
        WebElement mnuProductEle = mWebDriver.findElement(By.xpath(mnuProductXPath));
        actions.moveToElement(mnuProductEle).click().build().perform();

        waitForDebug(2000);

        //Input keyword: Tivi
        String txtKeywordXPath = "//input[@class='ant-input css-16pw25h h-8']";
        WebElement txtKeywordEle = mWebDriver.findElement(By.xpath(txtKeywordXPath));
        txtKeywordEle.clear();
        txtKeywordEle.sendKeys("Tivi");

        //Click button search
        String btnSearchXPath = "//button[@testek='btn-search']";
        WebElement btnSearchEle = mWebDriver.findElement(By.xpath(btnSearchXPath));
        btnSearchEle.click();

        waitForDebug(3000);
    }

    @Test(description = "Element Interaction: Click, Double Click, Right Click")
    public void testClick() {
        gotoTestWebsite(Menu.WIDGETS, Menu.ACCORDION);

        // Handle your code here

        String ID_ACCORDION = "accordion-header-";
        String ID_ACCORDION_CONTENT = "accordion-body-";

        for (int i = 1; i <= 3; i++) {
            // Click to open
            String accordionHeaderId = ID_ACCORDION + i;
            WebElement accordionHeaderEle = mWebDriver.findElement(By.id(accordionHeaderId));
            actions.click(accordionHeaderEle).perform();

            waitForDebug(2000);

            // Get the content
            String accordionContentId = ID_ACCORDION_CONTENT + i;
            WebElement accordionContentEle = mWebDriver.findElement(By.id(accordionContentId));
            System.out.println("Accordion Content value: " + accordionContentEle.getText());
            actions.click(accordionHeaderEle).perform();

            //Double-click
            actions.doubleClick(accordionHeaderEle).perform();
            System.out.println("Accordion Content value after double click: " + accordionHeaderEle.getText());

            waitForDebug(2000);
        }
    }

    @Test(description = "Element Interaction: Hover")
    public void testHover() {
        gotoTestWebsite(Menu.WIDGETS, Menu.MENU);

        // Handle your code here
        // Define list menu element
        String mnuLstXPath = "//a[starts-with(@test-id,'menu')]";
        List<WebElement> mnuEleList = mWebDriver.findElements(By.xpath(mnuLstXPath));

        for (WebElement menu : mnuEleList) {
            String menuText = menu.getText();
            List<String> subMenuTextList = new ArrayList<>();
            actions.moveToElement(menu).build().perform();

            waitForDebug(1000);
            // Define list submenu
            String XPATH_SUB_MNU_FORM = "//li[contains(@id,'%s')]//a[starts-with(@test-id,'submenu')]";
            String subMnuXPath = String.format(XPATH_SUB_MNU_FORM, menuText.toLowerCase());
            List<WebElement> subMenusListEle = mWebDriver.findElements(By.xpath(subMnuXPath));

            // Print sub menu
            if (!subMenusListEle.isEmpty()) {
                for (WebElement subMenuEle : subMenusListEle) {

                    waitForDebug(1000);
                    subMenuTextList.add(subMenuEle.getText());
                }
            }
            System.out.println(menuText + "= " + subMenuTextList);

            waitForDebug(1000);
        }
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