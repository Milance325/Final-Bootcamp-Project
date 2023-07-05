package zavrsniprojekat.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import zavrsniprojekat.Base.BaseTest;

public class OverwievpagePage extends BaseTest {

    public OverwievpagePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "finish")
    public WebElement finishButton;

    @FindBy(className = "title")
    public WebElement overviewPageTitle;

    @FindBy(className = "inventory_item_name")
    public WebElement inventoryItemName;

    public void clickOnFinishButton(){
        finishButton.click();
    }
}
