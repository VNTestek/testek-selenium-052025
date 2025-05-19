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
        //h4[name='db-title-name']
        String lblWebsiteTitleCSS = "h4[name='db-title-name']";
        WebElement lblTitle = webDriver.findElement(By.cssSelector(lblWebsiteTitleCSS));

        //h4[test-id='db-website']
        String lblDbWebsiteCSS = "h4[test-id='db-website']";
        WebElement lblDBTitle = webDriver.findElement(By.cssSelector(lblDbWebsiteCSS));

        //h4[test-id='db-discord']
        String lblDbDiscordCSS = "h4[test-id='db-discord']";
        WebElement lblDBDiscord = webDriver.findElement(By.cssSelector(lblDbDiscordCSS));

        //h4[test-id='db-facebook']
        String lblDbFacebookCSS = "h4[test-id='db-facebook']";
        WebElement lblFacebook = webDriver.findElement(By.cssSelector(lblDbFacebookCSS));

        //h4[test-id='db-contact']
        String lblDbContactCSS = "h4[test-id='db-contact']";
        WebElement lblContact = webDriver.findElement(By.cssSelector(lblDbContactCSS));

        //h4[test-id='db-systems']
        String lblDbSystemCSS = "h4[test-id='db-systems']";
        WebElement lblSystem = webDriver.findElement(By.cssSelector(lblDbSystemCSS));

        //li[test-id='db-api-system']
        String lblDbApiCSS = "li[test-id='db-api-system']";
        WebElement lblApi = webDriver.findElement(By.cssSelector(lblDbApiCSS));

        //li[test-id='db-automation-web']
        String lblAutoWebCSS = "li[test-id='db-automation-web']";
        WebElement lblAuto = webDriver.findElement(By.cssSelector(lblAutoWebCSS));

        //li[test-id='db-web-element']
        String lblWebElementCSS = "li[test-id='db-web-element']";
        WebElement lblWebElement = webDriver.findElement(By.cssSelector(lblWebElementCSS));

        //li[test-id='db-account']
        String lblAccountCSS = "li[test-id='db-account']";
        WebElement lblAccount = webDriver.findElement(By.cssSelector(lblAccountCSS));
        //li[test-id='db-account-admin']
        String lblAccAdminCSS = "li[test-id='db-account-admin']";
        WebElement lblAccAdmin = webDriver.findElement(By.cssSelector(lblAccAdminCSS));
        //li[test-id='db-account-user']
        String lblAccUserCSS = "li[test-id='db-account-user']";
        WebElement lblAccUser = webDriver.findElement(By.cssSelector(lblAccUserCSS));
        //li[test-id='db-account-guest']
        String lblAccGuestCSS = "li[test-id='db-account-guest']";
        WebElement lblAccGuest = webDriver.findElement(By.cssSelector(lblAccGuestCSS));
        //li[test-id='db-account-password']
        String lblAccPwdCSS = "li[test-id='db-account-password']";
        WebElement lblAccPwd = webDriver.findElement(By.cssSelector(lblAccPwdCSS));

        //li[test-id='db-database']
        String lblDatabaseCSS = "li[test-id='db-database']";
        WebElement lblDatabase = webDriver.findElement(By.cssSelector(lblDatabaseCSS));

        //img[test-id='about-me-coffee-img']
        String lblImgCSS = "img[test-id='about-me-coffee-img']";
        WebElement lblImg = webDriver.findElement(By.cssSelector(lblImgCSS));

        //h4[test-id='about-me-web-elements']
        String lblAboutMeCSS = "h4[test-id='about-me-web-elements']";
        WebElement lblAboutMe = webDriver.findElement(By.cssSelector(lblAboutMeCSS));

        //div[data-e2e='playlist-playlistCard-Container'] -> if keep line code, when running test, system will notice as 'test failed'
//        String lblPlaylistCSS = "div[data-e2e='playlist-playlistCard-Container']";
//        WebElement lblPlaylist = webDriver.findElement(By.cssSelector(lblPlaylistCSS));


    }

    @Test(description = "Find element with XPath")
    public void findLocatorWithXPath() {
        gotoTestWebsite();

        // Website Element
        String lblWebsiteXPath = "//h4[@test-id='db-website']";
        WebElement lblWebsiteEle = webDriver.findElement(By.xpath(lblWebsiteXPath));

        // Handle other elements similarly
        //h4[@name='db-title-name']
        String lblWebsiteTitleXPath = "//h4[@name='db-title-name']";
        WebElement lblTitle = webDriver.findElement(By.xpath(lblWebsiteTitleXPath));

        //h4[@test-id='db-discord']
        String lblDbDiscordXPath = "//h4[@test-id='db-discord']";
        WebElement lblDBDiscord = webDriver.findElement(By.xpath(lblDbDiscordXPath));

        //h4[@test-id='db-facebook']
        String lblDbFacebookXPath = "//h4[@test-id='db-facebook']";
        WebElement lblFacebook = webDriver.findElement(By.xpath(lblDbFacebookXPath));

        //h4[@test-id='db-contact']
        String lblDbContactXPath = "//h4[@test-id='db-contact']";
        WebElement lblContact = webDriver.findElement(By.xpath(lblDbContactXPath));

        //h4[@test-id='db-systems']
        String lblDbSystemXPath = "//h4[@test-id='db-systems']";
        WebElement lblSystem = webDriver.findElement(By.xpath(lblDbSystemXPath));

        //li[@test-id='db-api-system']
        String lblDbApiXPath = "//li[@test-id='db-api-system']";
        WebElement lblApi = webDriver.findElement(By.xpath(lblDbApiXPath));

        //li[@test-id='db-automation-web']
        String lblAutoWebXpath = "//li[@test-id='db-automation-web']";
        WebElement lblAuto = webDriver.findElement(By.xpath(lblAutoWebXpath));

        //li[@test-id='db-web-element']
        String lblDbWebElementXPath = "//li[@test-id='db-web-element']";
        WebElement lblDbWebElement = webDriver.findElement(By.xpath(lblDbWebElementXPath));

        //li[@test-id='db-account']
        String lblDbAccountXPath = "//li[@test-id='db-account']";
        WebElement lblDbAccount = webDriver.findElement(By.xpath(lblDbAccountXPath));
        //li[@test-id='db-account-admin']
        String lblAccAdminXpath = "//li[@test-id='db-account-admin']";
        WebElement lblAccAdmin = webDriver.findElement(By.xpath(lblAccAdminXpath));
        //li[@test-id='db-account-user']
        String lblAccUserXpath = "//li[@test-id='db-account-user']";
        WebElement lblAccUser = webDriver.findElement(By.xpath(lblAccUserXpath));
        //li[@test-id='db-account-guest']
        String lblAccGuestXpath = "//li[@test-id='db-account-guest']";
        WebElement lblAccGuest = webDriver.findElement(By.xpath(lblAccGuestXpath));
        //li[@test-id='db-account-password']
        String lblAccPwdXpath = "//li[@test-id='db-account-password']";
        WebElement lblAccPwd = webDriver.findElement(By.xpath(lblAccPwdXpath));

        //li[@test-id='db-database']
        String lblDbDatabaseXPath = "//li[@test-id='db-database']";
        WebElement lblDbDatabase = webDriver.findElement(By.xpath(lblDbDatabaseXPath));

        //img[@test-id='about-me-coffee-img']
        String lblImageXPath = "//img[@test-id='about-me-coffee-img']";
        WebElement lblImage = webDriver.findElement(By.xpath(lblImageXPath));

        //h4[@test-id='about-me-web-elements']
        String lblAboutMeXPath = "//h4[@test-id='about-me-web-elements']";
        WebElement lblAboutMe = webDriver.findElement(By.xpath(lblAboutMeXPath));

        //div[@id='embed-profile-container']
//        String lblTiktokXpath = "/div[@id='embed-profile-container']";
//        WebElement lblTiktok = webDriver.findElement(By.xpath(lblTiktokXpath));
//        String OpenBtnXpath = "//*[@id=\"embed-profile-container\"]/div/div[2]/a/button/div";
//        WebElement lblOpenBtn = webDriver.findElement(By.xpath(OpenBtnXpath));

    }


    /**
     * Go to Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }

}
