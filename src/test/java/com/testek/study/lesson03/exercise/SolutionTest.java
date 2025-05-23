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
        String lblAboutMeContainsCSS = "h2[test-id*='about-me']";
        WebElement lblTitleWebContainsElement = webDriver.findElement(By.xpath(lblAboutMeContainsCSS));

        String lblAboutMeStartWithCSS = "h2[test-id^='about-']";
        WebElement lblTitleWebStartWithElement = webDriver.findElement(By.xpath(lblAboutMeStartWithCSS));

        String lblTitleNameContainsCSS = "h4[test-id*='db-title']";
        WebElement lblTitleNameContainsElement = webDriver.findElement(By.xpath(lblTitleNameContainsCSS));

        String lblTitleNameStartWithCSS = "h4[@test-id^='db-']";
        WebElement lblTitleNameStartWithElement = webDriver.findElement(By.xpath(lblTitleNameStartWithCSS));



    }

    /**
     * Description:
     */
    @Test(description = "Find element with XPath")
    public void findAdvanceLocatorWithXPath() {
        gotoTestWebsite();

        // Full Name Component

        String lblAboutMeContainsXPath = "//h2[contains(@test-id ,'about-me')]";
        WebElement lblAboutMeContainsElement = webDriver.findElement(By.xpath(lblAboutMeContainsXPath));

        String lblAboutMeStartWithXPath = "//h2[starts-with(@test-id ,'about-')]";
        WebElement lblAboutMeStartWithElement = webDriver.findElement(By.xpath(lblAboutMeStartWithXPath));

        String lblAboutMeNormalSpaceXPath = "//h2[normalize-space() = 'TESTEK - KIỂM THỬ THỰC CHIẾN']";
        WebElement lblAboutMeTextElement = webDriver.findElement(By.xpath(lblAboutMeNormalSpaceXPath));

        String lblAboutMeAncestorXPath = "//h2[@test-id='about-me-title']/ancestor::div[@test-id='about-me-section']";
        WebElement lblAboutMeAncestorElement = webDriver.findElement(By.xpath(lblAboutMeAncestorXPath));

        String lblTitleNameContainsXPath = "//h4[contains(@test-id, 'db-title')]";
        WebElement lblTitleNameContainsElement = webDriver.findElement(By.xpath(lblTitleNameContainsXPath));

        String lblTitleNameStartWithXPath = "//h4[starts-with(@test-id, 'db-')]";
        WebElement lblTitleNameStartWithElement = webDriver.findElement(By.xpath(lblTitleNameStartWithXPath));

        String lblTitleNameTextXPath = "//h4[text()='Đào tạo API Testing, Performance Testing, Automation Testing']";
        WebElement lblTitleNameTextElement = webDriver.findElement(By.xpath(lblTitleNameTextXPath));

        String lblTitleNameDescendantXPath = "//body[@test-id='body-root']/descendant::h4[@id='db-title-id']";
        WebElement lblTitleNameDescendantElement = webDriver.findElement(By.xpath(lblTitleNameDescendantXPath));

        String lblDbWebsiteLinkContainsXpath = "//h4[contains(@test-id ,'db-website-link')]";
        WebElement txtWebContainsEle = webDriver.findElement(By.xpath(lblDbWebsiteLinkContainsXpath));

        String lblDbWebsiteLinkFollowingXpath = "//h4[@test-id='db-title']/following::h4[@test-id='db-website']";
        WebElement lblDbWebsiteLinkFollowingElement = webDriver.findElement(By.xpath(lblDbWebsiteLinkFollowingXpath));

        String lblDiscordLinkPreSibXpath = "//h4[@test-id='db-contact']/preceding-sibling::h4[@test-id='db-discord']";
        WebElement lblDiscordLinkPreSibElement = webDriver.findElement(By.xpath(lblDiscordLinkPreSibXpath));

        
        // Handle other elements similarly
    }


    /**
     * Go to Test Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}
