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

        //TESTEK - KIỂM THỬ THỰC CHIẾN
        String lblTitleContainsCSS = "h2[test-id *= 'about-me-title']";
        WebElement lblTitleEle = webDriver.findElement(By.cssSelector(lblTitleContainsCSS));

        String lblTitleStartsWithCSS = "h2[test-id ^ = 'about-me-title']";
        WebElement lblTitleEle1 = webDriver.findElement(By.cssSelector(lblTitleStartsWithCSS));

        //Đào tạo API Testing, Performance Testing, Automation Testing
        String lblSubTitleContainsCSS = "h4[name * = 'db-title-name']";
        WebElement lblSubTitleEle = webDriver.findElement(By.cssSelector(lblSubTitleContainsCSS));

        String lblSubTitleStartsWithCSS = "h4[name ^ = 'db-title']";
        WebElement lblSubTitleEle1 = webDriver.findElement(By.cssSelector(lblSubTitleStartsWithCSS));

        //Website: https://testek.vn
        String lblWebContainsCSS = "h4[test-id * = 'db-website']";
        WebElement lblWebEle = webDriver.findElement(By.cssSelector(lblWebContainsCSS));

        String lblWebStartsWithCSS = "h4[test-id ^ = 'db-web']";
        WebElement lblWebEle1 = webDriver.findElement(By.cssSelector(lblWebStartsWithCSS));

        //API System: Swagger
        String lblAPISystemContainsCSS = "li[test-id * = 'db-api']";
        WebElement lblAPISystemEle = webDriver.findElement(By.cssSelector(lblAPISystemContainsCSS));

        String lblAPISystemStartsWithCSS = "h4[test-id ^ = 'db-api']";
        WebElement lblAPISystemEle1 = webDriver.findElement(By.cssSelector(lblAPISystemContainsCSS));

        //Account
        String lblAccountContainsCSS = "li[test-id * = 'db-account'] b";
        WebElement lblAccountEle = webDriver.findElement(By.cssSelector(lblAccountContainsCSS));

        String lblAccountStartsWithCSS = "li[test-id ^ = 'db-account'] b";
        WebElement lblAccountEle1 = webDriver.findElement(By.cssSelector(lblAccountStartsWithCSS));

        //Admin: admin_com_role
        String lblAdminRoleContainsCSS = "li[test-id * = 'account-ad'] ";
        WebElement lblAdminRoleEle = webDriver.findElement(By.cssSelector(lblAdminRoleContainsCSS));

        String lblAdminRoleStartsWithCSS = "li[test-id ^ = 'db-account-ad']";
        WebElement lblAdminRoleEle1 = webDriver.findElement(By.cssSelector(lblAdminRoleContainsCSS));
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
        //TESTEK - KIỂM THỬ THỰC CHIẾN
        String lblTitleContainsXpath = "//h2[contains(@test-id,'about-me-title')]";
        WebElement lblTitleEle = webDriver.findElement(By.xpath(lblTitleContainsXpath));

        String lblTitleStartsWithXpath = "//h2[starts-with(@test-id,'about-me-title')]";
        WebElement lblTitleEle1 = webDriver.findElement(By.xpath(lblTitleStartsWithXpath));

        String lblTitleAncestorXpath = "//h2[@test-id='about-me-title']/ancestor::*]";
        WebElement lblTitleAncestor = webDriver.findElement(By.xpath(lblTitleAncestorXpath));

        String lblTitleDescendantXpath = "//h2[@test-id='about-me-title']/descendant::*";
        WebElement lblTitleDescend = webDriver.findElement(By.xpath(lblTitleDescendantXpath));

        //Đào tạo API Testing, Performance Testing, Automation Testing
        String lblSubTitleContainsXpath = "//h4[contains(@name, 'db-title-name')]";
        WebElement lblSubTitleEle = webDriver.findElement(By.xpath(lblSubTitleContainsXpath));

        String lblSubTitleStartsWithXpath = "//h4[starts-with(@name,'db-title')]";
        WebElement lblSubTitleEle1 = webDriver.findElement(By.xpath(lblSubTitleStartsWithXpath));

        String lblSubTitleAncestorXpath = "//h4[@test-id = 'db-title']/ancestor::div[@test-id='about-me-grid-item']";
        WebElement lblSubtitleEle = webDriver.findElement(By.xpath(lblSubTitleAncestorXpath));

        String lblSubtitleDescendantXpath = "//h2[@test-id='about-me-title']/descendant::*";
        WebElement lblSubtitleEle1 = webDriver.findElement(By.xpath(lblSubtitleDescendantXpath));

        //Website: https://testek.vn
        String lblWebsiteFollowingXpath = "//h4[@test-id='db-title']/following::*";
        WebElement lblWebsiteEle = webDriver.findElement(By.xpath(lblWebsiteFollowingXpath));

        String lblWebsitePreSibXpath = "//h4[@test-id='db-facebook']/preceding-sibling::h4[@test-id='db-website']";
        WebElement lblWebsiteEle1 = webDriver.findElement(By.xpath(lblWebsitePreSibXpath));

        //API System: Swagger
        String lblAPISystemChildXpath = "//ul[@test-id='db-systems-list']/child::li[@test-id='db-api-system']";
        WebElement lblAPISystemEle = webDriver.findElement(By.xpath(lblAPISystemChildXpath));

        //Account:
        String lblAccParentXpath = "//ul[@test-id='db-account-list']/parent::li[@test-id='db-account']";
        WebElement lblAccListParent = webDriver.findElement(By.xpath(lblAccParentXpath));
    }


    /**
     * Go to Test Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}
