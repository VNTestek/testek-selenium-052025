package com.testek.study.lesson02.exercise;

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
        webDriver.manage().window().maximize(); // Set the window size to maximum
    }

    /**
     * Method will be executed after each class, will close all running chrome sessions - Debug Mode
     **/
    @AfterClass
    public void afterClass() {
        if (Objects.nonNull(webDriver)) webDriver.quit();
    }


    @Test(description = "Find element with CSS")
    public void findLocatorWithCSS() {
        gotoTestWebsite();

        // Website Element
        String lblWebsiteCSS = "h4#db-title-id";
        WebElement lblWebsiteEle = webDriver.findElement(By.cssSelector(lblWebsiteCSS));

        // Handle other elements similarly

    }

    @Test(description = "Find element with XPath")
    public void findLocatorWithXPath() {
        gotoTestWebsite();

        // Website Element
        String lblWebsiteXPath = "//h4[@test-id='db-website']";
        WebElement lblWebsiteEle = webDriver.findElement(By.xpath(lblWebsiteXPath));

        // Handle other elements similarly

        // Header title TESTEK - KIỂM THỬ THỰC CHIẾN
        String txtXPath = "//h2/b";
        webDriver.findElement(By.xpath(txtXPath));
        String txtCSS = "h2 > b";
        webDriver.findElement(By.cssSelector(txtCSS));

        // Đào tạo API Testing, Performance Testing, Automation Testing
        webDriver.findElement(By.id("db-title-id"));
        webDriver.findElement(By.className("db-title-class"));
        txtXPath = "//h4[@test-id ='db-title']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "h4[test-id ='db-title']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // Website: https://testek.vn
        txtXPath = "//h4[@test-id='db-website']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "h4[test-id='db-website']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // https://testek.vn
        txtXPath = "//a[@test-id = 'db-website-link']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "a[test-id = 'db-website-link']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // Discord: Testek - Kiểm thử thực chiến
        txtXPath = "//h4[@test-id='db-discord']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "h4[test-id='db-discord']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // Link Testek - Kiểm thử thực chiến
        txtXPath = "//a[@test-id = 'db-discord-link']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "a[test-id = 'db-discord-link']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // Facebook: Testek - Kiểm thử thực chiến
        txtXPath = "//h4[@test-id='db-facebook']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "h4[test-id='db-facebook']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // Link face Testek - Kiểm thử thực chiến
        txtXPath = "//a[@test-id = 'db-facebook-link']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "a[test-id = 'db-facebook-link']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // Hotline: 083.286.8822 / Email: vntestek@gmail.com
        txtXPath = "//h4[@test-id='db-contact']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "h4[test-id='db-contact']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // Image
        txtXPath = "//img[@test-id='about-me-coffee-img']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "img[test-id='about-me-coffee-img']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // Các hệ thống Testek cung cấp
        txtXPath = "//h4[@test-id='db-systems']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "h4[test-id='db-systems']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // API System: Swagger
        txtXPath = "//li[@test-id='db-api-system']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "li[test-id='db-api-system']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // Link Swagger
        txtXPath = "//a[@test-id = 'db-api-system-link']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "a[test-id = 'db-api-system-link']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // Automation Web: Product Management
        txtXPath = "//li[@test-id='db-automation-web']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "li[test-id='db-automation-web']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // Link Product Management
        txtXPath = "//a[@test-id = 'db-automation-web-link']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "a[test-id = 'db-automation-web-link']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // Web Element: Basic Web Elements
        txtXPath = "//li[@test-id='db-web-element']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "li[test-id='db-web-element']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // Link Basic Web Elements
        txtXPath = "//a[@test-id = 'db-web-element-link']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "a[test-id = 'db-web-element-link']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // Admin: admin_com_role
        txtXPath = "//li[@test-id='db-account-admin']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "li[test-id='db-account-admin']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // User: user_com_role
        txtXPath = "//li[@test-id='db-account-user']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "li[test-id='db-account-user']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // Guest: guest_com_role
        txtXPath = "//li[@test-id='db-account-guest']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "li[test-id='db-account-guest']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // Password: aA12345678@
        txtXPath = "//li[@test-id='db-account-password']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "li[test-id='db-account-password']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // Database: Updating...
        txtXPath = "//li[@test-id='db-database']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "li[test-id='db-database']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // HỆ THỐNG CÁC WEB ELEMENTS CƠ BẢN TRONG AUTOMATION TESTING, CÙNG CHUNG TAY XÂY DỰNG CỘNG ĐỒNG KIỂM THỬ TỰ ĐỘNG VIỆT NAM LỚN MẠNH!!!
        txtXPath = "//h4[@test-id='about-me-web-elements']";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "h4[test-id='about-me-web-elements']";
        webDriver.findElement(By.cssSelector(txtCSS));

        // Tiktok box
        webDriver.findElement(By.className("tiktok-embed"));
        txtXPath = "//blockquote";
        webDriver.findElement(By.xpath(txtXPath));
        txtCSS = "blockquote";
        webDriver.findElement(By.cssSelector(txtCSS));
    }


    /**
     * Go to Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}
