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

        String lblTitleCSS = "h2[test-id *= 'about-me']";
        WebElement lblTitleElement = webDriver.findElement(By.cssSelector(lblTitleCSS));

        String lblTitleNameCSS = "h4[name ^= 'db']";
        WebElement lblTitleNameElement = webDriver.findElement(By.cssSelector(lblTitleNameCSS));

        String lblWebsiteCSS = "h4[test-id *= 'website']";
        WebElement lblWebsiteElement = webDriver.findElement(By.cssSelector(lblWebsiteCSS));

        String lblDiscordCSS = "#db-discord";
        WebElement lblDiscordElement = webDriver.findElement(By.cssSelector(lblDiscordCSS));

        String lblFacebookCSS = "h4[test-id *= 'facebook']";
        WebElement lblFacebookElement = webDriver.findElement(By.cssSelector(lblFacebookCSS));

        String lblHotlineAndEmailCSS = "h4[test-id *= 'contact']";
        WebElement lblHotlineAndEmailElement = webDriver.findElement(By.cssSelector(lblHotlineAndEmailCSS));

        String lblNameCSS = "h4[test-id *= 'systems']";
        WebElement lblNameElement = webDriver.findElement(By.cssSelector(lblNameCSS));

        String lblApiSystemCSS = "li[test-id *= 'api-system']";
        WebElement lblApiSystemElement = webDriver.findElement(By.cssSelector(lblApiSystemCSS));

        String lblAutomationWebCSS = "li[test-id *= 'automation']";
        WebElement lblAutomationWebElement = webDriver.findElement(By.cssSelector(lblAutomationWebCSS));

        String lblWebElementCSS = "li[test-id *= 'element']";
        WebElement lblWebElementElement = webDriver.findElement(By.cssSelector(lblWebElementCSS));

        String lblAccountListCSS = "ul[test-id='db-systems-list']";
        WebElement lblAccountListElement = webDriver.findElement(By.cssSelector(lblAccountListCSS));

        String lblDatabaseCSS = "li[test-id *= 'database']";
        WebElement lblDatabaseElement = webDriver.findElement(By.cssSelector(lblDatabaseCSS));

    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findAdvanceLocatorWithXPath() {
        gotoTestWebsite();

        String lblTitleDescendantXPath = "//div[@test-id='content-root']/descendant::h2[contains(@test-id,'about-me-title')]";
        WebElement lblTitleElement = webDriver.findElement(By.xpath(lblTitleDescendantXPath));

        String lblTitleNameXPath = "//h4[contains(@name,'db')]";
        WebElement lblTitleNameElement = webDriver.findElement(By.xpath(lblTitleNameXPath));

        String lblWebsiteXPath = "//h4[@test-id = 'db-title']/following-sibling::h4[@test-id = 'db-website']";
        WebElement lblWebsiteElement = webDriver.findElement(By.xpath(lblWebsiteXPath));

        String lblDiscordXPath = "//h4[@test-id = 'db-facebook']/preceding-sibling::h4[@test-id = 'db-discord']";
        WebElement lblDiscordElement = webDriver.findElement(By.xpath(lblDiscordXPath));

        String lblFacebookXPath = "//a[@test-id = 'db-facebook-link']/parent::h4[@test-id = 'db-facebook']";
        WebElement lblFacebookElement = webDriver.findElement(By.xpath(lblFacebookXPath));

        String lblHotlineAndEmailXPath = "//h4[text() = 'Hotline: 083.286.8822 / Email: vntestek@gmail.com']";
        WebElement lblHotlineAndEmailElement = webDriver.findElement(By.xpath(lblHotlineAndEmailXPath));

        String lblNameXPath = "//h4[text() = 'Các hệ thống Testek cung cấp']";
        WebElement lblNameElement = webDriver.findElement(By.xpath(lblNameXPath));

        String lblApiSystemXPath = "//ul[@test-id = 'db-systems-list']/child::li[@test-id = 'db-api-system']";
        WebElement lblApiSytemElement = webDriver.findElement(By.xpath(lblApiSystemXPath));

        String lblAutomationWebXPath = "//h4[@test-id = 'db-systems']/following::li[@test-id = 'db-automation-web']";
        WebElement lblAutonmationWebElement = webDriver.findElement(By.xpath(lblAutomationWebXPath));

        String lblWebElementXPath = "//li[@test-id = 'db-account']/preceding-sibling::li[@test-id = 'db-web-element']";
        WebElement lblWebElementElement = webDriver.findElement(By.xpath(lblWebElementXPath));

        String lblAccountListXPath = "//li[@test-id = 'db-account']/child::ul[@test-id = 'db-account-list']";
        WebElement lblAccountListElement = webDriver.findElement(By.xpath(lblAccountListXPath));

        String lblDatabaseXPath = "//li[@test-id = 'db-account']/following-sibling::li[@test-id = 'db-database']";
        WebElement lblDatabaseElement = webDriver.findElement(By.xpath(lblDatabaseXPath));

    }


    /**
     * Go to Test Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}
