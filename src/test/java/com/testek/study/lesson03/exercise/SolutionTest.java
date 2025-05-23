package com.testek.study.lesson03.exercise;

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

    /**
     * Description:
     */
    @Test(description = "Find element with CSS")
    public void findAdvanceLocatorWithCSS() {
        gotoTestWebsite();

        // Handle other elements similarly
        // Page Title:
        String lblTitleContainsCss = "h4[id*='db-title-id']";
        WebElement lblTitleElement = webDriver.findElement((By.cssSelector(lblTitleContainsCss)));

        //Image: By Me a Cooffe
        String imgQrStarsWithCss = "img[test-id^='about-me']";
        WebElement imgQrElement = webDriver.findElement((By.cssSelector(imgQrStarsWithCss)));

    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findAdvanceLocatorWithXPath() {
        gotoTestWebsite();

        // Full Name Component
        String lblTitleAncestorXPath = "//h4[@test-id='db-title']/ancestor::div[@test-id='about-me-grid']";
        WebElement lblTitleElement = webDriver.findElement(By.xpath(lblTitleAncestorXPath));

        // Handle other elements similarly

        //Page Title
        String lblPageTitleAncestorXpath = "//h4[@test-id='db-title']/ancestor::div[@id='about-me']//h2";
        WebElement lblPageTitleElement = webDriver.findElement((By.xpath(lblPageTitleAncestorXpath)));

        // Description: Đào tạo API Testing, Performance Testing, Automation Testing
        String lblDescriptionPrecedingXpath = "//h4[@test-id='db-website']/preceding::h4[@id='db-title-id']";
        WebElement lbDescriptionElement = webDriver.findElement((By.xpath(lblDescriptionPrecedingXpath)));

        // Facebook:
        String lblFacebookFollowingXpath = "//h4[@test-id='db-website']/following::h4[@test-id='db-facebook']";
        WebElement lblFacebookElement = webDriver.findElement((By.xpath(lblFacebookFollowingXpath)));

        // System: Các hệ thống testek cung cấp
        String lblSystemTextXpath = "//h4[text()='Các hệ thống Testek cung cấp']";
        WebElement lblSystemElement = webDriver.findElement((By.xpath(lblSystemTextXpath)));

        // Account: for API System & Automation Web
        String lblAccountContainsXpath = "//li[@test-id='db-account-admin']/ancestor::li[contains(@test-id, 'account')]/b";
        WebElement lblAccountElement = webDriver.findElement((By.xpath(lblAccountContainsXpath)));

        //Image: By Me a Cooffe
        String imgQrStarsWithXpath = "//img[starts-with(@test-id, 'about-me')]";
        WebElement imgQrElement = webDriver.findElement((By.xpath(imgQrStarsWithXpath)));

    }


    /**
     * Go to Test Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}
