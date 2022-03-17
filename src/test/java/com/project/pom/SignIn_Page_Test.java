package com.project.pom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignIn_Page_Test {

    private static final String TEST_URL = "https://demo.guru99.com/test/newtours/";

    private WebDriver driver;
    SignInPage signInPage;

    @BeforeEach
    public void setUp() throws Exception{
        signInPage = new SignInPage(driver);
        driver = signInPage.chromeDriverConnection();
        signInPage.visit(TEST_URL);
    }

    @Test
    public void test() throws InterruptedException {
        signInPage.SignIn();
        Thread.sleep(2000);
        assertTrue(signInPage.isHomePageDisplayed());
    }


    @AfterEach
    public void tearDown() throws Exception{
        //driver.quit();
    }
}
