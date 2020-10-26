package library2_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "inputEmail")
    WebElement inputEmail;

    @FindBy(id = "inputPassword")
    WebElement inputPassword;

    @FindBy(css = ".btn.btn-lg.btn-primary.btn-block")
    WebElement sighInButton;


    public void emailAddressInput(){
        inputEmail.sendKeys("student63@library");
    }

    public void passwordInput(){
        inputPassword.sendKeys("Jg2orVoF");
    }

    public HomePage buttonSighIn(){
        sighInButton.click();
        return new HomePage(driver);
    }


}
