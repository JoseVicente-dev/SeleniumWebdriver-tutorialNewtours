package com.qualitystream.tutorial;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleSearchTest {

    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_PATH = "src/test/resources/drivers/windows/chrome/chromedriver.exe";

    private static final String TEST_URL = "https://demo.guru99.com/test/newtours/";
    private WebDriver driver;

    @BeforeEach
    public void setUp(){

        System.setProperty(CHROME_DRIVER,CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(TEST_URL);
    }

    @Test
    public void testPage(){



    }
}
