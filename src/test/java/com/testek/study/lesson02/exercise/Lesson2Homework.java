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

public class Lesson2Homework {
    private WebDriver webDriver;

    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--max-window-size");
        chromeOptions.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
    }

    public void afterClass() {
        if (Objects.nonNull(webDriver)) webDriver.quit();
    }

    @AfterClass
    public void findLocatorWithCSS() {
        gotoTestWebsite();
        String lblWebsiteCSS = "h3[test-id='student-registration-title'";
        WebElement lblWebsiteEle = webDriver.findElement(By.cssSelector(lblWebsiteCSS));

    }

    @Test
    public void findLocatorWithXPath() {
        gotoTestWebsite();

        String lblWebsiteXPath = "input[@placeholder='Enter your first name']";
        WebElement lblWebsiteEle = webDriver.findElement(By.xpath(lblWebsiteXPath));


    }

    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}  


