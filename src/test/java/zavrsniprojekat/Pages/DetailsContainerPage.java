package zavrsniprojekat.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import zavrsniprojekat.Base.BaseTest;

import java.util.List;

public class DetailsContainerPage extends BaseTest {

    public DetailsContainerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_details_container")
    public WebElement productDetailsContainer;

    @FindBy(id = "back-to-products")
    public WebElement backToProductsButton;

    @FindBy(className = "shopping_cart_badge")
    public WebElement roundBadgeOnShoppingCart;

    @FindBy(className = "inventory_item_name")
    public WebElement inventoryItemName;




}
