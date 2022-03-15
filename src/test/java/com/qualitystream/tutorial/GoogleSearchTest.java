package com.qualitystream.tutorial;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleSearchTest {

    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_PATH = "src/test/resources/drivers/windows/chrome/chromedriver.exe";

    private static final String TEST_URL = "https://www.google.com";
    private WebDriver driver;

    By videoLinkLocator = By.xpath("//*[@id=\"rso\"]/div[1]/div/div[2]/div[2]/div[1]/div/div/div/div/a");

    @BeforeEach
    public void setUp() {

        System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(TEST_URL);
    }

    @Test
    public void testGooglePage() {

        WebElement searchBox = driver.findElement(By.name("q"));

        searchBox.clear();
        searchBox.sendKeys("quality-stream Introduccion a la automatizacion de pruebas de software");
        searchBox.submit();

        //Implicit Wait
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//Espera a que el elemento cargue antes de volver a buscarlo

        //Explicit Wait
        //WebDriverWait explicitWait = new WebDriverWait(driver, 10);//Inicializa la espera explicita.
        //explicitWait.until(ExpectedConditions.titleContains("quality-stream"));//Permite esperar maximo 10 secs hasta que el titulo aparezca
        //assertEquals("quality-stream Introduccion a la automatizacion de pruebas de software - Buscar con Google", driver.getTitle());

        //Fluent Wait
        Wait <WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(2000))
                .ignoring(NoSuchElementException.class);

        WebElement video = fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(videoLinkLocator);
            }
        });//Esta funcion asigna al WebElement <video> el elemento <videoLinkLocator>. Esperará 10 secs maximo y consultará cada 2000 milisecs, ignorando las NoSuchElementExceptions.

    }

    @AfterEach
    public void TearDown(){
        driver.quit();
    }
}
