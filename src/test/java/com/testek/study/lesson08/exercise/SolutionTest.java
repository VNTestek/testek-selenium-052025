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
    @Test(description = "Element Interaction: Student Form")
    public void testStudentForm() {
        gotoTestWebsite(Menu.FORM, Menu.STUDENT_FORM);
        // Handle your code here
        Actions actions = new Actions(webDriver);
        // Define the locator format
        String XPATH_H3_TITLE_FORM = "//h3[@id = '%s']";
        String XPATH_LBL_FORM = "//label[@for = '%s']";
        String XPATH_INPUT_TEXT_FORM = "//input[@placeholder = '%s']";
        String XPATH_RADIO_FORM = "//input[@type = 'radio' and @id = '%s']";
        String XPATH_DATE_FORM = "//input[@type = 'date' and @id = '%s']";
        String XPATH_CHECKBOX_FORM = "//input[@type = 'checkbox' and @id = '%s']";
        String XPATH_BUTTON_FORM = "//button[@test-id = '%s']";
        String XPATH_TXT_AREA_FORM = "//textarea[@id = '%s']";

        // Find elements & interact
        // Browser Windows lbl
        String lblBrowserWindowsTitleXPath = String.format(XPATH_H3_TITLE_FORM, "browser-windows-title");
        webDriver.findElement(By.xpath(lblBrowserWindowsTitleXPath));

        // Form đăng ký sinh viên lbl
        String lblFormTitleXPath = String.format(XPATH_H3_TITLE_FORM, "student-registration-title");
        webDriver.findElement(By.xpath(lblFormTitleXPath));

        //First Name lbl
        String lblFirstNameXPath = String.format(XPATH_LBL_FORM, "firstName");
        webDriver.findElement(By.xpath(lblFirstNameXPath));
        //First Name txt
        String txtFirstNameXPath = String.format(XPATH_INPUT_TEXT_FORM, "Enter your first name");
        WebElement txtFirstNameEle = webDriver.findElement(By.xpath(txtFirstNameXPath));
        txtFirstNameEle.clear();
        actions.sendKeys(txtFirstNameEle, "Trinh").perform();

        //Last Name lbl
        String lblLastNameXPath = String.format(XPATH_LBL_FORM, "lastName");
        webDriver.findElement(By.xpath(lblLastNameXPath));
        //Last Name txt
        String txtLastNameXPath = String.format(XPATH_INPUT_TEXT_FORM, "Enter your last name");
        WebElement txtLastNameEle = webDriver.findElement(By.xpath(txtLastNameXPath));
        txtLastNameEle.clear();
        actions.sendKeys(txtLastNameEle, "Toan").perform();

        //Email lbl
        String lblEmailXPath = String.format(XPATH_LBL_FORM, "email");
        webDriver.findElement(By.xpath(lblEmailXPath));
        //Email txt
        String txtEmailXPath = String.format(XPATH_INPUT_TEXT_FORM, "Enter your email");
        WebElement txtEmailEle = webDriver.findElement(By.xpath(txtEmailXPath));
        txtEmailEle.clear();
        actions.sendKeys(txtEmailEle, "toantkA@gmaifff.coo").perform();

        //Gender lbl
        String lblGenderXPath = String.format(XPATH_LBL_FORM, "gender");
        webDriver.findElement(By.xpath(lblGenderXPath));
        //Male RDO
        String rdoMaleXPath = String.format(XPATH_RADIO_FORM, "male");
        WebElement rdoMaleEle = webDriver.findElement(By.xpath(rdoMaleXPath));
        //Female RDO
        String rdoFemaleXPath = String.format(XPATH_RADIO_FORM, "female");
        webDriver.findElement(By.xpath(rdoFemaleXPath));
        //select Male RRO
        actions.click(rdoMaleEle).perform();

        //Mobile lbl
        String lblMobileXPath = String.format(XPATH_LBL_FORM, "mobile");
        webDriver.findElement(By.xpath(lblMobileXPath));
        //Mobile txt
        String txtMobileXPath = String.format(XPATH_INPUT_TEXT_FORM, "Enter your mobile number");
        WebElement txtMobileEle = webDriver.findElement(By.xpath(txtMobileXPath));
        txtMobileEle.clear();
        actions.sendKeys(txtMobileEle, "0988882222").perform();

        //Date of Birth lbl
        String lblDobXPath = String.format(XPATH_LBL_FORM, "dob");
        webDriver.findElement(By.xpath(lblDobXPath));
        //Date of Birth input
        String dateDobXPath = String.format(XPATH_DATE_FORM, "dob");
        WebElement dateDobEle = webDriver.findElement(By.xpath(dateDobXPath));
        dateDobEle.clear();
        actions.sendKeys(dateDobEle, "20101999").perform();

        //Subjects lbl
        String lblSubjectsXPath = String.format(XPATH_LBL_FORM, "subjects");
        webDriver.findElement(By.xpath(lblSubjectsXPath));
        //Subjects txt
        String txtSubjectsXPath = String.format(XPATH_INPUT_TEXT_FORM, "Enter your subjects");
        WebElement txtSubjectsEle = webDriver.findElement(By.xpath(txtSubjectsXPath));
        txtSubjectsEle.clear();
        actions.sendKeys(txtSubjectsEle, "Selenium").perform();

        //Hobbies lbl
        String lblHobbiesXPath = String.format(XPATH_LBL_FORM, "hobbies");
        webDriver.findElement(By.xpath(lblHobbiesXPath));
        //Reading CHK
        String chkReadingXPath = String.format(XPATH_CHECKBOX_FORM, "reading");
        WebElement chkReadingEle = webDriver.findElement(By.xpath(chkReadingXPath));
        //Sports CHK
        String chkSportsXPath = String.format(XPATH_CHECKBOX_FORM, "sports");
        WebElement chkSportsEle = webDriver.findElement(By.xpath(chkSportsXPath));
        //Music CHK
        String chkMusicXPath = String.format(XPATH_CHECKBOX_FORM, "music");
        WebElement chkMusicEle = webDriver.findElement(By.xpath(chkMusicXPath));
        //select only Music CHK
        boolean isReadingChecked = chkReadingEle.isSelected();
        boolean isSportsChecked = chkSportsEle.isSelected();
        boolean isMusicChecked = chkMusicEle.isSelected();
        if (isReadingChecked) {
            actions.click(chkReadingEle).perform();
        }
        if (isSportsChecked) {
            actions.click(chkSportsEle).perform();
        }
        if (!isMusicChecked) {
            actions.click(chkMusicEle).perform();
        }

        //Address lbl
        String lblAddressXPath = String.format(XPATH_LBL_FORM, "address");
        webDriver.findElement(By.xpath(lblAddressXPath));
        //Address txt
        String txtAddressXPath = String.format(XPATH_TXT_AREA_FORM, "address");
        WebElement txtAddressEle = webDriver.findElement(By.xpath(txtAddressXPath));
        txtAddressEle.clear();
        actions.sendKeys(txtAddressEle, "HN-VN").perform();

        //submit btn
        String btnSubmitXPath = String.format(XPATH_BUTTON_FORM, "submit-button");
        WebElement btnSubmitEle = webDriver.findElement(By.xpath(btnSubmitXPath));
        actions.click(btnSubmitEle).perform();
        waitForDebug(2000);

        //clear btn
        String btnClearFormXPath = String.format(XPATH_BUTTON_FORM, "reset-button");
        WebElement btnClearFormEle = webDriver.findElement(By.xpath(btnClearFormXPath));
        actions.click(btnClearFormEle).perform();

        waitForDebug(2000);

    }

    @Test(description = "Login > Dashboard > Sản phẩm")
    public void testSearchProducts() {
        String url = "https://testek.vn/lab/auto/login";
        webDriver.get(url);
        waitForDebug(3000);

        Actions actions = new Actions(webDriver);
        String username = "admin_com_role";
        String password = "aA12345678@";

        //username input
        WebElement txtLoginAccountEle = webDriver.findElement(By.id("normal_login_username"));
        txtLoginAccountEle.clear();
        txtLoginAccountEle.sendKeys(username);

        //password input
        WebElement txtLoginPassEle = webDriver.findElement(By.id("normal_login_password"));
        txtLoginPassEle.clear();
        txtLoginPassEle.sendKeys(password);

        //Login BTN
        String btnLoginXPath = "//span[contains(text(),'Đăng nhập')]";
        WebElement btnLoginEle = webDriver.findElement(By.xpath(btnLoginXPath));
        btnLoginEle.click();

        waitForDebug(5000);

        //access menu > product
        String mnuProductXPath = "//div[@class='flex items-center']//div[contains(text(),'Sản phẩm')]";
        WebElement mnuProductEle = webDriver.findElement(By.xpath(mnuProductXPath));
        actions.moveToElement(mnuProductEle).click().build().perform();
        waitForDebug(2000);

        //input keyword
        String txtKeywordXPath = "//input[@class='ant-input css-16pw25h h-8']";
        WebElement txtKeywordEle = webDriver.findElement(By.xpath(txtKeywordXPath));
        txtKeywordEle.clear();
        txtKeywordEle.sendKeys("Tivi");

        //Click btn Search
        String btnSearchXPath = "//button[@testek='btn-search']";
        WebElement btnSearchEle = webDriver.findElement(By.xpath(btnSearchXPath));
        btnSearchEle.click();

        waitForDebug(3000);
    }

    @Test(description = "Element Interaction: Click, Double Click, Right Click")
    public void testClick() {
        gotoTestWebsite(Menu.WIDGETS, Menu.ACCORDION);
        Actions actions = new Actions(webDriver);

        //Click Giảng viên là các chuyên gia đầu ngành
        String firstAccordionId = "accordion-header-1";
        WebElement firstAccordionEle = webDriver.findElement(By.id(firstAccordionId));
        firstAccordionEle.click();
        waitForDebug(2000);
        String firstAccordionContentId = "accordion-body-1";
        WebElement firstAccordionContentEle = webDriver.findElement(By.id(firstAccordionContentId));
        System.out.println("firstAccordionContent value: " + firstAccordionContentEle.getText());
        firstAccordionEle.click();

        //double-click
        actions.doubleClick(firstAccordionEle).perform();
        System.out.println("firstAccordionContent value after double click: " + firstAccordionContentEle.getText());

        //Học để làm KHÔNG học để biết
        String secondAccordionId = "accordion-header-2";
        WebElement secondAccordionEle = webDriver.findElement(By.id(secondAccordionId));
        secondAccordionEle.click();
        waitForDebug(2000);
        String secondAccordionContentId = "accordion-body-2";
        WebElement secondAccordionContentEle = webDriver.findElement(By.id(secondAccordionContentId));
        System.out.println("secondAccordionContent value: " + secondAccordionContentEle.getText());
        secondAccordionEle.click();

        //double-click
        actions.doubleClick(secondAccordionEle).perform();
        System.out.println("secondAccordionContent value after double click: " + secondAccordionContentEle.getText());

        // Định hướng nghề nghiệp
        String thirdAccordionId = "accordion-header-3";
        WebElement thirdAccordionEle = webDriver.findElement(By.id(thirdAccordionId));
        thirdAccordionEle.click();
        waitForDebug(2000);
        String thirdAccordionContentId = "accordion-body-3";
        WebElement thirdAccordionContentEle = webDriver.findElement(By.id(thirdAccordionContentId));
        System.out.println("thirdAccordionContent value: " + thirdAccordionContentEle.getText());
        thirdAccordionEle.click();

        //double-click
        actions.doubleClick(thirdAccordionEle).perform();
        System.out.println("thirdAccordionContent value after double click: " + thirdAccordionContentEle.getText());

    }

    @Test(description = "Element Interaction: Hover")
    public void testHover() {
        gotoTestWebsite(Menu.WIDGETS, Menu.MENU);
        Actions actions = new Actions(webDriver);

        //define list menu element
        String mnuLstXPath = "//a[starts-with(@test-id,'menu')]";
        List<WebElement> mnuEleLst = webDriver.findElements(By.xpath(mnuLstXPath));
        for (WebElement menu : mnuEleLst) {
            actions.moveToElement(menu).perform();
            waitForDebug(5000);

            String menuTitle = menu.getText();
            System.out.print(menuTitle + ": ");

            List<WebElement> subMenus = webDriver.findElements(By.xpath("//a[starts-with(@test-id,'submenu')]"));
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
