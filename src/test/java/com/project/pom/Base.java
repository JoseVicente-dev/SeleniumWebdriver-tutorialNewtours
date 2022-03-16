package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Base {
    private WebDriver driver;

    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_DRIVER_PATH = "src/test/resources/drivers/windows/chrome/chromedriver.exe";

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
    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    /**
     * Metodos equivalentes a las CommonActions del tutor Ivan. Especifican acciones rutinarias que se hacen en las paginas web
     * Se crean metodos tanto para localizadores By (POM) y su equivalente para WebElements (Page Factory)
     */
    //Traer/leer texto
    public String getText(WebElement element){
        return  element.getText();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    //Insertar texto (to type = escribir)
    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void type(String inputText, WebElement element){
        element.sendKeys(inputText);
    }

    //Dar click
    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void click(WebElement element){
        element.click();
    }

    //El elemento se muestra en la pagina
    public Boolean isDisplayed(By locator){
        try {
            return  driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public Boolean isDisplayed(WebElement element){
        try {
            return element.isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }
    //Permite pasar la ruta URL de la página a probar
    public void visit(String URL){
        driver.get(URL);
    }

}
