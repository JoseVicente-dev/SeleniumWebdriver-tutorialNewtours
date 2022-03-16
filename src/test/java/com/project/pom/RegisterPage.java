package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterPage extends Base {


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //Localizadores
    By registerLinkLocator = By.linkText("REGISTER");
    By registerPageLocator = By.xpath("//img[@src=\"images/mast_register.gif\"]");

    By userNameLocator = By.id("email");
    By passwordLocator = By.name("password");
    By confirmPassWordLocator = By.cssSelector("input[name='confirmPassword']");

    By registerBtnLocator = By.name("submit");

    By registeredMessage = By.tagName("font");

    //Metodo para ingresar los campos de registro
    public void registerUser() throws InterruptedException {

        click(registerLinkLocator);
        Thread.sleep(2000);
        if (isDisplayed(registerPageLocator)) {
            type("qualityadmin", userNameLocator);
            type("pass1", passwordLocator);
            type("pass1", confirmPassWordLocator);

            click(registerBtnLocator);
        } else {
            System.out.println("Register page was not found");
        }

    }

    //Metodo que confirma que el registro fue exitoso
    public String registeredMessage() {
        List<WebElement> fonts = findElements(registeredMessage);
        return getText(fonts.get(5));
    }

}
