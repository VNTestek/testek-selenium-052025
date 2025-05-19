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

        // Find element: Website
        /* Find by test-id */
        String websiteCSS = "h4[test-id='db-website']";
        WebElement websiteElement = webDriver.findElement(By.cssSelector(websiteCSS));

        /* Find by link attribute */
        String websiteLinkCSS = "a[href='https://testek.vn']";
        WebElement websiteLinkElement = webDriver.findElement(By.cssSelector(websiteLinkCSS));

        // Find element: Discord
        /* Find by test-id */
        String discordCSS = "h4[test-id='db-discord']";
        WebElement discordElement = webDriver.findElement(By.cssSelector(discordCSS));

        /* Find by link attribute */
        String discordLinkCSS = "a[href='https://discord.gg/jC7ZtmvuDX']";
        WebElement discordLinkEle = webDriver.findElement(By.cssSelector(discordLinkCSS));

        // Find element: Facebook
        /* Find by test-id */
        String facebookCSS = "h4[test-id='db-facebook']";
        WebElement facebookEle = webDriver.findElement(By.cssSelector(facebookCSS));

        /*Find by link attribute */
        String facebookLink = "a[href='https://www.facebook.com/share/g/15m67fr73k/']";
        WebElement facebookLinkEle = webDriver.findElement(By.cssSelector(facebookLink));

        // Find element: Hotline
        String hotlineCSS = "h4[test-id='db-contact']";
        WebElement hotlineElement = webDriver.findElement(By.cssSelector(hotlineCSS));

        // Find element: Các hệ thống Testek cung cấp
        String systemCSS = "h4[test-id='db-systems']";
        WebElement systemElement = webDriver.findElement(By.cssSelector(systemCSS));

        String apiSystemCSS = "li[test-id='db-api-system']";
        WebElement apiSystemEle = webDriver.findElement(By.cssSelector(apiSystemCSS));

        String apiSystemLink = "a[href='https://testek.vn/lab/api/v0/prod-man/swagger-ui.html#/']";
        WebElement apiSystemLinkEle = webDriver.findElement(By.cssSelector(apiSystemLink));

        String automationCSS = "li[test-id='db-automation-web']";
        WebElement automationEle = webDriver.findElement(By.cssSelector(automationCSS));

        String automationLinkCSS = "a[href='https://testek.vn/lab/auto/login']";
        WebElement automationLinkEle = webDriver.findElement(By.cssSelector(automationLinkCSS));

        String webElementCSS = "li[test-id='db-web-element']";
        WebElement webElement = webDriver.findElement(By.cssSelector(webElementCSS));

        String webElementLink = "a[href='https://testek.vn/lab/auto/web-elements']";
        WebElement webElement1 = webDriver.findElement(By.cssSelector(webElementLink));

        String accountCSS = "li[test-id='db-account']";
        WebElement accountElement = webDriver.findElement(By.cssSelector(accountCSS));

        String accountAdminCSS = "li[test-id='db-account-admin']";
        WebElement accountAdEle = webDriver.findElement(By.cssSelector(accountAdminCSS));

        String accountUserCSS = "li[test-id='db-account-user']";
        WebElement accountUserElement = webDriver.findElement(By.cssSelector(accountUserCSS));

        String accountGuestCSS = "li[test-id='db-account-guest']";
        WebElement accountGuestElement = webDriver.findElement(By.cssSelector(accountGuestCSS));

        String accountPassCSS = "li[test-id='db-account-password']";
        WebElement accountPassElement = webDriver.findElement(By.cssSelector(accountPassCSS));

        String databaseCSS = "li[test-id='db-database']";
        WebElement databaseElement = webDriver.findElement(By.cssSelector(databaseCSS));

        String qrCSS = "img[test-id='about-me-coffee-img']";
        WebElement qrElement = webDriver.findElement(By.cssSelector(qrCSS));
    }

    @Test(description = "Find element with XPath")
    public void findLocatorWithXPath() {
        gotoTestWebsite();

        // Website Element
        String lblWebsiteXPath = "//h4[@test-id='db-website']";
        WebElement lblWebsiteEle = webDriver.findElement(By.xpath(lblWebsiteXPath));

        String websiteLinkXPath = "//a[@href='https://testek.vn']";
        WebElement websiteElement = webDriver.findElement(By.xpath(websiteLinkXPath));

        // Discord Element
        String discordXPath = "//h4[@test-id='db-discord']";
        WebElement discordElement = webDriver.findElement(By.xpath(discordXPath));

        String discordLinkXPath = "//a[@href='https://discord.gg/jC7ZtmvuDX']";
        WebElement discordLinkEle = webDriver.findElement(By.xpath(discordLinkXPath));

        // Find element: Facebook
        /* Find by test-id */
        String facebookXPath = "//h4[@test-id='db-facebook']";
        WebElement facebookEle = webDriver.findElement(By.xpath(facebookXPath));

        /*Find by link attribute */
        String facebookLink = "//a[@href='https://www.facebook.com/share/g/15m67fr73k/']";
        WebElement facebookLinkEle = webDriver.findElement(By.xpath(facebookLink));

        // Find element: Hotline
        String hotlineXPath = "//h4[@test-id='db-contact']";
        WebElement hotlineElement = webDriver.findElement(By.xpath(hotlineXPath));

        // Find element: Các hệ thống Testek cung cấp
        String systemXPath = "//h4[@test-id='db-systems']";
        WebElement systemElement = webDriver.findElement(By.xpath(systemXPath));

        String apiSystemXPath = "//li[@test-id='db-api-system']";
        WebElement apiSystemEle = webDriver.findElement(By.xpath(apiSystemXPath));

        String apiSystemLink = "//a[@href='https://testek.vn/lab/api/v0/prod-man/swagger-ui.html#/']";
        WebElement apiSystemLinkEle = webDriver.findElement(By.xpath(apiSystemLink));

        String automationXPath = "//li[@test-id='db-automation-web']";
        WebElement automationEle = webDriver.findElement(By.xpath(automationXPath));

        String automationLink = "//a[@href='https://testek.vn/lab/auto/login']";
        WebElement automationLinkEle = webDriver.findElement(By.xpath(automationLink));

        String webElementXPath = "//li[@test-id='db-web-element']";
        WebElement webElement = webDriver.findElement(By.xpath(webElementXPath));

        String webElementLink = "//a[@href='https://testek.vn/lab/auto/web-elements']";
        WebElement webElement1 = webDriver.findElement(By.xpath(webElementLink));

        String accountXPath = "//li[@test-id='db-account']";
        WebElement accountElement = webDriver.findElement(By.xpath(accountXPath));

        String accountAdminXPath = "//li[@test-id='db-account-admin']";
        WebElement accountAdEle = webDriver.findElement(By.xpath(accountAdminXPath));

        String accountUserXPath = "//li[@test-id='db-account-user']";
        WebElement accountUserElement = webDriver.findElement(By.xpath(accountUserXPath));

        String accountGuestXPath = "//li[@test-id='db-account-guest']";
        WebElement accountGuestElement = webDriver.findElement(By.xpath(accountGuestXPath));

        String accountPassXPath = "//li[@test-id='db-account-password']";
        WebElement accountPassElement = webDriver.findElement(By.xpath(accountPassXPath));

        String databaseXPath = "//li[@test-id='db-database']";
        WebElement databaseElement = webDriver.findElement(By.xpath(databaseXPath));

        String qrXPath = "//img[@test-id='about-me-coffee-img']";
        WebElement qrElement = webDriver.findElement(By.xpath(qrXPath));
    }

    /**
     * Go to Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}
