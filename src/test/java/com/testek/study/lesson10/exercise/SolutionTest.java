package com.testek.study.lesson10.exercise;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

@Getter
@Setter
@Slf4j
public class SolutionTest {
    // The driver for interacting with the webpage
    private WebDriver mWebDriver;
    private WebDriverWait wait;

    /**
     * Method will be executed before each class, configure Chrome Driver and initialize
     */
    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--max-window-size");
        chromeOptions.addArguments("--remote-allow-origins=*");
        mWebDriver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(mWebDriver, Duration.ofSeconds(10));
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
     * Access to @link{Menu#FORM} navigation
     */
    @Test(description = "Element Interaction")
    public void addNewProduct() {
        // Handle your code here
        String FORM_DROPDOWN_ARIA_XPATH = "//input[@aria-controls ='form_item_%s']";
        String FORM_DROPDOWN_TEXT_XPATH = "//td[normalize-space() = '%s']/ancestor::div[@class = 'ant-select-item-option-content']";

        // Login website
        login();

        // Access tab Sản Phẩm
        accessMenu("Sản phẩm");

        // Click Thêm sản phẩm
        String btnAddProductXPath = "//span[normalize-space() = 'Thêm sản phẩm']/ancestor::button";
        clickTo(btnAddProductXPath, "Thêm sản phẩm");

        // Select Danh mục
        String drpCategoryXPath = String.format(FORM_DROPDOWN_ARIA_XPATH, "category_list");
        clickTo(drpCategoryXPath, "Danh mục");
        String drpWashingMachineXPath = String.format(FORM_DROPDOWN_TEXT_XPATH, "Máy giặt");
        clickTo(drpWashingMachineXPath, "Máy giặt");

        // Select Nhà cung cấp
        String drpSupplierXPath = String.format(FORM_DROPDOWN_ARIA_XPATH, "supplier_list");
        clickTo(drpSupplierXPath, "Nhà cung cấp");
        String drpLGXPath = String.format(FORM_DROPDOWN_TEXT_XPATH, "LG VietNam");
        clickTo(drpLGXPath, "LG VietNam");

        // Input Mã sản phẩm
        String txtCodeId = "form_item_code";
        String codeValue = "AUTO202505_LG_HUONGPHAM_" + System.currentTimeMillis();
        inputValue(txtCodeId, codeValue, "Mã");

        // Input Tên
        String txtNameId = "form_item_name";
        String nameValue = "Máy giặt AUTO202505_LG_HUONGPHAM_" + System.currentTimeMillis();
        inputValue(txtNameId, nameValue, "Tên");

        // Input Đơn vị tính
        String txtUnitId = "form_item_unit";
        String unitValue = "Chiếc";
        inputValue(txtUnitId, unitValue, "Đơn vị tính");

        // Input Mô tả
        String txtDesId = "form_item_description";
        String desValue = "Máy giặt LG - Được xây dựng bởi AUTO202505_LG_HUONGPHAM_" + System.currentTimeMillis();
        inputValue(txtDesId, desValue, "Mô tả");

        // Input Giá
        String txtPriceId = "form_item_price";
        String priceValue = "10000000";
        inputValue(txtPriceId, priceValue, "Giá");

        // Input Số lượng
        String txtQuantityId = "form_item_quantity";
        String quantityValue = "10";
        inputValue(txtQuantityId, quantityValue, "Số lượng");

        // Click Thêm button
        String btnAddXPath = "//span[normalize-space() ='Thêm']/ancestor::button";
        clickTo(btnAddXPath, "Thêm");

        // Print info from Mã sản phẩm
        String txtProductCodeXPath = "//input[@placeholder = 'Mã sản phẩm']";
        printInfo(txtProductCodeXPath, "Mã sản phẩm");

        // Print info from Error message
        String txtErrorMessageXPath = "//div[normalize-space() = 'Error message' and contains(@class, 'w-full')]//textarea";
        printInfo(txtErrorMessageXPath, "Error message");
    }


//    private void gotoTestWebsite(Menu parent, Menu subMenu) {
//        String url = "https://testek.vn/lab/auto/web-elements/";
//        mWebDriver.get(url);
//
//        String XPATH_MENU_FORMAT = "//div[@test-id='%s']";
//
//        // Access: Form > [Student Form]
//        WebElement mnuElementEle = mWebDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, parent.getName())));
//        mnuElementEle.click();
//
//        WebElement mnuEle = mWebDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, subMenu.getName())));
//        mnuEle.click();
//
//        waitForDebug(5000);
//    }

    /**
     * private void waitForDebug(long milliseconds) {
     * try {
     * sleep(milliseconds);
     * } catch (InterruptedException e) {
     * throw new RuntimeException(e);
     * }
     * }
     */

    @Test
    public void login() {
        goToURL("https://testek.vn/lab/auto/login");

        // Input Username
        String txtUsernameId = "normal_login_username";
        inputValue(txtUsernameId, "admin_com_role", "User name");

        // Input password
        String txtPwdId = "normal_login_password";
        inputValue(txtPwdId, "aA12345678@", "Password");

        // Click Login button
        String btnLoginXPath = "//div[@class = 'ant-form-item-control-input-content']//button";
        clickTo(btnLoginXPath, "Login");

    }

    private void inputValue(String id, String value, String title) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        element.clear();
        element.sendKeys(value);
        log.info("Input [{}] to [{}]", value, title);
    }

    private void clickTo(String xpath, String title) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        element.click();
        log.info("Click to [{}]", title);
    }

    private void goToURL(String url) {
        mWebDriver.get(url);
    }

    private void accessMenu(String tab) {
        String FORM_MENU_TEXT_XPATH = "//div[normalize-space() = '%s']/ancestor::div[contains(@class, 'menu flex items-center')]";

        String mnuProductXPath = String.format(FORM_MENU_TEXT_XPATH, tab);
        clickTo(mnuProductXPath, tab);
    }

    private void printInfo(String xpath, String title) {
        WebElement element = mWebDriver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(element, "value"));
        String text = element.getAttribute("value");
        log.info("Text of [{}]: [{}]", title, text);
    }
}
