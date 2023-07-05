package zavrsniprojekat.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import zavrsniprojekat.Base.BaseTest;

public class CompletePage extends BaseTest {

    public CompletePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "title")
    public WebElement completePageTitle;

    @FindBy(id = "back-to-products")
    public WebElement backToProductsButton;

    @FindBy(tagName = "h2")
    public WebElement successMessage;
}
