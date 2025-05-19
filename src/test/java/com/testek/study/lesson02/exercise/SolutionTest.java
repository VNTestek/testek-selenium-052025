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

        //TESTEK - KIỂM THỬ THỰC CHIẾN
        String titleWebCSS = "h2[test-id='about-me-title']";
        WebElement titleWebEle = webDriver.findElement(By.cssSelector(titleWebCSS));

        // Website: https://testek.vn
        String txtWebCSS = "h4[test-id='db-website']";
        WebElement txtWebEle = webDriver.findElement(By.cssSelector(txtWebCSS));
        String linkWebCSS = "a[test-id = 'db-website-link']";
        WebElement linkWebEle = webDriver.findElement(By.cssSelector(linkWebCSS));

        //Discord: Testek - Kiểm thử thực chiến
        String txtDiscordCSS = "h4#db-discord";
        WebElement txtDiscordEle = webDriver.findElement(By.cssSelector(txtDiscordCSS));
        String linkDiscordCSS = "a[href=\"https://discord.gg/jC7ZtmvuDX\"]";
        WebElement linkDiscordEle = webDriver.findElement(By.cssSelector(linkDiscordCSS));

        //Facebook: Testek - Kiểm thử thực chiến
        String txtFbCSS = "h4[test-id='db-facebook']";
        WebElement txtFbEle = webDriver.findElement(By.cssSelector(txtFbCSS));
        String linkFbCSS = "a[href=\"https://www.facebook.com/share/g/15m67fr73k/\"]";
        WebElement linkFbEle = webDriver.findElement(By.cssSelector(linkFbCSS));

        //Hotline Email
        String txtContactCSS = "h4[test-id='db-contact']";
        WebElement txtContactEle = webDriver.findElement(By.cssSelector(txtContactCSS));

        //Các hệ thống Testek cung cấp
        String txtSystemCSS = "h4[test-id='db-systems']";
        WebElement txtSystemEle = webDriver.findElement(By.cssSelector(txtSystemCSS));
        //API
        String txtApiCSS = "li[test-id='db-api-system']";
        WebElement txtApiEle = webDriver.findElement(By.cssSelector(txtApiCSS));
        String apiSysLinkCSS = "a[test-id='db-api-system-link']";
        WebElement apiSysLinkEle = webDriver.findElement(By.cssSelector(apiSysLinkCSS));
        //Auto web
        String txtAutoWebCSS = "li[test-id='db-automation-web']";
        WebElement txtAutoWebEle = webDriver.findElement(By.cssSelector(txtAutoWebCSS));
        String autoWebLinkCSS = "a[test-id='db-automation-web-link']";
        WebElement autoWebLinkEle = webDriver.findElement(By.cssSelector(autoWebLinkCSS));
        //Web Element
        String txtEleWebCSS = "li[test-id='db-web-element']";
        WebElement txtEleWebEle = webDriver.findElement(By.cssSelector(txtEleWebCSS));
        String txtEleWebLinkCSS = "a[test-id='db-web-element-link']";
        WebElement txtEleWebLinkEle = webDriver.findElement(By.cssSelector(txtEleWebLinkCSS));

        //Buy Me a Coffee IMG
        String qrImgCSS = "img[test-id='about-me-coffee-img']";
        WebElement qrImgEle = webDriver.findElement(By.cssSelector(qrImgCSS));

        // tiktok
        String openTiktokCSS = "blockquote[data-unique-id='vntestek']";
        WebElement openTiktokEle = webDriver.findElement(By.cssSelector(openTiktokCSS));
    }

    @Test(description = "Find element with XPath")
    public void findLocatorWithXPath() {
        gotoTestWebsite();

        // Website Element
        String lblWebsiteXPath = "//h4[@test-id='db-website']";
        WebElement lblWebsiteEle = webDriver.findElement(By.xpath(lblWebsiteXPath));

        // Handle other elements similarly

        //TESTEK - KIỂM THỬ THỰC CHIẾN
        String titleWebXpath = "//h2[@test-id='about-me-title']";
        WebElement titleWebEle = webDriver.findElement(By.xpath(titleWebXpath));

        // Website: https://testek.vn
        String linkWebXpath = "//a[@test-id = 'db-website-link']";
        WebElement linkWebEle = webDriver.findElement(By.xpath(linkWebXpath));

        //Discord: Testek - Kiểm thử thực chiến
        String txtDiscordXpath = "//h4[@id='db-discord']";
        WebElement txtDiscordEle = webDriver.findElement(By.xpath(txtDiscordXpath));
        String linkDiscordXpath = "//a[@href='https://discord.gg/jC7ZtmvuDX']";
        WebElement linkDiscordEle = webDriver.findElement(By.xpath(linkDiscordXpath));

        //Facebook: Testek - Kiểm thử thực chiến
        String txtFbXpath = "//h4[@test-id='db-facebook']";
        WebElement txtFbEle = webDriver.findElement(By.xpath(txtFbXpath));
        String linkFbXpath = "//a[@href=\"https://www.facebook.com/share/g/15m67fr73k/\"]";
        WebElement linkFbEle = webDriver.findElement(By.xpath(linkFbXpath));

        //Hotline Email
        String txtContactXpath = "//h4[@test-id='db-contact']";
        WebElement txtContactEle = webDriver.findElement(By.xpath(txtContactXpath));

        //Các hệ thống Testek cung cấp
        String txtSystemXpath = "//h4[@test-id='db-systems']";
        WebElement txtSystemEle = webDriver.findElement(By.xpath(txtSystemXpath));
        //API
        String txtApiXpath = "//li[@test-id='db-api-system']";
        WebElement txtApiEle = webDriver.findElement(By.xpath(txtApiXpath));
        String apiSysLinkXpath = "//a[@test-id='db-api-system-link']";
        WebElement apiSysLinkEle = webDriver.findElement(By.xpath(apiSysLinkXpath));
        //Auto web
        String txtAutoWebXpath = "//li[@test-id='db-automation-web']";
        WebElement txtAutoWebEle = webDriver.findElement(By.xpath(txtAutoWebXpath));
        String autoWebLinkXpath = "//a[@test-id='db-automation-web-link']";
        WebElement autoWebLinkEle = webDriver.findElement(By.xpath(autoWebLinkXpath));
        //Web Element
        String txtEleWebXpath = "//li[@test-id='db-web-element']";
        WebElement txtEleWebEle = webDriver.findElement(By.xpath(txtEleWebXpath));
        String txtEleWebLinkXpath = "//a[@test-id='db-web-element-link']";
        WebElement txtEleWebLinkEle = webDriver.findElement(By.xpath(txtEleWebLinkXpath));

        //Buy Me a Coffee IMG
        String qrImgXpath = "//img[@test-id='about-me-coffee-img']";
        WebElement qrImgEle = webDriver.findElement(By.xpath(qrImgXpath));

        // tiktok
        String openTiktokXpath = "//blockquote[@data-unique-id='vntestek']";
        WebElement openTiktokXpathEle = webDriver.findElement(By.xpath(openTiktokXpath));

    }


    /**
     * Go to Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}
