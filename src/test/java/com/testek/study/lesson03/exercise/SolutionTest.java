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
    private WebElement webElement;

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

        String containsTitleCSS="[test-id*='about-me-title']";
        webElement =webDriver.findElement(By.cssSelector(containsTitleCSS));
        String startTitleCSS="[test-id^='about-me-title']";
        webElement =webDriver.findElement(By.cssSelector(containsTitleCSS));
        String lastTitleCSS="[test-id$='about-me-title']";
        webElement =webDriver.findElement(By.cssSelector(containsTitleCSS));

        String containsWebsiteCSS="[test-id*='db-website']";
        webElement =webDriver.findElement(By.cssSelector(containsWebsiteCSS));
        String startWebsiteCSS="[test-id^='db-website']";
        webElement =webDriver.findElement(By.cssSelector(containsWebsiteCSS));
        String lastWebsiteCSS="[test-id$='db-link']";
        webElement =webDriver.findElement(By.cssSelector(containsWebsiteCSS));

        String containsDiscordCss="[test-id*='db-discord']";
        webElement = webDriver.findElement(By.cssSelector(containsDiscordCss));
        String startDiscordCss="[id^='db-discord']";
        webElement = webDriver.findElement(By.cssSelector(containsDiscordCss));
        String lastDiscordCss="[id$='db-discord']";
        webElement = webDriver.findElement(By.cssSelector(containsDiscordCss));

        String containsFacebookCSS="[test-id*='db-facebook']";
        webElement=webDriver.findElement(By.cssSelector(containsFacebookCSS));
        String startFacebookCSS="[test-id^='db-facebook']";
        webElement=webDriver.findElement(By.cssSelector(containsFacebookCSS));
        String lastFacebookCSS="[test-id$='db-facebook']";
        webElement=webDriver.findElement(By.cssSelector(containsFacebookCSS));

        String containsContactCSS="[test-id*='db-contact']";
        webElement=webDriver.findElement(By.cssSelector(containsContactCSS));
        String startContactCSS="[test-id^='db-contact']";
        webElement=webDriver.findElement(By.cssSelector(containsContactCSS));
        String lastContactCSS="[test-id$='db-contact']";
        webElement=webDriver.findElement(By.cssSelector(containsContactCSS));

        String containSystemCSS="[test-id*='db-system']";
        webElement=webDriver.findElement(By.cssSelector(containSystemCSS));
        String startSystemCSS="[test-id^='db-system']";
        webElement=webDriver.findElement(By.cssSelector(containSystemCSS));
        String lastSystemCSS="[test-id$='db-system']";
        webElement=webDriver.findElement(By.cssSelector(containSystemCSS));

        String containApiCSS="[test-id*='db-api-system']";
        webElement=webDriver.findElement(By.cssSelector(containApiCSS));
        String startApiCSS="[test-id^='db-api-system']";
        webElement=webDriver.findElement(By.cssSelector(containApiCSS));
        String lastApiCSS="[test-id$='db-api-system']";
        webElement=webDriver.findElement(By.cssSelector(containApiCSS));

        String containAccountCSS="[test-id*='system'] li[test-id*='db-account']";
        webElement=webDriver.findElement(By.cssSelector(containAccountCSS));
        String startAccountCSS="[test-id^='system'] li[test-id*='db-account']";
        webElement=webDriver.findElement(By.cssSelector(containAccountCSS));
        String lastAccountCSS="[test-id$='system'] li[test-id*='db-account']";
        webElement=webDriver.findElement(By.cssSelector(containAccountCSS));



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

        String containsTitleXPATH="//h2[contains(@test-id,'about-me')";
        webElement=webDriver.findElement(By.xpath(containsTitleXPATH));
        String startTitleXPATH="//h2[start-with(@test-id,'about-']";
        webElement = webDriver.findElement(By.xpath(startTitleXPATH));
        String descendantTitle="//div[@test-id='about-me-grid']/descendant::h2";
        webElement=webDriver.findElement(By.xpath(descendantTitle));

        String containsWebsiteXpath="//h4[contains(@name,'name']";
        webElement=webDriver.findElement(By.xpath(containsWebsiteXpath));
        String startWebsiteXpath="h4[star-with(@name,'db-title)']";
        webElement=webDriver.findElement(By.xpath(startWebsiteXpath));
        String textWebsiteXpath="//h4[text()='Đào tạo API Testing,Performance Testing,Automation Testing']";
        webElement=webDriver.findElement(By.xpath(textWebsiteXpath));

        String containsDiscordXpath="//h4[contains(@test-id,'db-discord')]";
        webElement=webDriver.findElement(By.xpath(containsDiscordXpath));
        String startDiscordXpath="//h4[start-with(@test-id,'db-disco')]";
        webElement=webDriver.findElement(By.xpath(startDiscordXpath));
        String startDiscordLinkXpath="//[start-with(@href,'https://discord.gg/')]";
        webElement=webDriver.findElement(By.xpath(startDiscordLinkXpath));

        String containsFbXpath="//h4[contains(@test-id,'facebook')]";
        webElement=webDriver.findElement(By.xpath(containsFbXpath));
        String startFbXpath="//h4[start-with(@test-id,'db-facebook')]";
        webElement=webDriver.findElement(By.xpath(startFbXpath));
        String containsFbLinkXpath="//[contains(@href,'facebook.com']";
        webElement=webDriver.findElement(By.xpath(containsFbLinkXpath));

        String containsContactXpath="//[contains(@test-id,'db-contact')]";
        webElement=webDriver.findElement(By.xpath(containsContactXpath));
        String startContactXpath="//[starts-with(@test-id,'db-contact')]";
        webElement=webDriver.findElement(By.xpath(startContactXpath));
        String textContactXpath="//h4[text()='Hotline:083.286.8822/Email: vntestek@gmail.com']";
        webElement=webDriver.findElement(By.xpath(textContactXpath));

        String containsSystemXpath="//h4[contain(@test-id,db-systems')]";
        webElement=webDriver.findElement(By.xpath(containsSystemXpath));
        String startSystemXpath="//h4[start-with(@test-id,db-systems')]";
        webElement=webDriver.findElement(By.xpath(startSystemXpath));
        String childSystemXpath="//div[@test-id='about-me-grid-item']/child::h4[@test-id='db-system']";
        webElement=webDriver.findElement(By.xpath(childSystemXpath));







    }


    /**
     * Go to Test Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}
