package com.qualitystream.tutorial;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MercuryToursAutomatedTest {

    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_PATH = "src/test/resources/drivers/windows/chrome/chromedriver.exe";
    private static final String TEST_URL = "https://demo.guru99.com/test/newtours/";
    private WebDriver driver;

    //Localizadores
    By registerLinkLocator = By.linkText("REGISTER");
    By registerPageLocator = By.xpath("//img[@src=\"images/mast_register.gif\"]");

    By userNameLocator = By.id("email");
    By passwordLocator = By.name("password");
    By confirmPassWordLocator = By.cssSelector ("input[name='confirmPassword']");

    By registerBtnLocator = By.name("submit");

    By userLocator = By.name("userName");
    By passLocator = By.name("password");
    By signInBtnLocator = By.name("submit");

    By homePageLocator = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3");

    @BeforeEach
    public void setUp() throws Exception{

        System.setProperty(CHROME_DRIVER,CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(TEST_URL);
    }

    @Test
    public void registerUser() throws InterruptedException {
        driver.findElement(registerLinkLocator).click();
        Thread.sleep(2000);
        if(driver.findElement(registerPageLocator).isDisplayed()){
            driver.findElement(userNameLocator).sendKeys("qualityadmin");
            driver.findElement(passwordLocator).sendKeys("pass1");
            driver.findElement(confirmPassWordLocator).sendKeys("pass1");

            driver.findElement(registerBtnLocator).click();
        }
        else {
            System.out.println("Register page was not found");
        }

        List<WebElement> fonts = driver.findElements(By.tagName("font"));
        assertEquals("Note: Your user name is qualityadmin.", fonts.get(5).getText());

    }

    @Test
    public void signIn() throws InterruptedException{
        if(driver.findElement(userLocator).isDisplayed()){

            driver.findElement(userLocator).sendKeys("qualityadmin");
            driver.findElement(passLocator).sendKeys("pass1");
            driver.findElement(signInBtnLocator).click();
            Thread.sleep(2000);
            assertTrue(driver.findElement(homePageLocator).isDisplayed());
        }else{
            System.out.println("Username textbox was not present");
        }

    }

    @AfterEach
    public void tearDown() throws  Exception{
        driver.quit();
    }
}
