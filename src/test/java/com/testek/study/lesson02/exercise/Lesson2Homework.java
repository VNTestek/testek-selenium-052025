package com.testek.study.lesson02.exercise;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Objects;

@Getter
@Setter

public class Lesson2Homework {
    private WebDriver webDriver;

    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--max-window-size");
        chromeOptions.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();}
        public void afterClass () {
            if (Objects.nonNull(webDriver)) webDriver.quit();}

    public void findLocatorWithCSS() {
        gotoTestWebsite();
        String lblWebsiteCSS = "h3[test-id='student-registration-title'";
        WebElement lblWebsiteEle = webDriver.findElement(By.cssSelector(lblWebsiteCSS));

    }
    //public void findLocatorWithXPath() {
        //gotoTestWebsite();

      //  String lblWebsiteXPath = "//h4[@test-id='db-website']";
      //  WebElement lblWebsiteEle = webDriver.findElement(By.xpath(lblWebsiteXPath));


    //}
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);
    }
}


