package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Base {
    private WebDriver driver;

    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_DRIVER_PATH = "src/test/resources/driver/windows/chrome/chromedriver.exe";

    public Base(WebDriver driver){
        this.driver = driver;
    }

    //Metodo para la conexion con Chrome
    public WebDriver chromeDriverConnection(){
        System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        return driver;
    }



    //Wrapper para un solo elemento
    public WebElement findElement (By locator){
        return driver.findElement(locator);
    }

    //Wrapper para una lista de elementos
    public List<WebElement> findElments(By locator){
        return driver.findElements(locator);
    }
    //Metodos equivalentes a las CommonActions del tutor Ivan. Especifican acciones rutinarias que se hacen en las paginas web
    //Traer/leer texto
    public String getText(WebElement element){
        return  element.getText();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    //Insertar texto (to type = escribir)
    public void type(String inputText, By locator){

    }



}
