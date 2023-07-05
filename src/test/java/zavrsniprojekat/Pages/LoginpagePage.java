package zavrsniprojekat.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import zavrsniprojekat.Base.BaseTest;

public class LoginpagePage extends BaseTest{

    public LoginpagePage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="user-name")
    public WebElement usernameField;

    @FindBy(id="password")
    public WebElement passwordField;

    @FindBy(id="login-button")
    public WebElement loginButton;

    @FindBy(css = ".error-message-container.error")
    public WebElement errorMessage;

    public void insertUsername(String username){
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    public void insertPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickOnLoginButton(){
        loginButton.click();
    }


}
