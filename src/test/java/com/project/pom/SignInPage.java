package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends Base {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    By userLocator = By.name("userName");
    By passLocator = By.name("password");
    By signInBtnLocator = By.name("submit");

    By homePageLocator = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3");

    //Metodo para ingresar las credenciales
    public void SignIn(){

        if (isDisplayed(userLocator)) {
            type("qualityadmin",userLocator);
            type("pass1",passLocator);
            click(signInBtnLocator);
        } else {
            System.out.println("Username textbox was not present");
        }
    }

    public Boolean isHomePageDisplayed(){
        return isDisplayed(homePageLocator);
    }


}
