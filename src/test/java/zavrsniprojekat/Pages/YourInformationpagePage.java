package zavrsniprojekat.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import zavrsniprojekat.Base.BaseTest;

public class YourInformationpagePage extends BaseTest {

    public YourInformationpagePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "firstName")
    public WebElement firstNameInputField;

    @FindBy(name = "lastName")
    public WebElement lastNameInputField;

    @FindBy(name = "postalCode")
    public WebElement postalCodeInputField;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(css = ".error-message-container.error")
    public WebElement errorMessage;

    public void insertFirstname(String name){
        firstNameInputField.clear();
        firstNameInputField.sendKeys(name);
    }
    public void insertLastname(String lastname){
        lastNameInputField.clear();
        lastNameInputField.sendKeys(lastname);
    }
    public void insertPostalCode(int x){
        postalCodeInputField.clear();
        postalCodeInputField.sendKeys(String.valueOf(x));
    }
}
