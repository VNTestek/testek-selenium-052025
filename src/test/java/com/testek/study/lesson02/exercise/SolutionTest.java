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
        // Title TESTEK - KIỂM THỬ THỰC CHIẾN
        lblWebsiteCSS= "h2>b";
        webDriver.findElement(By.cssSelector(lblWebsiteCSS));

        // Đào tạo API Testing, Performance Testing, Automation Testing
        lblWebsiteCSS= "#db-title-id";
        webDriver.findElement(By.cssSelector(lblWebsiteCSS));
        lblWebsiteCSS= "h4.db-title-class";
        webDriver.findElement(By.cssSelector(lblWebsiteCSS));
        lblWebsiteCSS= "h4[test-id='db-title']";
        webDriver.findElement(By.cssSelector(lblWebsiteCSS));

        //Link Website
        lblWebsiteCSS= "a[href='https://testek.vn']";
        webDriver.findElement(By.cssSelector(lblWebsiteCSS));

        // Link Discord
        lblWebsiteCSS= "a[href='https://discord.gg/jC7ZtmvuDX']";
        webDriver.findElement(By.cssSelector(lblWebsiteCSS));
        lblWebsiteCSS= "a[test-id='db-discord-link']";
        webDriver.findElement(By.cssSelector(lblWebsiteCSS));

        // Link Facebook
        lblWebsiteCSS= "a[href='https://www.facebook.com/share/g/15m67fr73k/']";
        webDriver.findElement(By.cssSelector(lblWebsiteCSS));
        lblWebsiteCSS= "a[test-id='db-facebook-link']";
        webDriver.findElement(By.cssSelector(lblWebsiteCSS));

        // Thông tin liên hệ SĐT email
        lblWebsiteCSS= "h4[test-id='db-contact']";
        webDriver.findElement(By.cssSelector(lblWebsiteCSS));

        // Các hệ thống Testek cung cấp
        lblWebsiteCSS= "h4[test-id='db-systems']";
        webDriver.findElement(By.cssSelector(lblWebsiteCSS));

        // API System
        lblWebsiteCSS= "a[test-id='db-api-system-link']";
        webDriver.findElement(By.cssSelector(lblWebsiteCSS));
        lblWebsiteCSS= "a[href='https://testek.vn/lab/api/v0/prod-man/swagger-ui.html#/']";
        webDriver.findElement(By.cssSelector(lblWebsiteCSS));

        // Automation Web
        lblWebsiteCSS= "a[test-id='db-automation-web-link']";
        webDriver.findElement(By.cssSelector(lblWebsiteCSS));
        lblWebsiteCSS= "a[href='https://testek.vn/lab/auto/login']";
        webDriver.findElement(By.cssSelector(lblWebsiteCSS));

        // Web Element
        lblWebsiteCSS= "a[test-id='db-web-element-link']";
        webDriver.findElement(By.cssSelector(lblWebsiteCSS));
        lblWebsiteCSS= "a[href='https://testek.vn/lab/auto/web-elements']";
        webDriver.findElement(By.cssSelector(lblWebsiteCSS));

        // Buy me a coffee
        lblWebsiteCSS= "p[test-id='about-me-coffee-text']";
        webDriver.findElement(By.cssSelector(lblWebsiteCSS));

        // Image
        lblWebsiteCSS= "img[src='https://lh3.googleusercontent.com/d/1jomM5CqmS7JPuI9docJdnBeYil5vR_yR=s220']";
        webDriver.findElement(By.cssSelector(lblWebsiteCSS));
        lblWebsiteCSS= "img[test-id='about-me-coffee-img']";
        webDriver.findElement(By.cssSelector(lblWebsiteCSS));
    }

    @Test(description = "Find element with XPath")
    public void findLocatorWithXPath() {
        gotoTestWebsite();

        // Website Element
        String lblWebsiteXPath = "//h4[@test-id='db-website']";
        WebElement lblWebsiteEle = webDriver.findElement(By.xpath(lblWebsiteXPath));

        // Handle other elements similarly
        // Title TESTEK - KIỂM THỬ THỰC CHIẾN
        lblWebsiteXPath = "//b['TESTEK - KIỂM THỬ THỰC CHIẾN']";
        webDriver.findElement(By.xpath(lblWebsiteXPath));

        // Đào tạo API Testing, Performance Testing, Automation Testing
        lblWebsiteXPath= "//h4[@id='db-title-id']";
        webDriver.findElement(By.xpath(lblWebsiteXPath));
        lblWebsiteXPath= "//h4[@name='db-title-name']";
        webDriver.findElement(By.xpath(lblWebsiteXPath));
        lblWebsiteXPath= "//h4[@class='db-title-class']";
        webDriver.findElement(By.xpath(lblWebsiteXPath));

        //Link Website
        webDriver.findElement(By.partialLinkText("testek.vn"));

        // Link Discord
        lblWebsiteXPath= "//a[@href='https://discord.gg/jC7ZtmvuDX']";
        webDriver.findElement(By.xpath(lblWebsiteXPath));

        // Link Facebook
        lblWebsiteXPath= "//a[@href='https://www.facebook.com/share/g/15m67fr73k/']";
        webDriver.findElement(By.xpath(lblWebsiteXPath));

        // Thông tin liên hệ SĐT email
        lblWebsiteXPath= "//h4[@test-id='db-contact']";
        webDriver.findElement(By.xpath(lblWebsiteXPath));

        // Các hệ thống Testek cung cấp
        lblWebsiteXPath= "//h4[@test-id='db-systems']";
        webDriver.findElement(By.xpath(lblWebsiteXPath));

        // API System
        lblWebsiteXPath= "//a[@href='https://testek.vn/lab/api/v0/prod-man/swagger-ui.html#/']";
        webDriver.findElement(By.xpath(lblWebsiteXPath));

        // Automation Web
        lblWebsiteXPath= "//a[@href='https://testek.vn/lab/auto/login']";
        webDriver.findElement(By.xpath(lblWebsiteXPath));

        // Web Element
        lblWebsiteXPath= "//a[@test-id='db-web-element-link']";
        webDriver.findElement(By.xpath(lblWebsiteXPath));

    }


    /**
     * Go to Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}
