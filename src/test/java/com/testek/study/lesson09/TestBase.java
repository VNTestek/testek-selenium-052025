package com.testek.study.lesson09;


import lombok.extern.slf4j.Slf4j;
import org.testng.ITestResult;
import org.testng.annotations.*;


@Listeners({TestListener.class})
@Slf4j
public class TestBase {
    public TestBase() {

    }

    @Parameters({"browser"})
    @BeforeSuite
    public void beforeSuite(@Optional("chrome") String browser) {
       // Before Suite
    }

    @BeforeMethod(alwaysRun = true)
    public void addInvocation(ITestResult tr) {
        // Action before test method
    }

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void createDriver(@Optional("chrome") String browser) {
        // Khởi tạo Chrome Driver
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
       // Quite Chrome Driver
    }
}
