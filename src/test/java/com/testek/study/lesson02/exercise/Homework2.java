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

public class Homework2 {
    private WebDriver webDriver;

    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--max-window-size");
        chromeOptions.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
    }

    @AfterClass

    public void afterClass() {
        if (Objects.nonNull(webDriver)) webDriver.quit();
    }

    @Test
    public void findLocatorWithCSS() {
        gotoTestWebsite();
        String titleCss = "h2[test-id='about-me-title']";
        WebElement descriptionCssEle = webDriver.findElement(By.cssSelector(titleCss));

        String websiteCss = "a[href='https://testek.vn']";
        WebElement websiteCssEle = webDriver.findElement((By.cssSelector(websiteCss)));

        String discordCss = "a[href='https://discord.gg/jC7ZtmvuDX']";
        WebElement discordCssEle = webDriver.findElement((By.cssSelector(discordCss)));

        String facebookCss = "a[href='https://www.facebook.com/share/g/15m67fr73k/']";
        WebElement facebookCssEle = webDriver.findElement((By.cssSelector(facebookCss)));

        String hotlineCss = "h4[test-id= 'db-contact']";
        WebElement hotlineCssEle = webDriver.findElement((By.cssSelector(hotlineCss)));

        String systemCss = "h4[test-id= 'db-systems']";
        WebElement systemCssEle = webDriver.findElement((By.cssSelector(systemCss)));

        String apiSystemCss = "a[href='https://testek.vn/lab/api/v0/prod-man/swagger-ui.html#/']";
        WebElement accountCssEle = webDriver.findElement((By.cssSelector(apiSystemCss)));

        String automationWebCss = "a[href='https://testek.vn/lab/auto/login']";
        WebElement imgCssEle = webDriver.findElement((By.cssSelector(automationWebCss)));

        String webElementCss = "a[href='https://testek.vn/lab/auto/web-elements']";
        WebElement aboutMeCssEle = webDriver.findElement((By.cssSelector(webElementCss)));

        //String openTiktokCss = "div[class='css-1f603so e1v8cfre1']";
        //WebElement openTiktokCssEle = webDriver.findElement((By.cssSelector(openTiktokCss)));
        //Code tren sai o dau vay a?

        String qrCodeCss = "img[test-id='about-me-coffee-img']";
        WebElement qrCodeCssEle = webDriver.findElement((By.cssSelector(qrCodeCss)));


    }


    public void findLocatorWithXPath() {
        gotoTestWebsite();

        String titleXpath = "//h2[@test-id='about-me-title']";
        WebElement pageTitleEle = webDriver.findElement(By.xpath(titleXpath));


        String websiteXpath = "//a[@href='https://testek.vn']";
        WebElement websiteXpathEle = webDriver.findElement((By.xpath(websiteXpath)));

        String discordXpath = "//a[@href='https://discord.gg/jC7ZtmvuDX']";
        WebElement discordXpathEle = webDriver.findElement((By.xpath(discordXpath)));

        String facebookXpath = "//a[@href='https://www.facebook.com/share/g/15m67fr73k/']";
        WebElement facebookXpathEle = webDriver.findElement((By.xpath(facebookXpath)));

        String hotlineXpath = "//h4[@test-id='db-contact']";
        WebElement hotlineXpathEle = webDriver.findElement((By.xpath(hotlineXpath)));

        String systemXpath = "//h4[@test-id='db-systems']";
        WebElement systemXpathEle = webDriver.findElement((By.xpath(systemXpath)));

        String apiSystemXpath = "//a[@href='https://testek.vn/lab/api/v0/prod-man/swagger-ui.html#/']";
        WebElement apiSystemXpathEle = webDriver.findElement((By.xpath(apiSystemXpath)));

        String automationWebXpath = "//a[@href='https://testek.vn/lab/auto/login']";
        WebElement automationWebXpathEle = webDriver.findElement((By.xpath(automationWebXpath)));

        String webElementXpath = "//a[@href='https://testek.vn/lab/auto/web-elements']";
        WebElement webElementXpathEle = webDriver.findElement((By.xpath(webElementXpath)));

        String openTiktokXpath = "//div[@class='css-1f603so e1v8cfre1']";
        WebElement openTiktokXpathEle = webDriver.findElement((By.xpath(openTiktokXpath)));

        String qrCodeXpath = "//img[@test-id='about-me-coffee-img']";
        WebElement qrCodeXpathEle = webDriver.findElement((By.xpath(qrCodeXpath)));



    }

    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}


