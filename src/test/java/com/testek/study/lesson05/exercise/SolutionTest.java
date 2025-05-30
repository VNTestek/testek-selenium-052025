package com.testek.study.lesson05.exercise;

import com.testek.study.common.Menu;
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

import static java.lang.Thread.sleep;

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
    }

    /**
     * Method will be executed after each class, will close all running chrome sessions - Debug Mode
     **/
    @AfterClass
    public void afterClass() {
        if (Objects.nonNull(webDriver)) webDriver.quit();
    }


    @Test(description = "Find element with CSS")
    public void findBasicLocatorWithCSS() {
        gotoTestWebsite();

        // Handle other elements similarly

        //Title:Form đăng ký sinh viên
        String containsTitleCss="h3[id*='registration']";
        webElement=webDriver.findElement(By.cssSelector(containsTitleCss));

         //First Name
        String containsFirstNameCss="[id*='firstName']";
        webElement=webDriver.findElement(By.cssSelector(containsFirstNameCss));
        String txtFirstNameCss="#firstName";
        webElement=webDriver.findElement(By.cssSelector(txtFirstNameCss));

        //Last Name
        String containsLastNameCss="[id*='lastName']";
        webElement=webDriver.findElement(By.cssSelector(containsLastNameCss));
        String txtLastNameCss="#lastName";
        webElement=webDriver.findElement(By.cssSelector(txtLastNameCss));

        //Email
        String containsEmailCss="[placeholder*='your email']";
        webElement=webDriver.findElement(By.cssSelector(containsEmailCss));
        String txtEmailCss="#email";
        webElement=webDriver.findElement(By.cssSelector(txtEmailCss));


        //Gender
        String containsGenderCss="[for*='gender']";
        webElement=webDriver.findElement(By.cssSelector(containsGenderCss));
        String maleCss="label[test-id='label-male']";
        webElement=webDriver.findElement(By.cssSelector(maleCss));
        String femaleCss="label[test-id='label-female']";
        webElement=webDriver.findElement(By.cssSelector(femaleCss));

        //Mobile
        String containsMobileCss="[for*='mobile']";
        webElement=webDriver.findElement(By.cssSelector(containsMobileCss));
        String txtMobileCss="#mobile";
        webElement=webDriver.findElement(By.cssSelector(txtMobileCss));


        //Date of Birth
        String containsDobCss="[for*='dob']";
        webElement=webDriver.findElement(By.cssSelector(containsDobCss));
        String txtDobCss="#dob";
        webElement=webDriver.findElement(By.cssSelector(txtDobCss));


        //Subject
        String containsSubjectsCss="[for*='subjects']";
        webElement=webDriver.findElement(By.cssSelector(containsSubjectsCss));
        String txtSubjectsCss="#subjects";
        webElement=webDriver.findElement(By.cssSelector(txtSubjectsCss));

        //Hobbies
        String containsHobbiesCss="[for*='hobbies']";
        webElement=webDriver.findElement(By.cssSelector(containsHobbiesCss));
        String readingCss="label[test-id='label-reading']";
        webElement=webDriver.findElement(By.cssSelector(readingCss));
        String sportsCss="label[test-id='label-sports']";
        webElement=webDriver.findElement(By.cssSelector(sportsCss));
        String musicCss="label[test-id='label-music']";
        webElement=webDriver.findElement(By.cssSelector(musicCss));

        //Adress
        String adressCss="label[test-id='label-address']";
        webElement=webDriver.findElement(By.cssSelector(adressCss));
        String containsTxtAdressCss="[placeholder*='address']";
        webElement=webDriver.findElement(By.cssSelector(containsTxtAdressCss));


    }

    @Test(description = "Find element with XPath")
    public void findBasicLocatorWithXPath() {
        gotoTestWebsite();

        // Handle other elements similarly

        //Title
        String containsTitleXpath="//h3[contains(@id,'registration')]";
        webElement=webDriver.findElement(By.xpath(containsTitleXpath));

        //First Name
        String firstNameXpath="//label[normalize-space()='First Name:']";
        webElement=webDriver.findElement(By.xpath(firstNameXpath));
        String startWithTxtFirstNameXpath="//input[start-with(@id,'first')]";
        webElement=webDriver.findElement(By.xpath(startWithTxtFirstNameXpath));

        //Last Name
        String lastNameXpath="//label[normalize-space()='Last Name:']";
        webElement=webDriver.findElement(By.xpath(lastNameXpath));
        String startWithTxtLastNameXpath="//input[start-with(@id,'last')]";
        webElement=webDriver.findElement(By.xpath(startWithTxtLastNameXpath));

        //Emails
        String emailsXpath="//label[@test-id='label-email']";
        webElement=webDriver.findElement(By.xpath(emailsXpath));
        String txtEmailsXpath="//form[@id='studentRegistrationForms']//input[@id='email']";
        webElement=webDriver.findElement(By.xpath(txtEmailsXpath));

        //Gender
        String genderXpath="//label[normalize-space()='Gender:']";
        webElement=webDriver.findElement(By.xpath(genderXpath));
        String maleXpath="//label[normalize-space()='Male']";
        webElement=webDriver.findElement(By.xpath(maleXpath));
        String femaleXpath="//label[normalize-space()='Female']";
        webElement=webDriver.findElement(By.xpath(femaleXpath));

        //Mobile
        String mobileXpath= "//label[normalize-space()='Mobile:']";
        webElement=webDriver.findElement(By.xpath(mobileXpath));
        String txtMobileXpath="//input[@id='mobile']";
        webElement=webDriver.findElement(By.xpath(txtMobileXpath));

        //Date of Birth
        String dobXpath= "//label[normalize-space()='Date of Birth:']";
        webElement=webDriver.findElement(By.xpath(dobXpath));
        String txtdobXpath="//input[@id='dob']";
        webElement=webDriver.findElement(By.xpath(txtdobXpath));


        //Subjects
        String subjectsXpath= "//label[normalize-space()='Subjects:']";
        webElement=webDriver.findElement(By.xpath(subjectsXpath));
        String txtsubjectsXpath="//input[@id='subjects']";
        webElement=webDriver.findElement(By.xpath(txtsubjectsXpath));

        //Hobbies
        String hobbiesXpath= "//label[normalize-space()='Hobbies:']";
        webElement=webDriver.findElement(By.xpath(hobbiesXpath));
        String readingXpath= "//label[normalize-space()='Reading:']";
        webElement=webDriver.findElement(By.xpath(readingXpath));
        String sportXpath= "//label[normalize-space()='Sport:']";
        webElement=webDriver.findElement(By.xpath(sportXpath));
        String musicXpath= "//label[normalize-space()='Music:']";
        webElement=webDriver.findElement(By.xpath(musicXpath));

        //Address
        String addressXpath="label[test-id='label-address']";
        webElement=webDriver.findElement(By.xpath(addressXpath));
        String addressTxtXpath="//textarea[@id='address']";
        webElement=webDriver.findElement(By.xpath(addressTxtXpath));

    }

    /**
     * URL: <a href="https://testek.vn/lab/auto/web-elements">...</a>
     * Access to Elements navigation
     */
    @Test(description = "Dynamic Locator Test")
    public void testDynamicLocator() {
        gotoTestWebsite();

        // Define the locator format then apply to elements

        String FORM_H3_TEXT="//h3[normalize-space()='%s']";
        String FORM_INPUT_PLACEHOLDER="//input[@placeholder='%s']";
        String FORM_BUTTON_TEXT="//button[normalize-space()='%s']";
        String FORM_TEXTAREA_ID="//textarea[@id='%s']";

        String titleXpath=String.format(FORM_H3_TEXT,"Form đăng ký sinh viên");
        String txtTitleXpath=String.format(FORM_H3_TEXT,"Thông tin nhập");
        
        String inputFirstNameXpath=String.format(FORM_INPUT_PLACEHOLDER,"Enter your first name");
        String inputLastNameXpath=String.format(FORM_INPUT_PLACEHOLDER,"Enter your last name");
        String inputEmailXpath=String.format(FORM_INPUT_PLACEHOLDER,"Enter your email");
        String inputPhoneXpath=String.format(FORM_INPUT_PLACEHOLDER,"Enter your mobile number");
        String inputSubjectXpath=String.format(FORM_INPUT_PLACEHOLDER,"Enter your subjects");

        String submitXpath=String.format(FORM_BUTTON_TEXT,"Submit");
        String clearXpath=String.format(FORM_BUTTON_TEXT,"Clear");

        String addressXpath=String.format(FORM_TEXTAREA_ID,"address");
        String txtResXpath=String.format(FORM_TEXTAREA_ID,"outputTextStudent");
        //Hongthai: Bắt thiếu các label cũng như element nhóe :D 

        webDriver.findElement(By.xpath(titleXpath));
        webDriver.findElement(By.xpath(txtTitleXpath));
        webDriver.findElement(By.xpath(inputFirstNameXpath));
        webDriver.findElement(By.xpath(inputLastNameXpath));
        webDriver.findElement(By.xpath(inputEmailXpath));
        webDriver.findElement(By.xpath(inputPhoneXpath));
        webDriver.findElement(By.xpath(inputSubjectXpath));
        webDriver.findElement(By.xpath(submitXpath));
        webDriver.findElement(By.xpath(clearXpath));
        webDriver.findElement(By.xpath(addressXpath));
        webDriver.findElement(By.xpath(txtResXpath));
    }

    /**
     * Go to Test Website
     */
    private void gotoTestWebsite() {
        String url = "https://testek.vn/lab/auto/web-elements/";
        webDriver.get(url);

        String XPATH_MENU_FORMAT = "//div[@test-id='%s']";

        // Access: Form > [Student Form]
        WebElement mnuElementEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, Menu.FORM.getName())));
        mnuElementEle.click();

        WebElement mnuEle = webDriver.findElement(By.xpath(String.format(XPATH_MENU_FORMAT, Menu.STUDENT_FORM.getName())));
        mnuEle.click();

        waitForDebug(5000);
    }

    /**
     * Sleep for debugging
     *
     * @param milliseconds : number of milliseconds
     */
    private void waitForDebug(long milliseconds) {
        try {
            sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
