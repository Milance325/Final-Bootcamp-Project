package zavrsniprojekat.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import zavrsniprojekat.Base.BaseTest;

import java.util.List;

public class ProductspagePage extends BaseTest {

    public ProductspagePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
    public WebElement addToCartButton;

    @FindBy(className = "shopping_cart_link")
    public WebElement shoppingCart;

    @FindBy(className = "title")
    public WebElement productsTitle;

    @FindBy(className = "shopping_cart_link")
    public WebElement shoppingCartIcon;

    @FindBy(className = "app_logo")
    public WebElement officialLogo;

    @FindBy(className = "product_sort_container")
    public WebElement dropDownContainer;

    @FindBy(linkText = "Twitter")
    public WebElement twitterLink;

    @FindBy(linkText = "Facebook")
    public WebElement facebookLink;

    @FindBy(linkText = "LinkedIn")
    public WebElement linkedinLink;

    @FindBy(className = "inventory_list")
    public WebElement inventoryItemsPairedByTwo;

    @FindBy(className = "shopping_cart_badge")
    public WebElement shoppingCartBadgeFromProductsPage;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement hamburgerButton;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    public WebElement specificElement;


    @FindBy(className ="inventory_item_name")
    List<WebElement> items;

    public void clickOnSpecificInventoryItem(String product){
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getText().equals(product)){
                items.get(i).click();
            }
        }
    }

    public void clickOnAddToCartButton(){
        addToCartButton.click();
    }
    public void clickOnShoppingCartIcon(){
        shoppingCart.click();
    }
}
