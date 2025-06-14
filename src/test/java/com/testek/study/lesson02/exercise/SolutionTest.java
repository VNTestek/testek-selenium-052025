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
        String lblDiscordCSS = "h4#db-discord";
        WebElement lblDiscordEle = webDriver.findElement(By.cssSelector(lblDiscordCSS));

        String lblCoffeeCSS = "div[test-id='about-me-grid-item-coffee']";
        WebElement lblCoffeeEle = webDriver.findElement(By.cssSelector(lblCoffeeCSS));

        String lblEleCSS = "h4[test-id='about-me-web-elements']";
        WebElement lblEleEle = webDriver.findElement(By.cssSelector(lblEleCSS));

        //Testek-kiểm thử thực chiến
        String titleWebCSS="h2[test-id='about-me-title']";
        WebElement titleWebEble=webDriver.findElement(By.cssSelector(titleWebCSS));

        //Website
        String txtWebCSS="h4[test-id='db-website']";
        WebElement txtWebEble=webDriver.findElement(By.cssSelector(txtWebCSS));
        String linkWebCSS="h4[test-id='db-website-link']";
        WebElement linkWebEble=webDriver.findElement(By.cssSelector(linkWebCSS));

        //Discord
        String txtDiscordCSS="h4[test-id='db-discord']";
        WebElement txtDisEble=webDriver.findElement(By.cssSelector(txtDiscordCSS));
        String linkDiscordCSS="a[href=\"https://discord.gg/jC7ZtmvuDX\"]";
        WebElement linkDiscordEble=webDriver.findElement(By.cssSelector(linkDiscordCSS));

        //Facebook
        String txtFbCSS="h4[test-id='db-facebook']";
        WebElement txtFbEble= webDriver.findElement(By.cssSelector(txtFbCSS));
        String linkFbCSS="a[href=\"https://discord.gg/jC7ZtmvuDX\"]";
        WebElement linkFbEble=webDriver.findElement(By.cssSelector(linkFbCSS));

        //Hotline-Email
        String txtContact="h4[test-id='db-contact']";
        WebElement txtContactEble=webDriver.findElement(By.cssSelector(txtContact));
    }


    @Test(description = "Find element with XPath")
    public void findLocatorWithXPath() {
        gotoTestWebsite();

        // Website Element
        String lblWebsiteXPath = "//h4[@test-id='db-website']";
        WebElement lblWebsiteEle = webDriver.findElement(By.xpath(lblWebsiteXPath));

        // Handle other elements similarly
        String lblFaceXPath = "//h4[@test-id='db-facebook']";
        WebElement lblFaceEle = webDriver.findElement(By.xpath(lblFaceXPath));

        String lblSysXPath = "//h4[@test-id='db-systems']";
        WebElement lblSysEle = webDriver.findElement(By.xpath(lblSysXPath));

        String lblApiXPath = "//li[@test-id='db-api-system']";
        WebElement lblApiEle = webDriver.findElement(By.xpath(lblApiXPath));

        String lblAuXPath = "//li[@test-id='db-automation-web']";
        WebElement lblAuEle = webDriver.findElement(By.xpath(lblAuXPath));

        String lblEleXPath = "//li[@test-id='db-web-element']";
        WebElement lblEle = webDriver.findElement(By.xpath(lblEleXPath));

        String lblAccXPath = "//li[@test-id='db-account']";
        WebElement lblAccEle = webDriver.findElement(By.xpath(lblAccXPath));

        String lblDataXPath = "//li[@test-id='db-database']";
        WebElement lblDataEle = webDriver.findElement(By.xpath(lblDataXPath));

        String lblContactCSS = "//h4[@test-id='db-contact']";
        WebElement lblContactEle = webDriver.findElement(By.xpath(lblContactCSS));

        //Testek-kiểm thử thực chiến
        String titleWebXpath="//h2[@test-id='about-me-title']";
        WebElement titleWebEble=webDriver.findElement(By.xpath(titleWebXpath));

        //Website
        String txtWebXpath="h4[test-id='db-website']";
        WebElement txtWebEble=webDriver.findElement(By.xpath(txtWebXpath));
        String linkWebXpath="h4[test-id='db-website-link']";
        WebElement linkWebEble=webDriver.findElement(By.xpath(linkWebXpath));

        //Discord
        String txtDiscordXpath="h4[test-id='db-discord']";
        WebElement txtDisEble=webDriver.findElement(By.xpath(txtDiscordXpath));
        String linkDiscordXpath="a[href=\"https://discord.gg/jC7ZtmvuDX\"]";
        WebElement linkDiscordEble=webDriver.findElement(By.xpath(linkDiscordXpath));

        //Facebook
        String txtFbXpath="h4[test-id='db-facebook']";
        WebElement txtFbEble= webDriver.findElement(By.xpath(txtFbXpath));
        String linkFbXpath="a[href=\"https://discord.gg/jC7ZtmvuDX\"]";
        WebElement linkFbEble=webDriver.findElement(By.xpath(linkFbXpath));

        //Hotline-Email
        String txtContactXpath="h4[test-id='db-contact']";
        WebElement txtContactEble=webDriver.findElement(By.xpath(txtContactXpath));
    }

    }


    /**
     * Go to Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}
