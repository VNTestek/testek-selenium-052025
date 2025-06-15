package com.testek.study.lesson10.exercise;

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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        mWebDriver.manage().window().maximize();
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
    public void testStudentForm() {
        gotoTestWebsite();
        // Handle your code here
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        WebElement mnuProductEle = mWebDriver.findElement(By.xpath("//div[@class='flex items-center']//div[contains(text(),'Sản phẩm')]"));
        mnuProductEle.click();
        waitForDebug(1000);

        WebElement btnAddProductEle = mWebDriver.findElement(By.xpath("//span[contains(text(),'Thêm sản phẩm')]"));
        btnAddProductEle.click();
        waitForDebug(1000);

        WebElement txtDanhmucEle = mWebDriver.findElement(By.xpath("//input[@id='form_item_category']"));
        txtDanhmucEle.click();
        waitForDebug(1000);
        WebElement txtDanhmuc = mWebDriver.findElement(By.xpath("//td[contains(text(),'Máy giặt')]"));
        txtDanhmuc.click();
        waitForDebug(1000);

        WebElement txtSupplierEle = mWebDriver.findElement(By.xpath("//input[@id='form_item_supplier']"));
        txtSupplierEle.click();
        waitForDebug(1000);
        WebElement txtSupplier = mWebDriver.findElement(By.xpath("//td[normalize-space()='LG VietNam']"));
        txtSupplier.click();
        waitForDebug(1000);

        WebElement txtMaSPEle = mWebDriver.findElement(By.xpath("//input[@id='form_item_code']"));
        txtMaSPEle.sendKeys("AUTO202505_LG_[AnhThai]_" + timestamp);
        waitForDebug(1000);

        WebElement txtTenSPEle = mWebDriver.findElement(By.xpath("//input[@id='form_item_name']"));
        txtTenSPEle.sendKeys("Máy giặt AUTO202505_LG_[AnhThai]_" + timestamp);
        waitForDebug(1000);

        WebElement txtDonViTinhEle = mWebDriver.findElement(By.xpath("//input[@id='form_item_unit']"));
        txtDonViTinhEle.sendKeys("Chiếc");
        waitForDebug(1000);

        WebElement txtMoTaEle = mWebDriver.findElement(By.xpath("//input[@id='form_item_description']"));
        txtMoTaEle.sendKeys("Máy giặt LG - Được xây dựng bởi AUTO202505_LG_[AnhThai]_" + timestamp);
        waitForDebug(1000);

        WebElement txtPriceEle = mWebDriver.findElement(By.xpath("//input[@id='form_item_price']"));
        txtPriceEle.sendKeys("10000000");
        waitForDebug(1000);

        WebElement txtItemQuantityEle = mWebDriver.findElement(By.xpath("//input[@id='form_item_quantity']"));
        txtItemQuantityEle.sendKeys("10");
        waitForDebug(1000);

        WebElement btnAddEle = mWebDriver.findElement(By.xpath("//span[normalize-space()='Thêm']"));
        btnAddEle.click();
        waitForDebug(5000);

        WebElement txnProductIDEle = mWebDriver.findElement(By.xpath("//input[@placeholder='Mã sản phẩm']"));
        System.out.println("Mã sản phẩm: " + txnProductIDEle.getText());
        waitForDebug(1000);

        WebElement txnErrorMessageEle = mWebDriver.findElement(By.xpath("//div[@testek='textarea']"));
        System.out.println("Error message: " + txnErrorMessageEle.getAttribute("value"));
        waitForDebug(1000);
    }



    /**
     * Go to Test Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/login";
        mWebDriver.get(url);
        waitForDebug(2000);

        WebElement linkAdminEle = mWebDriver.findElement(By.xpath("//div[normalize-space()='Admin']"));
        linkAdminEle.click();
        waitForDebug(2000);

        WebElement btnLoginEle = mWebDriver.findElement(By.xpath("//span[contains(text(),'Đăng nhập')]"));
        btnLoginEle.click();
        waitForDebug(2000);


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
