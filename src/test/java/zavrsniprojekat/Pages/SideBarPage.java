package zavrsniprojekat.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import zavrsniprojekat.Base.BaseTest;

public class SideBarPage extends BaseTest {

    public SideBarPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "reset_sidebar_link")
    public WebElement resetAppStateButton;
}
