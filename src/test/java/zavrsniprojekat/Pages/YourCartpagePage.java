package zavrsniprojekat.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import zavrsniprojekat.Base.BaseTest;

public class YourCartpagePage extends BaseTest {
    public YourCartpagePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    @FindBy(css = ".btn.btn_secondary.btn_small.cart_button")
    public WebElement removeButton;

    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingButton;

    @FindBy(className = "title")
    public WebElement yourCartPageTitle;

    @FindBy(className = "inventory_item_name")
    public WebElement inventoryItemName;

    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }
    public void clickOnRemoveButton(){
        removeButton.click();
    }
    public void clickOnContinueShoppingButton(){
        continueShoppingButton.click();
    }
}
