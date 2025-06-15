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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static java.lang.Thread.sleep;

@Getter
@Setter
@Slf4j
public class SolutionTest {
    // The driver for interacting with the webpage
    private WebDriver mWebDriver;
    private WebDriverWait mWebDriverWait;


    /**
     * Method will be executed before each class, configure Chrome Driver and initialize
     */
    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--max-window-size");
        chromeOptions.addArguments("--remote-allow-origins=*");
        mWebDriver = new ChromeDriver(chromeOptions);
        mWebDriverWait = new WebDriverWait(mWebDriver, Duration.ofSeconds(10));
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
    public void testAddNewProduct() {

        // Handle your code here

        //Login site
        login("admin_com_role", "aA12345678@");

        //Access Menu > Sản phẩm
        String subMnuProduct = "//div[@class='flex items-center']//div[contains(text(),'Sản phẩm')]";
        clickTo(subMnuProduct, "Sản Phẩm");

        //Click on [Them san pham] btn
        String addProd = "//button[@testek='btn-add']";
        clickTo(addProd, "Thêm sản phẩm");

        //Get timestamp
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));


        //Select 'Máy giặt' from [Danh mục]
        String categoryDrpId = "form_item_category";
        clickOnElement(categoryDrpId);
        String categoryOptionXPath = "//td[@class='td-item td-item-category' and normalize-space(text())='Máy giặt']";
        clickTo(categoryOptionXPath, "Danh Mục");

        //Select 'LG VietNam' from [Nhà cung cấp]
        String supplierDrpId = "form_item_supplier";
        clickOnElement(supplierDrpId);

        String supplierOptionXPath = "//div[@class='ant-select-item-option-content']//td[@class='td-item td-item-supplier' and text() = 'LG VietNam']";
        clickTo(supplierOptionXPath, "Nhà cung cấp");


        //Input Mã
        String productCode = "AUTO202505_LG_QUYNH" + timestamp;
        inputValueById("form_item_code", productCode, "Mã");

        //Input Tên
        inputValueById("form_item_name", "Máy giặt AUTO202505_LG_QUYNH" + timestamp, "Tên");

        //Input Đơn vị
        inputValueById("form_item_unit", "Chiếc", "Đơn vị");

        //Input Mô tả
        inputValueById("form_item_description", "Máy giặt LG - Được xây dựng bởi AUTO202505_LG_QUYNH" + timestamp, "Mô tả");

        //Input Gía
        inputValueById("form_item_price", "10000000", "Giá");

        //Input Số lượng
        inputValueById("form_item_quantity", "10", "Số lượng");


        inputValueById("form_item_quantity", "10", "Số lượng");

        //Click on [Thêm] button
        String btnAddXPath = "//button[@testek='btn-add']";
        clickTo(btnAddXPath, "Thêm");

        //Print info [Mã sản phẩm]
        inputValueByXPath("//input[@placeholder='Mã sản phẩm']", productCode, "Mã sản phẩm");
        printInfo("//input[@placeholder='Mã sản phẩm']", "Mã sản phẩm");

        //View details
        String viewDetailsXPath = "//button[@testek='btn-view-detail']";
        clickTo(viewDetailsXPath, "Xem chi tiết");

        //Print info [Error message]
        printInfo("//div[@testek='textarea']", "Error message");

    }


    /**
     * Go to Test Website
     */
    private void login(String username, String password) {
        String url = "https://testek.vn/lab/auto/login";
        mWebDriver.get(url);

        //Input username, pwd
        WebElement usernameEle = mWebDriver.findElement(By.id("normal_login_username"));
        usernameEle.sendKeys(username);
        WebElement passwordEle = mWebDriver.findElement(By.id("normal_login_password"));
        passwordEle.sendKeys(password);

        //Login
        String btnLoginXPath = "//span[contains(text(),'Đăng nhập')]";
        clickTo(btnLoginXPath, "Đăng nhập");
    }

    private void clickTo(String xpath, String title) {

        WebElement element = mWebDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        element.click();
        log.info("Clicked on [{}]", title);

    }

    private void clickOnElement(String id) {
        WebElement element = mWebDriver.findElement(By.id(id));
        element.click();

    }

    private void inputValueById(String id, String value, String title) {
        WebElement element = mWebDriver.findElement(By.id(id));
        element.clear();
        element.sendKeys(value);
        log.info("Input: [{}] to [{}]", value, title);
    }

    private void inputValueByXPath(String xpath, String value, String title) {
        WebElement element = mWebDriver.findElement(By.xpath(xpath));
        element.clear();
        element.sendKeys(value);
        log.info("Input: [{}] to [{}]", value, title);
    }

    private void printInfo(String xpath, String title) {
        WebElement skuElement = mWebDriver.findElement(By.xpath(xpath));
        String value = skuElement.getAttribute("value");
        if (Objects.nonNull(value)) {
            log.info("Result: [{}] to [{}]", title, value);
        }
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
