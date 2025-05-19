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
        String headerCSS="h2[test-id='about-me-title']";
        webDriver.findElement(By.cssSelector(headerCSS));

        //Đào tạo API Testing, Performance Testing, Automation Testing
        String titleCSS="h4[test-id='db-title']";
        webDriver.findElement(By.cssSelector(titleCSS));

        String titleCSS1="h4[id='db-title-id']";
        webDriver.findElement(By.cssSelector(titleCSS1));

        String titleCSS2="h4[name='db-title-name']";
        webDriver.findElement(By.cssSelector(titleCSS2));

        String titleCSS3="#db-title-id";
        webDriver.findElement(By.cssSelector(titleCSS3));

        String titleCSS4=".db-title-class";
        webDriver.findElement(By.cssSelector(titleCSS4));

        //Website: https://testek.vn
        String webCSS="h4[test-id='db-website']";
        webDriver.findElement(By.cssSelector(titleCSS));

        String webCSS1="a[href='https://testek.vn']";
        webDriver.findElement(By.cssSelector(titleCSS1));

        //buy me a coffee image
        String imageCSS="img[test-id='about-me-coffee-img']";
        webDriver.findElement(By.cssSelector(imageCSS));

        String imageCSS1="img[src='https://lh3.googleusercontent.com/d/1jomM5CqmS7JPuI9docJdnBeYil5vR_yR=s220']";
        webDriver.findElement(By.cssSelector(imageCSS1));

        //vntestek
        String testekCSS="span[class='css-1yc8689 eblccp12']";
        webDriver.findElement(By.cssSelector(imageCSS));

        String testekCSS1=".css-1yc8689 eblccp12";
        webDriver.findElement(By.cssSelector(imageCSS1));

        //mở tiktok
//        String buttonCSS="button[class='css-ug6w5y e1v8cfre4']";
//        webDriver.findElement(By.cssSelector(buttonCSS));

//        String buttonCSS1=".css-ug6w5y e1v8cfre4";
//        webDriver.findElement(By.cssSelector(buttonCSS1));

//        String buttonCSS2="button[data-e2e='common-cardFooter-TUXButton']";
//        webDriver.findElement(By.cssSelector(buttonCSS2));
    }

    @Test(description = "Find element with XPath")
    public void findLocatorWithXPath() {
        gotoTestWebsite();

        // Website Element
        String lblWebsiteXPath = "//h4[@test-id='db-website']";
        WebElement lblWebsiteEle = webDriver.findElement(By.xpath(lblWebsiteXPath));

        // Handle other elements similarly

        //TESTEK - KIỂM THỬ THỰC CHIẾN
        String headerXPath = "//h2[@test-id='about-me-title']";
        webDriver.findElement(By.xpath(headerXPath));

        //Đào tạo API Testing, Performance Testing, Automation Testing
        String titleXPath="//h4[@test-id='db-title']";
        webDriver.findElement(By.xpath(titleXPath));

        String titleXPath1="//h4[@id='db-title-id']";
        webDriver.findElement(By.xpath(titleXPath1));

        String titleXPath2="//h4[@name='db-title-name']";
        webDriver.findElement(By.xpath(titleXPath2));

        String titleXPath3="//h4[@class='db-title-class']";
        webDriver.findElement(By.xpath(titleXPath));

        //Website: https://testek.vn
        String webXPath="//h4[@test-id='db-website']";
        webDriver.findElement(By.xpath(webXPath));

        String webXPath1="//a[@href='https://testek.vn']";
        webDriver.findElement(By.xpath(webXPath));

        //buy me a coffee image
        String imageXPATH="//img[@test-id='about-me-coffee-img']";
        webDriver.findElement(By.xpath(imageXPATH));

        String imageXPATH1="//img[@src='https://lh3.googleusercontent.com/d/1jomM5CqmS7JPuI9docJdnBeYil5vR_yR=s220']";
        webDriver.findElement(By.xpath(imageXPATH1));

        //vntestek
//        String testekXPATH="//span[@class='css-1yc8689 eblccp12']";
//        webDriver.findElement(By.xpath(testekXPATH));

        //mở tiktok
//        String buttonXPATH="//button[@class='css-ug6w5y e1v8cfre4']";
//        webDriver.findElement(By.xpath(buttonXPATH));

//        String buttonXPATH1="//button[@data-e2e='common-cardFooter-TUXButton']";
//        webDriver.findElement(By.xpath(buttonXPATH1));
    }


    /**
     * Go to Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}
